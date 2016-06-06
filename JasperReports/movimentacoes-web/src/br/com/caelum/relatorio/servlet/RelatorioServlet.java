package br.com.caelum.relatorio.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.relatorio.ConnectionFactory;
import br.com.caelum.relatorio.gerador.GeradorRelatorio;

@WebServlet("/movimentacoes")
public class RelatorioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			Connection conn = new ConnectionFactory().getConnection();
			String nome = request.getServletContext().getRealPath("/WEB-INF/jasper/movimentacoes.jasper");
			
			String dataIni = request.getParameter("data_ini");
			String dataFim = request.getParameter("data_fim");
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			Date dataInicio = sdf.parse(dataIni);
			Date dataFinal = sdf.parse(dataFim);
			
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("DATA_INI", dataInicio);
			params.put("DATA_FIM", dataFinal);
			
			GeradorRelatorio geradorRelatorio = new GeradorRelatorio(nome, params, conn);
			geradorRelatorio.geraPDFParaOutputStream(response.getOutputStream());
			
			conn.close();
		} catch (SQLException e) {
			throw new ServletException(e);
		} catch (ParseException e) {
			throw new ServletException(e);
		} 
	}
}
