package com.unla.Grupo20OO22022.services;

import java.util.List;

import com.unla.Grupo20OO22022.models.MateriaModel;

public interface IMateriaService {
	
	public List<MateriaModel> findAll();
	
	public MateriaModel insertOrUpdate(MateriaModel materiaModel);
	
	public boolean remove(int id);
	
	public MateriaModel traerId(int id);
	
	public MateriaModel traerCodMateria(int codMateria);

}
