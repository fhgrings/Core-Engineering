package com.github.vinifkroth.coreeng.tema4.app;

import java.util.Scanner;

import com.github.vinifkroth.coreeng.tema4.model.Contato;
import com.github.vinifkroth.coreeng.tema4.service.AgendaDeContatos;
import com.github.vinifkroth.coreeng.tema4.util.CriadorDeContato;

public class App {

	public static void main(String[] args) {
		AgendaDeContatos agenda = new AgendaDeContatos();
		Scanner in = new Scanner(System.in);
		String nome, id;
		int op = Integer.MAX_VALUE;
		Contato contato;

		while (op != 0) {
			System.out.println("Bem-vindo ao sistema:" + "\n1.Cadastrar contato\n" + "2.Listar todos os contatos\n"
					+ "3.Buscar contato pelo nome\n" + "4.Buscar contato por seu id\n"
					+ "5.Remover contato por seu id\n" + "0.Sair do sistema");
			op = in.nextInt();
			in.nextLine();
			switch (op) {
			case 1:
				agenda.adicionar(CriadorDeContato.criar());
				break;
			case 2:
				System.out.println(agenda.listar());
				break;
			case 3:
				System.out.println("Digite o nome do contato que deseja buscar:");
				id = in.nextLine();
				contato = agenda.buscarPorNome(id);
				System.out.println(contato.equals(null) ? "Usuário com este nome não está presente em nosso sistema\n"
						: contato.toString() + "\n");
				break;
			case 4:
				System.out.println("Digite o id do contato que deseja buscar:");
				id = in.nextLine();
				contato = agenda.buscarPorId(id);
				System.out.println(contato.equals(null) ? "Usuário com esta id não está presente em nosso sistema"
						: contato.toString());
				break;
			case 5:
				System.out.println("Digite o nome do contato que deseja remover:");
				id = in.nextLine();
				System.out.println(agenda.removerPorId(id));
				break;
			case 0:
				System.out.println("Consulta encerrada");
				break;
			default:
				System.out.println("Opção inválida, favor reinserir uma opção válida");

			}

		}
	}

}
