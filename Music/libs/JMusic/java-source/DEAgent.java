/**
 * DEAgent - an agent in a Discrete Event simulation
 * A DEAgent doesn't act().
 * A DEAgent adds events to the queue, and requests resources.
 */
public class DEAgent extends Agent {
  
  /** true if blocked */
  private boolean blocked;
  
  ////////////////////////////// Constructors ////////////////////////
  // Copy this section AS-IS into subclasses, but rename to 
  // Your class.
  
  /**
   * Constructor that takes the model display (the original
   * position will be randomly assigned) and the simulation
   * @param modelDisplayer thing that displays the model
   * @param thisSim my simulation
   */
  public DEAgent (ModelDisplay modelDisplayer,
                  Simulation thisSim) {
    super(randNumGen.nextInt(modelDisplayer.getWidth()),
          randNumGen.nextInt(modelDisplayer.getHeight()),
          modelDisplayer, thisSim);
  }
  
  /** Constructor that takes the x and y, and a model
    * display to draw it on, and the simulation
    * @param x the starting x position
    * @param y the starting y position
    * @param modelDisplayer the thing that displays the model
    * @param thisSim my simulation
    */
  public DEAgent (int x, int y, 
                  ModelDisplay modelDisplayer, 
                  Simulation thisSim) {
    // let the parent constructor handle it
    super(x,y,modelDisplayer,thisSim);
  }
  
  ////////////////////// methods /////////////////////
  
  /**
   * Method to initialize the discrete event agent
   * @param thisSim the simulation
   */
  public void init(Simulation thisSim) {
    
    // call the parent init method
    super.init(thisSim);
    
    // Start out unblocked
    blocked = false;
  }
  
  /** 
   * Method to check if we are blocked? 
   * @return true if blocked else false 
   */
  public boolean isBlocked() {return blocked;}
  
  /** Method to check if we ready to be unlocked? 
    * return true if ready else false
    */
  public boolean isReady(Resource res) {
    //As a default, we're ready!
    return true;
  }
  
  /** 
   * Method to return the current simulation
   * time if the passed delay is negative or
   * the time + the passed delay
   * @param delay the amount of time for the delay
   * @return either the current time plus the delay if
   * the delay was positive or the current time
   */
  public double validTime(double delay) {
    // Don't allow a negative delay
    if (delay < 0) {
      return ((DESimulation) getSimulation()).getTime();
    }
    else {
      return (delay + ((DESimulation) getSimulation()).getTime());
    }
  } // validTime
  
  /**
   * Block myself for the input resource
   * @param resource the desired resource
   */
  public void waitFor(Resource resource) {
    // I'm now blocked
    blocked = true;
    // Put me on the waiting list
    resource.addToList(this);
  }
  
  /**
   * I've been unblocked!
   * @param resource the desired resource
   */
  public void unblocked(Resource resource) {
    // I'm now blocked
    blocked = false;
    // Assume the subclass will do something useful with this.
  }
  
  /**
   * Process an event.
   * The default is to do nothing with it.
   * @param message the message to process
   */
  public void processEvent(int message) {}
  
}
