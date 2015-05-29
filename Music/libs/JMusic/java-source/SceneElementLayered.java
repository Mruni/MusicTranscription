/** 
 * A scene element that knows its position
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class SceneElementLayered extends SceneElement {
  
  /** The x and y coordinates for this element */
  private int x, y;
  
  /**
   * Make a new element with a picture as input, and
   * next as null, to be drawn at given x,y
   * @param heldPic Picture for element to hold
   * @param xpos x position desired for element
   * @param ypos y position desired for element
   */
  public SceneElementLayered(Picture heldPic, int xpos, int ypos) {
    setPicture(heldPic);
    setNext(null);
    this.x = xpos;
    this.y = ypos;
  }
  
  /**
   * Method to draw from this picture on.
   * @param turtle the Turtle to draw with
   */
  public void drawWith(Turtle turtle) {
    // We just ignore the pen's position
    turtle.moveTo(x,y);
    turtle.drop(this.getPicture());
  }
}
