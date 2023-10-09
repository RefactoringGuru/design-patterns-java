package refactoring_guru.adapter.example.adapters;

import refactoring_guru.adapter.example.round.RoundPeg;
import refactoring_guru.adapter.example.square.SquarePeg;

/**
 * EN: Adapter allows fitting square pegs into round holes.
 * <p>
 * RU: Адаптер позволяет использовать КвадратныеКолышки и КруглыеОтверстия
 * вместе.
 */
public class SquarePegAdapter extends RoundPeg {
  private final SquarePeg squarePeg;

  public SquarePegAdapter(SquarePeg peg) {
    this.squarePeg = peg;
  }

    /**
     * Calculate a minimum circle radius, which can fit this square peg
     * <p>
     * Рассчитываем минимальный радиус, в который пролезет этот колышек.
     * @return result of computation
     */
  @Override
  public double getRadius() {
      return (Math.sqrt(Math.pow((squarePeg.width() / 2), 2) * 2));
  }
}
