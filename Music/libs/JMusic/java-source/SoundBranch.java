/**
 * Class that represents a branch in a tree of 
 * sounds
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class SoundBranch extends CollectableNode {
  
  /** the first child in the list of children */
  private CollectableNode firstChild;
  
  /**
   * Construct a branch with the first child and
   * next as null
   */
  public SoundBranch() {
    super(); // Call superclass constructor
    firstChild = null;
  }
  
  /**
   * Method to return the first child
   * @return the first child
   */
  public CollectableNode getFirstChild() {
    return firstChild; 
  }
  
  /**
   * Method to return a string with information 
   * about this branch
   * @return the information string
   */
  public String toString() {
    
    String childString = "No firstChild", nextString="No next";
    
    // if there is a first child get its string
    if (firstChild != null) {
      childString = firstChild.toString();
    }
    
    // if there is a next node get its string
    if (getNext() != null) {
      nextString = getNext().toString();
    }
    
    return "SoundBranch (with child: " + childString + 
      " and next: " + nextString + ")";
  }
  
  /**
   * Method to add a node to the end of the 
   * children list
   * @param child the child to add
   */
  public void addChild(CollectableNode child) {
    if (firstChild != null) {
      firstChild.add(child);
    }
    else {
      firstChild = child;
    }
  }
  
  /**
   * Collect all the sound from our firstChild,
   * then collect from next.
   * @return the combined sound
   */
  public Sound collect() {
    
    Sound childSound;
    CollectableNode node;
    
    if (firstChild != null) {
      childSound = firstChild.collect();
    }
    else {
      childSound = new Sound(1);
    }
    
    // Collect from my next
    if (this.getNext() != null) {
      node=this.getNext();
      childSound=childSound.append(node.collect());
    }
    
    return childSound;
  }
  
  /**
   * Collect all the sound from our firstChild,
   * then collect from next.
   * If there's processing, do to Next, not to Children
   * @return the collected sound
   */
  public Sound collectAfter() {
    
    Sound childSound;
    CollectableNode node;
    
    if (firstChild != null) {
      childSound = firstChild.collectAfter();
    }
    else {
      childSound = new Sound(1);
    }
    
    // Collect from my next
    if (this.getNext() != null) {
      node=this.getNext();
      childSound=childSound.append(node.collectAfter());
    }
    
    return childSound;
  }
  
  /**
   * Collect all the sound from our firstChild,
   * then collect from next.
   * But return next BEFORE firstChild
   * @return the collected sound
   */
  public Sound collectSwap() {
    
    Sound childSound;
    CollectableNode node;
    
    if (firstChild != null) {
      childSound = firstChild.collect();
    }
    else {
      childSound = new Sound(1);
    }
    
    // Collect from my next
    if (this.getNext() != null) {
      node=this.getNext();
      childSound=(node.collect()).append(childSound);
    }
    
    return childSound;
  }
}
