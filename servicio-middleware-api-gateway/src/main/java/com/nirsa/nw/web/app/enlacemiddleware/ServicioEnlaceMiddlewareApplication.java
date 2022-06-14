package com.nirsa.nw.web.app.enlacemiddleware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication
@EnableAsync
public class ServicioEnlaceMiddlewareApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioEnlaceMiddlewareApplication.class, args);
	}

}
