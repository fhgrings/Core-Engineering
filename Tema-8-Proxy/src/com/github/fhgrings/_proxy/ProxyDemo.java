package com.github.fhgrings._proxy;

public class ProxyDemo {
    public static void main(String[] args) {
        ISpotify meuAudio = new TocaMusicaProxy("Natural_ImagineDragons.mp3", "root", "root");
        ISpotify meuAudio2 = new TocaMusicaProxy("Natural_ImagineDragons.mp3", "login", "root");

        meuAudio.play();
        System.out.println();

        meuAudio2.play();
    }
}
