/** 
 * EggAgent -- big scary egg that sits there until t=30, 
 * then emerges as a monster!
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class EggAgent extends Agent {
  
  /** the pictures to use */
  private static Picture egg1, egg2, egg3, egg4;
  
  ////////////////////////////// Constructors ////////////////////////
  // Copy this section AS-IS into subclasses, but rename 
  
  /**
   * Constructor that takes the model display (the original
   * position will be randomly assigned) and the simulation
   * @param modelDisplayer thing that displays the model
   * @param thisSim my simulation
   */
  public EggAgent (ModelDisplay modelDisplayer,
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
  public EggAgent (int x, int y, ModelDisplay modelDisplayer, 
                   Simulation thisSim) {
    // let the parent constructor handle it
    super(x,y,modelDisplayer,thisSim);
  }
  
  /**
   * To initialize, set it up as the Egg in the upper lefthand corner
   * @param thisSim the simulation
   */
  public void init(Simulation thisSim) {
    if (egg1 == null) { //Initialize
      egg1 = new Picture(FileChooser.getMediaPath("egg1.jpg"));
      egg2 = new Picture(FileChooser.getMediaPath("egg2.jpg"));
      egg3 = new Picture(FileChooser.getMediaPath("egg3.jpg"));
      egg4 = new Picture(FileChooser.getMediaPath("egg4.jpg"));
    }
    
    // Start out as egg1
    this.setPicture(egg1);
    
    // Normal initialization
    super.init(thisSim);
    
    // Make the turtle disappear
    this.hide();
    this.setPenDown(false);
    
    // Move the egg up to the left hand corner
    this.moveTo(10,10);
  }
  
  /**
   * To act, just drop the Egg for 15 steps,
   * then be the eyes opened for five steps,
   * then be the eyes switching back-and-forth
   * @param t the timestep
   */
  public void act(int t) {    
    if (t < 19) {
      this.setPicture(egg1);
    }
    
    if (t > 19 && t < 24) {
      this.setPicture(egg2);
    }
    
    if (t > 23) {
      int choose=randNumGen.nextInt(2);
      if (choose == 1) {
        this.setPicture(egg3);
      }
      
      else {
        this.setPicture(egg4);
      }
    }
  } // end act()
  
}
