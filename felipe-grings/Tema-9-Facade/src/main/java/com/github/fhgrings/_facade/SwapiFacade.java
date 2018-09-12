package com.github.fhgrings._facade;


public class SwapiFacade {

    private SwapiRestClient swapiRestClient;
    private Converter converter;

    public SwapiFacade() {
        swapiRestClient = new SwapiRestClient();
        converter = new Converter();
    }

    public String findCharacterById(int id){
        return converter.jsonToCharacter(swapiRestClient.findSpeciesById(id)).toString();
    }
}