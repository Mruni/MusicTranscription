/**
 * Class that uses horizontal spacing between
 * children and a gap between them
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class HBranch extends Branch {
  
  /** Horizontal gap between children */
  private int gap;
  
  /**
   * Construct a branch with first child and
   * next as null
   * @param spacing the gap to leave between children
   */
  public HBranch(int spacing) {
    super(); // Call superclass constructor
    gap = spacing;
  }
  
  /**
   * Method to return a string with information 
   * about this branch
   * @return the information string
   */
  public String toString() { 
    return "Horizontal "+super.toString();
  }
  
  /**
   * Ask all our children to draw,
   * then tell the next element to draw
   * @param turtle Turtle to draw with
   */
  public void drawWith(Turtle turtle) {
    
    // start with the first child
    DrawableNode current = this.getFirstChild();
    
    // Have my children draw
    while (current != null) {
      current.drawWith(turtle);
      turtle.moveTo(turtle.getXPos()+gap,turtle.getYPos());
      current = current.getNext();
    }
    
    // Have my next draw
    if (this.getNext() != null) {
      current = this.getNext();
      current.drawWith(turtle);
    }
  }
}
