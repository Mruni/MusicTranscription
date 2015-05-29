/**
 * A branch of a tree that can have children
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class Branch extends DrawableNode {
  
  /**
   * first child in the list of children
   */
  private DrawableNode firstChild;
  
  /**
   * Construct a branch with the first child and
   * next as null
   */
  public Branch() {
    super(); // Call superclass constructor
    firstChild = null;
  }
  
  /**
   * Method to get the first child in the branch
   * @return the first child in the list
   */
  public DrawableNode getFirstChild()
  { return this.firstChild; }
  
  /**
   * Method to return a string with information 
   * about this branch
   * @returns the information string
   */
  public String toString() {
    
    String childString = "No children", nextString="No next";
    if (firstChild != null) {
      childString = firstChild.toString();
    }
    
    if (this.getNext() != null) {
      nextString = this.getNext().toString();
    }
    
    return "Branch (with child: "+childString+" and next: "+
      nextString+")";
  }
  
  /**
   * Method to add a child node
   * @param the child to add
   */
  public void addChild(DrawableNode child) {
    // if we have no child then this is the first
    if (firstChild == null) {
      firstChild = child;
    }
    // else add to the end of the list of children
    else {
      firstChild.add(child);
    }
  }
  
  /**
   * Ask all our children to draw,
   * then let next draw.
   * @param turtle the Turtle to draw with
   */
  public void drawWith(Turtle turtle) {
    DrawableNode current = firstChild;
    
    // Tell the children to draw
    while (current != null) {
      current.drawWith(turtle);
      current = current.getNext();
    }
    
    // Tell my next to draw
    if (this.getNext() != null) {
      current = this.getNext();
      current.drawWith(turtle);
    }
  }
}
