package com.unla.Grupo20OO22022.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unla.Grupo20OO22022.entities.Persona;
import com.unla.Grupo20OO22022.services.IPersonaService;

@Controller
@RequestMapping()
public class PersonaController {
	
	@Autowired
	private IPersonaService iPersonaService;
	
	@GetMapping("/listarPersonas")
	public String listar(Model model) {
		List<Persona>personas = iPersonaService.listar();
		model.addAttribute("personas", personas);
		return "index";
	}
	
	@GetMapping("/nuevaPersona")
	public String agregar(Model model){
		model.addAttribute("persona", new Persona());
		return "form";
	}
	
	@PostMapping("/guardarPersona")
	public String save(@Valid Persona p, Model model) {
		iPersonaService.save(p);
		return "redirect:/listarPersonas";
	}
	
	@GetMapping("/editarPersona/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Persona>persona = iPersonaService.listarId(id);
		model.addAttribute("persona", persona);
		return "form";
	}
	
	@GetMapping("/eliminarPersona/{id}")
	public String delete(Model model, @PathVariable int id) {
		iPersonaService.delete(id);
		return "redirect:/listar";
	}
}
