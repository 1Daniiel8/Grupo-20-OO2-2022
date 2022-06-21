package com.unla.Grupo20OO22022.models;

import java.util.Objects;

import javax.validation.constraints.NotEmpty;

public class DepartamentoModel {
	
	private long idDepartamento;
	
	@NotEmpty(message= "El departamento no puede estar vacio.")
	private String departamento;

	public DepartamentoModel() {}
	
	public DepartamentoModel(long idDepartamento, String departamento) {
		super();
		this.idDepartamento = idDepartamento;
		this.departamento = departamento;
	}
	public DepartamentoModel(String departamento) {
		this.departamento = departamento;
	}

	public long getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(long idDepartamento) {
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
		return departamento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(departamento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DepartamentoModel other = (DepartamentoModel) obj;
		return Objects.equals(departamento, other.departamento);
	}

}
