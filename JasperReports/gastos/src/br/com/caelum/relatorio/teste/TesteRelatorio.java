package br.com.caelum.relatorio.teste;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import br.com.caelum.relatorio.ConnectionFactory;
import br.com.caelum.relatorio.gerador.GeradorRelatorio;
import net.sf.jasperreports.engine.JRException;

public class TesteRelatorio {

	public static void main(String[] args) throws SQLException, JRException, FileNotFoundException {

		//JasperCompileManager.compileReportToFile("gasto_por_mes.jrxml");
		
		String nome = "gasto_por_mes";
		Map<String, Object> params = new HashMap<String, Object>();
		Connection conn = new ConnectionFactory().getConnection();
		
		GeradorRelatorio geradorRelatorio = new GeradorRelatorio(nome  + ".jasper", params, conn);
		geradorRelatorio.gerarPDFParaOutputStream(new FileOutputStream(nome + ".pdf"));
		
		conn.close();
	}

}
