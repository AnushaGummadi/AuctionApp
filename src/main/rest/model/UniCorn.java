package main.rest.model;

import java.util.List;

public class UniCorn {
    private Long unicornId;
    private String name;
    private String hairColor = "pink";//default Value
    private double hornLength;
    private String hornColor = "gold";//default Value
    private String eyeColor = "brown";//default Value
    private double height;
    private String heightUnit = "cm";//default Value
    private double weight;
    private String weightUnit = "kg";//default Value
    private List<IdentifiableMarks> identifiableMarks;

    public Long getUnicornId() {
        return unicornId;
    }

    public void setUnicornId(final Long unicornId) {
        this.unicornId = unicornId;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(final String hairColor) {
        this.hairColor = hairColor;
    }

    public double getHornLength() {
        return hornLength;
    }

    public void setHornLength(final double hornLength) {
        this.hornLength = hornLength;
    }

    public String getHornColor() {
        return hornColor;
    }

    public void setHornColor(final String hornColor) {
        this.hornColor = hornColor;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(final String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(final double height) {
        this.height = height;
    }

    public String getHeightUnit() {
        return heightUnit;
    }

    public void setHeightUnit(final String heightUnit) {
        this.heightUnit = heightUnit;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(final double weight) {
        this.weight = weight;
    }

    public String getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(final String weightUnit) {
        this.weightUnit = weightUnit;
    }

    public List<IdentifiableMarks> getIdentifiableMarks() {
        return identifiableMarks;
    }

    public void setIdentifiableMarks(final List<IdentifiableMarks> identifiableMarks) {
        this.identifiableMarks = identifiableMarks;
    }

    @Override
    public String toString() {
        return "UniCorn{" +
               "unicornId=" + unicornId +
               ", name='" + name + '\'' +
               ", hairColor='" + hairColor + '\'' +
               ", hornLength=" + hornLength +
               ", hornColor='" + hornColor + '\'' +
               ", eyeColor='" + eyeColor + '\'' +
               ", height=" + height +
               ", heightUnit='" + heightUnit + '\'' +
               ", weight=" + weight +
               ", weightUnit='" + weightUnit + '\'' +
               ", identifiableMarks=" + identifiableMarks +
               '}';
    }
}
