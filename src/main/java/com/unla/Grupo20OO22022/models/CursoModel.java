package com.unla.Grupo20OO22022.models;

import java.sql.Date;

import javax.validation.constraints.Min;

import com.sun.istack.NotNull;

public class CursoModel extends NotaPedidoModel {
	
	@NotNull
	@Min(value=4,message="EL CODIGO DEL CURSO TIENE QUE TENER MIN. 4 NUMEROS")
	private int codCurso;

	public CursoModel() {}

	public CursoModel(int idNota, Date fecha,char turno, String aula,String profesor, int porcentajeDeEstudiantes, 
			MateriaModel materia, String observaciones,
			@Min(value = 4, message = "EL CODIGO DEL CURSO TIENE QUE TENER MIN. 4 NUMEROS")int codCurso) {
		super(idNota,fecha,turno,aula,profesor,porcentajeDeEstudiantes,materia,observaciones);
		this.codCurso = codCurso;
	}
	
	public CursoModel(Date fecha,char turno, String aula,String profesor, int porcentajeDeEstudiantes, 
			MateriaModel materia, String observaciones,
			@Min(value = 4, message = "EL CODIGO DEL CURSO TIENE QUE TENER MIN. 4 NUMEROS")int codCurso) {
		super(fecha,turno,aula,profesor,porcentajeDeEstudiantes,materia,observaciones);
		this.codCurso = codCurso;
	}

	public int getCodCurso() {
		return codCurso;
	}

	public void setCodCurso(int codCurso) {
		this.codCurso = codCurso;
	}

	@Override
	public String toString() {
		return super.toString()+" -> Curso [codCurso=" + codCurso + "]";
	}

}
