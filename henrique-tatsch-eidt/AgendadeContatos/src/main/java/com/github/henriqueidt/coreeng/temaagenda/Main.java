package com.github.henriqueidt.coreeng.temaagenda;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("AGENDA DE CONTATOS: Digite o numero da opcao" +
                    "\n 1. Adicionar contato;" + "\n 2. Remover contato;" + "\n 3. Consulta por nome;" +
                    "\n 4. Consulta por id;" + "\n 5. Listar contatos" + "\n 6. Encerrar");

            opcao = ler.nextInt();
            ler.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Insira o nome do contato: ");
                    String nome = ler.nextLine();
                    System.out.println("Insira o numero de telefone: ");
                    String numero = ler.nextLine();
                    Agenda.inserirContato(nome, numero);
                    break;
                case 2:
                    System.out.println("Insira o nome completo do contato que deseja remover: ");
                    String nomeRemover = ler.nextLine();
                    Agenda.removerContato(nomeRemover);
                    break;
                case 3:
                    System.out.println("Insira o nome completo do contato que deseja consultar: ");
                    String nomeConsulta = ler.nextLine();
                    String contatoConsulta = Agenda.consultaContatoNome(nomeConsulta);
                    System.out.println(contatoConsulta);
                    break;
                case 4:
                    System.out.println("Insira o ID do contato que deseja consultar: ");
                    int id = ler.nextInt();
                    String contato = Agenda.consultaContatoId(id);
                    System.out.println(contato);
                    break;
                case 5:
                    String listacontatos = Agenda.listarContatos();
                    System.out.println(listacontatos);
                    break;
                case 6:
                    System.out.println("Programa encerrado!");
                    break;
                default:
                    System.out.println("Opcao invalida");

            }
        } while(opcao != 6);
    }
}
