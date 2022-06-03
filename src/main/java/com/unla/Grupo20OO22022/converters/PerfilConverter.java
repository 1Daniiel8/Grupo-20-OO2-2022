package com.unla.Grupo20OO22022.converters;

import org.springframework.stereotype.Component;

import com.unla.Grupo20OO22022.entities.Perfil;
import com.unla.Grupo20OO22022.models.PerfilModel;

@Component("perfilConverter")
public class PerfilConverter {
	public Perfil modelToEntity(PerfilModel perfilModel) {
		return new Perfil(perfilModel.getIdPerfil(), perfilModel.getTipo());
	}
	
	public PerfilModel entityToModel(Perfil perfil) {
		return new PerfilModel(perfil.getIdPerfil(), perfil.getTipo());
	}
}
