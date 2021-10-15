package br.com.alura.microservice.loja.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

import feign.RequestInterceptor;
import feign.RequestTemplate;

@Configuration
public class SecurityConfig {

	// CHAMADO PELO FEIGN ANTES DE CADA REQUEST
	@Bean
	public RequestInterceptor requestInterceptor() {
		return new RequestInterceptor() {
			
			@Override
			public void apply(RequestTemplate template) {
				Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
				if(authentication == null) {
					return;
				}
				
				OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
				template.header("Authorization", "Bearer" + details.getTokenValue());
			}
		};
	}
}
