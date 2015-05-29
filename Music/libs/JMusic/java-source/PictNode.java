/**
 * PictNode is a class representing a drawn picture
 * node in a scene tree.
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class PictNode extends DrawableNode {
  
  /**
   * The picture I'm associated with
   */
  private Picture myPict;
  
  /**
   * Make me with this picture
   * @param pict the Picture to use
   */
  public PictNode(Picture pict) {
    super(); // Call superclass constructor
    myPict = pict;
  }
  
  /**
   * Method to get the picture
   * @return the picture associated with this node
   */
  public Picture getPicture() { return myPict; }
  
  /**
   * Method to return a string with information 
   * about this node
   * @return the information string
   */
  public String toString() {
    return "PictNode (with picture: " + myPict + " and next: " +
      this.getNext();
  }
  
  /**
   * Use the given turtle to draw oneself
   * @param theTurtle the Turtle to draw with
   */
  public void drawWith(Turtle theTurtle) {
    theTurtle.drop(myPict);
  }
}
