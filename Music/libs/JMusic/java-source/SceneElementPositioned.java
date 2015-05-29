/**
 * Class that defines a scene element whose position
 * is defined by its position in the linked list
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class SceneElementPositioned extends SceneElement {
  
  /**
   * Make a new element with a picture as input, and
   * next as null.
   * @param heldPic Picture for element to hold
   */
  public SceneElementPositioned(Picture heldPic) {
    this.setPicture(heldPic);
    this.setNext(null);
  }
  
  /**
   * Method to draw from this picture.
   * @param turtle the Turtle to use for drawing
   */
  public void drawWith(Turtle turtle) {
    turtle.drop(this.getPicture());
  }
}
