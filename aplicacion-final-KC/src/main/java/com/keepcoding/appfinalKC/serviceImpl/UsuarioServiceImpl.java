package com.keepcoding.appfinalKC.serviceImpl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.keepcoding.appfinalKC.entity.Usuario;
import com.keepcoding.appfinalKC.repository.UsuarioRepository;
import com.keepcoding.appfinalKC.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	private final UsuarioRepository usuarioRepository;
	
	public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	@Override
    public Optional<Usuario> obtenerPorUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }
}
