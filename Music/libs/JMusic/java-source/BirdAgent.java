/**
 * BirdAgents use the bird character JPEGs
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class BirdAgent extends Agent {
  
  /** the pictures to use */
  private static Picture bird1, bird2, bird3, bird4, bird5, bird6;
  
  ////////////////////////////// Constructors ////////////////////////
  
  /**
   * Constructor that takes the model display (the original
   * position will be randomly assigned) and the simulation
   * @param modelDisplayer thing that displays the model
   * @param thisSim my simulation
   */
  public BirdAgent (ModelDisplay modelDisplayer,Simulation thisSim) {
    super(randNumGen.nextInt(modelDisplayer.getWidth()),
          randNumGen.nextInt(modelDisplayer.getHeight()),
          modelDisplayer, thisSim);
  }
  
  /** Constructor that takes the x and y, model
    * display to draw it on, and the simulation
    * @param x the starting x position
    * @param y the starting y position
    * @param modelDisplayer the thing that displays the model
    * @param thisSim my simulation
    */
  public BirdAgent (int x, int y, ModelDisplay modelDisplayer, 
                    Simulation thisSim) {
    // let the parent constructor handle it
    super(x,y,modelDisplayer,thisSim);
  }
  
  /**
   * Set up the birds
   * @param thisSim the simulation to use
   */
  public void init(Simulation thisSim) {
    
    if (bird1 == null) {
      // Do we have the bird characters defined yet?
      bird1 = new Picture(FileChooser.getMediaPath("bird1.jpg"));
      bird2 = new Picture(FileChooser.getMediaPath("bird2.jpg"));
      bird3 = new Picture(FileChooser.getMediaPath("bird3.jpg"));
      bird4 = new Picture(FileChooser.getMediaPath("bird4.jpg"));
      bird5 = new Picture(FileChooser.getMediaPath("bird5.jpg"));
      bird6 = new Picture(FileChooser.getMediaPath("bird6.jpg"));
    }
    // Start out with myPict as bird1
    this.setPicture(bird1);
    
    // Do the normal initializations
    super.init(thisSim);
    
    // Move all the birds to the far right corner
    this.setPenDown(false);
    this.moveTo(600,400);
    
    // Set speed to relatively slow
    this.setSpeed(40);
    
  }
  
  /**
   * act(t) For first 20 steps, walk toward the egg,
   * +/- 30 degrees.
   * Then walk AWAY from the egg, and with MORE wandering (panic).
   */
  public void act(int t) {
    
    // First, handle motion
    int speed = getSpeed();
    if (t <= 20) {
      // Tell it that this really is a BirdSimulation
      BirdSimulation mySim = (BirdSimulation) getSimulation();
      // which has an egg
      this.turnToFace(mySim.getEgg());
      this.turn(randNumGen.nextInt(60)-30);
      forward(randNumGen.nextInt(speed));
    } else {
      // Run away!!
      this.turnToFace(640,480); // Far right corner
      this.turn(randNumGen.nextInt(80)-40);
      forward(randNumGen.nextInt(speed));
    }
    
    // Next, set a new character
    int cell = randNumGen.nextInt(6)+1; // 0 to 5, + 1 => 1 to 6
    switch (cell) {
      case 1: 
        this.setPicture(bird1);
        break;
      case 2: 
        this.setPicture(bird2);
        break;
      case 3: 
        this.setPicture(bird3);
        break;
      case 4: 
        this.setPicture(bird4);
        break;
      case 5: 
        this.setPicture(bird5);
        break;
      case 6: 
        this.setPicture(bird6); 
        break;
    } // end switch
  } // end act
  
} // end BirdAgent class

