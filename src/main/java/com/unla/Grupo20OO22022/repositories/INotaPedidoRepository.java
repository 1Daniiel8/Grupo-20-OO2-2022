package com.unla.Grupo20OO22022.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.Grupo20OO22022.entities.NotaPedido;

@Repository("notaPedidoRepository")
public interface INotaPedidoRepository extends JpaRepository<NotaPedido, Integer> {
	
	public abstract NotaPedido findById(int id);
	
	@Query("SELECT n FROM NotaPedido n WHERE n.profesor = (:profesor)")
	public abstract List<NotaPedido> findByProfesor(@Param("profesor") String profesor);
}
