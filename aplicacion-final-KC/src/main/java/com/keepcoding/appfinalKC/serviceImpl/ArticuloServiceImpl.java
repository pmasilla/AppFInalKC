package com.keepcoding.appfinalKC.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keepcoding.appfinalKC.entity.Articulo;
import com.keepcoding.appfinalKC.repository.ArticuloRepository;
import com.keepcoding.appfinalKC.service.ArticuloService;
@Service
public class ArticuloServiceImpl implements ArticuloService{

	@Autowired
	private ArticuloRepository articuloRepository;
	
	@Override
	public List<Articulo> listarTodos() {
		
		return articuloRepository.findAll();
	}

	@Override
    public Articulo guardarArticulo(Articulo articulo) {
        if (articulo.getId() != null && articuloRepository.existsById(articulo.getId())) {
            Articulo articuloExistente = articuloRepository.findById(articulo.getId()).orElse(null);
            if (articuloExistente != null) {
                articuloExistente.setNombre(articulo.getNombre());
                articuloExistente.setDescripcion(articulo.getDescripcion());
                articuloExistente.setUnidadPrecio(articulo.getUnidadPrecio());
                articuloExistente.setUnidadStock(articulo.getUnidadStock());
                articuloExistente.setTipo(articulo.getTipo());
                articuloExistente.setProveedor(articulo.getProveedor());
                articuloExistente.setFecha(articulo.getFecha());
                return articuloRepository.save(articuloExistente);
            }
        }

        return articuloRepository.save(articulo);
    }
	@Override
	public Articulo obtenerPorId(Long id) {
		return articuloRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Long id) {
		articuloRepository.deleteById(id);
		
	}

}
