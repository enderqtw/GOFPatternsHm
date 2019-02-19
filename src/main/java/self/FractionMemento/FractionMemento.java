package self.FractionMemento;

import self.Model.Fraction;

public class FractionMemento {
    private final Fraction fractionSnapshot;

    public Fraction getFractionSnapshot() {
        return fractionSnapshot;
    }

    public FractionMemento(Fraction fractionSnapshot) {
        this.fractionSnapshot = fractionSnapshot;
    }
}
