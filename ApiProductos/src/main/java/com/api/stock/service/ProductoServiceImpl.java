package com.api.stock.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.api.stock.modelo.Producto;
import com.api.stock.modelo.Producto.TipoProducto;
import com.api.stock.repository.ProductoRepository;

/*Usar interfaces seguidas de clases que las implementan es una 
 * estrategia de diseño que aumenta la modularidad, flexibilidad, y mantenibilidad de tu código,*/
@Service
public class ProductoServiceImpl implements ProductoService {

	private final ProductoRepository repository;

	public ProductoServiceImpl(ProductoRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Producto> findAll() {
		return this.repository.findAll();
	}

	@Override
	public List<Producto> findAllByTipo(TipoProducto tipo) {
		Objects.requireNonNull(tipo);
		return this.repository.findAllByTipo(tipo);
	}

	@Override
	public Optional<Producto> findById(Long id) {
		return this.repository.findById(id);
	}

	@Override
	public Producto save(Producto producto) {
		this.repository.save(producto);
		return producto;
	}

	@Override
	public Producto update(Long id, Producto updatedProducto) {
		return repository.findById(id).map(producto -> {

			producto.setNombre(updatedProducto.getNombre());
			producto.setCantidadEnStock(updatedProducto.getCantidadEnStock());
			producto.setUmbralMinimo(updatedProducto.getUmbralMinimo());
			producto.setPrecio(updatedProducto.getPrecio());
			producto.setProveedor(updatedProducto.getProveedor());
			producto.setTipo(updatedProducto.getTipo());

			return repository.save(producto);
		}).orElseThrow(() -> new RuntimeException("Producto no encontrado con esa id " + id));
	}

	@Override
	public void deleteById(Long id) {
		this.repository.deleteById(id);
	}

	

	@Override
	public List<Producto> findAllByProveedor(String proveedor) {
		return repository.findAllByProveedor(proveedor);
	}

}
