package com.github.fhgrings._proxy;

public class TocaMusicaProxy implements ISpotify {
    private TocaMusica meuAudio;
    private String nomeArquivo;
    private String login;
    private String senha;

    public TocaMusicaProxy(String nomeArquivo, String login, String senha) {
        this.nomeArquivo = nomeArquivo;
        this.login = login;
        this.senha = senha;
        autenticacao();
    }

    public void autenticacao() {
        if (login.equalsIgnoreCase("root") && senha.equalsIgnoreCase("root")) {
            System.out.println("Autenticacao realizada!\n");
            meuAudio = new TocaMusica(nomeArquivo);
        } else {
            System.out.println("Login ou senha invalidos\n");
        }
    }

    @Override
    public void play() {
        if(meuAudio != null ) {
            System.out.println("Iniciando a musica");
        }
        try {
            meuAudio.play();
        } catch (Exception e) {
            System.out.println("Erro _ Necessario realizar login");
        }
    }
}
