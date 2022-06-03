package com.unla.Grupo20OO22022.controllers;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.Grupo20OO22022.entities.Perfil;
import com.unla.Grupo20OO22022.entities.Usuario;
import com.unla.Grupo20OO22022.helpers.ViewRouteHelper;
import com.unla.Grupo20OO22022.models.PerfilModel;
import com.unla.Grupo20OO22022.models.UsuarioModel;
import com.unla.Grupo20OO22022.services.implementation.UsuarioService;



@Controller
@RequestMapping ("/")
public class UserController {

	
	@Autowired
	@Qualifier("usuarioService")
	private UsuarioService service;
	

	@Autowired
	@Qualifier("perfilService")
	private IPerfilService servicePerfil; // implementar service
	
	@PreAuthorize("hasRole('ROLE_AUDITOR')|| hasRole('ROLE_ADMIN')  ")//
	@GetMapping("/listar")	
	public String listar(Model model) {
		List<Usuario> usuarios = service.listar();
		model.addAttribute("usuarios", usuarios);
		return ViewRouteHelper.HOME_INDEX;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/new")
	public String agregar(Model model) {
		List<PerfilModel> perfiles = servicePerfil.listar();
		List<Perfil> perfilesActivos = new ArrayList<Perfil>();
		for (PerfilModel p : perfiles) {
			if (p.isEnabled() == true) {
				perfilesActivos.add(p);
			}
		}
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("perfiles", perfilesActivos);
		return ViewRouteHelper.FORM_USUARIO;
	}
	
	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("usuario") Usuario u, BindingResult bindingResult, Model model ) {
		List<PerfilModel> perfiles = servicePerfil.listar(); // falta implementar services de perfil
		List<PerfilModel> perfilesActivos = new ArrayList<PerfilModel>();
		for (PerfilModel p : perfiles) {
			if (p.isEnabled() == true) {
				perfilesActivos.add(p);
			}
		}
		if (u.getNombre() == "" ) {
			FieldError error = new FieldError("usuario", "nombre", "Ingrese un nombre por favor. Intente nuevamente");
			bindingResult.addError(error);		
		}
		if (u.getApellido() == "" ) {
			FieldError error = new FieldError("usuario", "apellido", "Ingrese un apellido por favor. Intente nuevamente");
			bindingResult.addError(error);		
		}
		if (u.getEmail() == "" ) {
			FieldError error = new FieldError("usuario", "email", "Ingrese un email por favor. Intente nuevamente");
			bindingResult.addError(error);		
		}
		if (u.getUsername() == "" ) {
			FieldError error = new FieldError("usuario", "username", "Ingrese un username por favor. Intente nuevamente");
			bindingResult.addError(error);		
		}
		if (u.getPassword() == "" ) {
			FieldError error = new FieldError("usuario", "password", "Ingrese una clave por favor. Intente nuevamente");
			bindingResult.addError(error);		
		}
		
		if (service.traerPorId((int) u.getId_usuario()) == null) { //EL USUARIO ES NUEVO		
			if (service.findByDni(u.getDni())!=null ) {
				FieldError error = new FieldError("usuario", "dni", "Ya existe Usuario con DNI: "+ u.getDni() + ". Intente nuevamente");
				bindingResult.addError(error);
			}
			if (service.findByEmail(u.getEmail())!=null ) {
				FieldError error = new FieldError("usuario", "email", "Ya existe Usuario con Email: "+ u.getEmail() + ". Intente nuevamente");
				bindingResult.addError(error);
			}
			if (service.findByUsername(u.getUsername())!=null ) {
				FieldError error = new FieldError("usuario", "username", "Ya existe Usuario con Nombre de Usuario: "+ u.getUsername() + ". Intente nuevamente");
				bindingResult.addError(error);
			}
		}else { //SE ESTA EDITANDO UN USUARIO PRE EXISTENTE
			if (service.findByDni(u.getDni())!=null  && service.findByDni(u.getDni()).getId_usuario() != u.getId_usuario()){ // si el dni que quiere modificar es un dni que ya existe en la bd, que tire error
				FieldError error = new FieldError("usuario", "dni", "Ya existe Usuario con DNI: "+ u.getDni() + ". Intente nuevamente");
				bindingResult.addError(error);
			}
			if (service.findByEmail(u.getEmail())!=null && service.findByEmail(u.getEmail()).getId_usuario() != u.getId_usuario()) { //si el email que me llega ya existe en la bd, que tire error
				FieldError error = new FieldError("usuario", "email", "Ya existe Usuario con Email: "+ u.getEmail() + ". Intente nuevamente");
				bindingResult.addError(error);
			}
			if (service.findByUsername(u.getUsername()) != null && service.findByUsername(u.getUsername()).getId_usuario() !=u.getId_usuario()){//si el username que me esta enviando ya existe en la bd, que tire error
				FieldError error = new FieldError("usuario", "username", "Ya existe Usuario con Nombre de Usuario: "+ u.getUsername() + ". Intente nuevamente");
				bindingResult.addError(error);
			}
		}
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("usuario", u);
			model.addAttribute("perfiles", perfilesActivos);
			return ViewRouteHelper.FORM_USUARIO;
		}else {
			service.save(u);
			return ViewRouteHelper.HOME_INDEX;
		}

	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/editar/{id}")
	public String editar(Model model, @PathVariable int id) {
		Optional<Usuario> usuario = service.listarId(id);
		List<PerfilModel> perfiles = servicePerfil.listar();
		List<PerfilModel> perfilesActivos = new ArrayList<PerfilModel>();
		for (PerfilModel p : perfiles) {
			if (p.isEnabled() == true) {
				perfilesActivos.add(p);
			}
		}
		model.addAttribute("perfiles", perfilesActivos);
		model.addAttribute("usuario", usuario);
		return ViewRouteHelper.FORM_USUARIO;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/eliminar/{id}") // nose si está bien falta revisar
	public RedirectView delete(Model model, @PathVariable int id) {
		Usuario u = service.traerPorId(id);
		service.save(u);
		return new RedirectView(ViewRouteHelper.USUARIOS);
	}
	

	// ---------------------LOG IN------------------------------
			@GetMapping("/login")
			public String login(Model model,
								@RequestParam(name="error",required=false) String error,
								@RequestParam(name="logout", required=false) String logout) {
				model.addAttribute("error", error);
				model.addAttribute("logout", logout);
				return ViewRouteHelper.HOME_LOGIN;
			}

			@GetMapping("/logout")
			public String logout(Model model) {
			    return ViewRouteHelper.HOME_LOGOUT;
			}

			@GetMapping("/loginsuccess")
			public RedirectView loginCheck() {
				String ruta = "/";
				return new RedirectView(ruta);
			}
}