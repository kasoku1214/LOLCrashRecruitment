package com.crecruit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TeamRegisterController {

	@RequestMapping(value = "/team_register")
	public ModelAndView registerTeam(ModelAndView modelAndView) {
		modelAndView.setViewName("team_register");

		return modelAndView;
	}
}
