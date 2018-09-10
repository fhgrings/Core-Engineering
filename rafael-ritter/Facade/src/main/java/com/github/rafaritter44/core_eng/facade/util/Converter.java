package com.github.rafaritter44.core_eng.facade.util;

import com.github.rafaritter44.core_eng.facade.builder.SpeciesBuilder;
import com.github.rafaritter44.core_eng.facade.model.Species;
import com.github.rafaritter44.core_eng.facade.model.SpeciesApi;
import com.google.gson.Gson;

public class Converter {

    private static final Gson gson = new Gson();

    public static Species jsonToSpecies(String json) {
        return speciesApiToSpecies(jsonToSpeciesApi(json));
    }

    private static SpeciesApi jsonToSpeciesApi(String json) {
        return gson.fromJson(json, SpeciesApi.class);
    }

    private static Species speciesApiToSpecies(SpeciesApi speciesApi) {
        return SpeciesBuilder.builder()
                .withName(speciesApi.getName())
                .withClassification(speciesApi.getClassification())
                .withDesignation(speciesApi.getDesignation())
                .withAverageHeight(speciesApi.getAverage_height())
                .withSkinColors(speciesApi.getSkin_colors())
                .withHairColors(speciesApi.getHair_colors())
                .withEyeColors(speciesApi.getEye_colors())
                .withAverageLifespan(speciesApi.getAverage_lifespan())
                .withLanguage(speciesApi.getLanguage())
                .build();
    }

}
