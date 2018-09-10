package com.github.vinifkroth.coreeng.tema6.service;

import java.util.List;

import com.github.vinifkroth.coreeng.tema6.dao.ContatoDAO;
import com.github.vinifkroth.coreeng.tema6.model.Contato;
import com.github.vinifroth.coreeng.tema6.exception.PersistenciaException;

public class ContatoService {

	private ContatoDAO contatoDAO;
	
	public ContatoService() {
		contatoDAO = new ContatoDAO();
	}

	public String adicionar(String nome, String numero, String email) {
		Contato contato = new Contato(nome, numero, email);
		try {
			contatoDAO.inserir(contato);
			return "Contato inserido com sucesso";
		} catch (PersistenciaException e) {
			e.printStackTrace();
			return "Algum erro ocorreu ao inserir seu contato, favor verifique as informações inseridas";
		}
	}

	public String remover(String id) {
		try {
			if (contatoDAO.remover(id))
				return "Contato removido com sucesso";
			else
				return "Contato não removido, verifique se a ID inserida é válida";
		} catch (PersistenciaException e) {
			e.printStackTrace();
			return "Um erro inesperado aconteceu, tente novamente";
		}
	}

	public String listarOrdenadosPorId() {
		try {
			List<Contato> contatos = contatoDAO.litarOrdenadosPorId();
			if (contatos.size() == 0) {
				return "Nenhum contato cadastrado";
			}
			StringBuilder str = new StringBuilder();
			str.append("\nLista de contatos:\n");

			for (Contato cont : contatos) {
				str.append(cont.toString())
				   .append("\n");
			}
			return str.toString();
		} catch (PersistenciaException e) {
			e.printStackTrace();
			return "Um erro inesperado aconteceu, por favor tente novamente";
		}
	}

	public String listarOrdenadosPorNome() {
		try {
			List<Contato> contatos = contatoDAO.litarOrdenadosPorNome();
			if (contatos.size() == 0) {
				return "Nenhum contato cadastrado";
			}
			StringBuilder str = new StringBuilder();
			str.append("\nLista de contatos:\n");

			for (Contato cont : contatos) {
				str.append(cont.toString())
				   .append("\n");
			}
			return str.toString();
		} catch (PersistenciaException e) {
			e.printStackTrace();
			return "Um erro inesperado aconteceu, por favor tente novamente";
		}
	}

	public String buscarPorNome(String nome) {
		try {
			List<Contato> contatos = contatoDAO.buscarPorNome(nome);
			if(contatos.isEmpty())
				return "Nenhum contato encontrado com este nome, verifique o nome inserido e tente novamente";
			
			StringBuilder str = new StringBuilder();
			for(Contato cont : contatos) {
				str.append(cont.toString())
			       .append("\n");
			}
			return str.toString();
		} catch (PersistenciaException e) {
			e.printStackTrace();
			return "Um erro inesperado aconteceu, por favor tente novamente";
		}
	}

	public String buscarPorId(String id) {
		try {
			Contato contato = contatoDAO.buscarPorId(id);
			if(contato.getNome() == null)
				return "Nenhum contato encontrado com este Id, verifique o id inserido e tente novamente";
			return contato.toString();
		} catch (PersistenciaException e) {
			e.printStackTrace();
			return "Um erro inesperado aconteceu, por favor tente novamente";
		}
	}
}
