public class Driver {
  public static void main(String[] args) {
    // creates solver object for each positive odd integer 3 to 199 inclusive
    // and prints the output
    System.out.println("Input Column       Output Column\n");
    SquareSolver solver;
    for (int i = 3; i <= 199; i += 2) {
      solver = new SquareSolver(i);
      System.out.println(solver.getOutput() + "\n");
    }
  }
}
