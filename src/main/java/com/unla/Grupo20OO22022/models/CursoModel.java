package com.unla.Grupo20OO22022.models;

import javax.validation.constraints.Min;

import com.sun.istack.NotNull;

public class CursoModel extends NotaPedidoModel {
	
	@NotNull
	@Min(value=4,message="EL CODIGO DEL CURSO TIENE QUE TENER MIN. 4 NUMEROS")
	private int codCurso;

	public CursoModel() {}

	public CursoModel(@Min(value = 4, message = "EL CODIGO DEL CURSO TIENE QUE TENER MIN. 4 NUMEROS") int codCurso) {
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
