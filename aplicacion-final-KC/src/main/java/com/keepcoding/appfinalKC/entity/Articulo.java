package com.keepcoding.appfinalKC.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "ARTICULO")
public class Articulo {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(length = 255)
    private String descripcion;

    @Column(name = "unidad_precio", nullable = false, precision = 10, scale = 2)
    private BigDecimal unidadPrecio;

    @Column(name = "unidad_stock", nullable = false)
    private Integer unidadStock;

    @Column(length = 50)
    private String tipo;

    @Column(length = 50)
    private String proveedor;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha;
    
    @OneToMany(mappedBy = "articulo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Compra> compras;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getUnidadPrecio() {
		return unidadPrecio;
	}

	public void setUnidadPrecio(BigDecimal unidadPrecio) {
		this.unidadPrecio = unidadPrecio;
	}

	public Integer getUnidadStock() {
		return unidadStock;
	}

	public void setUnidadStock(Integer unidadStock) {
		this.unidadStock = unidadStock;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
    
    
}
