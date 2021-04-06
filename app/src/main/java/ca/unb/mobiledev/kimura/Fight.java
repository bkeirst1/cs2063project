package ca.unb.mobiledev.kimura;

public class Fight {

    private String fighterOne;

    private String fighterTwo;

    private String weightClass;

    public Fight(String fighterOne, String fighterTwo, String weightClass) {
        this.fighterOne = fighterOne;
        this.fighterTwo = fighterTwo;
        this.weightClass = weightClass;
    }

    public String getFighterOne() {
        return fighterOne;
    }

    public String getFighterTwo() {
        return fighterTwo;
    }

    public String getWeightClass() {
        return weightClass;
    }
}
