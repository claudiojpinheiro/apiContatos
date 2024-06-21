package br.com.cotiinformatica.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.cotiinformatica.entities.Contato;
import br.com.cotiinformatica.factories.ConnectionFactory;

public class contatoRepository {

	public void create(Contato contato) throws Exception {

		String query = "INSERT INTO contato (nome, email, telefone) VALUES(?,?,?)";
		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, contato.getNome());
		statement.setString(2, contato.getEmail());
		statement.setString(3, contato.getTelefone());
		statement.execute();

		ResultSet resultSet = statement.getGeneratedKeys();

		if (resultSet.next()) {
			contato.setIdContato(resultSet.getInt(1));
		}

		connection.close();
	}

	public void update(Contato contato) throws Exception {

		String query = "UPDATE contato SET nome=?, email=?, telefone=? WHERE id=?";
		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, contato.getNome());
		statement.setString(2, contato.getEmail());
		statement.setString(3, contato.getTelefone());
		statement.setObject(3, contato.getIdContato());
		statement.execute();

		connection.close();
	}

	public void Delete(Integer id) throws Exception {

		String query = "DELETE FROM contato WHERE id=?";

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, id);
		statement.execute();

		connection.close();
	}

	public List<Contato> findAll() throws Exception {

		String query = "SELECT * FROM contato";
		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement(query);

		ResultSet resultSet = statement.executeQuery();

		List<Contato> contatos = new ArrayList<>();

		while (resultSet.next()) {
			Contato contato = new Contato();

			contato.setIdContato(resultSet.getInt("id"));
			contato.setNome(resultSet.getString("nome"));
			contato.setEmail(resultSet.getString("email"));
			contato.setTelefone(resultSet.getString("telefone"));

		}

		connection.close();
		return contatos;

	}

	public Contato findById(Integer id) throws Exception {

		String query = "SELECT FROM contato WHERE id = ?";
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, id);

		
		
		ResultSet resultSet = statement.executeQuery();
		Contato contato = null;
		if (resultSet.next()) {

			contato = new Contato();
			contato.setIdContato(resultSet.getInt("idproduto"));
			contato.setNome(resultSet.getString("nome"));
			contato.setEmail(resultSet.getString("email"));
			contato.setTelefone(resultSet.getString("telefone"));

		}

		connection.close();
		return contato;
	}

}
