package com.crecruit.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.crecruit.form.TeamSearchForm;

/*
 * 全てのコントローラーの共通処理を扱うクラス
 */
@ControllerAdvice
public class CustomController {

	/*
	 * 全てのコントローラーの前処理として実行される。
	 * 検索用Formオブジェクトを初期化して返却する
	 * @ruturn 検索用Formオブジェクト
	 */
	@ModelAttribute("teamSearchForm")
	public TeamSearchForm createTeamSearchForm() {
		TeamSearchForm teamSearchForm = new TeamSearchForm();
		return teamSearchForm;
	}
}
