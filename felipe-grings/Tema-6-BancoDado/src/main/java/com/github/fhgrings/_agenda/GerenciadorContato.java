package com.github.fhgrings._agenda;

import java.sql.*;

public class GerenciadorContato {

    public boolean cadastrarContato(Contato contato) {

        try(Connection con = ConnectionFactory.getConnection(); PreparedStatement stmt = con.prepareStatement("INSERT INTO contato (nome,telefone,email) VALUES(?,?,?)")){
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getTelefone());
            stmt.setString(3, contato.getEmail());
            stmt.executeUpdate();
            System.out.println("Contato adicionado");
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean listarContatos() {
        try(Connection con = ConnectionFactory.getConnection();  PreparedStatement stmt = con.prepareStatement("SELECT * FROM contato")) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String lastName = rs.getString("nome");
                System.out.println(lastName + "\n");
            }

            System.out.println("Contato adicionado");
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;

        }
        return true;
    }

    public boolean buscarPorNome(String nome) {
        try(Connection con = ConnectionFactory.getConnection();  PreparedStatement stmt = con.prepareStatement("SELECT * FROM contato WHERE nome = '" + nome + "'");) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String lastName = rs.getString("nome");
                System.out.println(lastName + "\n");
            }

            System.out.println("Contato adicionado");
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean buscarPorId(int id) {
        try(Connection con = ConnectionFactory.getConnection(); PreparedStatement stmt = con.prepareStatement("SELECT * FROM contato WHERE id = '" + id + "'")) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String lastName = rs.getString("nome");
                System.out.println(lastName + "\n");
            }

            System.out.println("Contato adicionado");
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean removerContato(int id) {
        try(Connection con = ConnectionFactory.getConnection(); PreparedStatement stmt = con.prepareStatement("DELETE FROM contato where id = ?")) {
            stmt.setInt(1, id);
            stmt.execute();
            System.out.println("Contato Removido");
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
        return true;
    }
}
