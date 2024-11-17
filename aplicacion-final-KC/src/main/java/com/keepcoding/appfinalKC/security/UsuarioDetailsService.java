package com.keepcoding.appfinalKC.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.keepcoding.appfinalKC.entity.Usuario;
import com.keepcoding.appfinalKC.service.UsuarioService;

@Service
public class UsuarioDetailsService implements UserDetailsService{
	
	private final UsuarioService usuarioService;
	
	public UsuarioDetailsService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.obtenerPorUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));

        // Agregar manualmente el prefijo ROLE_
        String role = usuario.getRole();

        return User.builder()
                .username(usuario.getUsername())
                .password(usuario.getPassword())
                .roles(role) // Usa authorities para manejar roles específicos
                .build();
    }
}