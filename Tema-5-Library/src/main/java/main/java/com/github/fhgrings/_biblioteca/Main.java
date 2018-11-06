package main.java.com.github.fhgrings._biblioteca;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String cpf;

        GerenciadorLivros gerenciadorLivros = new GerenciadorLivros();
        GerenciadorCliente gerenciadorCliente = new GerenciadorCliente();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dataHoje = sdf.format(new Date());

        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH,7);
        String devolucaoDia = sdf.format(c.getTime());

        gerenciadorCliente.atualizarArray();
        gerenciadorLivros.atualizarArray();

        while(true) {
            System.out.println("Menu\n" +
                    "1  - Adicionar\n" +
                    "2  - Listar\n" +
                    "3  - Pesquisar por Autor\n" +
                    "4  - Buscar por Titulo\n" +
                    "5  - Remover\n" +
                    "6  - Alugar livro\n" +
                    "7  - Devolver Livros\n" +
                    "8  - Renovar Livro\n" +
                    "9  - Listar Livros Alugados\n" +
                    "10 - Listar Top 10 Clientes\n" +
                    "11 - Listar Livros Atrasados\n" +
                    "0  - Sair");

            int selecao = sc.nextInt();
            if (selecao == 0)
                break;

            switch (selecao) {
                case 1:
                    int idInt = (int) (Math.random() * 10000);
                    String id =Integer.toString(idInt);
                    System.out.println("Digite o autor do livro:");
                    String autor = sc.next();

                    System.out.println("Digite o titulo do livro:");
                    String titulo = sc.next();

                    Livro livro = new Livro(titulo, autor, id);
                    gerenciadorLivros.cadastrarLivros(livro);
                    break;

                case 2:
                    System.out.println(gerenciadorLivros.listarLivros());
                    break;

                case 3:
                    System.out.println("Digite o Autor buscado: ");
                    autor = sc.next();
                    System.out.println(gerenciadorLivros.buscarLivroByAutor(autor));
                    break;

                case 4:
                    System.out.println("Digite o titulo buscado: ");
                    String tituloBuscado = sc.next();
                    System.out.println(gerenciadorLivros.buscarLivroByTitulo(tituloBuscado));
                    break;

                case 5:
                    System.out.println("Digite o ID do livro que deseja remover: ");
                    autor = sc.next();
                    System.out.println(gerenciadorLivros.removerLivro(autor));
                    break;

                case 6:
                    System.out.println("Digite o titulo que deseja alugar: ");
                    titulo = sc.next();
                    System.out.println("Digite o cpf do cliente: ");
                    cpf = sc.next();

                    if (gerenciadorCliente.emprestaLivro(cpf))
                        System.out.println(gerenciadorLivros.alugarLivro(titulo, gerenciadorCliente.buscaCPF(cpf).getNome(), devolucaoDia));
                    else
                        System.out.println("Cliente nao encontrado");
                    break;

                case 7:
                    System.out.println("Digite o ID do livro a devolver");
                    id = sc.next();
                    System.out.println("Digite o cpf do cliente: ");
                    cpf = sc.next();

                    if(gerenciadorLivros.devolverLivro(id, dataHoje)) {
                        gerenciadorCliente.devolverLivro(cpf);
                        System.out.println("Livro devolvido!");
                    }


                    break;

                case 8:
                    System.out.println("Digite o ID a renovar ");
                    id = sc.next();
                    System.out.println("Digite o cpf do cliente: ");
                    cpf = sc.next();
                    System.out.println(gerenciadorLivros.renovarLivro(id, cpf, dataHoje, devolucaoDia));
                    break;

                case 9:
                    System.out.println(gerenciadorLivros.listarLivrosAlugados());
                    break;

                case 10:
                    System.out.println(gerenciadorCliente.listarTopClientes());
                    break;

                case 11:
                    System.out.println(gerenciadorLivros.listarAtrasados(dataHoje));
                    break;
            }
        }
        sc.close();
    }
}


