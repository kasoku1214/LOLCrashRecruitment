package com.crecruit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// 端末間gitテスト

@Controller
public class AboutSiteController {

	@RequestMapping(value = "/about_site")
	public ModelAndView openAboutSite(ModelAndView modelAndView) {

		// チーム登録画面に遷移
		modelAndView.setViewName("about_site");

		return modelAndView;
	}
}
