package com.example.prueba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@SpringBootApplication
public class PruebaApplication {

        @RequestMapping("/")
        String home(){
		return "Hello World from Apache NetBeans c:";
	}
        
	public static void main(String[] args) {
		SpringApplication.run(PruebaApplication.class, args);
	}

}
