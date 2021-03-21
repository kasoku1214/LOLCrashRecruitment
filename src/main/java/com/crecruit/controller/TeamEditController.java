package com.crecruit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.crecruit.entity.Summoner;
import com.crecruit.entity.Team;
import com.crecruit.form.PasswordForm;
import com.crecruit.service.TeamEditService;
import com.crecruit.utility.MessageText;

@Controller
public class TeamEditController {

	// チーム検索サービス
	@Autowired
	private TeamEditService teamEditService;

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

	/*
	 * 編集ページを開くメソッド
	 */
	@RequestMapping(value = "/open_team_edit", params = "update")
	public ModelAndView openTeamEditPage(ModelAndView modelAndView, PasswordForm passwordForm) {

		// teamIDからチームを取得
		Team team = teamEditService.findByTeamId(passwordForm.getTeamId());

		// 入力されたパスワードが間違っていた時
		if (!team.getPassword().equals(passwordForm.getPassword())) {

			// teamをMOVに格納
			modelAndView.addObject("team", team);

			// パスワードエラーメッセージを格納
			modelAndView.addObject("messageText", new MessageText("パスワードが違います。", "error"));

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

	/*
	 * チームを削除し、トップページに遷移するメソッド
	 */
	@RequestMapping(value = "/open_team_edit", params = "delete")
	public ModelAndView deleteTeam(ModelAndView modelAndView, PasswordForm passwordForm, Pageable pageable) {

		// teamIDからチームを取得
		Team team = teamEditService.findByTeamId(passwordForm.getTeamId());

		// 入力されたパスワードが間違っていた時
		if (!team.getPassword().equals(passwordForm.getPassword())) {

			// teamをMOVに格納
			modelAndView.addObject("team", team);

			// パスワードエラーメッセージを格納
			modelAndView.addObject("messageText", new MessageText("パスワードが違います。", "error"));

			// チーム登録画面に遷移
			modelAndView.setViewName("team_detail");

			return modelAndView;
		}

		// パスワードが正しかった時
		// チームを削除する
		teamEditService.deleteTeam(team.getTeamId());

		// トップページに戻るためにmov取得
		modelAndView = teamSearchController.searchAllTeam(modelAndView, pageable);

		// 削除完了メッセージ格納
		modelAndView.addObject("messageText", new MessageText("チームの削除が完了しました。", "success"));

		return modelAndView;
	}

	/*
	 * チーム情報を更新するメソッド
	 */
	@RequestMapping(value = "/team_edit")
	public ModelAndView editTeam(ModelAndView modelAndView, Team team, Pageable pageable) {

		List<Summoner> summonerList = new ArrayList<Summoner>();

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

		// トップページに戻るためにmov取得
		modelAndView = teamSearchController.searchAllTeam(modelAndView, pageable);

		// 更新完了メッセージ格納
		modelAndView.addObject("messageText", new MessageText("更新が完了しました。", "success"));

		return modelAndView;
	}

}
