package com.unla.Grupo20OO22022.services;

import java.util.List;

import com.unla.Grupo20OO22022.models.PerfilModel;

public interface IPerfilService {
	public List<PerfilModel> listar();
	
	public PerfilModel traerId(long id);
	
	public PerfilModel insertOrUpdate(PerfilModel perfilModel);
	
	public boolean delete(long idPerfil);
	
	PerfilModel traerTipo(String tipo);
	
}
