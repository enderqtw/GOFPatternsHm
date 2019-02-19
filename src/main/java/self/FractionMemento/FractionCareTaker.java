package self.FractionMemento;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FractionCareTaker {
    private List<FractionMemento> mementoList = new ArrayList<FractionMemento>();

    public void add(FractionMemento fractionMemento) {
        mementoList.add(fractionMemento);
    }

    public FractionMemento get(int index) {
        return mementoList.get(index);
    }

    public int getMementoSize() {
        return mementoList.size();
    }

    public FractionMemento getLastFractionSnapshot(final String fractionName) {
        List<FractionMemento> fractionMementoList = mementoList.stream()
                .filter(fraction -> fraction.getFractionSnapshot().getFractionName().equals(fractionName))
                .collect(Collectors.toList());

        int fractionSize = fractionMementoList.size();
        return fractionMementoList.get(fractionSize >= 1 ? fractionSize - 1 : fractionSize);
    }
}
