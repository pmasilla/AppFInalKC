package com.keepcoding.appfinalKC.service;

import java.util.List;

import com.keepcoding.appfinalKC.entity.Cliente;

public interface ClienteService {
	List<Cliente> listarTodos();
    Cliente obtenerPorId(Long id);
    void eliminar(Long id);
	Cliente guardarCliente(Cliente cliente);

}
