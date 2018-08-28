package com.github.vinifkroth.coreeng.tema5.app;

import java.util.Scanner;

import com.github.vinifkroth.coreeng.tema5.model.Book;
import com.github.vinifkroth.coreeng.tema5.service.Library;
import com.github.vinifkroth.coreeng.tema5.util.ManageTextData;

public class App {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Library library = ManageTextData.extractData();
		String id, document, title, author, response;
		int op = Integer.MAX_VALUE;
		while (op != 0) {
			System.out.println("\nMenu do sistema:" + "\n1.Cadastrar livro\n" + "2.Listar todos os livros\n"
					+ "3.Excluir livro\n" + "4.Buscar livros por autor\n" + "5.Buscar livros por título\n"
					+ "6.Alugar livro\n" + "7.Devolver livro\n" + "8.Renovar aluguel\n" + "9.Relatório de empréstimos\n"
					+ "10.Listar clientes mais ativos\n" + "11.Listar atrasos\n" + "0.Sair do sistema");
			op = in.nextInt();
			in.nextLine();
			switch (op) {
			case 0:
				System.out.println("Consulta encerrada");
				ManageTextData.storeData(library.getLibraryInfo());
				break;
			case 1:
				System.out.println("Digite o título do livro:");
				title = in.nextLine();
				System.out.println("Digite o autor do livro:");
				author = in.nextLine();
				System.out.println(library.addBook(new Book(title, author)));
				break;
			case 2:
				System.out.println(library.listAllBooks());
				break;
			case 3:
				System.out.println("Digite o id do livro que deseja excluir:");
				id = in.nextLine();
				System.out.println(library.removeBook(id));
				break;
			case 4:
				System.out.println("Digite o nome do autor:");
				author = in.nextLine();
				System.out.println(library.findBooksByAuthor(author));
				break;
			case 5:
				System.out.println("Digite o nome do livro:");
				title = in.nextLine();
				System.out.println(library.findBookByTitle(title));
				break;
			case 6:
				System.out.println(library.listAvailableBooks());
				System.out.println("Qual a Id do livro selecionado?");
				id = in.nextLine();
				System.out.println("Qual o documento do usuário que irá alugar o livro?");
				document = in.nextLine();
				System.out.println(library.lease(document, id));
				break;
			case 7:
				System.out.println(library.getLeasedList());
				System.out.println("Digite o id do livro que você deseja devolver:");
				id = in.nextLine();
				System.out.println(library.returnBook(id));
				System.out.println(
						"Você gostaria de devolver mais algum livro? Digite S, caso queira, ou qualquer outro caractére caso queira sair.");
				response = in.nextLine();
				while (response.equalsIgnoreCase("S")) {
					System.out.println("Digite o id do livro que você deseja devolver:");
					id = in.nextLine();
					System.out.println(library.returnBook(id));
					System.out.println(
							"Você gostaria de devolver mais algum livro? Digite S, caso queira, ou qualquer outro caracter caso queira sair.");
					response = in.nextLine();
				}
				break;
			case 8:
				System.out.println(library.getLeasedList());
				System.out.println("Qual a id do livro que deseja renovar?");
				id = in.nextLine();
				System.out.println(library.renewLease(id));
				break;
			case 9:
				System.out.println(library.getLeasedList());
				break;
			case 10:
				System.out.println(library.getTop10Leasers());
				break;
			case 11:
				System.out.println(library.getDelayedList());
				break;

			default:
				System.out.println("Opção inválida, favor reinserir uma opção válida");

			}

		}
	}

}
