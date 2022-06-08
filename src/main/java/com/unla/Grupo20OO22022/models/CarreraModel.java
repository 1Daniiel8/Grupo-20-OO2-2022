package com.unla.Grupo20OO22022.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class CarreraModel {
	
	private long idCarrera;
	
	@NotEmpty(message= "La carrera no puede estar vacio.")
	private String carrera;	
	
	private DepartamentoModel departamento;
	
	public CarreraModel() {}

	public CarreraModel(long idCarrera, @Size(min = 4, max = 30)String carrera, DepartamentoModel departamento) {
		super();
		this.idCarrera = idCarrera;
		this.carrera = carrera;
		this.departamento = departamento;
	}
	public CarreraModel(String carrera, DepartamentoModel departamento) {
		super();
		this.carrera = carrera;
		this.departamento = departamento;
	}

	public long getIdCarrera() {
		return idCarrera;
	}

	public void setIdCarrera(long idCarrera) {
		this.idCarrera = idCarrera;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public DepartamentoModel getDepartamento() {
		return departamento;
	}

	public void setDepartamento(DepartamentoModel departamento) {
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return "Carrera -> Carrera: " + carrera + "  Departamento:" + departamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carrera == null) ? 0 : carrera.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarreraModel other = (CarreraModel) obj;
		if (carrera == null) {
			if (other.carrera != null)
				return false;
		} else if(!carrera.equals(other.carrera))
			return false;
		return true;
	}
}
