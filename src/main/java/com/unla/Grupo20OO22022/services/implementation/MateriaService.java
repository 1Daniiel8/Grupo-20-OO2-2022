package com.unla.Grupo20OO22022.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.Grupo20OO22022.converters.MateriaConverter;
import com.unla.Grupo20OO22022.entities.Materia;
import com.unla.Grupo20OO22022.models.MateriaModel;
import com.unla.Grupo20OO22022.repositories.IMateriaRepository;
import com.unla.Grupo20OO22022.services.IMateriaService;

@Service("materiaService")
public class MateriaService implements IMateriaService{
	
	@Autowired
	private MateriaConverter materiaConverter;
	
	@Autowired
	private IMateriaRepository materiaRepository;

	@Override
	public List<MateriaModel> findAll() {
		List<MateriaModel> materias = new ArrayList<MateriaModel>();
		for(Materia materia : materiaRepository.findAll())
			materias.add(materiaConverter.entityToModel(materia));
		return materias;
	}

	@Override
	public MateriaModel insertOrUpdate(MateriaModel materiaModel) {
		return materiaConverter.entityToModel(materiaRepository.save(materiaConverter.modelToEntity(materiaModel)));
	}

	@Override
	public boolean remove(int id) {
		try {
			materiaRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public MateriaModel traerId(int id) {
		return materiaConverter.entityToModel(materiaRepository.findById(id));
	}

	@Override
	public MateriaModel traerCodMateria(int codMateria) {
		Materia aux =materiaRepository.findByCodMateria(codMateria);
		MateriaModel model=null;
		if(aux!=null)
		{
			model=materiaConverter.entityToModel(aux);
		}
		return model;
	}
}
