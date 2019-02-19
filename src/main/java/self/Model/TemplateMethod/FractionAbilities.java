package self.Model.TemplateMethod;

import self.Model.Fraction;

public abstract class FractionAbilities {
    private String race;
    private String godness;

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getGodness() {
        return godness;
    }

    public void setGodness(String godness) {
        this.godness = godness;
    }

    public abstract void increasePopulation(int population);

    public abstract void decreasePopulation(int population);

    public abstract void attack(Fraction fraction);
}
