package com.github.henriqueidt.coreeng.temaagenda;
import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private static int contatoId = 1000;
    public static List<Contato> contatos = new ArrayList();

    public static void inserirContato(String nome, String numero) {
        Contato contato = new Contato();
        contato.setNome(nome);
        contato.setNumero(numero);
        contato.setId(contatoId);
        contatos.add(contato);
        contatoId++;
    }

    public static void removerContato(String nome) {
                for (Contato c : contatos) {
                    if (c.getNome().equals(nome)) {
                        contatos.remove(contatos.indexOf(c));
                        break;
                    }
                }
    }

    public static String consultaContatoNome(String nome) {
        String lista = "";
        for(Contato c : contatos) {
                if(c.getNome().equals(nome)) {
                    lista = contatos.get(contatos.indexOf(c)).toString();
                    break;
                } else {
                    lista = "Nome nao cadastrado";
                }
            }
            return lista;
    }

    public static String consultaContatoId(int id) {
        String lista = "";
        for(Contato c : contatos) {
            if((id) == c.getId()) {
                lista = contatos.get(contatos.indexOf(c)).toString();
                break;
            } else {
                lista = "Id nao encontrado";
            }
        }
        return lista;
    }

    public static String listarContatos() {
        String arraycontatos = "";
        for (Contato c : contatos) {
                arraycontatos += c.toString();
                arraycontatos += "\n";
        }
        return arraycontatos;
    }
}
