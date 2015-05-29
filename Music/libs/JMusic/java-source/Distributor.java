import java.awt.Color; // To color our distributors

/**
 * Distributor -- takes orders from Market to Warehouse,
 * fills them, and returns with product.
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class Distributor extends DEAgent {

  /////////////////// fields ///////////////////////////

  /** message that means things have arrived at the market */
  public static final int MARKET_ARRIVE = 0;
  /** message that means the goods have left the market */
  public static final int MARKET_LEAVE = 1;
  /** message that means items arrived at the warehouse */
  public static final int WAREHOUSE_ARRIVE = 2;

  /** AmountOrdered so-far */
  private int amountOrdered;

  ////////////////////////////// Constructors ////////////////////////
  // Copy this section AS-IS into subclasses, but rename Agent to 
  // Your class.
  
  /**
   * Constructor that takes the model display (the original
   * position will be randomly assigned) and the simulation
   * @param modelDisplayer thing that displays the model
   * @param thisSim my simulation
   */
  public Distributor (ModelDisplay modelDisplayer,Simulation thisSim)
  {
    super(randNumGen.nextInt(modelDisplayer.getWidth()),
          randNumGen.nextInt(modelDisplayer.getHeight()),
          modelDisplayer, thisSim);
  }
  
  /** Constructor that takes the x and y, a model
    * display to draw it on, and the simulation
    * @param x the starting x position
    * @param y the starting y position
    * @param modelDisplayer the thing that displays the model
    * @param thisSim my simulation
    */
  public Distributor (int x, int y, ModelDisplay modelDisplayer, 
                      Simulation thisSim) 
  {
    // let the parent constructor handle it
    super(x,y,modelDisplayer,thisSim);
  }


  /////////////////////// Methods //////////////////////////

  /**
   * return the number of new orders
   * @return the number of new orders
   */
  public int newOrders() {
    // Between 5 and 25, uniform
    return randNumGen.nextInt(21)+5;
  }

  /**
   * return the time to deliver
   * @return the time to deliver
   */
  public double timeToDeliver() {
    // On average 5 days to deliver, normal distr.
    return validTime(randNumGen.nextGaussian()+5);
  }

  /**
   * return the trip time
   * @return the trip time
   */
  public double tripTime(){
    // On average 2 days to travel between market and warehouse
    return validTime(randNumGen.nextGaussian()+2);
  }

  /**
   * Initialize a distributor.
   * Start in the market, taking orders, then
   * schedule arrival at the warehouse.
   * @param thisSim the simulation
   */
  public void init(Simulation thisSim) {

    //First, do the normal stuff
    super.init(thisSim);
    this.setPenDown(false); // Pen up
    this.setBodyColor(Color.BLUE); // Go Blue!

    // Show the distributor in the market
    this.moveTo(600,460); // At far right
    // Get the orders, and set off for the warehouse
    amountOrdered = this.newOrders();
    ((DESimulation) thisSim).addEvent(
      new SimEvent(this,tripTime(),WAREHOUSE_ARRIVE));
  }

  /**
   * Method to check if we are we ready to be unlocked?
   * @param res the resource
   * @return true if ready else false
   */
  public boolean isReady(Resource res) {
    // Is the amount in the resource more than our orders?
    return (res.amountAvailable() >=
      amountOrdered);
  }

  /**
   * I've been unblocked!
   * @param resource the desired resource
   */
  public void unblocked(Resource resource) {
    super.unblocked(resource);

    // Consume the resource for the orders
    ((DESimulation) getSimulation()).log(this.getName() + 
      ", unblocked!");
    resource.consume(amountOrdered); // Zero time to load?
    ((DESimulation) getSimulation()).log(this.getName() + 
      ", Gathered product for orders of "+amountOrdered);
    // Schedule myself to arrive at the Market
    ((DESimulation) getSimulation()).addEvent(
      new SimEvent(this,tripTime(),MARKET_ARRIVE));
  }

  /**
   * Process an event.
   * Default is to do nothing with it.
   * @param message the message to process
   */
  public void processEvent(int message) {
    Simulation simulation = getSimulation();
    switch(message) {
      case MARKET_ARRIVE:
        // Show the distributor at the market, far left
        ((DESimulation) simulation).log(this.getName() +
                                        ", Arrived at market");
        this.moveTo(210,460);
        // Schedule time to deliver
        ((DESimulation) simulation).addEvent(
          new SimEvent(this,timeToDeliver(),MARKET_LEAVE));
        break;
      case MARKET_LEAVE:
        // Show the distributor at the market, far right
        ((DESimulation) simulation).log(this.getName() +
                                        ", Leaving market");
        this.moveTo(600,460);
        // Get the orders, and set off for the warehouse
        amountOrdered = this.newOrders();
        ((DESimulation) simulation).addEvent(
          new SimEvent(this,tripTime(),WAREHOUSE_ARRIVE));
        break;
      case WAREHOUSE_ARRIVE:
        
        // Show the distributor at the warehouse
        ((DESimulation) simulation).log(this.getName() +
                                        ", Arrived at warehouse " +
                                        "needs " + amountOrdered);
        this.moveTo(600,50);
        // Is there enough product available?
        Resource warehouseProduct = 
          ((FactorySimulation) simulation).getProduct();
        if (warehouseProduct.amountAvailable() >= amountOrdered) {
          // Consume the resource for the orders
          warehouseProduct.consume(amountOrdered); // Zero load time?
          ((DESimulation) simulation).log(this.getName() +
            ", Gathered product for orders of "+amountOrdered);
          // Schedule myself to arrive at the Market
          ((DESimulation) simulation).addEvent(
            new SimEvent(this,tripTime(),MARKET_ARRIVE));
        }
        else { // We have to wait until more product arrives!
          ((DESimulation) simulation).log(this.getName() + 
                                          ", is blocking");
          waitFor(((FactorySimulation) simulation).getProduct());}
        break;
    }
  }

}