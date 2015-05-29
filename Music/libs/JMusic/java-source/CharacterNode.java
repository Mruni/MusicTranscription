/*
 * CharacterNode has a picture for a given character.
 * Don't ever try to traverse this one!
 */
public class CharacterNode extends LLNode {
  /**
   * The picture I'm associated with
   */
  private Picture myPict;
  
  /*
   * Make me with this picture
   * @param pict the Picture I'm associated with
   */
  public CharacterNode(Picture pict) {
    super(); // Call superclass constructor
    myPict = pict;
  }
  
  /**
   * Don't try to remove() from a circular list!
   */
  public void remove(LLNode node) {
    System.out.println("Very dangerous to try to remove a node from this list!");
  }
  
  /**
   * Don't try to get the last() from a circular list!
   * @return the current node
   */
  public LLNode last() {
    System.out.println("Don't try to find last() from a circular list!");
    return this;
  }
  
  /**
   * Method to return a string with informaiton 
   * about this node
   */
  public String toString() {
    return "CharacterNode with picture: " + myPict;
  }
  
  /*
   * Use the given turtle to draw oneself
   * @param turtle the Turtle to draw with
   */
  public void drawWith(Turtle turtle) {
    // Assume that we're at the lower-left corner
    turtle.setHeading(0); 
    turtle.forward(myPict.getHeight());
    Picture bg = turtle.getPicture();
    myPict.blueScreen(bg,turtle.getXPos(),turtle.getYPos());
  }
}
