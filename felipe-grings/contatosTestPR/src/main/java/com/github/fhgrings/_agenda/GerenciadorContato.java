package main.java.com.github.fhgrings._agenda;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorContato {
    List<Contato> contatosList = new ArrayList<>();

    public void cadastroContato(Contato contato) {
        contatosList.add(contato);
        System.out.println("Contato adicionado!");
    }

    public int listarContatos() {
        for (Contato c : contatosList) {
            System.out.println("Contato: " + c);
        }
        return contatosList.size();
    }

    public int buscarPorNome(String nome) {
        for (Contato c : contatosList) {
            if (c.getNome().contains(nome)) {
                return c.getId();
            }
        }
        System.out.println("Nao encontrado");
        return 0;
    }

    public String buscarPorId(int id) {
        for (Contato c : contatosList){
            if (c.getId() == id ) {
                return c.getNome();
            }
        }
        System.out.println("Nao encontrado");
        return null;
    }

    public boolean removerContato(String nome) {
         for (Contato c : contatosList){
            if(c.getNome().contains(nome)) {
                contatosList.remove(c);
                System.out.println("Contato " + nome + " removido");
                return true;
            }
         }
         System.out.println("Contato nao encontrado");
         return false;
    }

}
