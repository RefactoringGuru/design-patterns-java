package refactoring_guru.adapter.example.round;

/**
 * EN: RoundHoles are compatible with RoundPegs.
 * <p>
 * RU: КруглоеОтверстие совместимо с КруглымиКолышками.
 */
public record RoundHole(double radius) {

  public boolean fits(RoundPeg peg) {
    boolean result;
    result = (this.radius() >= peg.getRadius());
    return result;
  }
}
