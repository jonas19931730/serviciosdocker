package com.nirsa.nw.web.app.servicioatunera;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class ServicioAtuneraApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioAtuneraApplication.class, args);
	}
	
	@Bean("conexionEnlace")
	//@LoadBalanced
	public RestTemplate registrarRestTemplate() {
		return new RestTemplate();
	}
	

	

}
