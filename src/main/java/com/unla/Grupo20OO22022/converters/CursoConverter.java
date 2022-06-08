package com.unla.Grupo20OO22022.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.unla.Grupo20OO22022.entities.Curso;
import com.unla.Grupo20OO22022.models.CursoModel;
@Component("cursoConverter")
public class CursoConverter {
	
	@Autowired
	private MateriaConverter materiaConverter;
	
	public Curso modelToEntity(CursoModel cursoModel) {
		return new Curso(cursoModel.getIdNota(), cursoModel.getFecha(), cursoModel.getTurno(), cursoModel.getAula(),
				cursoModel.getProfesor(), cursoModel.getPorcentajeDeEstudiantes(),
				materiaConverter.modelToEntity(cursoModel.getMateria()), cursoModel.getObservaciones(),
				cursoModel.getCodCurso());
	}

	public CursoModel entityToModel(Curso curso) {
		return new CursoModel(curso.getIdNota(), curso.getFecha(), curso.getTurno(), curso.getAula(),
				curso.getProfesor(), curso.getPorcentajeDeEstudiantes(),
				materiaConverter.entityToModel(curso.getMateria()), curso.getObservaciones(),
				curso.getCodCurso());
	}

}
