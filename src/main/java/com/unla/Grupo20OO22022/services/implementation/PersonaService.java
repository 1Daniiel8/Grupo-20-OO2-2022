package com.unla.Grupo20OO22022.services.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.unla.Grupo20OO22022.entities.Persona;
import com.unla.Grupo20OO22022.repositories.IPersonaRepository;
import com.unla.Grupo20OO22022.services.IPersonaService;

public class PersonaService implements IPersonaService{
	@Autowired
	@Qualifier("personaRepository")
	private IPersonaRepository iPersonaRepository;
	
	@Override
	public List<Persona> listar() {
		return (List<Persona>)iPersonaRepository.findAll();
	}

	@Override
	public Optional<Persona> listarId(int id) {
		return iPersonaRepository.findById(id);
	}

	@Override
	public int save(Persona p) {
		int res = 0;
		Persona persona = iPersonaRepository.save(p);
		if(!persona.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int id) {
		iPersonaRepository.deleteById(id);
		
	}

}
