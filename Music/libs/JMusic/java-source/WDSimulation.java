/**
 * A wolf and deer simulation that extends the Simulation class
 * @author Mark Guzdial
 * @author Barb Ericon
 */
public class WDSimulation extends Simulation {
  
  /** 
   * Fill the world with wolves and deer
   */
  public void setUp() {
    
    // Let the simulation be set up
    super.setUp();
    
    // Just for storing the new deer and wolves
    DeerAgent deer;
    WolfAgent wolf;
    World world = getWorld();
    
    // create some deer
    int numDeer = 20;
    for (int i = 0; i < numDeer; i++) {
      deer = new DeerAgent(world,this);
    }
    
    // create some wolves
    int numWolves = 5;
    for (int i = 0; i < numWolves; i++) {
      wolf = new WolfAgent(world,this);
    }
  }
  
  /**
   * return a string with the number of deer and the
   * number of wolves
   */
  public String toString() {
    // return the number of deer followed by a tab and
    // then the number of wolves
    return (DeerAgent.allDeer.size() + "/t" +
      WolfAgent.getWolves().size());
  }
  
  /** Main for testing */
  public static void main(String[] args) {
    WDSimulation wd = new WDSimulation();
    wd.openFrames("C:/temp/");
    wd.openFile("C:/dsBook/wds-data1.txt"); // If you want an output file.
    wd.run();  // By default, run for 50 steps
  }
  
}
