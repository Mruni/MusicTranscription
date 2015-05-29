/**
 * Sounds for a linked list
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class SoundElement {
  
  /** The sound this element is associated with */
  private Sound mySound;
  
  /** The next element to process */
  private SoundElement next;
  
  /**
   * Constructor sets next to null
   * and references the input sound.
   * @param aSound the sound to use
   */
  public SoundElement(Sound aSound){
    next = null;
    mySound = aSound;
  }
  
  /**
   * The method to get the sound 
   * @return the sound associated with this node
   */
  public Sound getSound(){return mySound;}
  
  /**
   * Play JUST me, blocked.
   */
  public void playSound(){mySound.blockingPlay();}
  
  /**
   * Play JUST me, blocked.
   */
  public void blockingPlay(){mySound.blockingPlay();}
  
  /**
   * Provide a printable representation of me
   * @return the information string
   */
  public String toString(){
    return "SoundElement with sound: " + mySound + 
           " (and next: " + next + ").";
  }
  
  /**
   * Method to set the next element
   * @param nextOne next element to add to the list
   */
  public void setNext(SoundElement nextOne) {
    this.next = nextOne;
  }
  
  /**
   * Method to get the next element
   * @return the next element in the list
   */
  public SoundElement getNext() {
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
   * Collect all the sounds from me on,
   * recursively into one sound.
   * @return the resulting sound
   */
  public Sound collect() {
    if (this.getNext() == null) {
      return mySound;
    }
    else {
      return mySound.append(this.getNext().collect());
    }
  }
  
  /** Method to remove a node from the list, fixing links 
    * appropriately.  You can't remove the current node
    * from the head of the list.
    * @param node the element to remove from list.
    */
  public void remove(SoundElement node) {
    
    if (node==this) {
      System.out.println("I can't remove myself from the head of the list.");
      return;
    }
    
    SoundElement current = this;
    
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
   * @param node the element to insert after this.
   */
  public void insertAfter(SoundElement node) {
    
    // Save what "this" currently points at
    SoundElement oldNext = this.getNext();
    this.setNext(node);
    node.setNext(oldNext);
  }
  
  /**
   * Return the last element in the list
   * @return the last element in the list
   */
  public SoundElement last() {
    SoundElement current;
    
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
  public void add(SoundElement node) {
    this.last().insertAfter(node);
  }
  
  /**
   * copyNode returns a copy of this element
   * @return another element with the same sound
   */
  public SoundElement copyNode() {
    Sound copySound = new Sound(mySound); // copy the sound
    SoundElement returnMe = new SoundElement(copySound);
    return returnMe;
  }
  
  /**
   * Repeat the input phrase for the number of times specified.
   * It always appends to the current node and loses any 
   * next reference.
   * @param nextOne the node to be copied in to list
   * @param count the number of times to copy it in.
   */
  public void repeatNext(SoundElement nextOne, int count) {
    SoundElement current = this; // Start from here
    SoundElement copy; // Where we keep the current copy
    
    for (int i=1; i <= count; i++) {
      copy = nextOne.copyNode(); // Make a copy
      current.insertAfter(copy); // Set as next
      current = copy; // Now append to copy
    }
  }
  
   /**
   * Weave the input song node count times every skipAmount nodes
   * @param nextOne node to be copied into the list
   * @param count how many times to copy
   * @param skipAmount how many nodes to skip per weave
   */
  public void weave(SoundElement nextOne, int count, 
                    int skipAmount) { 
    
    SoundElement current = this; // Start from here
    SoundElement copy; // Where we keep the one to be weaved in
    
    // loop count times
    for (int i=0; i < count; i++) {
      
      //Skip skipAmount nodes (this one is 1)
      for (int j=1; j < skipAmount; j++) {
        
        // as long as current isn't null move to next
        if (current != null) {
          current = current.getNext();
        }
      }
      
      // if current isn't null
      if (current != null) {
        // make a new copy
        copy = nextOne.copyNode();
        
        // insert it after current
        current.insertAfter(copy);
        
        // move current along
        current = copy.getNext();
      }
      
      // else if current is null return (break out early)
      if (current == null) {
        return;
      }
    }
  }
  
  /**
   * Replace the one sound with the other sound
   * in all the elements from me on.
   * Two sounds are equal if come from same filename
   * @param oldSound sound to be replaced
   * @param newSound sound to put in its place
   */
  public void replace(Sound oldSound, Sound newSound) {
    if (this.mySound.getFileName() != null) {
      if (this.mySound.getFileName().equals(oldSound.getFileName())) {
        this.mySound = newSound;
      }
    }
    
    if (next != null) {
      next.replace(oldSound,newSound);
    }
  }
  
  public static void main(String[] args) {
    Sound s = new Sound(FileChooser.getMediaPath("shh-a-h.wav"));
    Sound t = new Sound(FileChooser.getMediaPath("croak-h.wav"));
    Sound u = new Sound(FileChooser.getMediaPath("clap-q.wav"));
    SoundElement e1 = new SoundElement(s);
    SoundElement e2 = new SoundElement(t);
    SoundElement e3 = new SoundElement(u);
    e1.playFromMeOn();
    System.out.println(e1);
  }
  
}

