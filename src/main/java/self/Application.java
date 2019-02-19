package self;

import self.FractionMemento.FractionCareTaker;
import self.FractionMemento.FractionOriginator;
import self.Iterator.FractionIterator;
import self.Model.Fraction;
import self.Singletone.TradeCompanySingletone;
import self.Strategy.NegotiationCommand;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Application implements Runnable {

    FractionCareTaker careTaker = new FractionCareTaker();
    FractionOriginator fractionOriginator = new FractionOriginator();
    List<Fraction> fractions = new ArrayList<>();

    public static void main(String[] args) {
        new Application().run();
    }

    @Override
    public void run() {
        Random rnd = new Random();
        while (true) {
            int randomNumber = rnd.nextInt(4) + 1;

            switch (randomNumber) {
                case 1: {
                    System.out.println("Fraction creation case");
                    if (fractions.size() < 10) {
                        String name = "someFraction" + rnd.nextInt(10);
                        createFraction(name, rnd.nextInt(10000)+1, rnd.nextInt(10000)+1, rnd.nextInt(10000)+1);
                        System.out.println(careTaker.getLastFractionSnapshot(name).getFractionSnapshot().toString());
                    }
                } break;
                case 2: {
                    System.out.println("Fraction war case");
                    if (fractions.size() > 1) {
                        int number = rnd.nextInt(fractions.size());
                        fractions.get(rnd.nextInt(fractions.size())).attack(fractions.get(number));
                        careTaker.add(fractionOriginator.saveSnapshotToMemento(fractions.get(number)));
                    }
                } break;
                case 3: {
                    System.out.println("Fraction trading case");
                    if (fractions.size() >= 1) {
                        int fractionIndex = rnd.nextInt(fractions.size());
                        Fraction fraction = fractions.get(fractionIndex);
                        TradeCompanySingletone.getInstance().tradeSomeStuff(fraction, rnd.nextInt((int) fraction.getSilver() / 2));
                        careTaker.add(fractionOriginator.saveSnapshotToMemento(fraction));
                    }
                } break;
                case 4: {
                    System.out.println("Fraction negotiation case");
                    if (fractions.size() >= 1) {
                        int fractionIndex = rnd.nextInt(fractions.size());
                        int negotiationType = rnd.nextInt(2) + 1;
                        Fraction fraction = fractions.get(fractionIndex);

                        NegotiationCommand command = new NegotiationCommand(negotiationType);
                        command.getStrategy().negotiate(fraction);
                        careTaker.add(fractionOriginator.saveSnapshotToMemento(fraction));
                    }
                } break;
                default: {
                    throw new IllegalArgumentException("Not possible");
                }
            }

            if (careTaker.getMementoSize() != 0 & careTaker.getMementoSize() % 10 == 0) {
                System.out.println("========================================");
                System.out.println("Summary for fractions after 10 rounds passed.");
                FractionIterator itr = new FractionIterator(fractions);
                while (itr.hasNext()) {
                    System.out.println(itr.getNext().toString());
                }
                System.out.println("========================================");
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    private void createFraction(String name, int silver, int army, int reputation) {
        Fraction fraction = new Fraction(name, silver, army, reputation);
        careTaker.add(fractionOriginator.saveSnapshotToMemento(fraction));
        fractions.add(fraction);

    }
}
