package com.unla.Grupo20OO22022.models;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class FinalModel extends NotaPedidoModel {
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private int duracion;

	public FinalModel() {}

	public FinalModel(int idNota, Date fecha,char turno, String aula,String profesor, int porcentajeDeEstudiantes, 
			MateriaModel materia, String observaciones, int duracion) {
		super(idNota,fecha,turno,aula,profesor,porcentajeDeEstudiantes,materia,observaciones);
		this.duracion = duracion;
	}
	
	public FinalModel(Date fecha,char turno, String aula,String profesor, int porcentajeDeEstudiantes, 
			MateriaModel materia, String observaciones, int duracion) {
		super(fecha,turno,aula,profesor,porcentajeDeEstudiantes,materia,observaciones);
		this.duracion = duracion;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	@Override
	public String toString() {
		return super.toString()+" -> Final [duracion=" + duracion + "]";
	}
	
	
	
	

}
