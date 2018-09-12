package com.github.henriqueidt.coreeng.tematemplate;

public abstract class Veiculo {
    abstract void soldaPecas();
    abstract void pinta();
    abstract void colocaRodas();

    public final void monta() {
        soldaPecas();
        pinta();
        colocaRodas();
    }
}

