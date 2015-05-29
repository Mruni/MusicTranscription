/**
 * Class that uses vertical spacing between
 * children with a gap between children as well
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class VBranch extends Branch {
  
  /** Vertical gap between children */
  private int gap;
  
  /**
   * Construct a branch with children and
   * next as null
   * @param spacing the gap to use
   */
  public VBranch(int spacing) {
    super(); // Call superclass constructor
    gap = spacing;
  }
  
  /**
   * Method to return a string with information 
   * about this branch
   * @return the information string
   */
  public String toString() {
    return "Vertical " + super.toString();
  }
  
  /**
   * Ask all our children to draw,
   * then let the next node draw
   * @param turtle the Turtle to draw with
   */
  public void drawWith(Turtle turtle) {
    
    // start with the first child
    DrawableNode current = this.getFirstChild();
    
    // Have my children draw
    while (current != null) {
      current.drawWith(turtle);
      turtle.moveTo(turtle.getXPos(),turtle.getYPos() + gap);
      current =current.getNext();
    }
    
    // Have my next draw
    if (this.getNext() != null) {
      current = this.getNext();
      current.drawWith(turtle);
    }
  }
}
