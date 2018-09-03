package com.github.rafaritter44.core_eng.biblioteca.view;

import com.github.rafaritter44.core_eng.biblioteca.exceptions.LivroNaoEncontradoException;
import com.github.rafaritter44.core_eng.biblioteca.model.Biblioteca;
import com.github.rafaritter44.core_eng.biblioteca.model.Cliente;
import com.github.rafaritter44.core_eng.biblioteca.model.Emprestimo;
import com.github.rafaritter44.core_eng.biblioteca.model.SituacaoLivro;
import com.github.rafaritter44.core_eng.biblioteca.util.Conversor;

import java.util.Optional;
import java.util.Scanner;

public class InterfaceUsuario {

    private Biblioteca biblioteca;
    private Scanner leitor;
    private static final String ARQUIVO = "biblioteca.json";
    private static final String OPCAO = "Informe a opção: ";
    private static final String ENTER = "[ENTER] para continuar";
    private static final String TITULO = "Informe o título do livro: ";
    private static final String AUTOR = "Informe o nome do autor: ";
    private static final String ID = "Informe o ID do livro: ";
    private static final String LIVRO_INEXISTENTE = "Esse livro não existe.";
    private static final String LIVRO_EMPRESTADO = "Esse livro está emprestado no momento.";
    private static final String CLIENTE = "Informe o nome do cliente: ";
    private static final String CLIENTE_INEXISTENTE = "Esse cliente não existe.";
    private static final String SAIR = "0 - Sair";
    private static final String OPCAO_INEXISTENTE = "Essa opção não existe.";
    private static final String DEVOLUCAO_OK = "Livro devolvido com sucesso!";

    public InterfaceUsuario() {
        biblioteca = Conversor.ler(ARQUIVO);
        leitor = new Scanner(System.in);
    }

    public void executar() {
        String escolha;
        System.out.println("========== BEM-VINDO(A) À BIBLIOTECA ==========");
        do {
            System.out.print("1 - Cadastrar livro\n" +
                    "2 - Listar todos os livros\n" +
                    "3 - Excluir livro\n" +
                    "4 - Buscar livro por título\n" +
                    "5 - Buscar livro por autor\n" +
                    "6 - Emprestar livro\n" +
                    "7 - Devolver livro\n" +
                    "8 - Renovar empréstimo\n" +
                    "9 - Exibir relatório dos livros emprestados\n" +
                    "10 - Exibir TOP 10 clientes que mais locam livros\n" +
                    "11 - Exibir relatório dos empréstimos atrasados\n" +
                    SAIR + "\n" + OPCAO);
            escolha = leitor.nextLine();
            switch(escolha) {
                case "1":
                    System.out.print(TITULO);
                    String titulo = leitor.nextLine();
                    System.out.print(AUTOR);
                    String autor = leitor.nextLine();
                    biblioteca.cadastrar(titulo, autor);
                    System.out.print("Livro cadastrado com sucesso!\n" + ENTER);
                    leitor.nextLine();
                    break;
                case "2":
                    System.out.print(biblioteca.listar() + ENTER);
                    leitor.nextLine();
                    break;
                case "3":
                    System.out.print(ID);
                    Optional<Integer> idLivro = Conversor.toInteiro(leitor.nextLine());
                    SituacaoLivro situacao = SituacaoLivro.INEXISTENTE;
                    if(idLivro.isPresent())
                        situacao = biblioteca.excluir(idLivro.get());
                    switch(situacao) {
                        case REGULAR:
                            System.out.print("Livro excluído com sucesso!\n" + ENTER);
                            leitor.nextLine();
                            break;
                        case EMPRESTADO:
                            System.out.print(LIVRO_EMPRESTADO + "\n" + ENTER);
                            leitor.nextLine();
                            break;
                        case INEXISTENTE:
                            System.out.print(LIVRO_INEXISTENTE + "\n" + ENTER);
                            leitor.nextLine();
                    }
                    break;
                case "4":
                    System.out.print(TITULO);
                    System.out.print(biblioteca.buscarPorTitulo(leitor.nextLine()) + ENTER);
                    leitor.nextLine();
                    break;
                case "5":
                    System.out.print(AUTOR);
                    System.out.print(biblioteca.buscarPorAutor(leitor.nextLine()) + ENTER);
                    leitor.nextLine();
                    break;
                case "6":
                    System.out.print(CLIENTE);
                    Cliente cliente = biblioteca.getCliente(leitor.nextLine());
                    if(cliente == null) {
                        System.out.print(CLIENTE_INEXISTENTE + "\n" + ENTER);
                        leitor.nextLine();
                        break;
                    }
                    String opcao;
                    do {
                        if(!cliente.podeEmprestar()) {
                            System.out.print("Esse cliente atingiu o limite de empréstimos.\n" + ENTER);
                            leitor.nextLine();
                            break;
                        }
                        System.out.print(ID);
                        idLivro = Conversor.toInteiro(leitor.nextLine());
                        if(idLivro.isPresent())
                            situacao = biblioteca.emprestar(cliente, idLivro.get());
                        else
                            situacao = SituacaoLivro.INEXISTENTE;
                        switch(situacao) {
                            case REGULAR:
                                System.out.print("Livro emprestado com sucesso!\n" + ENTER);
                                leitor.nextLine();
                                break;
                            case EMPRESTADO:
                                System.out.print(LIVRO_EMPRESTADO + "\n" + ENTER);
                                leitor.nextLine();
                                break;
                            case INEXISTENTE:
                                System.out.print(LIVRO_INEXISTENTE + "\n" + ENTER);
                                leitor.nextLine();
                        }
                        do {
                            System.out.print("1 - Emprestar outro livro\n" + SAIR + "\n" + OPCAO);
                            opcao = leitor.nextLine();
                            if(!opcao.equals("0") && !opcao.equals("1")) {
                                System.out.print(OPCAO_INEXISTENTE + "\n" + ENTER);
                                leitor.nextLine();
                            }
                        } while(!opcao.equals("0") && !opcao.equals("1"));
                    } while(!opcao.equals("0"));
                    break;
                case "7":
                    System.out.print(CLIENTE);
                    cliente = biblioteca.getCliente(leitor.nextLine());
                    if(cliente == null) {
                        System.out.print(CLIENTE_INEXISTENTE + "\n" + ENTER);
                        leitor.nextLine();
                        break;
                    }
                    do {
                        if(cliente.semLivros()) {
                            System.out.print("Esse cliente não tem livros para devolver.\n" + ENTER);
                            leitor.nextLine();
                            break;
                        }
                        System.out.print(cliente.listarLivros() + ID);
                        idLivro = Conversor.toInteiro(leitor.nextLine());
                        if(idLivro.isPresent()) {
                            int multa = -1;
                            try {
                                multa = biblioteca.devolver(cliente, idLivro.get());
                            } catch (LivroNaoEncontradoException excecao) {
                                System.out.print(excecao.getMessage() + ENTER);
                                leitor.nextLine();
                            }
                            if (multa == 0) {
                                System.out.print(DEVOLUCAO_OK + "\n" + ENTER);
                                leitor.nextLine();
                            } else if (multa > 0) {
                                System.out.print(DEVOLUCAO_OK +
                                        "\nCobrar R$" + multa + ",00 de " + cliente.getNome() + " pelo atraso.\n" + ENTER);
                                leitor.nextLine();
                            }
                        } else {
                            System.out.print(cliente.getNome() + " não está com esse livro.\n" + ENTER);
                            leitor.nextLine();
                        }
                        do {
                            System.out.print("1 - Devolver outro livro\n" + SAIR + "\n" + OPCAO);
                            opcao = leitor.nextLine();
                            if(!opcao.equals("0") && !opcao.equals("1")) {
                                System.out.print(OPCAO_INEXISTENTE + "\n" + ENTER);
                                leitor.nextLine();
                                leitor.nextLine();
                            }
                        } while(!opcao.equals("0") && !opcao.equals("1"));
                    } while(!opcao.equals("0"));
                    break;
                case "8":
                    System.out.print(CLIENTE);
                    cliente = biblioteca.getCliente(leitor.nextLine());
                    if(cliente == null) {
                        System.out.print(CLIENTE_INEXISTENTE + "\n" + ENTER);
                        leitor.nextLine();
                        break;
                    }
                    do {
                        if(cliente.semLivros()) {
                            System.out.print("Esse cliente não tem livros para renovar.\n" + ENTER);
                            leitor.nextLine();
                            break;
                        }
                        System.out.print(cliente.listarLivros() + ID);
                        idLivro = Conversor.toInteiro(leitor.nextLine());
                        if(idLivro.isPresent()) {
                            Optional<Emprestimo> emprestimo = biblioteca.getEmprestimo(idLivro.get(), cliente);
                            if(emprestimo.isPresent()) {
                                if (biblioteca.renovar(emprestimo.get())) {
                                    System.out.print("Empréstimo renovado com sucesso!\n" + ENTER);
                                    leitor.nextLine();
                                } else {
                                    System.out.print("Renovação negada! A devolução desse livro está atrasada.\n" + ENTER);
                                    leitor.nextLine();
                                }
                            } else {
                                System.out.print(cliente.getNome() + " não está com esse livro.\n" + ENTER);
                                leitor.nextLine();
                            }
                        } else {
                            System.out.print(cliente.getNome() + " não está com esse livro.\n" + ENTER);
                            leitor.nextLine();
                        }
                        do {
                            System.out.print("1 - Renovar outro livro\n" + SAIR + "\n" + OPCAO);
                            opcao = leitor.nextLine();
                            if(!opcao.equals("0") && !opcao.equals("1")) {
                                System.out.print(OPCAO_INEXISTENTE + "\n" + ENTER);
                                leitor.nextLine();
                            }
                        } while(!opcao.equals("0") && !opcao.equals("1"));
                    } while(!opcao.equals("0"));
                    break;
                case "9":
                    System.out.print(biblioteca.relatorioEmprestados() + ENTER);
                    leitor.nextLine();
                    break;
                case "10":
                    System.out.print(biblioteca.relatorioTop10Alugadores() + ENTER);
                    leitor.nextLine();
                    break;
                case "11":
                    System.out.print(biblioteca.relatorioAtrasos() + ENTER);
                    leitor.nextLine();
                    break;
                case "0":
                    Conversor.gravar(ARQUIVO, biblioteca);
                    System.out.println("Todos os dados foram gravados no arquivo " + ARQUIVO);
                    break;
                default:
                    System.out.print(OPCAO_INEXISTENTE + "\n" + ENTER);
                    leitor.nextLine();
            }
        } while(!escolha.equals("0"));
    }

}
