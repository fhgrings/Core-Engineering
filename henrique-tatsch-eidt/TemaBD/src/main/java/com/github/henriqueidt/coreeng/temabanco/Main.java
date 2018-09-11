package com.github.henriqueidt.coreeng.temabanco;

import com.github.henriqueidt.coreeng.temabancoDAO.ClienteDAO;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ClienteDAO clienteDAO = new ClienteDAO();

        int opcao = 1;
        Scanner ler = new Scanner(System.in);

        do {
            System.out.println("Agenda vitrual. Selecione a opção:" + "\n1.Adicionar contato" +
                    "\n2.Remover contato" + "\n3.Listar contatos" + "\n4.Buscar por nome" + "\n5.Buscar por id" +
                    "\n6.Encerrar programa");

            opcao = ler.nextInt();
            ler.nextLine();
            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do contato: ");
                    String nomeInsere = ler.nextLine();
                    System.out.println("Informe o telefone: ");
                    String telefoneInsere = ler.nextLine();
                    System.out.println("Informe o email: ");
                    String emailInsere = ler.nextLine();
                    clienteDAO.cadastra(nomeInsere, telefoneInsere, emailInsere);
                    break;

                case 2:
                    System.out.println("Digite o id do contato a ser removido: ");
                    int idRemove = ler.nextInt();
                    clienteDAO.remove(idRemove);
                    break;

                case 3:
                    List<Contato> contatos = clienteDAO.ler();
                    for(Contato contato: contatos) {
                        System.out.println(contatos.get(contatos.indexOf(contato)).toString());
                    }
                    break;

                case 4:
                    System.out.println("Infome o nome do contato que busca: ");
                    String nomeConsulta = ler.nextLine();
                    List<Contato> contatoNomeConsulta = clienteDAO.consultaNome(nomeConsulta);
                    if (contatoNomeConsulta.size() > 0) {
                        System.out.println(contatoNomeConsulta.get(0).toString());
                    } else {
                        System.out.println("Contato nao encontrado");
                    }
                    break;

                case 5:
                    System.out.println("Infome o id do contato que busca: ");
                    int idConsulta = ler.nextInt();
                    List<Contato> contatoIdConsulta;
                    contatoIdConsulta = clienteDAO.consultaId(idConsulta);
                    if (contatoIdConsulta.size() > 0) {
                        System.out.println(contatoIdConsulta.get(0).toString());
                    } else {
                        System.out.println("Contato nao encontrado");
                    }
                    break;

                case 6:
                    System.out.println("Programa encerrado!");
                    break;

                default:
                    System.out.println("Comando invalido!");
                    break;
            }
        } while(opcao != 6);
    }
}
