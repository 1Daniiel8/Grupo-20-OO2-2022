package com.unla.Grupo20OO22022.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MateriaModel {
	
	private int idMateria;
	
	@NotNull(message="Codigo de Materia no puede ser estar vacio")
	@Min(value=4,message="EL CODIGO DE MATERIA TIENE QUE TENER 4 NUMEROS MIN.")
	private int codMateria;
	
	@Size(min=3,max=20, message="EL NOMBRE DE LA MATERIA DEBE TENER ENTRE 3 Y 20 CARACTERES")
	private String materia;
	
	private CarreraModel carrera;
	
	public MateriaModel() {}

	public MateriaModel(int idMateria,
			@NotNull(message = "Codigo de Materia no puede ser estar vacio") @Min(value = 4, message = "EL CODIGO DE MATERIA TIENE QUE TENER 4 NUMEROS MIN.") int codMateria,
			@Size(min = 3, max = 20, message = "EL NOMBRE DE LA MATERIA DEBE TENER ENTRE 3 Y 20 CARACTERES") String materia,
			CarreraModel carrera) {
		super();
		this.idMateria = idMateria;
		this.codMateria = codMateria;
		this.materia = materia;
		this.carrera = carrera;
	}
	
	public MateriaModel(
			@NotNull(message = "Codigo de Materia no puede ser estar vacio") @Min(value = 4, message = "EL CODIGO DE MATERIA TIENE QUE TENER 4 NUMEROS MIN.") int codMateria,
			@Size(min = 3, max = 20, message = "EL NOMBRE DE LA MATERIA DEBE TENER ENTRE 3 Y 20 CARACTERES") String materia,
			CarreraModel carrera) {
		super();
		this.codMateria = codMateria;
		this.materia = materia;
		this.carrera = carrera;
	}

	public int getIdMateria() {
		return idMateria;
	}

	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}

	public int getCodMateria() {
		return codMateria;
	}

	public void setCodMateria(int codMateria) {
		this.codMateria = codMateria;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public CarreraModel getCarrera() {
		return carrera;
	}

	public void setCarrera(CarreraModel carrera) {
		this.carrera = carrera;
	}

	@Override
	public String toString() {
		return "Materia :" + materia + " de la carrera:" + carrera;
	}

	

}
