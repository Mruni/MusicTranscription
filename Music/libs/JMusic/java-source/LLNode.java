/**
 * Class that represents a node in a linked list
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public abstract class LLNode {
  
  /** The next node in the list */
  private LLNode next;
  
  /**
   * Constructor for LLNode that just sets
   * next to null
   */
  public LLNode() {
    next = null;
  }
  
  /**
   * Method to set the next element
   * @param nextOne the element to set as next
   */
  public void setNext(LLNode nextOne) {
    this.next = nextOne;
  }
  
  /**
   * Method to get the next element
   * @return the next element in the linked list
   */
  public LLNode getNext() {
    return this.next;
  }
  
  /** Method to remove a node from the list, fixing 
    * the next links appropriately.
    * @param node the element to remove from the list.
    */
  public void remove(LLNode node) {
    if (node==this) {
      System.out.println("I can't remove myself from " +
                         "the head of the list");
      return;
    }
    
    LLNode current = this;
    
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
  public void insertAfter(LLNode node) {
    // Save what "this" currently points at
    LLNode oldNext = this.getNext();
    this.setNext(node);
    node.setNext(oldNext);
  }
  
  /**
   * Return the last element in the list
   * @return the last element in the list
   */
  public LLNode last() {
    LLNode current;
    
    current = this;
    while (current.getNext() != null) {
      current = current.getNext();
    }
    return current;
  }
  
  /**
   * Return the number of the elements in the list
   * @return the number of elements in the list
   */
  public int count() {
    LLNode current;
    int count = 1;
    
    current = this;
    while (current.getNext() != null) {
      count++;
      current = current.getNext();
    }
    return count;
  }
  
  
  /**
   * Add the passed node after the last node in this list.
   * @param node the element to insert after this.
   */
  public void add(LLNode node) {
    this.last().insertAfter(node);
  }
  
  /**
   * Reverse the list starting at this, 
   * and return the last element of the list.
   * The last element becomes the FIRST element
   * of the list, and THIS goes to null.
   * @return the new head of the list
   */
  public LLNode reverse() {
    LLNode reversed, temp;
    
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
   * @return the new head of the list
   */
  public LLNode reverse2() {
    LLNode reversed, current, popped;
    Stack stack = new LinkedListStack();
    
    current=this;
    while (current != null) {
      stack.push(current);
      current = current.getNext();
    }
    
    reversed = (LLNode) stack.pop();
    current = reversed;
    while (stack.size()>0) {
      popped=(LLNode) stack.pop();
      current.insertAfter(popped);
      current = popped;
    }
    
    return reversed;
  }
  
}

