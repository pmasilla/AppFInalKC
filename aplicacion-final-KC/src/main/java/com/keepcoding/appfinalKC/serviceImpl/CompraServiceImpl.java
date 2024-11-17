package com.keepcoding.appfinalKC.serviceImpl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keepcoding.appfinalKC.entity.Articulo;
import com.keepcoding.appfinalKC.entity.Compra;
import com.keepcoding.appfinalKC.repository.ArticuloRepository;
import com.keepcoding.appfinalKC.repository.CompraRepository;
import com.keepcoding.appfinalKC.service.CompraService;
@Service
public class CompraServiceImpl implements CompraService{
	@Autowired
	private CompraRepository compraRepository;
	@Autowired
	private ArticuloRepository articuloRepository;

	@Override
	public List<Compra> listarTodas() {
		return compraRepository.findAll();
	}

	@Override
	public Compra guardarCompra(Compra compra) {
	    Compra compraExistente = null;
	    if (compra.getId() != null) {
	        compraExistente = compraRepository.findById(compra.getId())
	                .orElse(null);
	    }

	    Articulo articulo = articuloRepository.findById(compra.getArticulo().getId())
	            .orElseThrow(() -> new IllegalArgumentException("Artículo no encontrado"));

	    BigDecimal precioUnidad = articulo.getUnidadPrecio();
	    BigDecimal cantidad = BigDecimal.valueOf(compra.getCantidad());

	    BigDecimal total = precioUnidad.multiply(cantidad);
	    BigDecimal iva = total.multiply(BigDecimal.valueOf(0.21));
	    BigDecimal totalIva = total.add(iva);

	    if (compraExistente != null) {
	        compraExistente.setCliente(compra.getCliente());
	        compraExistente.setArticulo(articulo);
	        compraExistente.setCantidad(compra.getCantidad());
	        compraExistente.setFecha(compra.getFecha());
	        compraExistente.setTotal(total);
	        compraExistente.setIva(iva);
	        compraExistente.setTotalIva(totalIva);

	        return compraRepository.save(compraExistente);
	    } else {
	        compra.setTotal(total);
	        compra.setIva(iva);
	        compra.setTotalIva(totalIva);

	        return compraRepository.save(compra);
	    }
	}
	@Override
	public Compra obtenerPorId(Long id) {
		return compraRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Long id) {
		compraRepository.deleteById(id);
	}

}
