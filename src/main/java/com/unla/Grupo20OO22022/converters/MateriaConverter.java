package com.unla.Grupo20OO22022.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.unla.Grupo20OO22022.entities.Materia;
import com.unla.Grupo20OO22022.models.MateriaModel;

@Component("materiaConverter")
public class MateriaConverter {
	
	@Autowired
	private CarreraConverter carreraConverter;
	
	public Materia modelToEntity(MateriaModel materiaModel) {
		return new Materia(materiaModel.getIdMateria(), materiaModel.getCodMateria(),materiaModel.getMateria(),carreraConverter.modelToEntity(materiaModel.getCarrera()));
	}
	
	public MateriaModel entityToModel (Materia materia) {
		return new MateriaModel(materia.getIdMateria(), materia.getCodMateria(),materia.getMateria(),carreraConverter.entityToModel(materia.getCarrera()));
	}

}
