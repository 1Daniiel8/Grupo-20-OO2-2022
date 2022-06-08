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
@Table(name = "curso")
@PrimaryKeyJoinColumn(name = "idNota")
public class Curso extends NotaPedido{
	
	@Column(name = "codCurso", unique = true)
	private int codCurso;
	
	public Curso() {
		
	}

	public Curso(int idNota, Date fecha, char turno, String aula, String profesor, int porcentajeDeEstudiantes, Materia materia, String observaciones, int codCurso) {
		super(idNota, fecha, turno, aula, profesor, porcentajeDeEstudiantes, materia, observaciones);
		this.codCurso = codCurso;
	}

	public int getCodCurso() {
		return codCurso;
	}

	public void setCodCurso(int codCurso) {
		this.codCurso = codCurso;
	}

}
