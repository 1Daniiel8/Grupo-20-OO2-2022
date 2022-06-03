package com.unla.Grupo20OO22022.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.unla.Grupo20OO22022.entities.Persona;

@Service("personaService")
public interface IPersonaService {
	public List<Persona> listar();
	public Optional<Persona> listarId(int id);
	public int save(Persona p);
	public void delete(int id);
}
