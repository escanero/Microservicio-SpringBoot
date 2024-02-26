package com.api.stock.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.stock.modelo.Producto;
import com.api.stock.modelo.Producto.TipoProducto;
import com.api.stock.service.ProductoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/productos")
public class ProductoController {

	private final ProductoService service;

	public ProductoController(ProductoService service) {
		this.service = service;
	}

	//   "GET" http://localhost:8080/productos
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Producto> findAll() {
		return service.findAll();
	}

	// "GET" http://localhost:8080/productos/{id}
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<Producto> findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}

	//  "POST" http://localhost:8080/productos
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Producto save(@RequestBody Producto producto) { /*RequestBody el cuerpo de esa solicitud se espera que contenga una representación JSON de un objeto Producto.*/
		return service.save(producto);
	}

    // "PUT" http://localhost:8080/productos/{id}
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Producto update(@PathVariable("id") Long id, @RequestBody Producto updatedProducto) {
		return service.update(id, updatedProducto);
	}

	//  "DELETE" http://localhost:8080/productos/{id}
	@DeleteMapping(value = "/{id}")
	public void deleteById(@PathVariable("id") Long id) {
		service.deleteById(id);
	}
	
    // "GET" http://localhost:8080/productos/buscarPorTipo?tipo=ELECTRONICO
    @GetMapping(value = "/buscarPorTipo", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Producto> findAllByTipo(@RequestParam("tipo") TipoProducto tipo) {
        return service.findAllByTipo(tipo);
    }
    
    // "GET" http://localhost:8080/productos/buscarPorProveedor?proveedor=NombreProveedor
    @GetMapping(value = "/buscarPorProveedor", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Producto> findAllByProveedor(@RequestParam("proveedor") String proveedor) {
        return service.findAllByProveedor(proveedor);
    }

}
