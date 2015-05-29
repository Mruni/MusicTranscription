import java.awt.Color; // For color

/**
 * Truck -- delivers product from the Factory
 * to the Warehouse.
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class Truck extends DEAgent {
  
  ////////////////// fields /////////////////////////
  
  /** an arrive at factory event */
  public static final int FACTORY_ARRIVE = 0;
  
  /** an arrive at warehouse event */
  public static final int WAREHOUSE_ARRIVE = 1;
  
  /** The amount of product being carried */
  private int load;
  
  ////////////////////////////// Constructors ////////////////////////
  // Copy this section AS-IS into subclasses, but rename 
  
  /**
   * Constructor that takes the model display (the original
   * position will be randomly assigned) and a simulation
   * @param modelDisplayer thing that displays the model
   * @param thisSim my simulation
   */
  public Truck (ModelDisplay modelDisplayer,
                Simulation thisSim) {
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
  public Truck (int x, int y, ModelDisplay modelDisplayer, 
                Simulation thisSim) { 
    // let the parent constructor handle it
    super(x,y,modelDisplayer,thisSim);
  }
  
  ///////////////////// methods /////////////////////////
  
  /** 
   * A method to create a new load.  The returned amount will be 
   * between 10 and 20 on a uniform distribution 
   */
  public int newLoad() {
    return 10 + randNumGen.nextInt(11);
  }
  
  /**
   * Calculate and return the total trip time
   * @return the total time of the trip in days
   */
  public double tripTime() {
    double delay = randNumGen.nextGaussian() + 3;
    DESimulation sim = (DESimulation) getSimulation();
    if (delay < 1) 
      // Must take at least one day
    {return 1.0 + sim.getTime();}
    else {return delay + sim.getTime();}
  }
  
  /**
   * Method to arrive at the factory, load up,
   * and schedule the event to arrive at the warehouse
   */
  private void arriveAtFactory() {
    
    // move to the factory
    this.moveTo(30,350);
    
    // Load up at the factory, and set off for the warehouse
    load = this.newLoad();
    ((DESimulation) getSimulation()).addEvent(
      new SimEvent(this,tripTime(),WAREHOUSE_ARRIVE));
    
  }
  
  /**
   * Method to arrive at the warehouse, unload,
   * and create the event to arrive at the warehouse
   */
  private void arriveAtWarehouse() {
    // change location to warehouse
    this.moveTo(50,50);
    
    FactorySimulation sim = (FactorySimulation) getSimulation();
    
    // Unload product -- takes zero time (unrealistic!)
    sim.getProduct().add(load);
    load = 0;
    
    // Head back to factory
    sim.addEvent(
      new SimEvent(this,tripTime(),FACTORY_ARRIVE));
  }
  
  /**
   * Set up the truck
   * Start out at the factory
   * @param thisSim the simulation
   */
  public void init(Simulation thisSim) {
    
    // Do the default init
    super.init(thisSim);
    this.setPenDown(false); // Pen up
    this.setBodyColor(Color.GREEN); // Let green deliver!
    
    // show up at factory, load up, and leave for the warehouse
    arriveAtFactory();
    
  }
  
  /**
   * Process an event.
   * @param message the type of event
   */
  public void processEvent(int message) {
    DESimulation sim = (DESimulation) getSimulation();
    switch(message) {
      case FACTORY_ARRIVE:
        // Show the truck at the factory
        sim.log(this.getName() + 
                                        ", Arrived at factory");
        // show up at factory, load up, and leave for the warehouse
        arriveAtFactory();
        break;
        
      case WAREHOUSE_ARRIVE:
        // Show the truck at the warehouse
        sim.log(this.getName() + 
          ", Arrived at warehouse with load "+load);
        arriveAtWarehouse();
        break;
    }
  }
  
}
