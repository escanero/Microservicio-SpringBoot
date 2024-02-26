package com.web.stock.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.web.stock.modelo.Producto;

@Service
public class ProductoService {
	
	 private final RestTemplate restTemplate;
	    private final String apiUrl = "http://localhost:8080/productos"; 
	    /*Es una variable que almacena la URL base de un servicio web.
	     * En este caso, apunta a un servicio que corre localmente en el puerto 8080.*/

	    public ProductoService(RestTemplate restTemplate) {
	        this.restTemplate = restTemplate;
	    }
	    /* inyectar la instancia de RestTemplate.
	     *  Esta técnica se llama inyección de dependencias y es una característica clave de Spring.*/

	    public Producto getProductoById(Long id) {
	    	 /*: Este método define la lógica para obtener un producto por su ID.
		     *  Utiliza RestTemplate para hacer una petición HTTP GET al servicio web especificado por apiUrl.
		     *   El resultado se convierte en una instancia de la clase Producto.*/
	        return restTemplate.getForObject(apiUrl + "/" + id, Producto.class);
	        /* Hace una petición GET a la URL formada por apiUrl y el ID del producto. Espera que la respuesta sea un objeto de tipo Producto.*/
	    }
	    
	    
	   
	    
	   

}
