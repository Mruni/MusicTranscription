import java.awt.Color;
import java.util.Random;
import java.util.Iterator;

/**
 * Class that represents a wolf.   The wolf class
 * tracks all the living wolves with a linked list.
 * 
 * @author Barb Ericson ericson@cc.gatech.edu
 */
public class Wolf extends Turtle {
  
  /////////////// fields //////////////////////
  
  /** class constant for the color */
  public static final Color GRAY = new Color(153,153,153);
  
  /** class constant for probability of NOT turning */
  public static final double PROB_OF_STAY = 1.0/10;
  
  /** class constant for top speed (max num steps can move in a timestep) */
  public static final int MAX_SPEED = 40;
  
  /** class constant for how far wolf can smell */
  public static final double SMELL_RANGE = 50;
  
  /** class constant for how close before wolf can attack */
  public static final double ATTACK_RANGE = 30;
  
  /** My simulation */
  private WolfDeerSimulation mySim;
  
  /** random number generator */
  protected static Random randNumGen = new Random();
  
  ////////////////////////////// Constructors ////////////////////////
  
  /**
   * Constructor that takes the model display (the original
   * position will be randomly assigned)
   * @param modelDisplayer thing that displays the model
   * @param thisSim my simulation
   */
  public Wolf (ModelDisplay modelDisplayer,
               WolfDeerSimulation thisSim) {
    super(randNumGen.nextInt(modelDisplayer.getWidth()),
          randNumGen.nextInt(modelDisplayer.getHeight()),
          modelDisplayer);
    init(thisSim);
  }
  
  /** Constructor that takes the x and y and a model
    * display to draw it on
    * @param x the starting x position
    * @param y the starting y position
    * @param modelDisplayer the thing that displays the model
    * @param thisSim my simulation
    */
  public Wolf (int x, int y, ModelDisplay modelDisplayer, 
               WolfDeerSimulation thisSim) {
    // let the parent constructor handle it
    super(x,y,modelDisplayer);
    init(thisSim);
  }
  
  ////////////////// methods ////////////////////////////////////////
  
  /** 
   * Method to get the simulation
   * @return the simulation
   */
  public WolfDeerSimulation getSimulation() { return this.mySim; }
  
  /**
   * Method to initialize the new wolf object
   * @param thisSim the simulation
   */
  public void init(WolfDeerSimulation thisSim) {
    
    // set the color of this wolf
    setColor(GRAY);
    
    // turn some random direction
    this.turn(randNumGen.nextInt(360));
    
    // set my simulation
    mySim = thisSim;
  }
  
  /**
   * Method to get the closest deer within the passed distance
   * to this wolf. We'll search the input list of the kind
   * of objects to compare to.
   * @param distance the distance to look within
   * @param list the list of agents to look at
   * @return the closest agent in the given distance or null
   */
  public AgentNode getClosest(double distance,
                              AgentNode list) {
    // get the head of the deer linked list
    AgentNode head = list;
    AgentNode curr = head;
    AgentNode closest = null;
    Deer thisDeer;
    double closestDistance = 999;
    double currDistance = 0;
    
    // loop through the linked list looking for the closest deer
    while (curr != null) {
      thisDeer = (Deer) curr.getAgent();
      currDistance = thisDeer.getDistance(this.getXPos(),
                                          this.getYPos());
      if (currDistance < distance) {
        if (closest == null || 
            currDistance < closestDistance) {
          closest = curr;
          closestDistance = currDistance;
        }
      }
      curr = (AgentNode) curr.getNext();
    }
    return closest;
  }
  
  /**
   * Method to act during a time step 
   * pick a random direction and move some random 
   * amount up to top speed
   */
  public void act() {
    
    // get the closest deer within some specified distance
    AgentNode closeDeer = 
      getClosest(30,
                 (AgentNode) mySim.getDeer().getNext());
    
    if (closeDeer != null) {
      Deer thisDeer = (Deer) closeDeer.getAgent();
      this.moveTo(thisDeer.getXPos(),
                  thisDeer.getYPos());
      thisDeer.die();
    }
    
    else {
      // if the random number is > prob of NOT turning then turn
      if (randNumGen.nextFloat() > PROB_OF_STAY) {
        this.turn(randNumGen.nextInt(360));
      }
      
      // go forward some random amount 
      forward(randNumGen.nextInt(MAX_SPEED));
    }
  }
  
}