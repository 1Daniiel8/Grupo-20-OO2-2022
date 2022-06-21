package com.unla.Grupo20OO22022.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.Grupo20OO22022.converters.CursoConverter;
import com.unla.Grupo20OO22022.converters.FinalConverter;
import com.unla.Grupo20OO22022.entities.Curso;
import com.unla.Grupo20OO22022.entities.Final;
import com.unla.Grupo20OO22022.entities.NotaPedido;
import com.unla.Grupo20OO22022.models.CursoModel;
import com.unla.Grupo20OO22022.models.FinalModel;
import com.unla.Grupo20OO22022.models.NotaPedidoModel;
import com.unla.Grupo20OO22022.repositories.INotaPedidoRepository;
import com.unla.Grupo20OO22022.services.INotaPedidoService;

@Service("notaPedidoService")
public class NotaPedidoService implements INotaPedidoService {

	@Autowired
	private FinalConverter finalConverter;
	
	@Autowired
	private CursoConverter cursoConverter;
	
	@Autowired
	@Qualifier("notaPedidoRepository")
	private INotaPedidoRepository notaRepository;
	
	@Override
	public List<NotaPedidoModel> findAll() {
		List<NotaPedidoModel> permisos = new ArrayList<NotaPedidoModel>();
		for(NotaPedido nota : notaRepository.findAll()) {
			if(nota instanceof Final)
				permisos.add(finalConverter.entityToModel((Final)nota));
			else if(nota instanceof Curso)
				permisos.add(cursoConverter.entityToModel((Curso)nota));
		}
		return permisos;
	}

	@Override
	public NotaPedidoModel findById(int id) {
		NotaPedido nota = notaRepository.findById(id);
		if(nota instanceof Final)
			return finalConverter.entityToModel((Final)nota);
		else if(nota instanceof Curso)
			return cursoConverter.entityToModel((Curso)nota);
		return null;
	}

	@Override
	public List<FinalModel> findAllFinal() {
		List<FinalModel> aux = new ArrayList<FinalModel>();
		for(NotaPedido nota : notaRepository.findAll()) {
			if(nota instanceof Final)
				aux.add(finalConverter.entityToModel((Final)nota));
		}
		return aux;
	}

	@Override
	public List<CursoModel> findAllCurso() {
		List<CursoModel> aux = new ArrayList<CursoModel>();
		for(NotaPedido nota : notaRepository.findAll()) {
			if(nota instanceof Curso)
				aux.add(cursoConverter.entityToModel((Curso)nota));
		}
		return aux;
	}

	@Override
	public NotaPedidoModel insertOrUpdate(NotaPedidoModel notaPedidoModel) {
		if (notaPedidoModel instanceof FinalModel)
			return finalConverter
					.entityToModel(notaRepository.save(finalConverter.modelToEntity((FinalModel) notaPedidoModel)));

		else if (notaPedidoModel instanceof CursoModel)
			return cursoConverter
					.entityToModel(notaRepository.save(cursoConverter.modelToEntity((CursoModel) notaPedidoModel)));
		return null;
	}

	@Override
	public List<NotaPedidoModel> findAllByProfesor(String profesor) {
		List<NotaPedidoModel> permisos = new ArrayList<NotaPedidoModel>();
		
		for (NotaPedido nota : notaRepository.findByProfesor(profesor)) {	
				if (nota instanceof Final)
					permisos.add(finalConverter.entityToModel((Final) nota));
				else if (nota instanceof Curso)
					permisos.add(cursoConverter.entityToModel((Curso) nota));
		}
		return permisos;
	}


}
