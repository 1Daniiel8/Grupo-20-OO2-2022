package com.unla.Grupo20OO22022.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.Grupo20OO22022.converters.CarreraConverter;
import com.unla.Grupo20OO22022.entities.Carrera;
import com.unla.Grupo20OO22022.models.CarreraModel;
import com.unla.Grupo20OO22022.repositories.ICarreraRepository;
import com.unla.Grupo20OO22022.services.ICarreraService;

@Service("carreraService")
public class CarreraService implements ICarreraService{
	
	@Autowired
	@Qualifier("carreraRepository")
	private ICarreraRepository carreraRepository;
	
	@Autowired
	@Qualifier("carreraConverter")
	private CarreraConverter carreraConverter;

	@Override
	public List<CarreraModel> traerCarreras() {
		List<CarreraModel> models = new ArrayList<CarreraModel>();
		for (Carrera car : carreraRepository.findAll()) {
			models.add(carreraConverter.entityToModel(car));
		}
		return models;
	}

	@Override
	public CarreraModel traerId(long id) {
		return carreraConverter.entityToModel(carreraRepository.findById(id));
	}

	@Override
	public CarreraModel traerCarrera(String carrera) {
		Carrera aux =carreraRepository.findByCarrera(carrera);
		CarreraModel model=null;
		if(aux!=null)
		{
			model=carreraConverter.entityToModel(aux);
		}
		return model;
	}

	@Override
	public CarreraModel insertOrUpdate(CarreraModel carreraModel) {
		Carrera carrera = carreraConverter.modelToEntity(carreraModel);
		return carreraConverter.entityToModel(carreraRepository.save(carrera));
	}

	@Override
	public boolean remove(long id) {
		try {
			carreraRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

}
