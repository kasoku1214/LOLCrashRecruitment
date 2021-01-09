package com.crecruit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.crecruit.entity.Summoner;
import com.crecruit.entity.Team;
import com.crecruit.service.TeamRegisterService;

@Controller
public class TeamRegisterController {

	@Autowired
	TeamRegisterService teamRegisterService;

	@Autowired
	TeamSearchController teamSearchController;

	@RequestMapping(value = "/team_register")
	public ModelAndView openRegisterTeamPage(ModelAndView modelAndView) {
		// Teamを生成
		Team team = new Team();
		modelAndView.addObject("team", team);

		// Summonerを５つ生成
		List<Summoner> summonerList = new ArrayList<Summoner>();
		for(int i=0; i<= 4; i++) {
			summonerList.add(new Summoner());
		}
		modelAndView.addObject("summonerList", summonerList);

		// チーム登録画面に遷移
		modelAndView.setViewName("team_register");

		return modelAndView;
	}

	@RequestMapping(value = "/team_create")
	public ModelAndView registerTeam(ModelAndView modelAndView, Team team, List<Summoner> summonerList) {

		System.out.println(summonerList.get(0).getSummonerName());
		System.out.println(summonerList.get(1).getSummonerName());
		System.out.println(summonerList.get(2).getSummonerName());
		System.out.println(summonerList.get(3).getSummonerName());
		System.out.println(summonerList.get(4).getSummonerName());

//		// 5人のsummonerをリストにする
//		List<Summoner> summonerList = new ArrayList<Summoner>();
//
//		// サモナー名がnullじゃない、かつ空欄ではない（つまり正しく入力されている）時のみ登録リストに追加
//		if (summoner1.getSummonerName() != null && !summoner1.getSummonerName().equals("")) {
//			summonerList.add(summoner1);
//		}
//		if (summoner2.getSummonerName() != null && !summoner2.getSummonerName().equals("")) {
//			summonerList.add(summoner2);
//		}
//		if (summoner3.getSummonerName() != null && !summoner3.getSummonerName().equals("")) {
//			summonerList.add(summoner3);
//		}
//		if (summoner4.getSummonerName() != null && !summoner4.getSummonerName().equals("")) {
//			summonerList.add(summoner4);
//		}
//		if (summoner5.getSummonerName() != null && !summoner5.getSummonerName().equals("")) {
//			summonerList.add(summoner5);
//		}

		// チームとメンバーを登録
		teamRegisterService.CreateTeam(team, summonerList);

		// トープページに遷移
		modelAndView = teamSearchController.searchAllTeam(modelAndView, null);

		return modelAndView;
	}
}
