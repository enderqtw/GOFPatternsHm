package self.Strategy;

public class NegotiationCommand {
    private NegotiationStrategy strategy;

    public NegotiationCommand(int strategyType) {
        switch (strategyType) {
            case 1: {
                strategy = new PeacefulNegotiation();
            } break;
            case 2: {
                strategy = new AgressiveNegotiation();
            } break;
            default: {
                throw new IllegalArgumentException("Incorrect strategy type!");
            }
        }
    }

    public NegotiationStrategy getStrategy() {
        return strategy;
    }
}
