package com.crecruit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.crecruit.entity.Team;
import com.crecruit.service.TeamSearchService;

@Controller
public class TeamSearchController {

	// チーム検索サービス
	@Autowired
	private TeamSearchService teamSearchService;

	@RequestMapping(value = "/")
	public ModelAndView searchAllTeam(ModelAndView modelAndView, Pageable pageable) {
		// 全チームの検索
		Page<Team> teamPage = teamSearchService.searchAllTeam(pageable);

		// htmlに値を渡す
		modelAndView.addObject("page", teamPage);
		modelAndView.addObject("teamList", teamPage.getContent());

		// 遷移先：チーム検索ページ
		modelAndView.setViewName("team_search");

		return modelAndView;
	}

	@RequestMapping(value = "/team_search")
	public ModelAndView searchTeam(ModelAndView modelAndView, Pageable pageable) {
		// 全チームの検索
		Page<Team> teamPage = teamSearchService.searchAllTeam(pageable);

		// htmlに値を渡す
		modelAndView.addObject("page", teamPage);
		modelAndView.addObject("teamList", teamPage.getContent());

		// 遷移先：チーム検索ページ
		modelAndView.setViewName("team_search");

		return modelAndView;
	}
}
