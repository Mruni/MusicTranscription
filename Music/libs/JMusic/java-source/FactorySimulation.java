/** 
 * FactorySimulation -- set up the whole simulation,
 * including creation of the Trucks and Distributors.
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class FactorySimulation extends DESimulation {
  
  /** the product the factory produces */
  private Resource product;
  
  /** 
   * A constuctor for the factory simulation
   */
  public FactorySimulation () {
    // Let the world be setup with a background picture
    super(new Picture(
        FileChooser.getMediaPath("EconomyBackground.jpg")));
  }
  
  /**
   * Get the product
   * @return the product
   */
  public Resource getProduct() {
    return product;
  }
  
  /**
   * Set up the simulation
   */
  public void setUp() {
    
    // Let the world be setup
    super.setUp();
    
    // get the world
    World world = getWorld();
    
    // Create a warehouse resource
    product = new Resource(); //Track product
    
    // Create three trucks
    Truck myTruck = null;
    for (int i=0; i<3; i++) {
      myTruck = new Truck(world,this);
      myTruck.setName("Truck: "+i);
    }
    
    // Create five Distributors
    Distributor sales = null;
    for (int i=0; i<5; i++) {
      sales = new Distributor(world,this);
      sales.setName("Distributor: "+i);
    }
  }
  
  /* main for testing */
  public static void main(String[] args) {
    FactorySimulation fs = new FactorySimulation();
    fs.openFrames("c:/temp/test1/");
    fs.run(25.0);
  }
}
