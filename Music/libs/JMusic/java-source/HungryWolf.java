/**
 * A class that extends the Wolf to have a hunger level.
 * Wolves only eat when they're hungry
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class HungryWolf extends Wolf {
  
  /** Number of cycles before I'll eat again */
  private int satisfied;
  
  /** class constant for number of turns before hungry */
  public static final int MAX_SATISFIED = 3;
  
  ////////////////////////////// Constructors ////////////////////////
  
  /**
   * Constructor that takes the model display (the 
   * original position will be randomly assigned) and
   * the simulation
   * @param modelDisplayer thing that displays the model
   * @param thisSim my simulation
   */
  public HungryWolf (ModelDisplay modelDisplayer,
                     WolfDeerSimulation thisSim) {
    super(modelDisplayer,thisSim);
  }
  
  /** Constructor that takes the x and y position,
    * a model display to draw it on, and a simulation
    * @param x the starting x position
    * @param y the starting y position
    * @param modelDisplayer the thing that displays the 
    * model
    * @param thisSim my simulation
    */
  public HungryWolf (int x, int y, 
                     ModelDisplay modelDisplayer, 
                     WolfDeerSimulation thisSim) {
    // let the parent constructor handle it
    super(x,y,modelDisplayer,thisSim);
  }
  
  /**
   * Method to initialize the hungry wolf object
   * @para thisSim the simulation
   */
  public void init(WolfDeerSimulation thisSim) {
    super.init(thisSim);
    satisfied = MAX_SATISFIED;
  }
  
  /**
   * Method to act during a time step 
   * pick a random direction and move some random amount up to top speed
   */
  public void act() {
    
    // Decrease satisfied time, until hungry again
    satisfied--;
    
    // get the closest deer within some specified distance
    WolfDeerSimulation sim = getSimulation();
    AgentNode closeDeer = getClosest(30,
                    (AgentNode) sim.getDeer().getNext());
    
    // check if there was a close deer
    if (closeDeer != null) {
      // Even if deer close, only eat it if you're hungry.
      if (satisfied <= 0) {
        Deer thisDeer = (Deer) closeDeer.getAgent();
        this.moveTo(thisDeer.getXPos(),
                    thisDeer.getYPos());
        thisDeer.die();
        satisfied = MAX_SATISFIED;
      }
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
