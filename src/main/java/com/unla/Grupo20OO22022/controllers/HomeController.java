package com.unla.Grupo20OO22022.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.unla.Grupo20OO22022.helpers.ViewRouteHelper;


@Controller
@RequestMapping("/")
public class HomeController {


	@GetMapping("")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.HOME_INDEX);
		return modelAndView;
	}
	
	@GetMapping("/about-us")
	public String aboutUs() {
		return ViewRouteHelper.HOME_ABOUT_US;
	}
	
	@GetMapping("/login")
	public String login(Model model, 
			                         @RequestParam(name = "error", required = false) String error,
			                         @RequestParam(name = "logout", required = false) String logout) {
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		return ViewRouteHelper.HOME_LOGIN;
	}

	@GetMapping("/logout")
	public String logout(Model model) {
		return ViewRouteHelper.HOME_LOGOUT;
	}

	@GetMapping("/loginsuccess")
	public String loginCheck() {
		return ViewRouteHelper.HOME_ROUTE;
	}
}
