package refactoring_guru.adapter.example.square;

/**
 * EN: SquarePegs are not compatible with RoundHoles (they were implemented by
 * previous development team). But we have to integrate them into our program.
 * <p>
 * RU: КвадратныеКолышки несовместимы с КруглымиОтверстиями (они остались в
 * проекте после бывших разработчиков). Но мы должны как-то интегрировать их в
 * нашу систему.
 */
public record SquarePeg(double width) {

  public double getSquare() {
    double result;
    result = Math.pow(this.width, 2);
    return result;
  }
}
