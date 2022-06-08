package com.unla.Grupo20OO22022.entities;

import java.sql.Date;

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
	
	@Column(name = "duracion")
	private int duracion;
	
	public Final() {}

	public Final(int idNota, Date fecha, char turno, String aula, String profesor,
			int porcentajeDeEstudiantes, Materia materia, String observaciones, int duracion) {
		super(idNota, fecha, turno, aula, profesor, porcentajeDeEstudiantes, materia, observaciones);
		this.duracion = duracion;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	

}
