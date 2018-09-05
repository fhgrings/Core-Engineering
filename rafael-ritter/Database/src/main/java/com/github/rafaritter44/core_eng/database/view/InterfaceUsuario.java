package com.github.rafaritter44.core_eng.database.view;

import com.github.rafaritter44.core_eng.database.dao.ContatoDAO;
import com.github.rafaritter44.core_eng.database.model.Contato;

import java.util.List;
import java.util.Scanner;

public class InterfaceUsuario {

    private ContatoDAO contatoDao;
    private Scanner leitor;
    private static final String ENTER = "[ENTER] para continuar";
    private static final String INFORME_ID = "Informe o ID: ";
    private static final String ERRO_CONSULTA = "Erro ao consultar contatos!\n";

    public InterfaceUsuario() {
        contatoDao = new ContatoDAO();
        leitor = new Scanner(System.in);
    }

    public void executar() {
        String escolha;
        System.out.println("========== BEM-VINDO(A) À AGENDA ==========");
        do {
            System.out.print("1 - Adicionar contato\n" +
                    "2 - Remover contato\n" +
                    "3 - Listar contatos ordenados por nome\n" +
                    "4 - Listar contatos ordenados por ID\n" +
                    "5 - Buscar contato por nome\n" +
                    "6 - Buscar contato por ID\n" +
                    "0 - Sair\n" +
                    "Informe a opção: ");
            escolha = leitor.nextLine();
            switch (escolha) {
                case "1":
                    System.out.print("Informe o nome: ");
                    String nome = leitor.nextLine();
                    System.out.print("Informe o telefone: ");
                    String telefone = leitor.nextLine();
                    System.out.print("Informe o e-mail: ");
                    String email = leitor.nextLine();
                    try {
                        contatoDao.insereContato(nome, telefone, email);
                        System.out.print("Contato adicionado com sucesso!\n" + ENTER);
                    } catch(Exception excecao) {
                        System.out.print("Erro ao adicionar contato!\n" + ENTER);
                    }
                    leitor.nextLine();
                    break;
                case "2":
                    System.out.print(INFORME_ID);
                    int linhasAlteradas = -1;
                    try {
                        linhasAlteradas = contatoDao.deletaContato(leitor.nextLine());
                    } catch(Exception excecao) {
                        System.out.print("Erro ao remover contato!\n" + ENTER);
                    }
                    if(linhasAlteradas == 0)
                        System.out.print("Nenhum contato com esse ID.\n" + ENTER);
                    else if(linhasAlteradas > 0)
                        System.out.print("Contato removido com sucesso!\n" + ENTER);
                    leitor.nextLine();
                    break;
                case "3":
                    try {
                        System.out.print(mapearContatos(contatoDao.listaPorNome()) + ENTER);
                    } catch(Exception excecao) {
                        System.out.print(ERRO_CONSULTA + ENTER);
                    }
                    leitor.nextLine();
                    break;
                case "4":
                    try {
                        System.out.print(mapearContatos(contatoDao.listaPorID()) + ENTER);
                    } catch(Exception excecao) {
                        System.out.print(ERRO_CONSULTA + ENTER);
                    }
                    leitor.nextLine();
                    break;
                case "5":
                    System.out.print("Informe o nome: ");
                    try {
                        System.out.print(mapearContatos(contatoDao.buscaPorNome(leitor.nextLine())) + ENTER);
                    } catch(Exception excecao) {
                        System.out.print(ERRO_CONSULTA + ENTER);
                    }
                    leitor.nextLine();
                    break;
                case "6":
                    System.out.print(INFORME_ID);
                    try {
                        System.out.print(mapearContatos(contatoDao.buscaPorID(leitor.nextLine())) + ENTER);
                    } catch(Exception excecao) {
                        System.out.print(ERRO_CONSULTA + ENTER);
                    }
                    leitor.nextLine();
                    break;
                case "0":
                    System.out.println("Fim de programa.");
                    break;
                default:
                    System.out.print("Essa opção não existe.\n" + ENTER);
                    leitor.nextLine();
            }
        } while (!escolha.equals("0"));
    }

    private String mapearContatos(List<Contato> consulta) {
        StringBuilder contatos = new StringBuilder();
        for(Contato contato: consulta)
            contatos.append(contato + "\n");
        return contatos.length() == 0 ?
                "Nenhum contato foi encontrado.\n":
                "Contatos encontrados:\n" + contatos.toString();
    }

}