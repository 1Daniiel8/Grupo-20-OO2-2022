package com.unla.Grupo20OO22022.services;

import java.util.List;

import com.unla.Grupo20OO22022.models.CarreraModel;

public interface ICarreraService {
	
public List<CarreraModel> traerCarreras();
	
	public CarreraModel traerId(long id);
	
	public CarreraModel traerCarrera(String carrera);
	
	public CarreraModel insertOrUpdate(CarreraModel carreraModel);
	
	public boolean remove(long id);

}
