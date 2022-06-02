package com.unla.Grupo20OO22022.services;

import java.util.List;
import java.util.Optional;

import com.unla.Grupo20OO22022.entities.Perfil;


public interface IPerfilService {
	public List<Perfil> listar();
	public Optional<Perfil> listarId(long idPerfil);
	public int save(Perfil p);
	public void delete(long idPerfil);
}
