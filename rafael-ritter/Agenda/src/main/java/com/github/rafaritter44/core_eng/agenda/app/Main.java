package com.github.rafaritter44.core_eng.agenda.app;

import com.github.rafaritter44.core_eng.agenda.models.Agenda;
import com.github.rafaritter44.core_eng.agenda.models.Contato;

public class Main {

    public static void main(String args[]) {
        Agenda agenda = new Agenda();
        adicionaImprime(agenda, "Rafael", "9991-8881");
        adicionaImprime(agenda, "Maria", "9000-8000");
        adicionaImprime(agenda, "João da Silva", "9405-2325");
        System.out.println("Primeiro contato da lista:\n" + agenda.get(0));
        System.out.println("Dados de Maria:\n" + agenda.get("Maria"));
        System.out.print(agenda);
        agenda.remove(2);
        System.out.println("João da Silva foi removido da lista de contatos.");
        System.out.print(agenda);

    }

    private static void adicionaImprime(Agenda agenda, String nome, String telefone) {
        agenda.add(nome, telefone);
        System.out.println(nome + " foi adicionado(a) à lista de contatos!");
    }

}
