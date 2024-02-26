package com.web.stock.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

	/*es una clase en Spring que facilita la comunicación con servicios web, como realizar peticiones HTTP.*/
	
	 @Bean
	    public RestTemplate restTemplate() {
	        return new RestTemplate();
	    }
	/*crea y devuelve una nueva instancia de RestTemplate.
	 *  Esta instancia será administrada por Spring y puede ser
	 *   inyectada en otras partes de la aplicación */
}

