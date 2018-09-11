package com.github.mariaeduardacunha.tema4.agenda.model;

import java.util.ArrayList;
import java.util.List;

public class Agenda {

    private List<Contato> listaContatos = new ArrayList<>();
    private String lista;

    public void adicionar(Contato contato) {
        listaContatos.add(contato);
    }

    public String buscarId(int id){
        for(Contato contato : listaContatos)
            if (contato.getId() == id) {
                return contato.getNome();
            }
        System.out.println("Contato não existe!");
        return null;
    }

    public int buscarNome(String nome){
        for(Contato contato : listaContatos){
            if(contato.getNome().contains(nome)){
                return contato.getId();
            }
        }
        System.out.println("Contato não existe!");
        return 0;
    }

    public int listar(){
        for (Contato contato : listaContatos){
            if(listaContatos.size() != 0) {
                System.out.println("Contato: " + contato);
            }else{
                System.out.println("Lista Vazia!");
            }
        }
        System.out.println("Quantidade de Contatos: ");
        return listaContatos.size();
    }

    public boolean removerId(int id){
        for(Contato contato : listaContatos){
            if(contato.getId() == id){
                listaContatos.remove(contato);
                System.out.println("Contato Removido");
                return true;
            }
        }
        System.out.println("Contato não existe");
        return false;
    }

    public boolean removerNome(String nome){
        for(Contato contato : listaContatos){
            if((contato.getNome().contains(nome))){
                listaContatos.remove(contato);
                System.out.println("Contato Removido");
                return true;
            }
        }
        System.out.println("Contato não existe");
        return false;
    }
}