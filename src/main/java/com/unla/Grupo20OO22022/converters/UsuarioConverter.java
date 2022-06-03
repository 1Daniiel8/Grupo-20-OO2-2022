package com.unla.Grupo20OO22022.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.unla.Grupo20OO22022.entities.Usuario;
import com.unla.Grupo20OO22022.models.UsuarioModel;


@Component ("usuarioConverter")
public class UsuarioConverter {

	
	@Autowired
	@Qualifier("perfilConverter")
	private PerfilConverter perfilConverter; // agregar Perfil converter
	
	public UsuarioModel entityToModel(Usuario usuario) {
		return new UsuarioModel(usuario.getId_usuario(), usuario.getNombre(), usuario.getApellido(),usuario.getDni(), usuario.getEmail(), usuario.getUsername(), usuario.getPassword(), perfilConverter.entityToModel(usuario.getPerfil()));
	}
	
	public Usuario modelToEntity(UsuarioModel usuarioModel) {
		return new Usuario(usuarioModel.getNombre(), usuarioModel.getApellido(), usuarioModel.getDni(), usuarioModel.getEmail(), usuarioModel.getUsername(), usuarioModel.getPassword(), perfilConverter.modelToEntity(usuarioModel.getPerfil()));
	}
}
