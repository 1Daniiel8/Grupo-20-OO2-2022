package com.unla.Grupo20OO22022.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.unla.Grupo20OO22022.entities.Carrera;
import com.unla.Grupo20OO22022.models.CarreraModel;


@Component("carreraConverter")
public class CarreraConverter {
	
	@Autowired
	private DepartamentoConverter depaConverter;

	public Carrera modelToEntity(CarreraModel carreraModel) {
		return new Carrera(carreraModel.getIdCarrera(),carreraModel.getCarrera(),depaConverter.modelToEntity(carreraModel.getDepartamento()));
	}
	
	public CarreraModel entityToModel (Carrera carrera) {
		return new CarreraModel(carrera.getIdCarrera(),carrera.getCarrera(),depaConverter.entityToModel(carrera.getDepartamento()));
	}
}
