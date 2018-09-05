package main.java.com.github.fhgrings._biblioteca;

import java.io.*;
import java.util.*;

public class GerenciadorCliente {
    private String path = "Clientes.txt";
    List<Cliente> clienteList = new ArrayList<>();

    public void atualizarArray(){
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" - ");
                Cliente cliente = new Cliente(parts[0],parts[1], Integer.valueOf(parts[2]));
                clienteList.add(cliente);
            }
        } catch (IOException e) {
            System.out.println("Erro");
          }
        }

    public Cliente buscaCPF(String Cpf) {
        for (Cliente cliente : clienteList){
            if(cliente.getCpf().equalsIgnoreCase(Cpf)) {
            return cliente;
            }
        }
        return null;
    }

    public boolean emprestaLivro(String Cpf) {
        for (Cliente cliente : clienteList){
            if (cliente.getCpf().equalsIgnoreCase(Cpf) && cliente.getLivrosAlugados()<5) {
                cliente.setLivrosAlugados(cliente.getLivrosAlugados() +1);
                cliente.setHistAluguel(cliente.getHistAluguel()+1);
                return true;
                }
            }
        return false;
    }

    public boolean devolverLivro(String Cpf) {
        for (Cliente cliente : clienteList){
            if (cliente.getCpf().equalsIgnoreCase(Cpf)) {
                cliente.setLivrosAlugados(cliente.getLivrosAlugados() -1);
                System.out.println("Cliente Ok!");
                return true;
                }
            }
        return false;
    }

    public String listarTopClientes () {
        StringBuffer sbf = new StringBuffer();
        Collections.sort(clienteList, new ClienteHistoricoComparador());
        int contador =0;
            for (Cliente cliente : clienteList){
                sbf.append("Cliente: " + cliente.getNome() + "    Livros Alugados: " + cliente.getHistAluguel() + "\n");
                contador++;
                if (contador > 9)
                    break;
            }
            return sbf.toString();
    }
}