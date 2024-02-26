package com.api.stock.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.stock.modelo.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

	List<Producto> findAllByTipo(Producto.TipoProducto tipo);
	List<Producto> findAllByProveedor(String proveedor);
	
}
