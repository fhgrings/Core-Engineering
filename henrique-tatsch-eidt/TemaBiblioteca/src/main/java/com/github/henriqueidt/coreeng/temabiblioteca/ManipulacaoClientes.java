package com.github.henriqueidt.coreeng.temabiblioteca;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ManipulacaoClientes {
    public static List<Cliente> clientes = new ArrayList();

    public boolean cadastraCliente(String nome) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equals(nome)) {
                return false;
            }
        }
            Cliente cliente = new Cliente(nome,0);
            clientes.add(cliente);
            return true;
    }

    public void incrementaHistorico(String nome) {
        int index = -1;
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equals(nome)) {
                index = clientes.indexOf(cliente);
                break;
            }
        }
        if (index != -1) {
            clientes.get(index).setHistorico(clientes.get(index).getHistorico() + 1);
        }
    }

    public String topClientes() {
        int index = 0, procura = 10;
        boolean ninguemEncontrado;
        String top = null;
        Collections.sort(clientes, new Comparator<Cliente>() {
            public int compare(Cliente c1, Cliente c2) {
                return Integer.valueOf(c2.historico).compareTo(c1.historico);
            }
        });
        for (int i = 0; i < clientes.size() && i < 10; i++) {
            if (clientes.get(i).getNome().equals("livre")) {
                procura++;
            }
        }
        for (int i = 0; i < clientes.size() && i < procura; i++) {
            if (!clientes.get(i).getNome().equals("livre")) {
                if (top == null) {
                    top = ("Nome: " + clientes.get(i).getNome() + " Livros retirados: " + clientes.get(i).getHistorico());
                } else {
                    top += ("\nNome: " + clientes.get(i).getNome() + " Livros retirados: " + clientes.get(i).getHistorico());
                }

            }
        }
        return top;
    }
}


