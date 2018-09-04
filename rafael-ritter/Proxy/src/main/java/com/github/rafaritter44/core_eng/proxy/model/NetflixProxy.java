package com.github.rafaritter44.core_eng.proxy.model;

public class NetflixProxy implements Netflix {

    private Netflix netflix;
    private String usuario;
    private String senha;
    private static final String USUARIO_ADMIN = "papai";
    private static final String SENHA_ADMIN = "1234";

    public NetflixProxy(String usuario, String senha) {
        netflix = new NetflixReal();
        this.usuario = usuario;
        this.senha = senha;
        inicializa();
    }

    private void inicializa() {
        System.out.println("Acessando conta Netflix de " + usuario);
    }

    @Override
    public void assistirConteudoAdulto() {
        if(temPermissao())
            netflix.assistirConteudoAdulto();
        else
            System.out.println("Permissão negada!!! Você não tem autorização para assistir a esse filme!");
    }

    @Override
    public void assistirConteudoInfantil() {
        netflix.assistirConteudoInfantil();
    }

    private boolean temPermissao() {
        return usuario.equals(USUARIO_ADMIN) && senha.equals(SENHA_ADMIN);
    }

}
