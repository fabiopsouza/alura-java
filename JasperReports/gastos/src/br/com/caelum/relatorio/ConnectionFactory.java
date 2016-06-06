package br.com.caelum.relatorio;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	public Connection getConnection(){
		try{
			return DriverManager.getConnection("jdbc:mysql://localhost/financas", "root", "teste123");
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
}
