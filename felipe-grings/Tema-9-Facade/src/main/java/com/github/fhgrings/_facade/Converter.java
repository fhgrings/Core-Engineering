package com.github.fhgrings._facade;


import com.google.gson.Gson;

public class Converter {
    private static final Gson gson = new Gson();
    public static Character jsonToCharacter(String json) {
        return characterApiToCharacter(jsonToCharacterApi(json));
    }
    private static CharacterApi jsonToCharacterApi(String json) {
        return gson.fromJson(json, CharacterApi.class);
    }
    private static Character characterApiToCharacter(CharacterApi CharacterApi) {
        return CharacterBuilder.builder().withName(CharacterApi.getName())
                .withSkinColors(CharacterApi.getSkin_color()).
                withGender(CharacterApi.getGender()).
                withHeight(CharacterApi.getHeight()).
                withMass(CharacterApi.getMass()).
                withHomeWorld(CharacterApi.getHomeworld())
                .build();
    }
}