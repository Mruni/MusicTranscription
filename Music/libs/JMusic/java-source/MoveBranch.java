/**
 * Class that represents a change in location
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class MoveBranch extends Branch {
  
  /** x position to draw at */
  private int x;
  
  /** y position to draw at */
  private int y;
  
  /**
   * Construct a branch with children and
   * next as null
   * @param x the x position to use
   * @param y the y position to use
   */
  public MoveBranch(int x, int y) {
    super(); // Call superclass constructor
    this.x = x;
    this.y = y;
  }
  
  /** 
   * Method to get the x position
   * @return the x position
   */
  public int getXPos() {return this.x;}
  
  /**
   * Method to get the Y position 
   * @return the y position
   */
  public int getYPos() {return this.y;}
  
  /**
   * Method to move to a new x and y
   * @param x the new x
   * @param y the new y
   */
  public void moveTo(int x, int y) {
    this.x = x; 
    this.y = y;
  }
  
  /**
   * Method to return a string with information 
   * about this branch
   * @return the information string
   */
  public String toString() { 
    return "Move ("+ x + "," + y + ") "+ super.toString();
  }
  
  /**
   * Set the location, then draw
   * @param t the Turtle to draw with
   */
  public void drawWith(Turtle t) {
    t.moveTo(this.x,this.y);
    super.drawWith(t); // Do a normal branch now
  }
}