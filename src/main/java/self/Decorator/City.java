package self.Decorator;

public class City extends Streets {
    private int population;

    public City(int houses) {
        super(houses);
        this.population = houses * 4;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public void buildCity() {
        buildProcedure();
        populationProcedure();
    }

    void populationProcedure() {
        new Thread(){
            @Override
            public void run() {
                population++;
                try {
                    currentThread().sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.run();
    }
}
