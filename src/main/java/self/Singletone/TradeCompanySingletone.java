package self.Singletone;

import self.Model.Fraction;

public class TradeCompanySingletone {
    private final static TradeCompanySingletone tradeCompany = new TradeCompanySingletone();

    private TradeCompanySingletone() {
        if (tradeCompany != null) {
            try {
                throw new IllegalAccessException("There can be only one Trade Company!");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static TradeCompanySingletone getInstance() {
        return tradeCompany;
    }

    public static void tradeSomeStuff(Fraction fraction, int silver) {
        int availableSilver = fraction.getSilver();
        if (availableSilver >= silver) {
            fraction.setSilver(fraction.getSilver() - silver);
            fraction.setArmy(fraction.getArmy() * (silver * 2));
        } else {
            double fee = silver / fraction.getArmy();
            fraction.setReputation( fraction.getReputation() - (int) fee);
            fraction.setSilver( availableSilver - (int) (silver * 0.15));
        }
    }
}
