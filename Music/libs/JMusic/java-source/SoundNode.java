/*
 * SoundNode is a class representing a sound in a sound tree.
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class SoundNode extends CollectableNode {
  
  /** The sound I'm associated with */
  private Sound mySound;
  
  /*
   * Make me with this sound
   * @param sound the Sound I'm associated with
   */
  public SoundNode(Sound sound) {
    super(); // Call superclass constructor
    mySound = sound;
  }
  
  /**
   * Method to return a string with information 
   * about this node
   * @return the information string
   */
  public String toString() {
    return "SoundNode (with sound: " + mySound + 
      " and next: " + getNext() + ")";
  }
  
  /** 
   * Collect all the sounds from me on,
   * recursively.
   * @return the collected sound
   */
  public Sound collect() {
    SoundNode nextNode;
    if (this.getNext() == null) {
      return mySound;
    }
    else {
      nextNode = (SoundNode) this.getNext();
      return mySound.append(nextNode.collect());
    }
  }
  
  /**
   * Collect and process after this node
   * @return the collected sound
   */
  public Sound collectAfter() {
    if (this.getNext() == null) {
      return mySound;
    }
    else {
      return mySound.append((this.getNext()).collectAfter());
    }
  }
  
  /**
   * Collect swapped: Doesn't change in SoundNode
   * @return the collected sound 
   */
  public Sound collectSwap() {
    if (this.getNext() == null) {
      return mySound;
    }
    else {
      return mySound.append((this.getNext()).collectAfter());
    }
  }
}
