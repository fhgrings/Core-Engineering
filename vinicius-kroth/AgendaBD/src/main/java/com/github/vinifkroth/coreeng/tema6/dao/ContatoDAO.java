package com.github.vinifkroth.coreeng.tema6.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.github.vinifkroth.coreeng.tema6.model.Contato;
import com.github.vinifkroth.coreeng.tema6.util.ConexaoUtil;
import com.github.vinifroth.coreeng.tema6.exception.PersistenciaException;

public class ContatoDAO {

	public Contato buscarPorId(String id) throws PersistenciaException {

		try (Connection conexao = ConexaoUtil.getConexaoMySQL();
				PreparedStatement statement = conexao.prepareStatement("SELECT * from contato WHERE id = ?");) {
			statement.setString(1, id);
			try (ResultSet resultSet = statement.executeQuery()) {
				return mapearContato(resultSet);
			} catch (Exception e) {
				return new Contato();
			}

		} catch (Exception e) {
			throw new PersistenciaException(e);
		}
	}

	public List<Contato> buscarPorNome(String nome) throws PersistenciaException {
		try (Connection conexao = ConexaoUtil.getConexaoMySQL();
				PreparedStatement statement = conexao.prepareStatement("SELECT * from contato WHERE nome = ?");) {
			statement.setString(1, nome);
			List<Contato> contatos = new ArrayList<>();

			try (ResultSet resultset = statement.executeQuery();) {
				while (resultset.next()) {
					contatos.add(mapearContato(resultset));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return contatos;
		} catch (Exception e) {
			throw new PersistenciaException(e);
		}

	}

	public boolean inserir(Contato contato) throws PersistenciaException {
		try (Connection conexao = ConexaoUtil.getConexaoMySQL();
				PreparedStatement statement = conexao
						.prepareStatement("INSERT INTO contato (nome, numero, email)" + "VALUES(?, ?, ?)")) {
			statement.setString(1, contato.getNome());
			statement.setString(2, contato.getNumero());
			statement.setString(3, contato.getEmail());
			return statement.execute();

		} catch (Exception e) {
			throw new PersistenciaException(e);
		}
	}

	public boolean remover(String id) throws PersistenciaException {

		try (Connection conexao = ConexaoUtil.getConexaoMySQL();
				PreparedStatement statement = conexao.prepareStatement("DELETE from contato WHERE id = ?");) {
			statement.setString(1, id);
			return statement.execute();

		} catch (Exception e) {
			throw new PersistenciaException(e);
		}
	}

	public List<Contato> litarOrdenadosPorId() throws PersistenciaException {

		try (Connection conexao = ConexaoUtil.getConexaoMySQL();
				PreparedStatement statement = conexao.prepareStatement("SELECT * from contato ORDER BY id");) {
			List<Contato> contatos = new ArrayList<>();

			try (ResultSet resultset = statement.executeQuery();) {
				while (resultset.next()) {
					contatos.add(mapearContato(resultset));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return contatos;
		} catch (Exception e) {
			throw new PersistenciaException(e);
		}
	}

	public List<Contato> litarOrdenadosPorNome() throws PersistenciaException {

		try (Connection conexao = ConexaoUtil.getConexaoMySQL();
				PreparedStatement statement = conexao.prepareStatement("SELECT * from contato ORDER BY nome");) {
			List<Contato> contatos = new ArrayList<>();

			try (ResultSet resultset = statement.executeQuery();) {
				while (resultset.next()) {
					contatos.add(mapearContato(resultset));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return contatos;
		} catch (Exception e) {
			throw new PersistenciaException(e);
		}

	}

	private Contato mapearContato(ResultSet resultSet) throws Exception {
		Contato contato = new Contato();
		contato.setId(resultSet.getString("id"));
		contato.setEmail(resultSet.getString("email"));
		contato.setNome(resultSet.getString("nome"));
		contato.setNumero(resultSet.getString("numero"));
		return contato;
	}
}
