/**
 * BlueScreenNode is a PictNode that composes the
 * picture using the blueScreen() method in Picture
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class BlueScreenNode extends PictNode {
  
  /**
   * Constructor that sets the picture
   * @param p the Picture to use
   */
  public BlueScreenNode(Picture p) {
    super(p); // Call superclass constructor
  }
  
  /**
   * Method to return a string with information 
   * about this node
   * @return the information string
   */
  public String toString() {
    return "BlueScreenNode (with picture: "+ 
      this.getPicture() + " and next: " + this.getNext();
  }
  
  /**
   * Use the given turtle to draw oneself
   * Get the turtle's picture, then blueScreen onto it
   * @param theTurtle the Turtle to draw with
   */
  public void drawWith(Turtle theTurtle) {
    Picture bg = theTurtle.getPicture();
    Picture myPict = this.getPicture();
    myPict.blueScreen(bg,theTurtle.getXPos(),
                      theTurtle.getYPos());
  }
}
