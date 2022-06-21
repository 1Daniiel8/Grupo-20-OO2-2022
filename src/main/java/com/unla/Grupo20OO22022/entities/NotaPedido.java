package com.unla.Grupo20OO22022.entities;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import com.unla.Grupo20OO22022.enums.Aprobado;

@Entity
@DynamicInsert(true)
@DynamicUpdate(true)
@Table(name = "notapedido")
@Inheritance(strategy = InheritanceType.JOINED)//HACE QUE SE CREEN TABLAS SEPARADAS DE LAS CLASES HIJA EN SQL
public abstract class NotaPedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idNota;
	
	@Column(name = "fecha")
	private Date fecha;
	
	@Column(name = "turno")
	private char turno;
	
	@Column(name = "aula")
	private String aula;
	
	@Column(name = "profesor")
	private String profesor;
	
	@Column(name = "porcentajeDeEstudiantes")
	private int porcentajeDeEstudiantes;
	
	@ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "idMateria", nullable = false)
	private Materia materia;
	
	@Column(name = "observaciones")
	private String observaciones;
	
	@Column(name = "aprobado")
	private Aprobado aprobado;
	
	@Column(name = "createat")
	@CreationTimestamp
	private LocalDateTime createAt;
	
	@Column(name = "updateat") 
	@UpdateTimestamp
	private LocalDateTime updateAt;
	
	public NotaPedido() {}

	public NotaPedido(int idNota, Date fecha, char turno, String aula, String profesor,
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
		this.aprobado = Aprobado.Desaprobado;
	}
	
	public NotaPedido(Date fecha, char turno, String aula, String profesor,
			int porcentajeDeEstudiantes, Materia materia, String observaciones) {
		this.fecha = fecha;
		this.turno = turno;
		this.aula = aula;
		this.profesor = profesor;
		this.porcentajeDeEstudiantes = porcentajeDeEstudiantes;
		this.materia = materia;
		this.observaciones = observaciones;
		this.aprobado = Aprobado.Desaprobado;
	}
	public NotaPedido(Date fecha, char turno, String aula, String profesor,
			int porcentajeDeEstudiantes, Materia materia) {
		this.fecha = fecha;
		this.turno = turno;
		this.aula = aula;
		this.profesor = profesor;
		this.porcentajeDeEstudiantes = porcentajeDeEstudiantes;
		this.materia = materia;
	}

	public int getIdNota() {
		return idNota;
	}

	protected void setIdNota(int idNota) {
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

	public Aprobado getAprobado() {
		return aprobado;
	}

	public void setAprobado(Aprobado aprobado) {
		this.aprobado = aprobado;
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
