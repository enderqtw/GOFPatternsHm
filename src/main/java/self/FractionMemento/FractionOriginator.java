package self.FractionMemento;

import self.Model.Fraction;

public class FractionOriginator {

    private Fraction fractionSnapshot;

    public Fraction getFractionSnapshot() {
        return fractionSnapshot;
    }

    public void setFractionSnapshot(Fraction fractionSnapshot) {
        this.fractionSnapshot = fractionSnapshot;
    }

    public FractionMemento saveSnapshotToMemento(Fraction fractionSnapshot) {
        return new FractionMemento(fractionSnapshot);
    }

    public void getSnapshotFromMemento(FractionMemento fractionMemento) {
        this.fractionSnapshot = fractionMemento.getFractionSnapshot();
    }
}
