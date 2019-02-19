package self.Strategy;

import self.Model.Fraction;

public class PeacefulNegotiation implements NegotiationStrategy {
    private final int reputationAmount = 5;

    @Override
    public void negotiate(Fraction fraction) {
        fraction.setReputation(fraction.getReputation() + 20);
    }
}
