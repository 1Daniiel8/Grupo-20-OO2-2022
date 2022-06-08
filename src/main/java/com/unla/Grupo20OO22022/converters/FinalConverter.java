package com.unla.Grupo20OO22022.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.unla.Grupo20OO22022.entities.Final;
import com.unla.Grupo20OO22022.models.FinalModel;

@Component("finalConverter")
public class FinalConverter {

	@Autowired
	private MateriaConverter materiaConverter;

	public Final modelToEntity(FinalModel finalModel) {
		return new Final(finalModel.getIdNota(), finalModel.getFecha(), finalModel.getTurno(), finalModel.getAula(),
				finalModel.getProfesor(), finalModel.getPorcentajeDeEstudiantes(),
				materiaConverter.modelToEntity(finalModel.getMateria()), finalModel.getObservaciones(),
				finalModel.getDuracion());
	}

	public FinalModel entityToModel(Final finalEnt) {
		return new FinalModel(finalEnt.getIdNota(), finalEnt.getFecha(), finalEnt.getTurno(), finalEnt.getAula(),
				finalEnt.getProfesor(), finalEnt.getPorcentajeDeEstudiantes(),
				materiaConverter.entityToModel(finalEnt.getMateria()), finalEnt.getObservaciones(),
				finalEnt.getDuracion());
	}

}
