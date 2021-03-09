package com.crecruit.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

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

	/*
	 * 例外ハンドリングメソッド
	 * （全例外に対して）
	 */
	@ExceptionHandler(Exception.class)
	public ModelAndView openErrorPageByException(Exception e) {

		System.out.println(e);

		// MOVの作成
		ModelAndView modelAndView = new ModelAndView();

		// teamSeachFormをMOVに格納
		TeamSearchForm teamSearchForm = new TeamSearchForm();
		modelAndView.addObject("teamSearchForm", teamSearchForm);

		// エラー画面に遷移
		modelAndView.setViewName("error");

		return modelAndView;
	}
}
