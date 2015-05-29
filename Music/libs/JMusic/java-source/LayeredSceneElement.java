/**
 * Class that uses a linked list to indicate
 * the layer a picture is in
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class LayeredSceneElement {
  
  /** the picture that this element holds */
  private Picture myPic;
  
  /** the next element in the list */
  private LayeredSceneElement next;
  
  /** The coordinates for this element */
  private int x, y;
  
  /**
   * Make a new element with a picture as input, and
   * next as null, to be drawn at given x,y
   * @param heldPic Picture for element to hold
   * @param xPos x position desired for element
   * @param yPos y position desired for element
   */
  public LayeredSceneElement(Picture heldPic, int xPos, int yPos){
    myPic = heldPic;
    next = null;
    x = xPos;
    y = yPos;
  }
  
  /**
   * Method to set the next element
   * @param nextOne next element in list
   */
  public void setNext(LayeredSceneElement nextOne) {
    this.next = nextOne;
  }
  
  /** 
   * Method to get the next element
   * @return the next element
   */
  public LayeredSceneElement getNext() {
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
   * Method to draw from this node on in the list, using blueScreen.
   * Each new element has it's lower-left corner at the lower-right 
   * of the previous node. Starts drawing from left-bottom
   * @param bg Picture to draw drawing on
   */
  public void drawFromMeOn(Picture bg) {
    LayeredSceneElement current;
    
    current = this;
    while (current != null) {
      current.drawMeOn(bg);
      current = current.getNext();
    }
  }
  
  /**
   * Method to draw from this picture, using blueScreen.
   * @param bg Picture to draw drawing on
   */
  private void drawMeOn(Picture bg) {
    this.getPicture().blueScreen(bg,x,y);
  }
  
  /** 
   * Method to remove node from list, fixing links appropriately.  
   * @param node element to remove from list.
   */
  public void remove(LayeredSceneElement node) {
    if (node==this) {
      System.out.println("I can't remove the first node from the list.");
      return;
    }

    LayeredSceneElement current = this;
    
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
   * Return the last element in the list
   */
  public LayeredSceneElement last() {
    LayeredSceneElement current;
    
    current = this;
    while (current.getNext() != null) {
      current = current.getNext();
    }
    return current;
  }
  
  /**
   * Reverse the list starting at this, 
   * and return the last element of the list.
   * The last element becomes the FIRST element
   * of the list, and THIS points to null.
   */
  public LayeredSceneElement reverse() {
    LayeredSceneElement reversed, temp;
    
    // Handle the first node outside the loop
    reversed = this.last();
    this.remove(reversed);
    
    while (this.getNext() != null) {
      temp = this.last();
      this.remove(temp);
      reversed.add(temp);
    }
    
    // Now put the head of the old list on the end of
    // the reversed list.
    reversed.add(this);
    
    // At this point, reversed 
    // is the head of the list
    return reversed;
  }
  
  /**
   * Reverse2: Push all the elements on
   * the stack, then pop all the elements
   * off the stack.
   */
    public LayeredSceneElement reverse2() {
      LayeredSceneElement reversed, current, popped;
      Stack<LayeredSceneElement> stack = 
        new LinkedListStack<LayeredSceneElement>();

      // Push all the elements on the list
      current=this;
      while (current != null)
      {
        stack.push(current);
        current = current.getNext();
      }

      // Make the last element (current top of stack) into new first
      reversed = stack.pop();
 
      // Now, pop them all onto the list
      current = reversed;
      while (stack.size()>0) {
        popped = stack.pop();
        current.insertAfter(popped);
        current = popped;
      }
      return reversed;
    }
  
  /**
   * Add the input node after the last node in this list.
   * @param node element to insert after this.
   */
  public void add(LayeredSceneElement node) {
    this.last().insertAfter(node);
  }
  
  /**
   * Insert the input node after this node.
   * @param node element to insert after this.
   */
  public void insertAfter(LayeredSceneElement node) {
    // Save what "this" currently points at
    LayeredSceneElement oldNext = this.getNext();
    this.setNext(node);
    node.setNext(oldNext);
  }
}
