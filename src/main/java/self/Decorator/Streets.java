package self.Decorator;

public class Streets implements CityStructureFundaments {
    private int houses;

    public Streets(int houses) {
        this.houses = houses;
    }

    public int getHouses() {
        return houses;
    }

    public void setHouses(int houses) {
        this.houses = houses;
    }

    @Override
    public void buildCity() {
        buildProcedure();
    }

    void buildProcedure() {
        new Thread(){
            @Override
            public void run() {
                houses++;
                try {
                    currentThread().sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.run();
    }
}
