package com.github.rafaritter44.core_eng.facade.facade;

import com.github.rafaritter44.core_eng.facade.model.Species;
import com.github.rafaritter44.core_eng.facade.rest.SwApiRestClient;
import com.github.rafaritter44.core_eng.facade.util.Converter;

import java.util.Optional;

public class SwApiFacade {

    private SwApiRestClient restClient;

    public SwApiFacade() {
        this.restClient = new SwApiRestClient();
    }

    public Optional<Species> findSpeciesByID(String id) {
        try {
            return Optional.ofNullable(Converter.jsonToSpecies(restClient.findSpeciesByID(id)));
        } catch(Exception exception) {
            return Optional.empty();
        }
    }

}
