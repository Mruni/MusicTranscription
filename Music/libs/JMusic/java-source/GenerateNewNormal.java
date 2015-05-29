import java.util.*;  // Need this for Random
import java.io.*;  // For BufferedWriter

/**
 * Class to generate a normal distribution of numbers
 * with a mean and range specified
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class GenerateNewNormal {
  
  public static void main(String[] args) {
    Random rng = new Random(); // Random Number Generator
    BufferedWriter output=null; // file for writing
    
    double mean = 25.0;
    double range = 5.0;
    
    // Try to open the file
    try {
      // create a writer 
      output = 
        new BufferedWriter(new FileWriter("C:/dsBook/normal-new.txt"));
    } catch (Exception ex) {
      System.out.println("Trouble opening the file.");
    }
    
    // Fill it with 5000 numbers with a mean of 5.0 and a 
    //larger spread, normally distributed
    for (int i=0; i < 5000; i++) {
      try {
        output.write("\t"+((range * rng.nextGaussian()) + mean));
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
               
          
           