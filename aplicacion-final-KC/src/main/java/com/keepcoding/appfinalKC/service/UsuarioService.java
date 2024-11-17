package com.keepcoding.appfinalKC.service;

import java.util.Optional;

import com.keepcoding.appfinalKC.entity.Usuario;

public interface UsuarioService {
	Optional<Usuario> obtenerPorUsername(String username);

}
