package com.github.henriqueidt.coreeng.temafacade.facade;

public class HPFacade {

    private HPRestClient restClient;

    public HPFacade() {
        this.restClient = new HPRestClient();
    }

    public String getHPCharacters() {
        return restClient.characterApi();
    }
}
