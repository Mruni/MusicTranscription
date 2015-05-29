import java.util.*;
import java.io.*;

/**
 * Class to generate a histogram
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class HistogramGenerator {
  
  /** the map to hold the values */
  private Map<Double,Integer> valueMap = 
    new TreeMap<Double,Integer>();
  
  /**
   * Method to read a set of values from the inputFile and create
   * bins based on the array of keys.  This will count the number
   * of values in each bin.  Any value larger than the last key
   * will be put in the last bin.
   * @param inputFile the file to read from
   * @param an array of key values to use
   */
  public void countValuesForKeys(String inputFile, double[] keys) {
    
    BufferedReader reader = null;
    String line = null;
    double doubleValue = 0.0;
    boolean found = false;
    int lastIndex = keys.length - 1;
    
    // put the keys in the map using a count of 0 
    for (int i = 0; i < keys.length; i++) {
      valueMap.put(keys[i],0);
    }
    
    try {
      // open the file
      reader = new BufferedReader(new FileReader(inputFile));
      
      // loop reading from the file
      while ((line = reader.readLine()) != null) {
        doubleValue = Double.parseDouble(line);
        found = false;
        for (double key : keys) {
          if (doubleValue < key) {
            valueMap.put(key,valueMap.get(key) + 1);
            found = true;
            break; 
          }
        }
        if (!found) valueMap.put(keys[lastIndex],
                                 valueMap.get(keys[lastIndex]) + 1);
      }
      
      // close the file
      reader.close();
      
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
      ex.printStackTrace();
    }
  }
  
  /**
   * Method to read a set of values from the inputFile create even
   * bins based on the passed factor.  This will count the number
   * of values in each bin.
   * @param inputFile the file to read from
   * @param factor the factor to use to break the values into bins
   */
  public void countValues(String inputFile, int factor) {
    
    BufferedReader reader = null;
    String line = null;
    double doubleValue = 0.0;
    double key = 0.0;
    int currCount = 0;
    
    try {
      // open the file
      reader = new BufferedReader(new FileReader(inputFile));
      
      // loop reading from the file
      while ((line = reader.readLine()) != null) {
        doubleValue = Double.parseDouble(line);
        doubleValue = doubleValue * factor;
        key = Math.ceil(doubleValue) / (double) factor;
        if (valueMap.containsKey(key)) {
          currCount = valueMap.get(key);
          currCount++;
          valueMap.put(key,currCount);
        } 
        else {
          valueMap.put(key,1);
        }
      }
      
      // close the file
      reader.close();
      
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
      ex.printStackTrace();
    }
  }
  
  /**
   * Method to output the keys and values in the histogram
   * to a file 
   * @param fileName the name of the file to write to
   */
  public void writeFile(String fileName) {
    
    BufferedWriter writer = null;
    double key = 0;
    int value = 0;
    Set<Double> keySet = null;
    
    try {
      
      // create the writer
      writer = new BufferedWriter(new FileWriter(fileName));
      
      // get the keys and loop through them
      keySet = valueMap.keySet();
      Iterator<Double> iterator = keySet.iterator();
      while (iterator.hasNext()) {
        key = iterator.next();
        value = valueMap.get(key);
        writer.write(key + "\t" + value);
        writer.newLine();
      }
      
      // close the writer
      writer.close();
      
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
      ex.printStackTrace();
    }
  }
  
  /** 
   * Generate the histogram from the uniform data
   */
  public static void genUniform() {
    HistogramGenerator histGen = new HistogramGenerator();
    double[] keyArray = {0.1,0.2,0.3,0.4,0.5,0.6,0.7,0.8,0.9,1.0};
    histGen.countValuesForKeys("C:/dsBook/uniform.txt",keyArray);
    histGen.writeFile("C:/dsBook/uniformHist.txt");
  }
  
  /** 
   * Method to generate the normal histogram
   */
  public static void genNormal() {
    HistogramGenerator histGen = new HistogramGenerator();
    double[] keyArray = {-1.0, -0.9, -0.8, -0.7, -0.6, -0.5, -0.4, -0.3,
      -0.2, -0.1,0.0,0.1,0.2,0.3,0.4,0.5,0.6,0.7,0.8,0.9,1.0};
    histGen.countValuesForKeys("C:/dsBook/normal.txt",keyArray);
    histGen.writeFile("C:/dsBook/normalHist.txt");
  }
  
  /** 
   * Method to generate the normal histogram
   */
  public static void genNewNormal() {
    HistogramGenerator histGen = new HistogramGenerator();
    double[] keyArray = {20,21,22,23,24,25,26,27,28,29,30};
    histGen.countValuesForKeys("C:/dsBook/normal-new.txt",keyArray);
    histGen.writeFile("C:/dsBook/normal-new-Hist.txt");
  }
  
  /** Main method for testing */
  public static void main(String[] args) {
    // try uniform, normal or new normal here
    // don't try all 3 at the same time!
    genNormal();
  }
}
  