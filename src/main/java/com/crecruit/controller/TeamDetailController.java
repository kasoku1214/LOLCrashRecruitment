package com.crecruit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.crecruit.entity.Team;
import com.crecruit.form.PasswordForm;
import com.crecruit.service.TeamDetailService;
import com.crecruit.utility.MessageText;

@Controller
public class TeamDetailController {

	// チーム検索サービス
	@Autowired
	private TeamDetailService teamDetailService;

	@Autowired
	private TeamSearchController teamSearchController;

	/**
	 * エラーメッセージ表示判定オブジェクトを初期化して返却する
	 * @ruturn エラーメッセージ表示判定オブジェクト
	 */
	@ModelAttribute("messageText")
	public MessageText createMessageText() {
		MessageText messageText = new MessageText();
		return messageText;
	}

	@RequestMapping(value = "/team_detail/{teamId}")
	public ModelAndView openTeamDetailPage(ModelAndView modelAndView, @PathVariable("teamId") Integer teamId,
			Pageable pageable) {

		// teamIDからチーム情報を検索
		Team team = teamDetailService.findByTeamId(teamId);

		// teamIDに該当するチームが存在しない場合
		if (team == null) {

			// トップページに戻るためにmov取得
			modelAndView = teamSearchController.searchAllTeam(modelAndView, pageable);

			// エラーメッセージ格納
			modelAndView.addObject("messageText",
					new MessageText("チーム情報が存在しませんでした。削除されたチームか存在しないチームの情報を開こうとしています。", "error"));

			return modelAndView;
		}

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
}
