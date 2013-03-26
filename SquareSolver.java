public class SquareSolver {
  // each number test gets its own string
  String output = "";

  // object constructor processes input then prints manipulated output
  public SquareSolver(int m) {
    stepOne(m);
  }

  // accessor method for modified string
  public String getOutput() {
    return output;
  }

  // input m is converted to x, compared, and outputs/returns if a perfect
  // square
  // else, it passes along to the next step
  private void stepOne(int m) {
    int x = (int) Math.floor(Math.sqrt(m));
    int xSquared = (int) Math.pow(x, 2);
    if (xSquared == m) {
      // y is always 0 in a perfect square
      int y = 0;
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
      String mString = formatM(m);
      output += mString + "        is a prime";
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
    String mString = formatM(m);
    output += mString + "        = " + (int) xSquared + "-" + ySquared + " = " + x + "^2-" + y + "^2 = (" + x + "-" + y
        + ")(" + x + "+" + y + ") = " + xMinusY + "*" + xPlusY;
  }

  // adds leading zeros to m in order to line up console output
  private String formatM(int m) {
    String mString = Integer.toString(m);
    if (m < 10)
      mString = 00 + mString;
    if (m < 100)
      mString = 0 + mString;
    return mString;
  }

}
