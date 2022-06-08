package com.unla.Grupo20OO22022.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.unla.Grupo20OO22022.entities.Perfil;
import com.unla.Grupo20OO22022.entities.Usuario;
import com.unla.Grupo20OO22022.models.PerfilModel;
import com.unla.Grupo20OO22022.models.UsuarioModel;
import com.unla.Grupo20OO22022.repositories.IPerfilRepository;
import com.unla.Grupo20OO22022.services.implementation.PerfilService;

@Component("usuarioConverter")
public class UsuarioConverter {
	
	@Autowired
	private PerfilService perfilService;
	@Autowired
	private IPerfilRepository perfilR;
	
	public Usuario modelToEntity(UsuarioModel usuarioModel) {
		
		Perfil perfil = perfilR.findById(usuarioModel.getPerfil().getIdPerfil());
		return new Usuario(usuarioModel.getIdPersona(),usuarioModel.getNombre(),usuarioModel.getApellido(), 
				usuarioModel.getDni(), usuarioModel.getEmail(), usuarioModel.getUsername(),
				usuarioModel.getPassword(),perfil);
	}

	public UsuarioModel entityToModel(Usuario usuario) {
		
		PerfilModel perfilM = perfilService.traerId(usuario.getPerfil().getIdPerfil());
		return new UsuarioModel(usuario.getIdPersona(), usuario.getDni(), usuario.getNombre(), usuario.getApellido(),
				usuario.getEmail(), usuario.getUsername(), usuario.getPassword(), perfilM);
	}

}
