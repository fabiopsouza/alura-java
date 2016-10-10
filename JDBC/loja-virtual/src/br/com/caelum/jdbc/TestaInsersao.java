package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsersao {

	public static void main(String[] args) throws SQLException {

		//Esse tipo de try fecha automaticamente (semelhante ao using do C#)
		try (Connection connection = new ConnectionPool().getConnection()) { 
			connection.setAutoCommit(false);
			String sql = "insert into Produto(nome, descricao) values(?, ?)";

			try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

				adicionar("TV LCD", "32 polegadas", preparedStatement);
				adicionar("Bluray", "Full HDMI", preparedStatement);

				connection.commit();
			} catch (Exception e) {
				connection.rollback();
				System.out.println("Rollback efetuado");
			}
		}

	}

	public static void adicionar(String nome, String descricao, PreparedStatement preparedStatement)
			throws SQLException {

		if (nome.equals("Bluray"))
			throw new IllegalArgumentException("Problema ocorrido");

		preparedStatement.setString(1, nome);
		preparedStatement.setString(2, descricao);

		boolean resultado = preparedStatement.execute();

		System.out.println(resultado);
		ResultSet resultSet = preparedStatement.getGeneratedKeys();

		while (resultSet.next()) {
			String id = resultSet.getString("id");
			System.out.println(id);
		}

		resultSet.close();
	}
}
