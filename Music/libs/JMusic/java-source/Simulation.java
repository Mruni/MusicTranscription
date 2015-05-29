import java.io.*;  // For BufferedWriter
import java.util.*; // For LinkedList and Queue implementation

/**
 * Class that implements a general Simulation
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class Simulation {
  
  ////////// Fields /////////////////
  
  /** Linked lists for tracking all agents in the simulation */
  private LinkedList<Agent> agents = 
    new LinkedList<Agent>();
  
  /** World that the simulation runs in */
  private World world;
  
  /** Background picture for the world */
  private Picture background;
  
  /** A BufferedWriter for writing to */
  private BufferedWriter output;
  
  /** FrameSequencer in case the user wants an animation */
  private FrameSequencer frames;
  
  
  ///// Constructors //////////////
  
  /**
   * Constructor to set output to null
   */
  public Simulation() {
    // By default, don't write to a file.
    output = null;
    // By default, don't have an animation
    frames = null;
  }
  
  /**
   * Constructor to set output to null
   */
  public Simulation(Picture bg) {
    // By default, don't write to a file.
    output = null;
    // By default, don't have an animation
    frames = null;
    background = bg;
  }
  
  //////// Methods ///////////////
  
  /**
   * Method to get the world
   */
  public World getWorld() { return world; }
  
  /**
   * Method to get the BufferedOutput to write to
   */
  public BufferedWriter getOutput() { return output; }
  
  /** 
   * Get a linked list of all agents
   * @return a linked list of all agent
   */
  public LinkedList getAgents() {return agents;}
  
  /** 
   * Add this actor to the agents list
   * @param newOne agent to add to the list
   */
  public void add(Agent newOne) {
    agents.add(newOne);
  }
  
  /** 
   * Remove this actor from the agents list
   * @param newOne the agent to remove from the list
   */
  public void remove(Agent newOne) {
    agents.remove(newOne);
  }
  
  /**
   * setUp the simulation.
   * Subclasses should call this (via super)
   * and create agents.
   */
  public void setUp() {
    // Set up the World
    world = new World();
    if (background != null)
      world.setPicture(background);
    world.setAutoRepaint(false);
  }
  
  /**
   * Open the input file and set the BufferedWriter to speak to it.
   * @param filename the filename to open
   */
  public void openFile(String filename) {
    
    // Try to open the file
    try {
      
      // create a writer 
      output = new BufferedWriter(new FileWriter(filename));
      
    } catch (Exception ex) {
      System.out.println("Trouble opening the file " + filename);
      // If any problem, make it null again
      output = null;
    }
  }
  
  /** 
   * Open a frame sequencer using the given directory
   * @param dir name of the directory
   */
  public void openFrames(String dir) {
    frames = new FrameSequencer(dir);
  }
  
  /**
   * Ask all agents to run for the number of input 
   * steps
   * @param numSteps the number of timesteps to run
   */
  public void run(int numSteps) {

    // For storing the current agent
    Agent current = null;
    
    // Set up the simulation
    this.setUp();
    
    // loop for a set number of timesteps 
    for (int t = 0; t < numSteps; t++) {
      
      // loop through all the agents, and have them
      // act()
      for (int index=0; index < agents.size(); index++) {
        current = (Agent) agents.get(index);
        //current.act(); - original statement
        current.act(t); // pass in timestep
      }
      // Could separate acting from updating...
      
      // repaint the world to show the movement
      // IF there is a world
      if (world != null) {
        world.repaint();
      }
      
      // Do the end of step processing
      this.endStep(t);
      
      // Wait for one second
      //Thread.sleep(1000);
    }
    
  }
  
  /**
   * Run for a default of 50 timesteps
   */
  public void run() {
    this.run(50);
    this.closeFile();
  }
  
  /**
   * End of step processing
   * @param t the current timestep number
   */
  public void endStep(int t) {
    
    // Let's figure out where we stand...
    System.out.println(">>> Timestep: " + t);
    
    // If we have an open FrameSequencer, write world to it.
    if (frames != null) {
      Picture copyPict = null;
      if (background != null) {
        copyPict = new Picture(background);
      }
      else {
        copyPict = new Picture(world.getWidth(),
                                       world.getHeight());
      }
      world.setPicture(copyPict);
      frames.addFrame(copyPict);
    }
    
    // If we have an open file, write the counts to it
    if (output != null) {
      // Try it
      try {
        output.write(this.toString());
        output.newLine();
      } catch (Exception ex) {
        System.out.println("Couldn't write the data!");
        System.out.println(ex.getMessage());
        // Make output null so that we don't keep trying
        output = null;
      }
    }
  }  // endStep()
  
  /**
   * Return a string with information on the number 
   * of agents.
   * Will probably be overridden in subclsses.
   * @return the information string
   */
  public String toString() {
    // Get the size (an int), make it an Integer, 
    // in order to turn it into a string. (Whew!)
    return (new Integer(agents.size())).toString();
  }
  
  /**
   * close the file and clear the output stream
   */
  public void closeFile() {
    // If we have an open file, close it and null the variable
    if (output != null) {
      try {
        output.close();
      }
      catch (Exception ex) {
        System.out.println("Something went wrong closing the file");
      }
      finally {
        // No matter what, mark the file as not-there
        output = null;
      }
    }
  } // closeFile()
  
}
