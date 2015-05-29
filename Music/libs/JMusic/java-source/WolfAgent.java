import java.awt.Color;
import java.util.LinkedList;

/**
 * WolfAgent -- Wolf as a subclass of Agent
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class WolfAgent extends Agent {
  
  /** class constant for how far a wolf can smell */
  public static final double SMELL_RANGE = 50;
  
  /** class constant for the attack range */
  public static final double ATTACK_RANGE = 30;
  
  /** Collection of all Wolf Agents */
  private static LinkedList<WolfAgent> allWolves = 
    new LinkedList<WolfAgent>();
  
  /** My x position */
  private int myX;
  
  /** My y position */
  private int myY;
  
  ////////////////////////////// Constructors ////////////////////////
  // Copy this section AS-IS into subclasses, but rename 
  
  /**
   * Constructor that takes the model display (the original
   * position will be randomly assigned) and the simulation
   * @param modelDisplayer thing that displays the model
   * @param thisSim my simulation
   */
  public WolfAgent (ModelDisplay modelDisplayer,
                    Simulation thisSim) {
    super(randNumGen.nextInt(modelDisplayer.getWidth()),
          randNumGen.nextInt(modelDisplayer.getHeight()),
          modelDisplayer,thisSim);
  }
  
  /** 
   * Constructor that takes the x and y, a model
   * display to draw it on, and the simulation
   * @param x the starting x position
   * @param y the starting y position
   * @param modelDisplayer the thing that displays the model
   * @param thisSim my simulation
   */
  public WolfAgent (int x, int y, ModelDisplay modelDisplayer, 
                    Simulation thisSim) { 
    // let the parent constructor handle it
    super(x,y,modelDisplayer,thisSim);
  }
  
  /**
   * Get the linked list of Wolf Agent
   * @return the linked list of wolves
   */
  public static LinkedList<WolfAgent> getWolves() 
  { return allWolves; }
  
  /**
   * Initialize, by adding to Wolf list
   * @param thisSim the simulation
   */
  public void init(Simulation thisSim) {
    
    // Do the normal initializations
    super.init(thisSim);
    
    // Make it Gray
    setColor(Color.GRAY);
    
    // Add to list of Wolves
    allWolves.add(this);
    
    /* set the x and y position */
    myX = this.getXPos();
    myY = this.getYPos();
  }
  
  /**
   * Chase and eat the deer
   */
  public void act() {
    
    // get the closest deer within the attack distance
    DeerAgent closeDeer = (DeerAgent) getClosest(ATTACK_RANGE,
                                                 DeerAgent.getDeer());
    
    if (closeDeer != null) {
      this.moveTo(closeDeer.getXPos(),
                  closeDeer.getYPos());
      closeDeer.die();
    }
    
    // otherwise 
    else {
      
      // get the closest deer within smelling range
      closeDeer = (DeerAgent) getClosest(SMELL_RANGE,
                                         DeerAgent.allDeer);
      
      // if there is a close deer 
      if (closeDeer != null) {
        // Turn toward the deer
        this.turnToFace(closeDeer);
        // How much to move?  How about minimum of maxSpeed 
        // or distance to deer?
        this.forward((int) Math.min(getSpeed(),
                                    closeDeer.getDistance(this.getXPos(),
                                                          this.getYPos())));
      }
      
      else { // Otherwise, wander aimlessly  
        super.act();
      } // end else
    } // end else
  } // end act()
  
}
