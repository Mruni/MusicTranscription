import java.awt.Color; // Color for colorizing
import java.util.LinkedList;

/**
 * DeerAgent -- Deer as a subclass of Agent
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class DeerAgent extends Agent {
  
  /** class constant for the color */
  public static final Color BROWN = new Color(116,64,35);
  
  /** class constant for how far deer can smell */
  public static final double SMELL_RANGE = 50;
  
  /** Collection of all Deer */
  public static LinkedList<DeerAgent> allDeer = 
    new LinkedList<DeerAgent>();
  
  ////////////////////////////// Constructors ////////////////////////
  // Copy this section AS-IS into subclasses, but rename 
  
  /**
   * Constructor that takes the model display (the original
   * position will be randomly assigned) and the simulation
   * @param modelDisplayer thing that displays the model
   * @param thisSim my simulation
   */
  public DeerAgent (ModelDisplay modelDisplayer,Simulation thisSim)
  {
    super(randNumGen.nextInt(modelDisplayer.getWidth()),
          randNumGen.nextInt(modelDisplayer.getHeight()),
          modelDisplayer, thisSim);
  }
  
  /** Constructor that takes the x and y, a model
    * display to draw it on, and a simulation
    * @param x the starting x position
    * @param y the starting y position
    * @param modelDisplayer the thing that displays the model
    * @param thisSim my simulation
    */
  public DeerAgent (int x, int y, ModelDisplay modelDisplayer, 
                    Simulation thisSim) {
    // let the parent constructor handle it
    super(x,y,modelDisplayer,thisSim);
  }
  
  /**
   * Method to get the linked list of deer
   * @return the linked list of deer
   */
  public static LinkedList<DeerAgent> getDeer() { 
    return allDeer; 
  }
  
  /**
   * Initialize, by adding to Deer list
   * @param thisSim the simulation
   */
  public void init(Simulation thisSim) {
    
    // Do the normal initializations
    super.init(thisSim);
    
    // Make it brown
    setColor(BROWN);
    
    // Add to list of Deer
    allDeer.add(this);
  }
  
  /**
   * To die, do normal stuff, but
   * also remove from deer list
   */
  public void die() {
    super.die();
    allDeer.remove(this);
    System.out.println("Deer left: " + allDeer.size());
  }
  
  /**
   * How a DeerAgent acts
   */
  public void act()
  {
    // get the closest wolf within the smell range
    WolfAgent closeWolf = (WolfAgent) getClosest(SMELL_RANGE,
                                                 WolfAgent.getWolves());
    
    if (closeWolf != null) {
      // Turn to face the wolf
      this.turnToFace(closeWolf);
      // Now turn in the opposite direction
      this.turn(180);
      // How far to run? How about half of current speed??
      this.forward((int) (getSpeed()/2));
    }
    else {
      // Run the normal act() -- wander aimlessly
      super.act();
    }
  }
  
}
