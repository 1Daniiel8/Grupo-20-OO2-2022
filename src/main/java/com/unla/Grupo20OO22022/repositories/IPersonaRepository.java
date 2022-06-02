package com.unla.Grupo20OO22022.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.unla.Grupo20OO22022.entities.Persona;

@Repository("personaRepository")
public interface IPersonaRepository extends CrudRepository<Persona, Serializable>{
}