package refactoring_guru.adapter.example;

import refactoring_guru.adapter.example.adapters.SquarePegAdapter;
import refactoring_guru.adapter.example.round.RoundHole;
import refactoring_guru.adapter.example.round.RoundPeg;
import refactoring_guru.adapter.example.square.SquarePeg;

/**
 * EN: Somewhere in client code...
 * <p>
 * RU: Где-то в клиентском коде...
 */
public class Demo {
  public static void main(String[] args) {
    demonstrateRoundPegAndHole();
    demonstrateAdapterForSquarePeg();
  }

  private static void demonstrateRoundPegAndHole() {
    RoundHole roundHole = new RoundHole(5);
    RoundPeg roundPeg = new RoundPeg(5);

    if (roundHole.fits(roundPeg)) {
      System.out.println("Round peg r5 fits round hole r5.");
    }
  }

  private static void demonstrateAdapterForSquarePeg() {
    RoundHole roundHole = new RoundHole(5);

    SquarePeg smallSqPeg = new SquarePeg(2);
    SquarePegAdapter smallSqPegAdapter = new SquarePegAdapter(smallSqPeg);
    if (roundHole.fits(smallSqPegAdapter)) {
      System.out.println("Square peg w2 fits round hole r5.");
    }

    SquarePeg largeSqPeg = new SquarePeg(20);
    SquarePegAdapter largeSqPegAdapter = new SquarePegAdapter(largeSqPeg);
    if (!roundHole.fits(largeSqPegAdapter)) {
      System.out.println("Square peg w20 does not fit into round hole r5.");
    }
  }
}
