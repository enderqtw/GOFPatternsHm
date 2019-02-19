package self.Model;

import self.Model.TemplateMethod.FractionAbilities;

public class Fraction extends FractionAbilities {

    private final String fractionName;
    private int silver;
    private int army;
    private int reputation;

    public Fraction(String fractionName) {
        this(fractionName, 0, 0, 0);
    }

    public Fraction(String fractionName, int silver) {
        this(fractionName, silver, 0, 0);
    }

    public Fraction(String fractionName, int silver, int army) {
        this(fractionName, silver, army, 0);
    }

    public Fraction(String fractionName, int silver, int army, int reputation) {
        this.fractionName = fractionName;
        this.silver = silver >= 0 ? silver : 0;
        this.army = army >= 0 ? army : 0;
        this.reputation = reputation;

        this.setGodness("default");
        this.setRace("none");
    }

    public String getFractionName() {
        return fractionName;
    }

    public int getSilver() {
        return silver;
    }

    public void setSilver(int silver) {
        this.silver = silver;
    }

    public int getArmy() {
        return army;
    }

    public void setArmy(int army) {
        this.army = army;
    }

    public int getReputation() {
        return reputation;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }

    @Override
    public void increasePopulation(int population) {
        army += population;
    }

    @Override
    public void decreasePopulation(int population) {
        if (army >= population)
            army -= population;
    }

    @Override
    public void attack(Fraction enemyFraction) {
        int enemyArmy = enemyFraction.getArmy();
        int enemySilver = enemyFraction.getSilver();

        if (enemyArmy < army) {
            enemyFraction.setArmy((int)(enemyArmy * 0.8));
            army = (int)(army * 0.9);

            int silverFee = 0;
            if (enemySilver != 0)
                silverFee = (int)enemySilver / 5;
            enemyFraction.setSilver(enemySilver - silverFee);
            silver += silverFee;
        } else {
            enemyFraction.setArmy((int)(enemyArmy * 0.9));
            army = (int)(army * 0.8);

            int silverFee = 0;
            if (silver != 0)
                silverFee = (int)silver / 5;
            enemyFraction.setSilver(enemySilver + silverFee);
            silver -= silverFee;
        }
    }

    public String toString() {
        return "Fraction name:\t" + fractionName
                +"\nRace:\t" + getRace()
                +"\nGodness name:\t" + getGodness()
                +"\nSilver amount:\t" + silver
                +"\nArmy count:\t" + army
                +"\nReputation:\t" + reputation;
    }
}
