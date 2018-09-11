package com.github.henriqueidt.coreeng.temaproxy;

import javax.xml.crypto.dom.DOMCryptoContext;
import java.util.Scanner;

public class DormitorioProxy implements Dormitorio {

    private final Dormitorio dormitorio;

    public DormitorioProxy(Dormitorio dormitorio) {
        this.dormitorio = dormitorio;
    }

    @Override
    public void abrir() {
        Scanner scanner = new Scanner (System.in);
        System.out.println("Mulher Gorda: Senha por favor");
        if(!scanner.nextLine().equals("Olho de dragao")) {
            System.out.println("Mulher Gorda: AVADA KEDABRA!");
        } else {
            dormitorio.abrir();
        }
    }
}
