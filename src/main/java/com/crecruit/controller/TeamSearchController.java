package com.crecruit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TeamSearchController {

	@RequestMapping(value = "/")
	public ModelAndView searchTeam(ModelAndView modelAndView) {
		modelAndView.setViewName("team_search");

		return modelAndView;
	}
}
