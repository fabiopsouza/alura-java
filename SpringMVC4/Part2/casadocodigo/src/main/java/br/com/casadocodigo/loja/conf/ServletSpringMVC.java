package br.com.casadocodigo.loja.conf;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer{

	//Os metodos são inicializados nessa ordem, por isos pode haver erro na injecao de dependencia dependendo da ordem que for usado
	
	@Override
	protected Class<?>[] getRootConfigClasses() { 
		//Identifica as classes de condiguração
		return new Class[]{SecurityConfiguration.class, AppWebConfiguration.class, JPAConfiguration.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {}; //Identifica as classes de condiguração
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("UTF-8");
		return new Filter[] {encodingFilter};
	}
	
	@Override 
	protected void customizeRegistration(Dynamic registration) { 
		//string em branco por que quer tratar o arquivo do mesmo jeito que foi recebido, (sem seperador por exemplo)
		registration.setMultipartConfig(new MultipartConfigElement(""));  
	}
}
