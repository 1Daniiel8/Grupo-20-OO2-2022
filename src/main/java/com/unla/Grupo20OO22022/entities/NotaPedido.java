package com.unla.Grupo20OO22022.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@DynamicInsert(true)
@DynamicUpdate(true)
@Table(name = "notaPedido")
public class NotaPedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idNota;
	
	@Column(name = "fecha")
	private LocalDate fecha;
	
	@Column(name = "turno")
	private char turno;
	
	@Column(name = "aula")
	private String aula;
	
	@Column(name = "profesor")
	private String profesor;
	
	@Column(name = "porcentajeDeEstudiantes")
	private int porcentajeDeEstudiantes;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
	@JoinColumn(name = "materia_idMateria", nullable = false)
	private Materia materia;
	
	@Column(name = "observaciones")
	private String observaciones;
	
	@Column(name = "createat")
	@CreationTimestamp
	private LocalDateTime createAt;
	
	@Column(name = "updateat") 
	@UpdateTimestamp
	private LocalDateTime updateAt;
	
	public NotaPedido() {}

	public NotaPedido(int idNota, LocalDate fecha, char turno, String aula, String profesor,
			int porcentajeDeEstudiantes, Materia materia, String observaciones) {
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
	
	public NotaPedido(LocalDate fecha, char turno, String aula, String profesor,
			int porcentajeDeEstudiantes, Materia materia, String observaciones) {
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

	protected void setIdNota(int idNota) {
		this.idNota = idNota;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
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

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}

	public LocalDateTime getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(LocalDateTime updateAt) {
		this.updateAt = updateAt;
	}
	
	
	

}
