package com.test;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ResttestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResttestApplication.class, args);
	}
	
    /**
     * Bean de tipo {@link ModelMapper} para el mapeado de propiedades entre clases, siguiendo el patrón Assembler
     * @return Procesador de propiedades de clases para su mapeo
     */
    @Bean
    public static ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
