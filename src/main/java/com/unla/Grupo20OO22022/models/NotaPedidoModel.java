package com.unla.Grupo20OO22022.models;

import java.sql.Date;
import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

public class NotaPedidoModel {
	
	private int idNota;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fecha;
	
	private char turno;
	
	@NotEmpty(message= "El aula no puede ser vacio.")
	private String aula;
	
	@NotEmpty(message= "Tiene q haber un profesor al menos.")
	private String profesor;
	
	@NotNull
	private int porcentajeDeEstudiantes;
	
	private MateriaModel materia;
	
	@NotEmpty(message= "ESTE CAMPO NO PUEDE ESTAR VACIO.")
	private String observaciones;
	
	@NotEmpty(message = "Debe selecionar una fecha de inicio valida.")
	private String fechaString;

	public NotaPedidoModel() {
		fechaString = Date.valueOf(LocalDate.now()).toString();
	}

	public NotaPedidoModel(int idNota, Date fecha, @NotEmpty(message = "El turno no puede ser vacio.") char turno,
			@NotEmpty(message = "El aula no puede ser vacio.") String aula,
			@NotEmpty(message = "El profesor no puede ser vacio.") String profesor,
			@NotEmpty(message = "El porcentaje no puede ser vacio.") int porcentajeDeEstudiantes, MateriaModel materia,
			String observaciones) {
		super();
		this.idNota = idNota;
		this.fecha = fecha;
		this.turno = turno;
		this.aula = aula;
		this.profesor = profesor;
		this.porcentajeDeEstudiantes = porcentajeDeEstudiantes;
		this.materia = materia;
		this.observaciones = observaciones;
	}


	public NotaPedidoModel(Date fecha, @NotEmpty(message = "El turno no puede ser vacio.") char turno,
			@NotEmpty(message = "El aula no puede ser vacio.") String aula,
			@NotEmpty(message = "El profesor no puede ser vacio.") String profesor,
			@NotEmpty(message = "El porcentaje no puede ser vacio.") int porcentajeDeEstudiantes, MateriaModel materia,
			String observaciones) {
		super();
		this.fecha = fecha;
		this.turno = turno;
		this.aula = aula;
		this.profesor = profesor;
		this.porcentajeDeEstudiantes = porcentajeDeEstudiantes;
		this.materia = materia;
		this.observaciones = observaciones;
	}


	public int getIdNota() {
		return idNota;
	}


	public void setIdNota(int idNota) {
		this.idNota = idNota;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public char getTurno() {
		return turno;
	}


	public void setTurno(char turno) {
		this.turno = turno;
	}


	public String getAula() {
		return aula;
	}


	public void setAula(String aula) {
		this.aula = aula;
	}


	public String getProfesor() {
		return profesor;
	}


	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}


	public int getPorcentajeDeEstudiantes() {
		return porcentajeDeEstudiantes;
	}


	public void setPorcentajeDeEstudiantes(int porcentajeDeEstudiantes) {
		this.porcentajeDeEstudiantes = porcentajeDeEstudiantes;
	}


	public MateriaModel getMateria() {
		return materia;
	}


	public void setMateria(MateriaModel materia) {
		this.materia = materia;
	}


	public String getObservaciones() {
		return observaciones;
	}


	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getFechaString() {
		return fechaString;
	}

	public void setFechaString(String fechaString) {
		this.fechaString = fechaString;
	}

	@Override
	public String toString() {
		return "NotaPedidoModel [fecha=" + fecha + ", turno=" + turno + ", aula=" + aula + ", profesor=" + profesor
				+ ", porcentajeDeEstudiantes=" + porcentajeDeEstudiantes + ", materia=" + materia + ", observaciones="
				+ observaciones + "]";
	}
	
	
	
	
	
	
	

}
