/**
 * A class that represents a slow walking turtle
 * @author Mark Guzdial
 * @author Barb Ericson
 */
class SlowWalkingTurtle extends Turtle {
  
  /** Constructor that takes the model display
    * @param modelDisplay the thing that displays the model
    */
  public SlowWalkingTurtle (ModelDisplay modelDisplay) { 
    // let the parent constructor handle it
    super(modelDisplay);
  }
  
  /**
   * Method to have the turtle go forward then wait a moment
   * and then go on.
   * @param pixels the number of pixels to go forward
   */
  public void forward(int pixels) {
    super.forward(pixels);
    try {
      Thread.sleep(500); // Wait a half sec
    } catch (Exception e) {
      System.err.println("Exception: " + e.getMessage());
      System.err.println("Stack Trace is:");
      e.printStackTrace();
    }
  }
  
}
