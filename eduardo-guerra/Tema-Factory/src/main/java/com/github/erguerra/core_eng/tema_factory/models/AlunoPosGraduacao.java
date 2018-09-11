package com.github.erguerra.core_eng.tema_factory.models;

public class AlunoPosGraduacao implements Aluno {

    public void realizarMatricula() {
        System.out.println("Aluno matriculado na pos-graduacao");
    }

    public void cancelarMatricula() {
        System.out.println("Aluno desmatriculado da pos-graduacao");
    }
}
