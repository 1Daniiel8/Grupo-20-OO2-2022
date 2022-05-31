package com.unla.Grupo20OO22022.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicInsert(true)
@DynamicUpdate(true)
@Table(name = "final")
@PrimaryKeyJoinColumn(name = "idNota")
public class Final extends NotaPedido{
	
	@Column(name = "fechaExamen", unique = true)
	private LocalDate fechaExamen;
	
	public Final() {}

	public Final(int idNota, LocalDate fecha, char turno, String aula, String profesor,
			int porcentajeDeEstudiantes, Materia materia, String observaciones, LocalDate fechaExamen) {
		super(idNota, fecha, turno, aula, profesor, porcentajeDeEstudiantes, materia, observaciones);
		this.fechaExamen = fechaExamen;
	}
	
	public Final(LocalDate fecha, char turno, String aula, String profesor,
			int porcentajeDeEstudiantes, Materia materia, String observaciones, LocalDate fechaExamen) {
		super(fecha, turno, aula, profesor, porcentajeDeEstudiantes, materia, observaciones);
		this.fechaExamen = fechaExamen;
	}

	public LocalDate getFechaExamen() {
		return fechaExamen;
	}

	public void setFechaExamen(LocalDate fechaExamen) {
		this.fechaExamen = fechaExamen;
	}
	
	
	

}
