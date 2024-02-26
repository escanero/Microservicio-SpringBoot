package com.api.stock.service;

import java.util.List;
import java.util.Optional;

import com.api.stock.modelo.Producto;

public interface ProductoService {

	
	List<Producto> findAll();
	List<Producto> findAllByTipo(Producto.TipoProducto tipo);
	List<Producto> findAllByProveedor(String proveedor);
	Optional<Producto> findById(Long id);
	
	
	Producto save(Producto producto);
	Producto update(Long id, Producto producto);
	
	
	void deleteById(Long id);
	
}
