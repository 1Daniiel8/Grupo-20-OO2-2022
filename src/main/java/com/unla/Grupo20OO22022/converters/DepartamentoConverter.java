package com.unla.Grupo20OO22022.converters;

import org.springframework.stereotype.Component;

import com.unla.Grupo20OO22022.entities.Departamento;
import com.unla.Grupo20OO22022.models.DepartamentoModel;

@Component("departamentoConverter")
public class DepartamentoConverter {
	
	public Departamento modelToEntity(DepartamentoModel departamentoModel) {
		return new Departamento(departamentoModel.getIdDepartamento(),departamentoModel.getDepartamento());
	}
	
	public DepartamentoModel entityToModel (Departamento departamento) {
		return new DepartamentoModel(departamento.getIdDepartamento(),departamento.getDepartamento());
	}

}
