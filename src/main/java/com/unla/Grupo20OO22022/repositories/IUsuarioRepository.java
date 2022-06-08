package com.unla.Grupo20OO22022.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.Grupo20OO22022.entities.Usuario;

@Repository("usuarioRepository")
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
	
	@Query("SELECT u FROM Usuario u inner join fetch u.perfil where u.username = (:username)")
	public abstract Usuario findByUsernameWithPerfil(@Param("username")String username);
	
	@Query("SELECT u FROM Usuario u WHERE u.dni = (:dni)")
	public abstract Usuario findByDni(@Param("dni") long dni);
	
	@Query("SELECT u FROM Usuario u WHERE u.email = (:email)")
	public abstract Usuario findByEmail(@Param("email") String email);
	
	@Query("SELECT u FROM Usuario u WHERE u.username = (:username)")
	public abstract Usuario findByUsername(@Param("username") String username);
	
	public abstract Usuario findById(long id);
}
