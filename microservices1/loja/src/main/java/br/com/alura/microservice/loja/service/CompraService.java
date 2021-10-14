package br.com.alura.microservice.loja.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.alura.microservice.loja.client.FornecedorClient;
import br.com.alura.microservice.loja.dto.CompraDTO;
import br.com.alura.microservice.loja.dto.InfoFornecedorDTO;
import br.com.alura.microservice.loja.dto.InfoPedidoDTO;
import br.com.alura.microservice.loja.model.Compra;
import br.com.alura.microservice.loja.repository.CompraRepository;

@Service
public class CompraService {

//	@Autowired
//	private RestTemplate client;
	
//	@Autowired
//	private DiscoveryClient eurekaClient;
	
	private static final Logger LOG = LoggerFactory.getLogger(CompraService.class);
	
	@Autowired
	private FornecedorClient fornecedorClient;
	
	@Autowired
	private CompraRepository repository;
	
	@HystrixCommand(threadPoolKey = "realizaCompraThreadPool")
	public Compra getById(Long id) {
		return repository.findById(id).orElse(new Compra());
	}
	
	@HystrixCommand(fallbackMethod = "realizaCompraFallback", // Qual método vai responder em caso de cirquit breaker (1s)
			threadPoolKey = "realizaCompraThreadPool") 
	public Compra realizaCompra(CompraDTO compra) {
		
		String estado = compra.getEndereco().getEstado();
		
		LOG.info("Buscando informações do fornecedor de {}", estado);
		InfoFornecedorDTO info = fornecedorClient.getInfoPorEstado(estado);
		
		LOG.info("Realizando um pedido", estado);
		InfoPedidoDTO pedido = fornecedorClient.realizaPedido(compra.getItens());
		
		System.out.println(info.getEndereco());
		
		Compra compraSalva = new Compra();
		compraSalva.setPedidoId(pedido.getId());
		compraSalva.setTempoDePreparo(pedido.getTempoDePreparo());
		compraSalva.setEnderecoDestino(compra.getEndereco().toString());
		
		repository.save(compraSalva);
		
		return compraSalva;
		
//		REQUISIÇÃO SEM FEIGN
//		ResponseEntity<InfoFornecedorDTO> exchange = client.exchange("http://FORNECEDOR/info/" + compra.getEndereco().getEstado(), 
//				HttpMethod.GET, 
//				null, 
//				InfoFornecedorDTO.class);
//		
//		eurekaClient.getInstances("fornecedor").stream()
//		.forEach(fornecedor -> {
//			System.out.println("localhost:" + fornecedor.getPort());
//		});
	}
	
	// Método chamado quando realizaCompra() falhar
	public Compra realizaCompraFallback(CompraDTO compra) {
		Compra compraFallback = new Compra();
		compraFallback.setEnderecoDestino(compra.getEndereco().toString());
		return compraFallback;
	}
}
