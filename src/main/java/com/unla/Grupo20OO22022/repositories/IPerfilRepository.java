package com.unla.Grupo20OO22022.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.unla.Grupo20OO22022.entities.Perfil;

@Repository
public interface IPerfilRepository extends CrudRepository<Perfil, Long> {
	
}