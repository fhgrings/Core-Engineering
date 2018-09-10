package com.github.vinifkroth.coreeng.tema6.app;

import java.util.Scanner;

import com.github.vinifkroth.coreeng.tema6.service.ContatoService;

public class App {

	public static void main(String[] args) throws Exception {

		ContatoService contatoService = new ContatoService();
		Scanner in = new Scanner(System.in);
		int op = Integer.MAX_VALUE;
		while (op != 0) {
			System.out.println("Bem-vindo ao sistema:" + "\n1.Cadastrar contato\n"
					+ "2.Listar todos os contatos ordenados por ID\n"
					+ "3.Listar todos os contatos ordenados por nome\n" + "4.Buscar contato pelo nome\n"
					+ "5.Buscar contato por seu id\n" + "6.Remover contato por seu id\n" + "0.Sair do sistema");
			op = in.nextInt();
			in.nextLine();
			switch (op) {
			case 0:
				System.out.println("Consulta encerrada");
				break;
			case 1:
				System.out.println("Digite o nome do contato");
				String nome = in.nextLine();
				System.out.println("Digite o numero do contato");
				String numero = in.nextLine();
				System.out.println("Digite o email do contato");
				String email = in.nextLine();
				System.out.println(contatoService.adicionar(nome, numero, email));
				break;
			case 2:
				System.out.println(contatoService.listarOrdenadosPorId());
				break;
			case 3:
				System.out.println(contatoService.listarOrdenadosPorNome());
				break;
			case 4:
				System.out.println("Digite o nome do contato que deseja buscar:");
				nome = in.nextLine();
				System.out.println(contatoService.buscarPorNome(nome));
				break;
			case 5:
				System.out.println("Digite o id do contato que deseja buscar:");
				String id = in.nextLine();
				System.out.println(contatoService.buscarPorId(id));
				break;
			case 6:
				System.out.println("Digite o id do contato que deseja remover:");
				id = in.nextLine();
				System.out.println(contatoService.remover(id));
				break;

			default:
				System.out.println("Opção inválida, favor reinserir uma opção válida");

			}

		}
	}

}
