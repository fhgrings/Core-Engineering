package com.github.rafaritter44.core_eng.agenda.models;

import java.util.ArrayList;
import java.util.List;

public class Agenda {

    private List<Contato> contatos;
    private static int contadorID;

    public Agenda() {
        contatos = new ArrayList<Contato>();
        contadorID = 0;
    }

    public void add(String nome, String telefone) {
        contatos.add(new Contato(contadorID, nome, telefone));
        contadorID++;
    }

    public Contato remove(int id) {
        if(id < 0)
            return null;
        for(int i=0; i<contatos.size(); i++)
            if(id == contatos.get(i).getId())
                return contatos.remove(i);
        return null;
    }

    @Override
    public String toString() {
        String lista = "Lista de Contatos:\n";
        for(Contato contato: contatos)
            lista += contato + "\n";
        return lista;
    }

    public Contato get(String nome) {
        if(nome == null)
            return null;
        for(Contato contato: contatos)
            if(nome.equals(contato.getNome()))
                return contato;
        return null;
    }

    public Contato get(int id) {
        if(id < 0)
            return null;
        for(int i=0; i<contatos.size(); i++)
            if(id == contatos.get(i).getId())
                return contatos.get(i);
        return null;
    }

}
