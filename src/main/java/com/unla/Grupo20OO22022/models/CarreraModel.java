package com.unla.Grupo20OO22022.models;

import javax.validation.constraints.NotNull;

public class CarreraModel {
	
	private int idCarrera;
	
	@NotNull(message="Carrera no puede ser campo vacio")
	private String carrera;	
	
	private DepartamentoModel departamento;
	
	public CarreraModel() {}

	public CarreraModel(int idCarrera,@NotNull(message="Carrera no puede ser campo vacio") String carrera, DepartamentoModel departamento) {
		super();
		this.idCarrera = idCarrera;
		this.carrera = carrera;
		this.departamento = departamento;
	}
	public CarreraModel(@NotNull(message="Carrera no puede ser campo vacio") String carrera, DepartamentoModel departamento) {
		this.carrera = carrera;
		this.departamento = departamento;
	}

	public int getIdCarrera() {
		return idCarrera;
	}

	public void setIdCarrera(int idCarrera) {
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
		return "Carrera: " + carrera + ", departamento:" + departamento + "]";
	}
	
	
	
	

}
