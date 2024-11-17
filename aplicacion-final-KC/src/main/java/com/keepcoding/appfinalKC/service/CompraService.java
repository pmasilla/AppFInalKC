package com.keepcoding.appfinalKC.service;

import java.util.List;

import com.keepcoding.appfinalKC.entity.Compra;

public interface CompraService {
	List<Compra> listarTodas();
    Compra obtenerPorId(Long id);
    void eliminar(Long id);
	Compra guardarCompra(Compra compra);

}
