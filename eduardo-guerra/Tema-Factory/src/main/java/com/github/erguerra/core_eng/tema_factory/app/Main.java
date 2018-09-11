package com.github.erguerra.core_eng.tema_factory.app;

import com.github.erguerra.core_eng.tema_factory.factory.FabricaDeAlunos;
import com.github.erguerra.core_eng.tema_factory.models.Aluno;

public class Main {
    public static void main(String[] args) {

        FabricaDeAlunos fabricaDeAlunos = new FabricaDeAlunos();

        Aluno alunoDeGraduacao = fabricaDeAlunos.getAluno("Graduacao");
        Aluno alunoDePosGrad = fabricaDeAlunos.getAluno("PosGraduacao");

        alunoDeGraduacao.realizarMatricula();
        alunoDePosGrad.realizarMatricula();
        alunoDeGraduacao.cancelarMatricula();
        alunoDePosGrad.cancelarMatricula();

    }
}
