package com.github.vinifkroth.coreeng.tema4.service;

import java.util.ArrayList;
import java.util.List;

import com.github.vinifkroth.coreeng.tema4.model.Contato;
import com.github.vinifkroth.coreeng.tema4.util.GeradorDeId;

import java.util.Optional;

public class AgendaDeContatos {

	private List<Contato> contatos;
	private GeradorDeId geradorDeId;

	public AgendaDeContatos() {
		contatos = new ArrayList<>();
		geradorDeId = new GeradorDeId();
	}

	public String adicionar(Contato contato) {
		contato.setId(geradorDeId.gerarId());
		if (contatos.add(contato)) {
			return "Contato adicionado com sucesso";
		} else
			return "Um erro inesperado aconteceu, tente novamente";

	}

	public String listar() {
		StringBuilder str = new StringBuilder();
		str.append("Lista de contatos:\n\n");
		for (Contato contato : contatos) {
			str.append(contato.toString());
			str.append("\n");
		}
		return str.toString();
	}

	public Contato buscarPorNome(String nome) {
		  return contatos.stream()
				.filter(c -> c.getNome()
				.equals(nome))
				.findFirst()
				.orElse(null);
		
	}

	public Contato buscarPorId(String id) {
		 return contatos.stream()
					.filter(c -> c.getId()
					.equals(id))
					.findFirst()
					.orElse(null);
	}

	public String removerPorId(String id) {
		for (int i = 0; i < contatos.size(); i++) {
			Contato cliente = contatos.get(i);
			if (cliente.getId().equals(id)) {
				contatos.remove(i);
				return "Contato removido com sucesso";
			}
		}
		return "Nenhum contato com este ID foi encontrado";

	}

	public int getTamanho() {
		return contatos.size();
	}
}
