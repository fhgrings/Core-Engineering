package com.github.fhgrings._agenda;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GerenciadorContato dadosContatos = new GerenciadorContato();

        while(true) {
            System.out.println("Menu\n" +
                    "1 - Adicionar\n" +
                    "2 - Listar\n" +
                    "3 - Pesquisar por nome\n" +
                    "4 - Buscar por ID\n" +
                    "5 - Remover\n" +
                    "6 - Sair");
            int selecao = sc.nextInt();
            if (selecao == 6)
                break;

            switch (selecao) {
                case 1:
                    System.out.println("Digite o nome do contato:");
                    String nomeAddContato = sc.next();
                    System.out.println("Digite o telefone do contato:");
                    String telefone = sc.next();
                    System.out.println("Digite o email do contato:");
                    String email = sc.next();
                    Contato contatos = new Contato(nomeAddContato,telefone, email);
                    dadosContatos.cadastrarContato(contatos);
                    break;

                case 2:
                    dadosContatos.listarContatos();
                    break;

                case 3:
                    System.out.println("Digite o nome buscado: ");
                    String nomeBuscaContato = sc.next();
                    dadosContatos.buscarPorNome(nomeBuscaContato);
                    break;

                case 4:
                    System.out.println("Digite o ID buscado: ");
                    int idBuscado = sc.nextInt();
                    dadosContatos.buscarPorId(idBuscado);
                    break;

                case 5:
                    System.out.println("Digite o id que deseja remover: ");
                    int id = sc.nextInt();
                    dadosContatos.removerContato(id);
                    break;
            }
        }
        sc.close();
    }
}