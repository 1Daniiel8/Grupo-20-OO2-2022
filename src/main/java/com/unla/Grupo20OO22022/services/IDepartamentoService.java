package com.unla.Grupo20OO22022.services;

import java.util.List;

import com.unla.Grupo20OO22022.models.DepartamentoModel;

public interface IDepartamentoService {
	
	public List<DepartamentoModel> traerDepartamentos();
	
	public DepartamentoModel traerId(long id);
	
	public DepartamentoModel traerDepa(String departamento);
	
	public DepartamentoModel insertOrUpdate(DepartamentoModel departamentoModel);
	
	public boolean remove(long id);
	
	

}
