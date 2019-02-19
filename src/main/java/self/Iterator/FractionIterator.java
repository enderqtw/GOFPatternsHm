package self.Iterator;

import self.Model.Fraction;

import java.util.ArrayList;
import java.util.List;

public class FractionIterator implements WorldFractionIterator {
    private List<Fraction> fractionList = new ArrayList<>();
    private int currentPosition = 0;

    public FractionIterator(List fractionList) {
        this.fractionList.addAll(fractionList);
    }

    @Override
    public boolean hasNext() {
        return currentPosition < fractionList.size();
    }

    @Override
    public Fraction getNext() {
        return hasNext() ? fractionList.get(currentPosition++) : null;
    }
}
