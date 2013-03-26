public class SquareSolver {
  // each number test gets its own string
  String output = "";

  // object constructor processes input then prints manipulated output
  public SquareSolver(int m) {
    stepOne(m);
    System.out.println(output);
    System.out.println();
  }

  // input m is converted to x, compared, and outputs/returns if a perfect
  // square
  // else, it passes along to the next step
  private void stepOne(int m) {
    int x = (int) Math.floor(Math.sqrt(m));
    int xSquared = (int) Math.pow(x, 2);
    if (xSquared == m) {
      //y is always 0 in a perfect square
      int y=0;
      manipulateFactorizationString(m, x, xSquared, y);
      return;
    } else {
      stepTwo(m, x);
    }
  }

  // increments x, checks if m is a prime. if so, returns
  // else, it calls step three
  private void stepTwo(int m, int x) {
    x++;
    if (x == (m + 1) / 2) {
      output += m + "        m is a prime";
      return;
    } else {
      stepThree(m, x);
    }
  }

  // sets y and performs an integer/factorization check
  // if false, increments and goes back to step Two
  private void stepThree(int m, int x) {
    double xSquared = Math.pow(x, 2);
    int integerCheck = (int) xSquared - m;
    int y = (int) Math.sqrt(integerCheck);
    int intCheckY = (int) Math.pow(Math.floor(y), 2);
    if (intCheckY == integerCheck) {
      manipulateFactorizationString(m, x, xSquared, y);
      return;
    } else {
      stepTwo(m, x);
    }
  }

  // ugly code to manipulate string for non perfect square factorizations
  private void manipulateFactorizationString(int m, int x, double xSquared, int y) {
    int ySquared = (int) Math.pow(y, 2);
    int xMinusY = x - y;
    int xPlusY = x + y;
    output += m + "        =    " + (int) xSquared + "-" + ySquared + "    =    " + x + "^2-" + y + "^2    =    (" + x
        + "-" + y + ")(" + x + "+" + y + ")    =    " + xMinusY + "*" + xPlusY;
  }

}
