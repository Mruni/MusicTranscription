/**
 * Class to show using the array of string arguments
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class TestStringArgs {
  public static void main(String [] args) {
    if (args.length == 0)
      System.out.println("No arguments were entered!");
    for (int i = 0; i < args.length; i++) {
      System.out.println("argument " + i + ": " + args[i]);
    }
  }
}
