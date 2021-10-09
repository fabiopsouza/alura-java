package br.com.alura.microservice.loja;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {

	@Bean
	@LoadBalanced // Essa anotação que resolve o nome pelo ip e porta (ex.: CompraService.realizaCompra#client.exchange)
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
