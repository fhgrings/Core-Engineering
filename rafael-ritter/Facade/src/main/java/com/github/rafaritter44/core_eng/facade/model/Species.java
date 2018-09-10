package com.github.rafaritter44.core_eng.facade.model;

import java.util.List;

public class Species {

    private String name;
    private String classification;
    private String designation;
    private String averageHeight;
    private String skinColors;
    private String hairColors;
    private String eyeColors;
    private String averageLifespan;
    private String language;

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
                "Classification: " + classification + "\n" +
                "Designation: " + designation + "\n" +
                "Average Height: " + averageHeight + "\n" +
                "Skin colors: " + skinColors + "\n" +
                "Hair colors: " + hairColors + "\n" +
                "Eye colors: " + eyeColors + "\n" +
                "Average lifespan: " + averageLifespan + "\n" +
                "Language: " + language;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getClassification() { return classification; }
    public void setClassification(String classification) { this.classification = classification; }
    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }
    public String getAverageHeight() { return averageHeight; }
    public void setAverageHeight(String averageHeight) { this.averageHeight = averageHeight; }
    public String getSkinColors() { return skinColors; }
    public void setSkinColors(String skinColors) { this.skinColors = skinColors; }
    public String getHairColors() { return hairColors; }
    public void setHairColors(String hairColors) { this.hairColors = hairColors; }
    public String getEyeColors() { return eyeColors; }
    public void setEyeColors(String eyeColors) { this.eyeColors = eyeColors; }
    public String getAverageLifespan() { return averageLifespan; }
    public void setAverageLifespan(String averageLifespan) { this.averageLifespan = averageLifespan; }
    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }

}
