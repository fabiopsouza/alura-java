package br.com.caelum.vraptor.intercepts;

import javax.inject.Inject;

import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AfterCall;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.BeforeCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.annotations.Public;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.controller.LoginController;
import br.com.caelum.vraptor.controller.UsuarioLogado;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;

@Intercepts
public class AutorizadorInterceptor {

	@Inject
	private UsuarioLogado usuarioLogado;
	@Inject
	private Result result;
	@Inject
	private ControllerMethod controllerMethod;

	@Accepts
	public boolean accepts() { // Não interceptar metodos com a anotação Public
		return !controllerMethod.containsAnnotation(Public.class); // Verifica
																	// se contem
																	// a
																	// anotação
																	// "Public"
	}

	@AroundCall
	public void intercepta(SimpleInterceptorStack stack) {

		if (usuarioLogado.getUsuario() == null) {
			result.redirectTo(LoginController.class).formulario();
			return;
		}

		stack.next();
	}

	/*
	 * @BeforeCall public void before(){ // Executa antes de qualquer metodo }
	 * 
	 * @AfterCall public void after(){ // Executa depois de qualquer metodo }
	 */
}
