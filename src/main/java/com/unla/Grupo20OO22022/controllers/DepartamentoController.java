package com.unla.Grupo20OO22022.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.unla.Grupo20OO22022.helpers.ViewRouteHelper;
import com.unla.Grupo20OO22022.models.DepartamentoModel;
import com.unla.Grupo20OO22022.services.implementation.DepartamentoService;

@Controller
@RequestMapping("/departamento")
public class DepartamentoController {
	
	@Autowired
	@Qualifier("departamentoService")
	private DepartamentoService departamentoService;
	
	@GetMapping("/new")
	public ModelAndView formDepartamento() {
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.DEPARTAMENTO_FORM);
		modelAndView.addObject("departamento", new DepartamentoModel());
		return modelAndView;
	}
	
	@PostMapping("/save")
	public ModelAndView save(@Valid @ModelAttribute("departamento") DepartamentoModel departamentoModel, BindingResult bindingResult, RedirectAttributes redirAttrs)
	{
		ModelAndView mAV;

		DepartamentoModel departamentoExistente = departamentoService.traerDepa(departamentoModel.getDepartamento());
		if(departamentoModel.equals(departamentoExistente))
		{
			FieldError error = new FieldError("departamento", "departamento", "Ya existe un departamento con el nombre ingresado");
			bindingResult.addError(error);
			mAV = new ModelAndView(ViewRouteHelper.DEPARTAMENTO_FORM);
		}else if(bindingResult.hasErrors())
		{
			mAV = new ModelAndView(ViewRouteHelper.DEPARTAMENTO_FORM);
		} else{
			departamentoService.insertOrUpdate(departamentoModel);
		    	redirAttrs.addFlashAttribute("success", departamentoModel.toString()+" agregado exitosamente.");
		       	mAV = new ModelAndView(ViewRouteHelper.HOME_ROUTE);
		    }
		return mAV;
	}

}
