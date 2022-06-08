package com.unla.Grupo20OO22022.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.unla.Grupo20OO22022.helpers.ViewRouteHelper;
import com.unla.Grupo20OO22022.models.CursoModel;
import com.unla.Grupo20OO22022.models.FinalModel;
import com.unla.Grupo20OO22022.models.MateriaModel;
import com.unla.Grupo20OO22022.models.NotaPedidoModel;
import com.unla.Grupo20OO22022.services.implementation.MateriaService;
import com.unla.Grupo20OO22022.services.implementation.NotaPedidoService;

@Controller
@RequestMapping("/nota")
public class NotaPedidoController {
	
	@Autowired
	@Qualifier("notaPedidoService")
	private NotaPedidoService notaService;
	
	@Autowired
	private MateriaService materiaService;
	
	@GetMapping("/listar")
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.NOTA_LISTA);
		List<CursoModel> cursoModels = new ArrayList<CursoModel>();
		List<FinalModel> finalModels = new ArrayList<FinalModel>();
		MateriaModel materiaModel = new MateriaModel();

		for (NotaPedidoModel notaModel : notaService.findAll()) {
			if (notaModel instanceof CursoModel)
				cursoModels.add((CursoModel) notaModel);
			else if (notaModel instanceof FinalModel)
				finalModels.add((FinalModel) notaModel);
		}

		modelAndView.addObject("cursos", cursoModels);
		modelAndView.addObject("finales", finalModels);
		modelAndView.addObject("materia", materiaModel);
		return modelAndView;
	}
	
	@Transactional
	@GetMapping("/curso/new")
	public ModelAndView formCurso(@RequestParam(name = "error", required = false) String error) {
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.NOTA_CURSO_FORM);
		modelAndView.addObject("notaPedido", new CursoModel());
		modelAndView.addObject("materias", materiaService.findAll());
		modelAndView.addObject("error", error);
		modelAndView.addObject("hoy", DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDate.now()));

		return modelAndView;
	}
	
	@Transactional
	@PostMapping("/curso/save")
	public ModelAndView saveCurso(@Valid @ModelAttribute("notaPedido") CursoModel cursoModel, BindingResult bindingResult){
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.HOME_ROUTE);
		
		if(cursoModel.getObservaciones()==null) {
			cursoModel.setObservaciones(" ");
		}
		
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("materias", materiaService.findAll());
			modelAndView.setViewName(ViewRouteHelper.NOTA_CURSO_FORM);
		}else {
			cursoModel.setMateria(materiaService.traerId((cursoModel.getMateria().getIdMateria())));
			notaService.insertOrUpdate(cursoModel);
		}
		return modelAndView;
	}
	
	@Transactional
	@GetMapping("/final/new")
	public ModelAndView formFinal(@RequestParam(name = "error", required = false) String error) {
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.NOTA_FINAL_FORM);
		modelAndView.addObject("notaPedido", new FinalModel());
		modelAndView.addObject("materias", materiaService.findAll());
		modelAndView.addObject("error", error);
		modelAndView.addObject("hoy", DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDate.now()));

		return modelAndView;
	}
	
	@Transactional
	@PostMapping("/final/save")
	public ModelAndView saveFinal(@Valid @ModelAttribute("notaPedido") FinalModel finalModel,
			BindingResult bindingResult){
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.HOME_ROUTE);
		
		if(finalModel.getObservaciones()==null) {
			finalModel.setObservaciones(" ");
		}
		
		if (bindingResult.hasErrors()) {	
			modelAndView.addObject("materias", materiaService.findAll());
			modelAndView.setViewName(ViewRouteHelper.NOTA_FINAL_FORM);
			return modelAndView;
		}
			
		else {
			finalModel.setMateria(materiaService.traerId((finalModel.getMateria().getIdMateria())));
			notaService.insertOrUpdate(finalModel);
			
			return modelAndView;
		}
	}

}
