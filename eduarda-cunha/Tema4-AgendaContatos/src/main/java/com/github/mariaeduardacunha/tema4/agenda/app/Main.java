package com.github.mariaeduardacunha.tema4.agenda.app;
import com.github.mariaeduardacunha.tema4.agenda.model.Agenda;
import com.github.mariaeduardacunha.tema4.agenda.model.Contato;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Agenda dados = new Agenda();

        int opcaoMenu = 1;
        int id = 1;

        do {
            System.out.println("\n\t\tMENU");
            System.out.println("\t1. Adicionar contato");
            System.out.println("\t2. Buscar por id");
            System.out.println("\t3. Buscar por nome");
            System.out.println("\t4. Listar contatos");
            System.out.println("\t5. Remover por id");
            System.out.println("\t6. Remover por nome");
            System.out.println("\t0. Sair");

            opcaoMenu = scan.nextInt();

            switch(opcaoMenu){

                case 1:
                    System.out.println("\t---ADICIONAR---");
                    System.out.println("Digite os dados necessários:");
                    System.out.println("Nome: ");
                    String nome = scan.next();
                    System.out.println("Número: ");
                    String celular = scan.next();
                    System.out.println("Email:");
                    String email = scan.next();
                    Contato contato = new Contato(nome, id, celular, email);
                    dados.adicionar(contato);
                    id++;
                    System.out.println("Contato Adicionado!!");
                    break;

                case 2:
                    System.out.println("\t---BUSCAR ID---");
                    System.out.println("Digite o ID que deseja buscar: ");
                    int idPesquisa = scan.nextInt();
                    System.out.println("Nome: " + dados.buscarId(idPesquisa));
                    break;

                case 3:
                    System.out.println("\t---BUSCAR NOME---");
                    System.out.println("Digite o nome que deseja buscar: ");
                    String nomePesquisa = scan.next();
                    System.out.println("ID: " + dados.buscarNome(nomePesquisa));
                    break;

                case 4:
                    System.out.println("\t---LISTAR CONTATOS---");
                    System.out.println(dados.listar());
                    break;

                case 5:
                    System.out.println("\t---REMOVER POR ID---");
                    System.out.println("Digite o ID que deseja remover:");
                    id = scan.nextInt();
                    dados.removerId(id);
                    break;

                case 6:
                    System.out.println("---REMOVER POR NOME---");
                    System.out.println("Digite o nome que deseja remover:");
                    nome = scan.next();
                    dados.removerNome(nome);
                    break;

                case 0:
                    System.out.println("\n\tFechando o sistema!");
                    break;

                default:
                    System.out.println("\n\tOpção inválida!");

            }

        }while(opcaoMenu != 0);

    }
}