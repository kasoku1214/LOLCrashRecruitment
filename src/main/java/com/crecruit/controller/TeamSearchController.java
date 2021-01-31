package com.crecruit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.crecruit.entity.Team;
import com.crecruit.form.TeamSearchForm;
import com.crecruit.service.TeamSearchService;

@Controller
public class TeamSearchController {

	// チーム検索サービス
	@Autowired
	private TeamSearchService teamSearchService;

	/**
     * 検索用Formオブジェクトを初期化して返却する
     * @ruturn 検索用Formオブジェクト
     */
    @ModelAttribute("teamSearchForm")
    public TeamSearchForm createTeamSearchForm(){
        TeamSearchForm teamSearchForm = new TeamSearchForm();
        return teamSearchForm;
    }

	@RequestMapping(value = "/")
	public ModelAndView searchAllTeam(ModelAndView modelAndView, Pageable pageable) {
		// 全チームの検索
		List<Team> teamList = teamSearchService.searchAllTeam();

		// htmlに値を渡す
		modelAndView.addObject("teamList", teamList);

		// 遷移先：チーム検索ページ
		modelAndView.setViewName("team_search");

		return modelAndView;
	}

	@RequestMapping(value = "/team_search")
	public ModelAndView searchTeam(ModelAndView modelAndView, Pageable pageable, TeamSearchForm teamSearchForm) {

		// 全チームの検索
		List<Team> teamList = teamSearchService.searchTeam(teamSearchForm);

		// htmlに値を渡す
		modelAndView.addObject("teamList", teamList);

		// 遷移先：チーム検索ページ
		modelAndView.setViewName("team_search");

		return modelAndView;
	}
}
