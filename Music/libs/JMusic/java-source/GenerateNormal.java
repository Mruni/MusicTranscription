import java.util.*;  // Need this for Random
import java.io.*;  // For BufferedWriter

/**
 * Class to generate a normal distribution of numbers
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class GenerateNormal {
  
  public static void main(String[] args) {
    Random rng = new Random(); // Random Number Generator
    BufferedWriter output=null; // file for writing
    
    // Try to open the file
    try {
      // create a writer 
      output = 
        new BufferedWriter(new FileWriter("C:/dsBook/normal.txt"));
    } catch (Exception ex) {
      System.out.println("Trouble opening the file.");
    }
    
    // Fill it with 5000 numbers 
    // normally distributed
    for (int i=0; i < 5000; i++) {
      try {
        output.write("\t" + rng.nextGaussian());
        output.newLine();
      } catch (Exception ex) {
        System.out.println("Couldn't write the data!");
        System.out.println(ex.getMessage());
      }
    }
    
    // Close the file
    try {
      output.close();
    } catch (Exception ex) {
      System.out.println("Something went wrong closing the file");
    }
  }
}