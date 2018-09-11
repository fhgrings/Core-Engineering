package com.github.erguerra.core_eng.tema_factory.models;

public class AlunoGraduacao implements Aluno {

    public void realizarMatricula() {
        System.out.println("Aluno matriculado na graducao");
    }

    public void cancelarMatricula() {
        System.out.println("Aluno desmatriculado da graduacao");
    }
}
