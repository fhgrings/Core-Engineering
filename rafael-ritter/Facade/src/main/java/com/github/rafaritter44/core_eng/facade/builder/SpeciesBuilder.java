package com.github.rafaritter44.core_eng.facade.builder;

import com.github.rafaritter44.core_eng.facade.model.Species;

public class SpeciesBuilder {

    private Species species;

    public SpeciesBuilder() {
        species = new Species();
    }

    public static SpeciesBuilder builder() {
        return new SpeciesBuilder();
    }

    public SpeciesBuilder withName(String name) {
        species.setName(name);
        return this;
    }

    public SpeciesBuilder withClassification(String classification) {
        species.setClassification(classification);
        return this;
    }

    public SpeciesBuilder withDesignation(String designation) {
        species.setDesignation(designation);
        return this;
    }

    public SpeciesBuilder withAverageHeight(String averageHeight) {
        species.setAverageHeight(averageHeight);
        return this;
    }


    public SpeciesBuilder withSkinColors(String skinColors) {
        species.setSkinColors(skinColors);
        return this;
    }

    public SpeciesBuilder withHairColors(String hairColors) {
        species.setHairColors(hairColors);
        return this;
    }

    public SpeciesBuilder withEyeColors(String eyeColors) {
        species.setEyeColors(eyeColors);
        return this;
    }

    public SpeciesBuilder withAverageLifespan(String averageLifespan) {
        species.setAverageLifespan(averageLifespan);
        return this;
    }

    public SpeciesBuilder withLanguage(String language) {
        species.setLanguage(language);
        return this;
    }

    public Species build() { return species; }

}
