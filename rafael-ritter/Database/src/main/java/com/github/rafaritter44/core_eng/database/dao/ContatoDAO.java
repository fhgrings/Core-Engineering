package com.github.rafaritter44.core_eng.database.dao;

import com.github.rafaritter44.core_eng.database.model.Contato;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContatoDAO {

    private ConexaoFactory fabrica;

    public ContatoDAO() {
        fabrica = new ConexaoFactory();
    }

    private List<Contato> mapearContatos(ResultSet consulta) throws Exception {
        List<Contato> contatos = new ArrayList<>();
        try {
            while (consulta.next()) {
                int id = consulta.getInt("id");
                String nome = consulta.getString("nome");
                String telefone = consulta.getString("telefone");
                String email = consulta.getString("email");
                contatos.add(new Contato(id, nome, telefone, email));
            }
            return contatos;
        } catch(Exception excecao) {
            throw excecao;
        }
    }

    public List<Contato> listaPorNome() throws Exception {
        try (Connection conexao = fabrica.getConexao();
             Statement declaracao = conexao.createStatement();
             ResultSet consulta = declaracao.executeQuery("select * from contatos order by nome")) {
            return mapearContatos(consulta);
        } catch (Exception excecao) {
            throw excecao;
        }
    }

    public List<Contato> listaPorID() throws Exception {
        try (Connection conexao = fabrica.getConexao();
             Statement declaracao = conexao.createStatement();
             ResultSet consulta = declaracao.executeQuery("select * from contatos order by id")) {
            return mapearContatos(consulta);
        } catch (Exception excecao) {
            throw excecao;
        }
    }

    public List<Contato> buscaPorNome(String nome) throws Exception {
        try (Connection conexao = fabrica.getConexao();
             Statement declaracao = conexao.createStatement();
             ResultSet consulta = declaracao.executeQuery("select * from contatos where nome = '" + nome + "'")) {
            return mapearContatos(consulta);
        } catch (Exception excecao) {
            throw excecao;
        }
    }

    public List<Contato> buscaPorID(String id) throws Exception {
        try (Connection conexao = fabrica.getConexao();
             Statement declaracao = conexao.createStatement();
             ResultSet consulta = declaracao.executeQuery("select * from contatos where id = " + id)) {
            return mapearContatos(consulta);
        } catch (Exception excecao) {
            throw excecao;
        }
    }

    public Integer insereContato(String nome, String telefone, String email) throws Exception {
        try (Connection conexao = fabrica.getConexao(); Statement declaracao = conexao.createStatement()) {
            return declaracao.executeUpdate("insert into contatos (nome, telefone, email) " +
                    "values ('" + nome + "', '" + telefone + "', '" + email + "')");
        } catch (Exception excecao) {
            throw excecao;
        }
    }

    public Integer deletaContato(String id) throws Exception {
        try (Connection conexao = fabrica.getConexao(); Statement declaracao = conexao.createStatement()) {
            return declaracao.executeUpdate("delete from contatos where id = " + id);
        } catch (Exception excecao) {
            throw excecao;
        }
    }
}
