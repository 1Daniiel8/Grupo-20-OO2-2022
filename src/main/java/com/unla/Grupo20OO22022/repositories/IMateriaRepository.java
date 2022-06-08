package com.unla.Grupo20OO22022.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.Grupo20OO22022.entities.Materia;

@Repository("materiaRepository")
public interface IMateriaRepository extends JpaRepository<Materia, Integer> {
	
	public abstract Materia findById(int id);
	
	@Query("SELECT m FROM Materia m WHERE m.codMateria = :codMateria")
	public abstract Materia findByCodMateria(@Param("codMateria") int codMateria);

}
