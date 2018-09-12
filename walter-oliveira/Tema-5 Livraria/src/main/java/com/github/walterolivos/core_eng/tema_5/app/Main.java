package com.github.walterolivos.core_eng.tema_5.app;

import com.github.walterolivos.core_eng.tema_5.models.Livro;
import com.github.walterolivos.core_eng.tema_5.models.Usuario;
import com.github.walterolivos.core_eng.tema_5.models.Livraria;
import com.github.walterolivos.core_eng.tema_5.Services.Emprestimo;
import com.github.walterolivos.core_eng.tema_5.Services.GeradorId;
import com.github.walterolivos.core_eng.tema_5.Services.Gerenciador;
import com.github.walterolivos.core_eng.tema_5.Services.GerenciaTexto;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Livraria livraria = GerenciaTexto.extractData();
        int opcao = Integer.MAX_VALUE;

        while (opcao != 0){
            System.out.println("\nMenu:" + "\n1 - Cadastrar livro\n" + "2 - Listar livros\n:"
                + "3 - Excluir livro\n" + "4 - Buscar livro por autor\n" + "5 - Buscar livro por titulo\n"
                + "6 - Alugar livro\n" + "7 - Devolver livro\n" + "8 - Renovar aluguel\n" + "9 - Relatorio de emprestimo"
                + "10 - Listar clientes mais ativos\n" + "11 - Listar atrasados\n" + "0 - Sair\n");
            opcao = in.nextInt();

            switch (opcao){
                case 1:
                    String titulo, autor;
                    System.out.println("Digite o titulo do livro:");
                    titulo = in.nextLine();
                    System.out.println("Digite o autor do livro:");
                    autor = in.nextLine();
                    System.out.println(livraria.adicionarLivro(new Livro(titulo, autor)));
                    break;

                case 2:
                    System.out.println(livraria.listarTodosLivros());
                    break;

                case 3:
                    String id;
                    System.out.println("Digite o id do livro que deseja excluir:");
                    id = in.nextLine();
                    System.out.println(livraria.removerLivro(id));


                case 4:
                    System.out.println("Digite o nome do autor:");
                    autor = in.nextLine();
                    System.out.println(livraria.pesquisarLivrosPeloAutor(autor));
                    break;

                case 5:
                    System.out.println("Digite o nome do livro:");
                    titulo = in.nextLine();
                    System.out.println(livraria.pesquisarLivroPeloTitulo(titulo));

                case 6:
                    String documento;
                    System.out.println(livraria.listarLivrosDisponiveis());
                    System.out.println("Qual o Id do livro selecionado?");
                    id = in.nextLine();
                    System.out.println("Qual o documento do usuario que ira alugar o livro?");
                    documento = in.nextLine();
                    System.out.println(livraria.emprestimo(documento,id));
                    break;

                case 7:
                    System.out.println(livraria.getListaEmprestimos());
                    System.out.println("Digite o id do livro que deseja devolver:");
                    id = in.nextLine();
                    System.out.println(livraria.retornarLivro(id));
                    break;

                case 8:
                    System.out.println(livraria.getListaEmprestimos());
                    System.out.println("Qual id do livro que deseja renovar?");
                    id = in.nextLine();
                    System.out.println(livraria.retornarLivro(id));
                    break;

                case 9:
                    System.out.println(livraria.getListaEmprestimos());
                    break;

                case 10:
                    System.out.println(livraria.getTop10Emprestimo());
                    break;

                case 11:
                    System.out.println(livraria.getListaAtrasados());
                    break;

                default:
                    System.out.println("Opção invalida");
            }
        }
    }
}
