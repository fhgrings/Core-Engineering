package com.github.fhgrings._facade;


public class CharacterBuilder {

    private Character character;

    public CharacterBuilder() {
        character = new Character();
    }


    public static CharacterBuilder builder() {
        return new CharacterBuilder();
    }

    public CharacterBuilder withName(String name) {
        character.setName(name);
        return this;
    }

    public CharacterBuilder withSkinColors(String skin_color) {
        character.setSkin_color(skin_color);
        return this;
    }

    public CharacterBuilder withHeight(String height){
        character.setHeight(height);
        return this;
    }

    public CharacterBuilder withMass(String mass){
        character.setMass(mass);
        return this;
    }

    public CharacterBuilder withGender(String Gender){
        character.setGender(Gender);
        return this;
    }

    public CharacterBuilder withHomeWorld(String homeWorld){
        character.setHomeworld(homeWorld);
        return this;
    }

    public Character build() { return character; }
}
