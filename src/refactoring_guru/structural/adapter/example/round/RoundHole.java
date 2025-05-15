package refactoring_guru.structural.adapter.example.round;

/**
 * EN: RoundHoles are compatible with RoundPegs.
 *
 * RU: КруглоеОтверстие совместимо с КруглымиКолышками.
 */
public class RoundHole {
    private final double radius;

    public RoundHole(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public boolean fits(RoundPeg peg) {
        boolean result;
        result = (this.getRadius() >= peg.getRadius());
        return result;
    }
}
