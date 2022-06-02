package com.unla.Grupo20OO22022.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unla.Grupo20OO22022.entities.Perfil;
import com.unla.Grupo20OO22022.helpers.ViewRouteHelper;
import com.unla.Grupo20OO22022.services.IPerfilService;

@Controller
@RequestMapping
public class PerfilController {
	
	@Autowired
	private IPerfilService service;
	
	@GetMapping("/listarPerfil")
	public String listar(Model model) {
		List<Perfil> perfiles = service.listar();
		model.addAttribute("perfiles", perfiles);
		return ViewRouteHelper.PROFILE_INDEX;
	}
	
	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("perfil", new Perfil());
		return ViewRouteHelper.PROFILE_FORM;
	}
	
	@PostMapping("/save")
	public String save(@Valid Perfil p, Model model) {
		service.save(p);
		return ViewRouteHelper.PROFILE_ROUTE;
	}
	
	@GetMapping("/editar/{idPerfil}")
	public String editar(@PathVariable long idPerfil, Model model) {
		Optional <Perfil> perfil = service.listarId(idPerfil);
		model.addAttribute("perfil", perfil);
		return ViewRouteHelper.PROFILE_FORM;
	}
	
	@GetMapping("/eliminar/{idPerfil}")
	public String delete(@PathVariable long idPerfil, Model model) {
		service.delete(idPerfil);
		return ViewRouteHelper.PROFILE_ROUTE;
	}
}