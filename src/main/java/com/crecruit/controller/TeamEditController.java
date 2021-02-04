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
import com.crecruit.form.PasswordForm;
import com.crecruit.form.TeamSearchForm;
import com.crecruit.service.TeamEditService;

@Controller
public class TeamEditController {

	// チーム検索サービス
	@Autowired
	private TeamEditService teamEditService;

	/**
	 * 検索用Formオブジェクトを初期化して返却する
	 * @ruturn 検索用Formオブジェクト
	 */
	@ModelAttribute("teamSearchForm")
	public TeamSearchForm createTeamSearchForm() {
		TeamSearchForm teamSearchForm = new TeamSearchForm();
		return teamSearchForm;
	}

	@RequestMapping(value = "/open_team_edit")
	public ModelAndView openTeamEditPage(ModelAndView modelAndView, PasswordForm passwordForm) {

		// teamIDからチームを取得
		Team team = teamEditService.findByTeamId(passwordForm.getTeamId());

		// 入力されたパスワードが間違っていた時
		if (!team.getPassword().equals(passwordForm.getPassword())) {

			// teamをMOVに格納
			modelAndView.addObject("team", team);

			// error判定をMOVに格納
			modelAndView.addObject("isError", true);

			// チーム登録画面に遷移
			modelAndView.setViewName("team_detail");

			return modelAndView;
		}

		// パスワードが正しかった時
		// teamをMOVに格納
		modelAndView.addObject("team", team);

		// チーム編集画面に遷移
		modelAndView.setViewName("team_edit");

		return modelAndView;
	}

	@RequestMapping(value = "/team_edit")
	public String editTeam(ModelAndView modelAndView, Team team) {

		List<Summoner> summonerList =new ArrayList<Summoner>();

		// チームメンバー内のサモナーネームが空欄ではないサモナーをリストに追加
		for (Summoner summoner : team.getSummonerList()) {
			if (!summoner.getSummonerName().equals("")) {
				summonerList.add(summoner);
			}
		}

		// 更新後のサモナーリストを設定する
		team.setSummonerList(summonerList);

		// チームとメンバーを更新
		teamEditService.editTeam(team);

		return "redirect:/";
	}

}
