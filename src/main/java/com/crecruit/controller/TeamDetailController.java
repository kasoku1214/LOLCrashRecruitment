package com.crecruit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.crecruit.entity.Team;
import com.crecruit.form.PasswordForm;
import com.crecruit.form.TeamSearchForm;
import com.crecruit.service.TeamDetailService;

@Controller
public class TeamDetailController {

	// チーム検索サービス
	@Autowired
	private TeamDetailService teamDetailService;

	/**
	 * 検索用Formオブジェクトを初期化して返却する
	 * @ruturn 検索用Formオブジェクト
	 */
	@ModelAttribute("teamSearchForm")
	public TeamSearchForm createTeamSearchForm() {
		TeamSearchForm teamSearchForm = new TeamSearchForm();
		return teamSearchForm;
	}

	/**
	 * 編集判定用PasswordFormオブジェクトを初期化して返却する
	 * @ruturn 編集判定用PasswordFormオブジェクト
	 */
	@ModelAttribute("passwordForm")
	public PasswordForm createPasswordForm() {
		PasswordForm passwordForm = new PasswordForm();
		return passwordForm;
	}

	@RequestMapping(value = "/team_detail/{teamId}")
	public ModelAndView openTeamDetailPage(ModelAndView modelAndView, @PathVariable("teamId") Integer teamId) {

		Team team = teamDetailService.findByTeamId(teamId);

		// PasswordFormに値を格納
		PasswordForm passwordForm = new PasswordForm();
		passwordForm.setTeamId(teamId);

		// teamをMOVに格納
		modelAndView.addObject("team", team);

		// passwordFormをMOVに格納
		modelAndView.addObject("passwordForm", passwordForm);

		// チーム登録画面に遷移
		modelAndView.setViewName("team_detail");

		return modelAndView;
	}

	@RequestMapping(value = "/team_edit")
	public ModelAndView openTeam(ModelAndView modelAndView, PasswordForm passwordForm) {

		System.out.println(passwordForm.getTeamId());
		System.out.println(passwordForm.getPassword());

		// teamIDからチームを取得
		Team team = teamDetailService.findByTeamId(passwordForm.getTeamId());

		// 入力されたパスワードが間違っていた時
		if (!team.getPassword().equals(passwordForm.getPassword())) {
			// teamをMOVに格納
			modelAndView.addObject("team", team);

			// チーム登録画面に遷移
			modelAndView.setViewName("team_detail");
		}

		// パスワードが正しかった時
		// teamをMOVに格納
		modelAndView.addObject("team", team);

		// チーム編集画面に遷移
		modelAndView.setViewName("team_edit");

		return modelAndView;
	}
}
