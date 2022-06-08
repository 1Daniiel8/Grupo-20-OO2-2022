package com.unla.Grupo20OO22022.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.Grupo20OO22022.entities.Carrera;

@Repository("carreraRepository")
public interface ICarreraRepository extends JpaRepository<Carrera, Long>{
	
    public abstract Carrera findById(long id);
	
	@Query("SELECT c FROM Carrera c WHERE c.carrera = :carrera")
	public abstract Carrera findByCarrera(@Param("carrera") String carrera);

}
