package com.crecruit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.crecruit.entity.Member;
import com.crecruit.entity.Team;
import com.crecruit.service.TeamRegisterService;

@Controller
public class TeamRegisterController {

	@Autowired
	TeamRegisterService teamRegisterService;

	@RequestMapping(value = "/team_register")
	public ModelAndView openRegisterTeamPage(ModelAndView modelAndView) {
		// Teamを生成
		Team team = new Team();
		modelAndView.addObject("team", team);

		// Memberを生成
		Member member = new Member();
		modelAndView.addObject("member", member);

		// チーム登録画面に遷移
		modelAndView.setViewName("team_register");

		return modelAndView;
	}


	@RequestMapping(value = "/team_create")
	@Transactional
	public ModelAndView registerTeam(ModelAndView modelAndView, Team team, Member member) {

		// チームとメンバーを登録
		teamRegisterService.CreateTeam(team, member);

		modelAndView.setViewName("/");

		return modelAndView;
	}
}
