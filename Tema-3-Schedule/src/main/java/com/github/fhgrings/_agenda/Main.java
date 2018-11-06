package main.java.com.github.fhgrings._agenda;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GerenciadorContato dadosContatos = new GerenciadorContato();
        int id=1;


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
                    String nome = sc.next();
                    Contato contatos = new Contato(nome, id);
                    dadosContatos.cadastroContato(contatos);
                    id++;
                    break;

                case 2:
                    dadosContatos.listarContatos();
                    break;

                case 3:
                    System.out.println("Digite o nome buscado: ");
                    nome = sc.next();
                    System.out.println("ID: " + dadosContatos.buscarPorNome(nome));
                    break;

                case 4:
                    System.out.println("Digite o ID buscado: ");
                    int idBuscado = sc.nextInt();
                    System.out.println("Nome: " + dadosContatos.buscarPorId(idBuscado));
                    break;

                case 5:
                    System.out.println("Digite o nome que deseja remover: ");
                    nome = sc.next();
                    dadosContatos.removerContato(nome);
                    break;
            }
        }
        sc.close();
    }
}
