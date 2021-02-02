package com.crecruit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.crecruit.entity.Summoner;
import com.crecruit.entity.Team;
import com.crecruit.form.TeamSearchForm;
import com.crecruit.service.TeamRegisterService;

@Controller
public class TeamRegisterController {

	@Autowired
	TeamRegisterService teamRegisterService;

	@Autowired
	TeamSearchController teamSearchController;

	/**
     * 検索用Formオブジェクトを初期化して返却する
     * @return 検索用Formオブジェクト
     */
    @ModelAttribute("teamSearchForm")
    public TeamSearchForm createTeamSearchForm(){
        TeamSearchForm teamSearchForm = new TeamSearchForm();
        return teamSearchForm;
    }

	/**
     * 登録用Teamオブジェクトを初期化して返却する
     * @return 登録用Teamオブジェクト
     */
    @ModelAttribute("team")
    public Team CreateTeamForRegister(){
    	// Teamを生成
        Team team = new Team();
        // メンバーリストを生成
        List<Summoner> summonerList = new ArrayList<Summoner>();

        // メンバーを５人生成
        for (int i = 0; i < 5; i++) {
        	summonerList.add(new Summoner());
        }

        // チームにメンバーリストを渡す
        team.setSummonerList(summonerList);
        return team;
    }

	@RequestMapping(value = "/team_register")
	public ModelAndView openRegisterTeamPage(ModelAndView modelAndView) {

		// チーム登録画面に遷移
		modelAndView.setViewName("team_register");

		return modelAndView;
	}

	@RequestMapping(value = "/team_create")
	public ModelAndView registerTeam(ModelAndView modelAndView, Team team) {

		// 登録するサモナーリスト
		List<Summoner> summonerList =new ArrayList<Summoner>();

		// チームメンバー内のサモナーネームが空欄ではないサモナーをリストに追加
		for (Summoner summoner : team.getSummonerList()) {
			if (!summoner.getSummonerName().equals("")) {
				summonerList.add(summoner);
			}
		}

		// チームに登録するサモナーリストを設定する
		team.setSummonerList(summonerList);

		// チームとメンバーを登録
		teamRegisterService.CreateTeam(team);

		// トープページに遷移
		modelAndView = teamSearchController.searchAllTeam(modelAndView, null);

		return modelAndView;
	}
}
