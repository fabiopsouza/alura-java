package br.com.casadocodigo.loja.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.dao.ProdutoDAO;
import br.com.casadocodigo.loja.infra.FileSaver;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoPreco;
import br.com.casadocodigo.loja.validation.ProdutoValidation;

@Controller
@RequestMapping("produtos") //Define o inicio da url para todas as actions do controller (/produtos)
public class ProdutosController {

	@Autowired //injecao de dependencia
	private ProdutoDAO produtoDao;
	
	@Autowired
	private FileSaver fileSaver;
	
	//liga o metodo de validação com o @Valid do controller
	@InitBinder
	public void initBinder(WebDataBinder binder){
		
		binder.addValidators(new ProdutoValidation());
		
	}
	
	@RequestMapping("/form")//Recebe produto para não apagar os campos em uma validação (tmb eh necessario usar os form:inputs do spring)
	public ModelAndView form(Produto produto){ 
		ModelAndView modelAndView = new ModelAndView("produtos/form");
		modelAndView.addObject("tipos", TipoPreco.values());
		return modelAndView;
	}
	
	//Obrigatoriamente o BindingResult deve vir depois do @Valid Produto
	@RequestMapping(method=RequestMethod.POST) 
	public ModelAndView grava(MultipartFile sumario, @Valid Produto produto, 
			BindingResult result, RedirectAttributes redirectAttributes){
		
		if(result.hasErrors()){
			return form(produto);
		}
		
		String path = fileSaver.write("arquivos-sumario", sumario);
		produto.setSumarioPath(path);
		
		produtoDao.gravar(produto);
		redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso!");
		
		return new ModelAndView("redirect:produtos");
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listar(){
		List<Produto> produtos = produtoDao.listar();
		ModelAndView modelAndView = new ModelAndView("/produtos/lista");
		modelAndView.addObject("produtos", produtos);
		return modelAndView;
	}
	
	@RequestMapping("/detalhe/{id}") //@PathVariable receber o id via url amigavel
	public ModelAndView detalhe(@PathVariable("id") Integer id){
		ModelAndView modelAndView = new ModelAndView("produtos/detalhe");
		Produto produto = produtoDao.find(id);
		modelAndView.addObject("produto", produto);
		return modelAndView;
	}

}
