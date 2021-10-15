package br.com.alura.microservice.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.microservice.loja.dto.CompraDTO;
import br.com.alura.microservice.loja.model.Compra;
import br.com.alura.microservice.loja.service.CompraService;

@RestController
@RequestMapping("/compra")
public class CompraController {

	@Autowired
	private CompraService service;
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public Compra getById(@PathVariable("id") Long id) {
		return service.getById(id);
	}
	
	@PostMapping
	public Compra realizaCompra(@RequestBody CompraDTO compra) {
		return service.realizaCompra(compra);
	}
}
