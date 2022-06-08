package com.unla.Grupo20OO22022.services.implementation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.unla.Grupo20OO22022.repositories.IUsuarioRepository;
import com.unla.Grupo20OO22022.models.UsuarioModel;
import com.unla.Grupo20OO22022.converters.UsuarioConverter;
import com.unla.Grupo20OO22022.entities.Perfil;
import com.unla.Grupo20OO22022.entities.Usuario;


@Service("usuarioService")
public class UsuarioService implements UserDetailsService {
	
	@Autowired
	@Qualifier("usuarioRepository")
	private IUsuarioRepository usuarioRepository;
	
	@Autowired
	@Qualifier("usuarioConverter")
	private UsuarioConverter usuarioConverter;
	
	
	public List<UsuarioModel> traerUsuarios() {
		List<UsuarioModel> models = new ArrayList<UsuarioModel>();
		for (Usuario user : usuarioRepository.findAll()) {
			models.add(usuarioConverter.entityToModel(user));
		}
		return models;
	}
	
	
	public UsuarioModel traerId(long id) {
		Usuario usuario = usuarioRepository.findById(id);
		UsuarioModel model=null;
		if (usuario!=null)
		{
			model=usuarioConverter.entityToModel(usuario);
		}
		return model; 
	}
	
	public UsuarioModel insertOrUpdate(UsuarioModel userModel) {
		Usuario user = usuarioRepository.save(usuarioConverter.modelToEntity(userModel));
		return usuarioConverter.entityToModel(user);
	}

	
	public boolean remove(long id) {
		try {
			usuarioRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	public UsuarioModel traerUsername(String username)
	{
		Usuario usuario = usuarioRepository.findByUsernameWithPerfil(username);
		UsuarioModel model=null;
		if (usuario!=null)
		{
			model=usuarioConverter.entityToModel(usuario);
		}
		return model;
	}
	
	public UsuarioModel findByEmail(String email)
	{
		Usuario usuario = usuarioRepository.findByEmail(email);
		UsuarioModel model=null;
		if (usuario!=null)
		{
			model=usuarioConverter.entityToModel(usuario);
		}
		return model;
	}
	
	public UsuarioModel findByDni(int dni) {
		Usuario usuario = usuarioRepository.findByDni(dni);
		UsuarioModel model=null;
		if (usuario!=null)
		{
			model=usuarioConverter.entityToModel(usuario);
		}
		return model; 
	}
	
	//-----------------------------------------LOGIN---------------------------------------------------------
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByUsernameWithPerfil(username);
		return builUser(usuario, buildGrantedAuthorities(usuario.getPerfil()));
	}
	
	private User builUser(Usuario usuario, List<GrantedAuthority> grantedAuthorities) {
		return new User(usuario.getUsername(), usuario.getPassword(), grantedAuthorities);
	}
	
	private List<GrantedAuthority> buildGrantedAuthorities(Perfil perfil){
		Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
		grantedAuthorities.add(new SimpleGrantedAuthority(perfil.getTipo()));
		return new ArrayList<GrantedAuthority>(grantedAuthorities);
	}
}
