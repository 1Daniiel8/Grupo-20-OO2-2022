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
import com.unla.Grupo20OO22022.entities.Perfil;
import com.unla.Grupo20OO22022.entities.Usuario;



@Service("usuarioService")
public class UsuarioService implements UserDetailsService {
	
	@Autowired
	@Qualifier("usuarioRepository")
	private IUsuarioRepository usuarioRepository;
	
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
