/**
 * Stuff that all nodes and branches in the
 * scene tree know.
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public abstract class DrawableNode {
  
  /**
   * The next branch/node/whatever to process
   */
  private DrawableNode next;
  
  /**
   * Constructor for DrawableNode just sets
   * next to null
   */
  public DrawableNode() {
    next = null;
  }
  
  /**
   * Method to set the next node
   * @param nextOne next node in list
   */
  public void setNext(DrawableNode nextOne) {
    this.next = nextOne;
  }
  
  /**
   * Method to get the next node
   * @return the next node
   */
  public DrawableNode getNext() {
    return this.next;
  }
  
  /**
   * Use the given turtle to draw oneself
   * @param t the Turtle to draw with
   */
  public abstract void drawWith(Turtle t);
  // no body in an abstract method
  
  /**
   * Draw on the given picture
   * @param bg the background picture to draw on
   */
  public void drawOn(Picture bg) {
    Turtle t = new Turtle(bg);
    t.setPenDown(false);
    this.drawWith(t);
  }
  
  /** 
   * Method to remove a node from the list, fixing links 
   * appropriately.  You can't remove the current node
   * from the head of the list.
   * @param node the element to remove from list.
   */
  public void remove(DrawableNode node) {
    
    if (node==this) {
      System.out.println(
                         "I can't remove myself from the head of the list.");
      return;
    }
    
    // start with this node
    DrawableNode current = this;
    
    // While there are more nodes to consider
    while (current.getNext() != null) {
      if (current.getNext() == node) {
        // Simply make node's next be this next
        current.setNext(node.getNext());
        // Make this node point to nothing
        node.setNext(null);
        return;
      }
      current = current.getNext();
    }
  }
  
  /**
   * Insert the input node after this node.
   * @param node element to insert after this.
   */
  public void insertAfter(DrawableNode node) {
    // Save what "this" currently points at
    DrawableNode oldNext = this.getNext();
    this.setNext(node);
    node.setNext(oldNext);
  }
  
  /**
   * Return the last element in the list
   * @return the last element in the list
   */
  public DrawableNode last() {
    DrawableNode current;
    
    current = this;
    while (current.getNext() != null) {
      current = current.getNext();
    }
    return current;
  }
  
  /**
   * Add the input node after the last node in this list.
   * @param node element to insert after this.
   */
  public void add(DrawableNode node) {
    this.last().insertAfter(node);
  }
  
}

