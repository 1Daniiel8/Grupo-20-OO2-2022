package com.unla.Grupo20OO22022.services;

import java.util.List;

import com.unla.Grupo20OO22022.models.UsuarioModel;

public interface IUsuarioService {
	
	public List<UsuarioModel> traerUsuarios();
	
	public UsuarioModel traerId(long id);

	public UsuarioModel traerUsername(String username);

	public UsuarioModel insertOrUpdate(UsuarioModel userModel);
		
	public boolean remove(long id);
	
	public UsuarioModel findByDni(long dni);
	
	public UsuarioModel findByEmail(String email);

}
