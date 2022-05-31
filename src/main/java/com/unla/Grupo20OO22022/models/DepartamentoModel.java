package com.unla.Grupo20OO22022.models;

import javax.validation.constraints.NotNull;

public class DepartamentoModel {
	
	private int idDepartamento;
	
	@NotNull(message="Departamento no puede ser estar vacio")
	private String departamento;

	public DepartamentoModel() {}
	
	public DepartamentoModel(int idDepartamento,
			@NotNull(message = "Departamento no puede ser estar vacio") String departamento) {
		super();
		this.idDepartamento = idDepartamento;
		this.departamento = departamento;
	}
	public DepartamentoModel(@NotNull(message = "Departamento no puede ser estar vacio") String departamento) {
		this.departamento = departamento;
	}

	public int getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(int idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return "DepartamentoModel :" + departamento;
	}
	
	
	

}
