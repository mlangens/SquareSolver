public class Driver {
  public static void main(String[] args) {
    SquareSolver solver;
    for (int i = 3; i <= 199; i += 2) {
      solver = new SquareSolver(i);      
    }
  }
}
