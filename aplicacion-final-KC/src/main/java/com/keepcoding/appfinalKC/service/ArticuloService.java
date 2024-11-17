package com.keepcoding.appfinalKC.service;

import java.util.List;

import com.keepcoding.appfinalKC.entity.Articulo;

public interface ArticuloService {
	List<Articulo> listarTodos();
    Articulo obtenerPorId(Long id);
    void eliminar(Long id);
	Articulo guardarArticulo(Articulo articulo);
}
