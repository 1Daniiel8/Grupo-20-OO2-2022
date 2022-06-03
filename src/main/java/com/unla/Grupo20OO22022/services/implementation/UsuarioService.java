package com.unla.Grupo20OO22022.services.implementation;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.unla.Grupo20OO22022.repositories.IUsuarioRepository;
import com.unla.Grupo20OO22022.services.IUsuarioService;

import com.unla.Grupo20OO22022.entities.Usuario;



@Service("usuarioService")
public class UsuarioService implements IUsuarioService {

	
	@Autowired
	@Qualifier("usuarioRepository")
	private IUsuarioRepository usuarioRepository;
	
	
	@Override
	public List<Usuario> listar() {
		return (List<Usuario>)usuarioRepository.findAll();
		
	}

	@Override
	public Optional<Usuario> listarId(int id) {
		return usuarioRepository.findById((long) id);
	}

	@Override
	public Usuario findByDni(@Param("dni") long dni) {
		return usuarioRepository.findByDni(dni);
	}

	@Override
	public Usuario findByEmail(@Param("email") String email) {
		return usuarioRepository.findByEmail(email);
	}

	@Override
	public Usuario findByUsername(@Param("username") String username) {
		return usuarioRepository.findByUsername(username);
	}

	@Override
	public int save(Usuario u) {
		int res=0;
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		u.setPassword(pe.encode(u.getPassword()));
		Usuario usuario = usuarioRepository.save(u);
		if (!usuario.equals(null)) {
			res =1;
		}
		return res;
	}

	@Override
	public void delete(int id) {
		usuarioRepository.deleteById((long) id);
	}

	@Override
	public Usuario traerPorId(int id) {
		return usuarioRepository.traerPorId(id);
	}

	
	
	
	
}