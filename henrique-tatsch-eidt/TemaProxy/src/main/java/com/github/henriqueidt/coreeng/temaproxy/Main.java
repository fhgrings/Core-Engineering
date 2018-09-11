package com.github.henriqueidt.coreeng.temaproxy;

public class Main {
    public static void main(String[] args) {
        DormitorioProxy proxy = new DormitorioProxy(new DormitorioGrifinoria());
        proxy.abrir();
    }
}
