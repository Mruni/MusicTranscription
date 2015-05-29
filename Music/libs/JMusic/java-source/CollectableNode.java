/**
 * Node in a sound tree. 
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public abstract class CollectableNode {
  
  /** reference to the next node */
  private CollectableNode next;
  
  /**
   * No argument constructor that sets
   * next to null
   */
  public CollectableNode() {
    next = null;
  }
  
  /**
   * Method to set the next node
   * @param nextOne the next element in list
   */
  public void setNext(CollectableNode nextOne) {
    this.next = nextOne;
  }
  
  /**
   * Method to get the next node
   * @return the next node in the list
   */
  public CollectableNode getNext() {
    return this.next;
  }
  
  /**
   * Play the list of sound elements
   * after me
   */
  public void playFromMeOn() {
    this.collect().play();
  }
  
  /** 
   * Collect all the sounds from me on
   * @return the collected sound
   */
  public abstract Sound collect();
  
  /** 
   * Collect all the sounds from me on,
   * but if there's processing, do it after.
   * @return the collected sound
   */
  public abstract Sound collectAfter();
  
  /** 
   * Method to remove a node from the list, 
   * fixing links appropriately.
   * @param node the node to remove from the list.
   */
  public void remove(CollectableNode node) {
    if (node==this) {
      System.out.println("Can't remove myself as the first node");
      return;
    }
    
    // start with me
    CollectableNode current = this;
    
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
   * Insert the passed node after this node.
   * @param node the node to insert after this.
   */
  public void insertAfter(CollectableNode node) {
    // Save what "this" currently points at
    CollectableNode oldNext = this.getNext();
    this.setNext(node);
    node.setNext(oldNext);
  }
  
  /**
   * Return the last node in the list
   * @return the last node in the list
   */
  public CollectableNode last() {
    CollectableNode current;
    
    current = this;
    while (current.getNext() != null) {
      current = current.getNext();
    }
    return current;
  }
  
  /**
   * Add the input node after the last node in this list.
   * @param node the node to insert after this.
   */
  public void add(CollectableNode node) {
    this.last().insertAfter(node);
  }
  
}

