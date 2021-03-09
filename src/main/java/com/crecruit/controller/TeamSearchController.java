package com.crecruit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.crecruit.entity.Team;
import com.crecruit.form.TeamSearchForm;
import com.crecruit.service.TeamSearchService;
import com.crecruit.utility.MessageText;

@Controller
public class TeamSearchController {

	// チーム検索サービス
	@Autowired
	private TeamSearchService teamSearchService;

	/**
	 * エラーメッセージ表示判定オブジェクトを初期化して返却する
	 * @ruturn エラーメッセージ表示判定オブジェクト
	 */
	@ModelAttribute("messageText")
	public MessageText createMessageText() {
		MessageText messageText = new MessageText();
		return messageText;
	}

	@RequestMapping(value = "/")
	public ModelAndView searchAllTeam(ModelAndView modelAndView, Pageable pageable) {
		// 全チームの検索
		Page<Team> teamListPage = teamSearchService.searchAllTeam(pageable);

		// htmlに値を渡す
		modelAndView.addObject("page", teamListPage);
		modelAndView.addObject("teamList", teamListPage.getContent());
		modelAndView.addObject("url", "/");

		// 遷移先：チーム検索ページ
		modelAndView.setViewName("team_search");

		return modelAndView;
	}

	@RequestMapping(value = "/team_search")
	public ModelAndView searchTeam(ModelAndView modelAndView, Pageable pageable, TeamSearchForm teamSearchForm) {

		// 全チームの検索
		Page<Team> teamListPage = teamSearchService.searchTeam(teamSearchForm, pageable);

		// チーム名による検索であれば、検索条件のランクとロールを初期化する
		if(!teamSearchForm.getTeamName().equals("")) {
			teamSearchForm.setRankCode(0);
			teamSearchForm.setRoleCode(0);
			modelAndView.addObject("teamSearchForm", teamSearchForm);
		}

		// htmlに値を渡す
		modelAndView.addObject("page", teamListPage);
		modelAndView.addObject("teamList", teamListPage.getContent());
		modelAndView.addObject("url",
				"/team_search?roleCode=" + teamSearchForm.getRoleCode() + "&rankCode=" + teamSearchForm.getRankCode());

		// 遷移先：チーム検索ページ
		modelAndView.setViewName("team_search");

		return modelAndView;
	}
}
