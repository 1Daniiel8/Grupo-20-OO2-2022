package com.unla.Grupo20OO22022.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.Grupo20OO22022.converters.DepartamentoConverter;
import com.unla.Grupo20OO22022.entities.Departamento;
import com.unla.Grupo20OO22022.models.DepartamentoModel;
import com.unla.Grupo20OO22022.repositories.IDepartamentoRepository;
import com.unla.Grupo20OO22022.services.IDepartamentoService;

@Service("departamentoService")
public class DepartamentoService implements IDepartamentoService{
	
	@Autowired
	@Qualifier("departamentoRepository")
	private IDepartamentoRepository departamentoRepository;
	
	@Autowired
	@Qualifier("departamentoConverter")
	private DepartamentoConverter departamentoConverter;

	@Override
	public List<DepartamentoModel> traerDepartamentos() {
		List<DepartamentoModel> models = new ArrayList<DepartamentoModel>();
		for (Departamento dep : departamentoRepository.findAll()) {
			models.add(departamentoConverter.entityToModel(dep));
		}
		return models;
	}

	@Override
	public DepartamentoModel traerId(long id) {
		return departamentoConverter.entityToModel(departamentoRepository.findById(id));
	}

	@Override
	public DepartamentoModel insertOrUpdate(DepartamentoModel departamentoModel) {
		Departamento departamento = departamentoConverter.modelToEntity(departamentoModel);
		return departamentoConverter.entityToModel(departamentoRepository.save(departamento));
	}

	@Override
	public boolean remove(long id) {
		try {
			departamentoRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public DepartamentoModel traerDepa(String departamento) {
		Departamento aux =departamentoRepository.findByDepa(departamento);
		DepartamentoModel model=null;
		if(aux!=null)
		{
			model=departamentoConverter.entityToModel(aux);
		}
		return model;
	}

}
