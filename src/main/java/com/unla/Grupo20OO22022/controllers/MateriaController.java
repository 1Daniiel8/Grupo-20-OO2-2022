package com.unla.Grupo20OO22022.controllers;

import java.util.List;

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
import com.unla.Grupo20OO22022.models.CarreraModel;
import com.unla.Grupo20OO22022.models.MateriaModel;
import com.unla.Grupo20OO22022.services.implementation.MateriaService;
import com.unla.Grupo20OO22022.services.implementation.CarreraService;

@Controller
@RequestMapping("/materia")
public class MateriaController {
	
	@Autowired
	@Qualifier("materiaService")
	private MateriaService materiaService;
	
	@Autowired
	@Qualifier("carreraService")
	private CarreraService carreraService;
	
	@GetMapping("/new")
	public ModelAndView formMateria() {
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.MATERIA_FORM);
		modelAndView.addObject("materia", new MateriaModel());
		List<CarreraModel> carreras = carreraService.traerCarreras();
		modelAndView.addObject("carreras", carreras);
		return modelAndView;
	}
	
	@PostMapping("/save")
	public ModelAndView save(@Valid @ModelAttribute("materia") MateriaModel materiaModel, BindingResult bindingResult, RedirectAttributes redirAttrs)
	{
		ModelAndView mAV = new ModelAndView();
		MateriaModel materiaExistente = materiaService.traerCodMateria(materiaModel.getCodMateria());
		if(materiaModel.equals(materiaExistente))
		{
			FieldError error = new FieldError("materia", "codMateria", "Ya existe una materia con el codigo ingresado");
			bindingResult.addError(error);
			mAV.setViewName(ViewRouteHelper.MATERIA_FORM);
		}else if(bindingResult.hasErrors())
		{
			List<CarreraModel> carreras = carreraService.traerCarreras();
			mAV.addObject("carreras",carreras);
			mAV.setViewName(ViewRouteHelper.MATERIA_FORM);
		} else{
			    materiaModel.setCarrera(carreraService.traerId(materiaModel.getCarrera().getIdCarrera()));
			    materiaService.insertOrUpdate(materiaModel);
		    	redirAttrs.addFlashAttribute("success", materiaModel.toString()+" agregado exitosamente.");
		    	mAV.setViewName(ViewRouteHelper.HOME_ROUTE);
		    }
		return mAV;
	}

}
