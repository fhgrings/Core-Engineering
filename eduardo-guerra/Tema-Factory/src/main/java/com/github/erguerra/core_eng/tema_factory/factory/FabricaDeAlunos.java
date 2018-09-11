package com.github.erguerra.core_eng.tema_factory.factory;

import com.github.erguerra.core_eng.tema_factory.models.Aluno;
import com.github.erguerra.core_eng.tema_factory.models.AlunoGraduacao;
import com.github.erguerra.core_eng.tema_factory.models.AlunoPosGraduacao;

public class FabricaDeAlunos {

    public Aluno getAluno(String tipoAluno) {
        switch (tipoAluno) {
            case "Graduacao":
                return new AlunoGraduacao();
            case "PosGraduacao":
                return new AlunoPosGraduacao();
            default:
                throw new RuntimeException("Tipo de aluno invalido");
        }
    }
}
