import java.util.*; // For Random number generator and Linked List
import java.awt.Color; // For colorizing

/**
 * Class that represents a general Agent.  
 * We are designing to offer more flexibility than
 * one might expect to use.
 * 
 * @author Mark Guzdial guzdial@cc.gatech.edu
 * @author Barb Ericson ericson@cc.gatech.edu
 */
public class Agent extends Turtle {
  
  /////////////// fields //////////////////////
  
  /** the picture of the agent */
  private Picture myPict;
  
  /** class constant for probability of NOT turning */
  public static final double PROB_OF_STAY = 1.0/10;
  
  /** class constant for top speed (max num steps can move in a timestep) */
  public static final int MAX_SPEED = 40;
  
  /** random number generator - protected allows direct 
    * access by children */
  protected static Random randNumGen = new Random();
  
  /** the current speed */
  private int speed;
  
  /** the simulation */
  private Simulation simulation;
  
  ////////////////////////////// Constructors ////////////////////////
  
  /**
   * Constructor that takes the model display (the original
   * position will be randomly assigned) and the simulation
   * @param modelDisplayer thing that displays the model
   * @param thisSim my simulation
   */
  public Agent (ModelDisplay modelDisplayer,
                Simulation thisSim) {
    super(randNumGen.nextInt(modelDisplayer.getWidth()),
          randNumGen.nextInt(modelDisplayer.getHeight()),
          modelDisplayer);
    init(thisSim);
  }
  
  /** Constructor that takes the x and y, a model
    * display to draw it on, and the simulation
    * @param x the starting x position
    * @param y the starting y position
    * @param modelDisplayer the thing that displays the model
    * @param thisSim my simulation
    */
  public Agent (int x, int y, 
                ModelDisplay modelDisplayer, 
                Simulation thisSim) {
    // let the parent constructor handle it
    super(x,y,modelDisplayer);
    init(thisSim);
  }
  
  ////////////////// methods ////////////////////////////////////////
  
  /**
   * Method to get the picture
   * @return the picture for this agent
   */
  public Picture getPicture() { return myPict; }
  
  /**
   * Method to set the picture
   * @param pict the picture to use
   */
  public void setPicture(Picture pict) {
    myPict = pict;
  }
  
  /** 
   * Method to set the speed
   * @param velocity the new speed to use
   */
  public void setSpeed(int velocity) {speed = velocity;}
  
  /**
   * Method to get the speed
   * @return the current speed 
   */
  public int getSpeed() { return speed; }
  
  /**
   * Method to get the simulation
   * @return the simulation
   */
  public Simulation getSimulation() {return simulation;}
  
  /**
   * Method to initialize the new agent object
   * @param thisSim the simulation
   */
  public void init(Simulation thisSim)
  {
    // turn some random direction
    this.turn(randNumGen.nextInt(360));
    
    // set my simulation
    simulation = thisSim;
    
    // Set up the speed (by default)
    speed = MAX_SPEED;
    
    // Add to list of all agents
    thisSim.add(this);
  }
  
  /**
   * Method that handles when an Agent dies
   */
  public void die() 
  { 
    // Leave a mark on the world where I died...
    this.setBodyColor(Color.red); 
    
    // Remove me from the agents list
    simulation.remove(this);
    
    // ask the model display to remove this
    // Think of this as "ask the viewable world to remove this turtle"
    //getModelDisplay().remove(this);
  }
  
  /**
   * Method to get the closest agent within the passed distance
   * to this agent but NOT this agent. 
   * We'll search the input list of the kind
   * of objects to compare to.
   * @param distance the distance to look within
   * @param list the list of agents to look at
   * @return the closest agent in the given distance or null
   */
  public Agent getClosest(double distance,
                          LinkedList list) {
    
    // Keep track of closest so-far
    Agent closest = null;
    double closestDistance = 999;
    double currDistance = 0;
    Agent current = null;
    
    // loop through the linked list looking for the closest Agent
    for (int i = 0; i<list.size(); i++) {
      current = (Agent) list.get(i);
      if (current != this) {
        currDistance = current.getDistance(this.getXPos(),this.getYPos());
        if (currDistance < distance) {
          if (closest == null || 
              currDistance < closestDistance) {
            closest = current;
            closestDistance = currDistance;
          }
        }
      }// current != this
    }// for loop
    return closest;
  }
  
  /** 
   * Method to count the number of agents within the 
   * range that are on the given list
   * @param range the number of steps within which to consider agents
   * @param list of agents to consider
   * @return the number of agents within range.
   */
  public int countInRange(double range, 
                          LinkedList list) {
    // Keep track of count in range
    int count = 0;
    double currDistance;
    Agent current = null;
    
    // loop through the linked list looking for the closest Agent
    for (int i = 0; i<list.size(); i++) {
      current = (Agent) list.get(i);
      currDistance = current.getDistance(this.getXPos(),this.getYPos());
      if (currDistance < range) {
        count++;
      }
    } // for loop
    
    return count;
  }
  
  /**
   * act() with a timestep
   * @param t the timestep
   */
  public void act(int t) {
    // By default, don't act on it
    this.act();
  }
  
  /**
   * Method to act during a time step.  The 
   * default is to pick a random direction and 
   * move some random amount up to the top speed.
   */
  public void act() {
    
    /* if the random number is > prob of NOT 
     * turning then turn */
    if (randNumGen.nextFloat() > PROB_OF_STAY) {
      this.turn(randNumGen.nextInt(360));
    }
    
    // go forward some random amount 
    forward(randNumGen.nextInt(speed));
  } // end act()
  
}