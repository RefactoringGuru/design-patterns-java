package refactoring_guru.structural.adapter.example.adapters;

import refactoring_guru.structural.adapter.example.round.RoundPeg;
import refactoring_guru.structural.adapter.example.square.SquarePeg;

/**
 * EN: Adapter allows fitting square pegs into round holes.
 *
 * RU: Адаптер позволяет использовать КвадратныеКолышки и КруглыеОтверстия
 * вместе.
 */
public class SquarePegAdapter extends RoundPeg {
    private final SquarePeg peg;

    public SquarePegAdapter(SquarePeg peg) {
        this.peg = peg;
    }

    @Override
    public double getRadius() {
        double result;
        // EN: Calculate a minimum circle radius, which can fit this peg.
        //
        // RU: Рассчитываем минимальный радиус, в который пролезет этот колышек.
        result = (Math.sqrt(Math.pow((peg.getWidth() / 2), 2) * 2));
        return result;
    }
}
