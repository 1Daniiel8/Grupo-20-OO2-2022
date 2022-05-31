package com.unla.Grupo20OO22022.models;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class FinalModel extends NotaPedidoModel {
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaExamen;

	public FinalModel() {}

	public FinalModel(Date fechaExamen) {
		super();
		this.fechaExamen = fechaExamen;
	}

	public Date getFechaExamen() {
		return fechaExamen;
	}

	public void setFechaExamen(Date fechaExamen) {
		this.fechaExamen = fechaExamen;
	}

	@Override
	public String toString() {
		return super.toString()+" -> Final [fechaExamen=" + fechaExamen + "]";
	}
	
	
	
	

}
