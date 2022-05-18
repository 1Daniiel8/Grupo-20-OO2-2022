package com.unla.Grupo20OO22022.ABM.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.Grupo20OO22.ABM.helper.ViewRouteHelper;

@Controller
@RequestMapping ("/")
public class UserContoller {

	
	// ---------------------LOG IN------------------------------
			@GetMapping("/login")
			public String login(Model model,
								@RequestParam(name="error",required=false) String error,
								@RequestParam(name="logout", required=false) String logout) {
				model.addAttribute("error", error);
				model.addAttribute("logout", logout);
				return ViewRouteHelper.USUARIO_LOGIN;
			}
			
			@GetMapping("/logout")
			public String logout(Model model) {
			    return ViewRouteHelper.USUARIO_LOGOUT;
			}
			
			@GetMapping("/loginsuccess")
			public RedirectView loginCheck() {
				String ruta = "/";
				return new RedirectView(ruta);
			}
}
