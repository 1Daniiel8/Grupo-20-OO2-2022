package com.unla.Grupo20OO22022.services;

import java.util.List;
import java.util.Optional;

import com.unla.Grupo20OO22022.entities.Persona;

public interface IPersonaService {
	public List<Persona> listar();
	public Optional<Persona> listarId(int id);
	public int save(Persona p);
	public void delete(int id);
}
