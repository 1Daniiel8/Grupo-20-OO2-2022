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
import com.unla.Grupo20OO22022.models.DepartamentoModel;
import com.unla.Grupo20OO22022.services.implementation.CarreraService;
import com.unla.Grupo20OO22022.services.implementation.DepartamentoService;

@Controller
@RequestMapping("/carrera")
public class CarreraController {
	
	@Autowired
	@Qualifier("carreraService")
	private CarreraService carreraService;
	
	@Autowired
	@Qualifier("departamentoService")
	private DepartamentoService departamentoService;
	
	@GetMapping("/new")
	public ModelAndView formCarrera() {
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.CARRERA_FORM);
		modelAndView.addObject("carrera", new CarreraModel());
		List<DepartamentoModel> departamentos = departamentoService.traerDepartamentos();
		modelAndView.addObject("departamentos", departamentos);
		return modelAndView;
	}
	
	@PostMapping("/save")
	public ModelAndView save(@Valid @ModelAttribute("carrera") CarreraModel carreraModel, BindingResult bindingResult, RedirectAttributes redirAttrs)
	{
		ModelAndView mAV = new ModelAndView();
		CarreraModel carreraExistente = carreraService.traerCarrera(carreraModel.getCarrera());
		if(carreraModel.equals(carreraExistente))
		{
			FieldError error = new FieldError("carrera", "carrera", "Ya existe una carrera con el nombre ingresado");
			bindingResult.addError(error);
			mAV.setViewName(ViewRouteHelper.CARRERA_FORM);
		}else if(bindingResult.hasErrors())
		{
			List<DepartamentoModel> depas = departamentoService.traerDepartamentos();
			mAV.addObject("departamentos",depas);
			mAV.setViewName(ViewRouteHelper.CARRERA_FORM);
		} else{
			    carreraModel.setDepartamento(departamentoService.traerId(carreraModel.getDepartamento().getIdDepartamento()));
			    carreraService.insertOrUpdate(carreraModel);
		    	redirAttrs.addFlashAttribute("success", carreraModel.toString()+" agregado exitosamente.");
		    	mAV.setViewName(ViewRouteHelper.HOME_ROUTE);
		    }
		return mAV;
	}

}
