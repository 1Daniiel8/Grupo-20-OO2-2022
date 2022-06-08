package com.unla.Grupo20OO22022.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.Grupo20OO22022.entities.Departamento;

@Repository("departamentoRepository")
public interface IDepartamentoRepository extends JpaRepository<Departamento, Long>{
	
	public abstract Departamento findById(long id);	
	
	@Query("SELECT d FROM Departamento d WHERE d.departamento = :departamento")
	public abstract Departamento findByDepa(@Param("departamento") String departamento);

}
