package com.unla.Grupo20OO22022.services;

import java.util.List;

import com.unla.Grupo20OO22022.models.CursoModel;
import com.unla.Grupo20OO22022.models.FinalModel;
import com.unla.Grupo20OO22022.models.NotaPedidoModel;


public interface INotaPedidoService {
	
	public List<NotaPedidoModel> findAll();
	public List<NotaPedidoModel> findAllByProfesor(String profesor);
	public NotaPedidoModel findById(int id);
	
	public List<FinalModel> findAllFinal();
	public List<CursoModel> findAllCurso();
	
	public NotaPedidoModel insertOrUpdate(NotaPedidoModel notaPedidoModel);
	

}
