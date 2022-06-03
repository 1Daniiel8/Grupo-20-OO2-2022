package com.unla.Grupo20OO22022.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.Grupo20OO22022.models.PerfilModel;
import com.unla.Grupo20OO22022.repositories.IPerfilRepository;
import com.unla.Grupo20OO22022.services.IPerfilService;
import com.unla.Grupo20OO22022.converters.PerfilConverter;
import com.unla.Grupo20OO22022.entities.Perfil;

@Service
public class PerfilService implements IPerfilService{

	@Autowired
	@Qualifier("perfilRepository")
	private IPerfilRepository perfilRepository;
	
	@Autowired
	@Qualifier("perfilConverter")
	private PerfilConverter perfilConverter;
	
		@Override
		public List<PerfilModel> listar() {
			List<PerfilModel> models = new ArrayList<PerfilModel>();
			for (Perfil perfil : perfilRepository.findAll()) {
				models.add(perfilConverter.entityToModel(perfil));
			}
			return models;
		}

		@Override
		public PerfilModel traerId(long id) {
			Perfil perfil = perfilRepository.findById(id);
			PerfilModel model=null;
			if (perfil!=null)
			{
				model=perfilConverter.entityToModel(perfil);
			}
			return model; 
		}
		
		@Override
		public boolean delete(long idPerfil) {
			try {
				perfilRepository.deleteById(idPerfil);
				return true;
			}catch (Exception e) {
				return false;
			}
		}
		
		@Override
		public PerfilModel insertOrUpdate(PerfilModel perfilModel) {
			Perfil perfil = perfilRepository.save(perfilConverter.modelToEntity(perfilModel));
			return perfilConverter.entityToModel(perfil);
		}
		
		@Override
		public PerfilModel traerTipo(String tipo) {
			Perfil perfil = perfilRepository.findByTipo(tipo);
			PerfilModel model=null;
			if (perfil!=null)
			{
				model=perfilConverter.entityToModel(perfil);
			}
			return model; 
		}
}
