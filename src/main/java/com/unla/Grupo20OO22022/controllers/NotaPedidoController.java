package com.unla.Grupo20OO22022.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.unla.Grupo20OO22022.entities.NotaPedido;
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
	
	@GetMapping("/listarnotas")
	public ModelAndView listarByProfesor() {
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.NOTA_LISTA);
		List<CursoModel> cursoModels = new ArrayList<CursoModel>();
		List<FinalModel> finalModels = new ArrayList<FinalModel>();
		MateriaModel materiaModel = new MateriaModel();
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		for (NotaPedidoModel notaModel : notaService.findAllByProfesor(user.getUsername())) {
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
		modelAndView.addObject("add", true);
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
		modelAndView.addObject("add", true);
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
	
	@GetMapping("curso/aprobar")
	public ModelAndView updateCurso(@RequestParam(value= "idNota", required=false)NotaPedido nota) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.NOTA_CURSO_FORM);
		CursoModel cursoModel= new CursoModel();
		
		cursoModel =(CursoModel)notaService.findById(nota.getIdNota());
		
		mAV.addObject("notaPedido", cursoModel);
		mAV.addObject("materias", cursoModel.getMateria());
		mAV.addObject("add", false);
		return mAV;
	}
	
	@GetMapping("final/aprobar")
	public ModelAndView updateFinal(@RequestParam(value= "idNota", required=false)NotaPedido nota) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.NOTA_FINAL_FORM);
		FinalModel finalModel= new FinalModel();
		
		finalModel = (FinalModel)notaService.findById(nota.getIdNota());
		
		mAV.addObject("notaPedido", finalModel);
		mAV.addObject("materias", finalModel.getMateria());
		mAV.addObject("add", false);
		return mAV;
	}
	
	@PostMapping("curso/edit")
	public  ModelAndView update(@Valid @ModelAttribute("notaPedido") NotaPedidoModel cursoModel, BindingResult result,RedirectAttributes redirAttrs)
	{
		boolean editIncorrecto=false;
		
		ModelAndView mAV=null;
		
		CursoModel curso = (CursoModel) notaService.findById(cursoModel.getIdNota());
		curso.setAprobado(cursoModel.getAprobado());
		
		if (result.hasErrors())			
			{editIncorrecto=true;}
		
		if(editIncorrecto)
		{
			 mAV = new ModelAndView(ViewRouteHelper.NOTA_CURSO_FORM);
			 mAV.addObject("materias", materiaService.findAll());
		}else {
			notaService.insertOrUpdate(curso);
			redirAttrs.addFlashAttribute("success", curso.toString()+" editado exitosamente.");
			mAV =new ModelAndView(ViewRouteHelper.HOME_ROUTE);
		}
		return mAV;
	}

	
	@PostMapping("final/edit")
	public  ModelAndView update(@Valid @ModelAttribute("notaPedido") NotaPedido finalModel, BindingResult result,RedirectAttributes redirAttrs)
	{
		boolean editIncorrecto=false;
		
		FinalModel finalm = (FinalModel) notaService.findById(finalModel.getIdNota());
		finalm.setAprobado(finalModel.getAprobado());
		
		ModelAndView mAV=null;
		
		if (result.hasErrors())			
			{editIncorrecto=true;}
		
		if(editIncorrecto)
		{
			 mAV = new ModelAndView(ViewRouteHelper.NOTA_FINAL_FORM);
			 mAV.addObject("materias", materiaService.findAll());
		}else {
			notaService.insertOrUpdate(finalm);
			redirAttrs.addFlashAttribute("success", finalm.toString()+" editado exitosamente.");
			mAV =new ModelAndView(ViewRouteHelper.HOME_ROUTE);
		}
		return mAV;
	}

}
