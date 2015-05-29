/**
 * BirdSimulation
 * A flock of 10 birds investigate a mysterious egg,
 * which suddenly shows itself to be a monster!
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class BirdSimulation extends Simulation {
  
  /** the egg to investigate */
  private EggAgent egg; // We'll need to get this later in BirdAgent
  
  /** to make the animation */
  private FrameSequencer myFrames; // Need a separate one from Simulations
  
  /**
   * Set up the world with 10 birds and the mysterious egg
   */
  public void setUp() {
    
    // Set up the world
    super.setUp();
    
    // We'll need frames for the animation
    myFrames = new FrameSequencer("C:/Temp/");
    myFrames.show();
    
    // create 10 birds
    BirdAgent tweetie;
    World world = getWorld();
    for (int num = 0; num < 10; num++) {
      tweetie = new BirdAgent(world,this);}
    
    // And the egg
    egg = new EggAgent(world,this);
  }
  
  /**
   * Method to return the egg
   * @return the egg
   */
  public EggAgent getEgg() { return egg; }
  
  /**
   * What to do at the last time step 
   * t the current timestep
   */
  public void endStep(int t) {
    
    // Do the normal file processing (if any)
    super.endStep(t);
    
    // But now, make a 640x480 frame, and copy
    // in pictures from all the agents
    Picture frame = new Picture(640,480);
    Agent drawMe = null;
    for (int index=0; index<this.getAgents().size(); index++) {
      drawMe = (Agent) this.getAgents().get(index);
      drawMe.getPicture().blueScreen(frame,drawMe.getXPos(),
                                     drawMe.getYPos());
    }
    myFrames.addFrame(frame);
  }
  
}
