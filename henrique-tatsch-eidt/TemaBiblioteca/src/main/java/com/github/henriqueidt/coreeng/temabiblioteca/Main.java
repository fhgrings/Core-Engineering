package com.github.henriqueidt.coreeng.temabiblioteca;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        LivroDao livroDao = new LivroDao();
        ManipulacaoClientes manipulacaoClientes = new ManipulacaoClientes();
        ManipulacaoArquivos manipulacaoArquivos = new ManipulacaoArquivos();

        int opcao = 1;

        String conteudo = manipulacaoArquivos.read();
        if (conteudo.length() > 2) {
            livroDao.separaConteudo(conteudo);
        }
        do {
            System.out.println("Bem vindo a Biblioteca do Henrique! Selecione a opção:" +
                    "\n 1.Cadastrar livro " + "\n 2.Listar livros " + "\n 3.Excluir livro" +
                    "\n 4.Buscar livro " + "\n 5.Retirar livro" + "\n 6.Livros emprestados" +
                    "\n 7.Top 10 " + "\n 8.Livros atrasados " + "\n 9.Devolucao " + "\n 10.Renovacao: " + "\n 11.Encerrar programa ");

            opcao = ler.nextInt();
            ler.nextLine();

            switch(opcao) {
                case 1:
                    System.out.println("Digite o titulo do livro: ");
                    String tituloCadastra = ler.nextLine();
                    System.out.println("Digite o nome do autor de " + tituloCadastra);
                    String autorCadastra = ler.nextLine();
                    livroDao.inserirLivro(tituloCadastra, autorCadastra);
                    break;
                case 2:
                    System.out.println(livroDao.listarLivros());
                    break;
                case 3:
                    System.out.println("Digite o nome do livro a ser excluido: ");
                    String tituloExclui = ler.nextLine();
                    livroDao.removerLivro(tituloExclui);
                    break;
                case 4:
                    System.out.println("Digite o nome do livro que procura: ");
                    String tituloBusca = ler.nextLine();
                    System.out.println(livroDao.consultaLivro(tituloBusca));

                    break;
                case 5:
                    System.out.println("Digite o nome do cliente: ");
                    String nomeRetira = ler.nextLine();
                    manipulacaoClientes.cadastraCliente(nomeRetira);
                    if (livroDao.confereLivrosRetirados(nomeRetira) < 5) {
                        System.out.println("Digite o nome do livro a ser retirado: ");
                        String tituloRetira = ler.nextLine();
                        if(livroDao.retirarLivro(tituloRetira, nomeRetira)) {
                            manipulacaoClientes.incrementaHistorico(nomeRetira);
                        } else {
                            System.out.println("Livro não disponivel!");
                        }
                    } else {
                        System.out.println("Voce nao pode retirar mais livros");
                    }
                    break;
                case 6:
                    System.out.println(livroDao.livrosEmprestados());
                    break;
                case 7:
                    System.out.println(manipulacaoClientes.topClientes());
                    break;
                case 8:
                    System.out.println(livroDao.livrosAtrasados());
                    break;
                case 9:
                    int atraso = 0;
                    System.out.println("Digite o nome do livro que deseja devolver: ");
                    String tituloDevolucao = ler.nextLine();
                    atraso = livroDao.devolucaoLivro(tituloDevolucao);
                    if (atraso == 0) {
                        System.out.println("Livro devolvido sem multas");
                    } else {
                        System.out.println("Livro devolvido com multa de " + atraso * 5 + " reais");
                    }
                    break;
                case 10:
                    System.out.println("Digite o seu nome: ");
                    String nomeRenovacao = ler.nextLine();
                    if(!livroDao.confereAtrasos(nomeRenovacao)) {
                        System.out.println("Digite o nome do livro que deseja renovar: ");
                        String tituloRenovacao = ler.nextLine();
                        livroDao.renovarLivro(tituloRenovacao);
                    } else {
                        System.out.println("Você não pode fazer renovacoes pois esta atrasado! ");
                    }
                    break;
                case 11:
                    manipulacaoArquivos.write(livroDao.getLivros());
                    System.out.println("Programa encerrado");
                    break;
                default:
                    System.out.println("Comando invalido");
                    break;
            }
        } while(opcao != 11);
    }
}
