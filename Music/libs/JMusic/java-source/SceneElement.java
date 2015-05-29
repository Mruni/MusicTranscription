/**
 * Represents an element that knows how to draw itself in a 
 * scene using a Turtle to do the drawing
 *
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public abstract class SceneElement {
  
  /**
   * the picture that this element holds
   */
  private Picture myPic;
  
  /**
   * the next element in the list -- any SceneElement
   */
  private SceneElement next;
  
  
  /**
   * Method to set the next element
   * @param nextOne next element in list
   */
  public void setNext(SceneElement nextOne) {
    this.next = nextOne;
  }
  
  /**
   * Method to get the next element 
   * @return the next element
   */
  public SceneElement getNext() {
    return this.next;
  }
  
  /**
   * Returns the picture in the node.
   * @return the picture in the node
   */
  public Picture getPicture() {
    return this.myPic;
  }
  
  /**
   * Method to set the picture in the node
   * @param pict the picture to use
   */
  public void setPicture(Picture pict)
  {
    this.myPic = pict;
  }
  
  /**
   * Method to draw from this node on in the list.
   * For positioned elements, compute locations.
   * Each new element has it's lower-left corner at the 
   * lower-right of the previous node. Starts drawing from 
   * left-bottom
   * @param bg Picture to draw drawing on
   */
  public void drawFromMeOn(Picture bg) {
    
    SceneElement current;
    
    // Start the X at the left
    // Start the Y along the bottom
    int currentX=0, currentY = bg.getHeight()-1;
    
    Turtle turtle = new Turtle(bg);
    turtle.setPenDown(false); // Pick the pen up
    
    current = this;
    while (current != null) {
      // Position the turtle for the next positioned element
      turtle.moveTo(currentX,currentY-current.getPicture().getHeight());
      turtle.setHeading(0);
      
      current.drawWith(turtle);
      currentX = currentX + current.getPicture().getWidth();
      
      current = current.getNext();
    }
  }
  
  /*
   * Use the given turtle to draw oneself
   * @param t the Turtle to draw with
   */
  public abstract void drawWith(Turtle t);
  // No body defined here in the abstract class
  
  /** Method to remove node from list, fixing links appropriately.
   * @param node element to remove from list.
   */
  public void remove(SceneElement node) {
    if (node==this) {
      System.out.println("I can't remove the first node from the list.");
      return;
    }
    
    SceneElement current = this;
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
  public void insertAfter(SceneElement node) {
    
    // Save what "this" currently points at
    SceneElement oldNext = this.getNext();
    this.setNext(node);
    node.setNext(oldNext);
  }
  
  /**
   * Return the last element in the list
   */
  public SceneElement last() {
    SceneElement current;
    
    current = this;
    while (current.getNext() != null) {
      current = current.getNext();
    }
    return current;
  }
  
  /**
   * Return the number of elements in the list
   * @return the number of elements in the list
   */
  public int count() {
    int numElements = 1;
    
    SceneElement current = this;
    while (current.getNext() != null) {
      current = current.getNext();
      numElements++;
    }
    return numElements;
  }
  
  /**
   * Reverse the list starting at this, 
   * and return the last element of the list.
   * The last element becomes the FIRST element
   * of the list, and THIS goes to null.
   */
  public SceneElement reverse() {
    SceneElement reversed, temp;
    
    // Handle the first node outside the loop
    reversed = this.last();
    this.remove(reversed);
    
    while (this.getNext() != null) {
      temp = this.last();
      this.remove(temp);
      reversed.add(temp);
    }
    // At this point, reversed 
    // is the head of the list
    return reversed;
  }
  
  /**
   * Add the input node after the last node in this list.
   * @param node element to insert after this.
   */
  public void add(SceneElement node) {
    this.last().insertAfter(node);
  }
  
}
