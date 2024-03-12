package com.example.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.rest.ctrl.entity.Book;
import com.example.rest.service.RestService;
import com.example.rest.service.Repository.RestRepository;

@SpringBootApplication
public class RestMappingApplication {
   
	@Autowired
    private static RestRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(RestMappingApplication.class, args);
	
	}
	  // @Override
//	 @Bean
//	    public CommandLineRunner demo(RestService restService) {
//	        return args -> {
//	            // Save the book using the service
//	            restService.saveBook();
//	        };
//	 }
}
