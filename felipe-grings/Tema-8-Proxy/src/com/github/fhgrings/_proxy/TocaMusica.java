package com.github.fhgrings._proxy;

public class TocaMusica implements ISpotify {

    public TocaMusica(String nomeArquivo) {
          carregandoArquivo(nomeArquivo);
    }

    @Override
    public void play() {
        System.out.println("Tuts Tuts Tuts");
    }

    public void carregandoArquivo(String nomeArquivo) {
        System.out.println("Carregando arquivo " + nomeArquivo + " do disco. ");
    }
}
