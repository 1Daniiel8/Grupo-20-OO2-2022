package com.unla.Grupo20OO22022.ABM.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name ="usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idUsuario; // HACE FALTA EL IDSUARIO?
	
	@Column (name="email", nullable=false, length=45)
	private String email ;
	
	@Column (name="username", nullable=false, length=45)
	private String username;
	
	@Column (name="password", nullable=false, length=45)
	private String password;
	
	@ManyToOne (fetch =FetchType.LAZY)
	@JoinColumn (name= "idPerfil" , nullable=false)
	private Perfil perfil;
	
	
	public Usuario () {} 
	
	public Usuario(int idUsuario,String email, String username, String password,Perfil perfil) {
		super();
		this.idUsuario=idUsuario;
		this.email = email;
		this.username = username;
		this.password = password;
		this.perfil = perfil;
	}

	

	public int getIdUsuario() {
		return idUsuario;
	}



	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public Perfil getPerfil() {
		return perfil;
	}



	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}



	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", email=" + email + ", username=" + username + ", password="
				+ password + "]";
	}
	
	
	
	
	
	
}
