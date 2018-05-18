package refactoring_guru.adapter.example.square;

/**
 * EN: SquarePegs are not compatible with RoundHoles (they were implemented by
 * previous development team). But we have to integrate them into our program.
 *
 * RU: КвадратныеКолышки несовместимы с КруглымиОтверстиями (они остались в
 * проекте после бывших разработчиков). Но мы должны как-то интегрировать их в
 * нашу систему.
 */
public class SquarePeg {
    private double width;

    public SquarePeg(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public double getSquare() {
        double result;
        result = Math.pow(this.width, 2);
        return result;
    }
}
