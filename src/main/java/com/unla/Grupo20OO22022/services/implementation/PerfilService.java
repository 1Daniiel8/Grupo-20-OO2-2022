package com.unla.Grupo20OO22022.services.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.Grupo20OO22022.entities.Perfil;
import com.unla.Grupo20OO22022.repositories.IPerfilRepository;
import com.unla.Grupo20OO22022.services.IPerfilService;

@Service
public class PerfilService implements IPerfilService{

	@Autowired
	private IPerfilRepository data;
	
	@Override
	public List<Perfil> listar() {
		return (List<Perfil>)data.findAll();
	}

	@Override
	public Optional<Perfil> listarId(long idPerfil) {
		return data.findById(idPerfil);
	}

	@Override
	public int save(Perfil p) {
		int res = 0;
		Perfil perfil = data.save(p);
		if (!perfil.equals(null)) {
			res = 1;
		}
		return res;
	}

	@Override
	public void delete(long idPerfil) {
		data.deleteById(idPerfil);
	}
}
