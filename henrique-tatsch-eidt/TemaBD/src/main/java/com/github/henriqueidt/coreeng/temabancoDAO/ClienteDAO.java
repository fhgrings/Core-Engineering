package com.github.henriqueidt.coreeng.temabancoDAO;

import com.github.henriqueidt.coreeng.temabanco.ConexaoFactory;
import com.github.henriqueidt.coreeng.temabanco.Contato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    ConexaoFactory conexaoFactory = new ConexaoFactory();

    public void cadastra(String nome, String telefone, String email) {

        try (Connection connection = conexaoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO contato (nome, telefone, email) VALUES(?,?,?)");) {
            statement.setString(1, nome);
            statement.setString(2, telefone);
            statement.setString(3, email);

            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro!");
        }
    }

    public void remove(int id) {

        try (Connection connection = conexaoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM contato WHERE id = ?");) {

            statement.setInt(1, id);

            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro " + ex);
        }
    }

    public List<Contato> ler() {
        List<Contato> contatos = new ArrayList<>();

        try (Connection connection = conexaoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM contato ORDER BY nome ASC");) {

            ResultSet result = statement.executeQuery();

            while (result.next()) {

                Contato contato = new Contato();
                contato.setId(result.getInt("id"));
                contato.setNome(result.getString("nome"));
                contato.setEmail(result.getString("email"));
                contato.setTelefone(result.getString("telefone"));
                contatos.add(contato);
            }

        } catch (SQLException ex) {
            System.out.println("Erro" + ex);
        }
        return contatos;
    }

    public List<Contato> consultaNome(String nome) {
        List<Contato> contatos = new ArrayList<>();

        try (Connection connection = conexaoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM contato WHERE nome LIKE ?");) {
            statement.setString(1, "%" + nome + "%");
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                Contato contato = new Contato();
                contato.setId(result.getInt("id"));
                contato.setNome(result.getString("nome"));
                contato.setEmail(result.getString("email"));
                contato.setTelefone(result.getString("telefone"));
                contatos.add(contato);
            }

        } catch (SQLException ex) {
            System.out.println("Erro" + ex);
        }
        return contatos;
    }

    public List<Contato> consultaId(int id) {
        List<Contato> contatos = new ArrayList<>();

        try (Connection connection = conexaoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM contato WHERE id LIKE ?");) {
            statement.setString(1, "%" + id + "%");
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                Contato contato = new Contato();
                contato.setId(result.getInt("id"));
                contato.setNome(result.getString("nome"));
                contato.setEmail(result.getString("email"));
                contato.setTelefone(result.getString("telefone"));
                contatos.add(contato);
            }

        } catch (SQLException ex) {
            System.out.println("Erro" + ex);
        }
        return contatos;
    }

}
