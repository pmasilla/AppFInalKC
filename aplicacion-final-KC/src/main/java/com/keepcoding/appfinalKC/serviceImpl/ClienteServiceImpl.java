package com.keepcoding.appfinalKC.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keepcoding.appfinalKC.entity.Cliente;
import com.keepcoding.appfinalKC.repository.ClienteRepository;
import com.keepcoding.appfinalKC.service.ClienteService;
@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public List<Cliente> listarTodos() {
	
		return clienteRepository.findAll();
	}

	@Override
	public Cliente obtenerPorId(Long id) {
		return clienteRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Long id) {
		clienteRepository.deleteById(id);
	}

	@Override
	public Cliente guardarCliente(Cliente cliente) {
	    if (cliente.getId() != null && clienteRepository.existsById(cliente.getId())) {
	        Cliente clienteExistente = clienteRepository.findById(cliente.getId()).orElse(null);
	        if (clienteExistente != null) {
	            clienteExistente.setNombre(cliente.getNombre());
	            clienteExistente.setApellido(cliente.getApellido());
	            clienteExistente.setEmpresa(cliente.getEmpresa());
	            clienteExistente.setPuesto(cliente.getPuesto());
	            clienteExistente.setDireccion(cliente.getDireccion());
	            clienteExistente.setCodigoPostal(cliente.getCodigoPostal());
	            clienteExistente.setProvincia(cliente.getProvincia());
	            clienteExistente.setTelefono(cliente.getTelefono());
	            clienteExistente.setFechaNac(cliente.getFechaNac());
	            return clienteRepository.save(clienteExistente);
	        }
	    }
	    return clienteRepository.save(cliente);
	}
}
	
