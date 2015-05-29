/**
 * Class that scales the children
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class ScaleBranch extends SoundBranch {

  /** Amount to scale the children by */
  private double factor;
  
  /**
   * Construct a branch with the passed factor
   * @param theFactor the factor to use
   */
  public ScaleBranch(double theFactor) {
    super(); // Call superclass constructor
    this.factor = theFactor;
  }
  
  /**
   * Method to get the scaling factor
   * @return the scaling factor
   */
  public double getFactor() { return this.factor; }
  
  /**
   * Method to set the scaling factor
   * @param theFactor the new factor to use
   */
  public void setFactor(double theFactor) {
    this.factor = theFactor; 
  }
  
  /**
   * Method to return a string with information 
   * about this branch
   * @return the information string
   */
  public String toString() {
    return "ScaleBranch (" + factor + 
      ") "+ super.toString();
  }
  
  /**
   * Collect all the sound from the children,
   * then collect from next.
   * Scale the getFirstChild()
   * @return the collected sound
   */
  public Sound collect() {
    
    Sound childSound;
    
    if (getFirstChild() != null) {
      childSound = getFirstChild().collect().scale(factor);
    }
    else {
      childSound = new Sound(1);
    }
    
    // Collect from my next
    if (this.getNext() != null) {
      Sound nextSound=(this.getNext()).collect();
      childSound = childSound.append(nextSound);
    }
    
    return childSound;
  }
  
  /**
   * Collect all the sound from the children,
   * then collect from next.
   * Scale the next list, not the children
   * @return the collected sound
   */
  public Sound collectAfter(){
    
    Sound childSound;
    
    if (getFirstChild() != null) {
      childSound = getFirstChild().collect();
    }
    else {
      childSound = new Sound(1);
    }
    
    // Collect from my next
    if (this.getNext() != null) {
      Sound nextSound=(this.getNext()).collect();
      childSound = childSound.append(nextSound.scale(factor));
    }
    
    return childSound;
  }
  
  /**
   * Collect all the sound from next and then
   * our children
   * Scale the children
   * But return the next BEFORE the children
   * @return the collected sound
   */
  public Sound collectSwap(){
    
    Sound childSound;
    
    if (getFirstChild() != null) {
      childSound = getFirstChild().collect().scale(factor);
    }
    else {
      childSound = new Sound(1);
    }
    
    // Collect from my next
    if (this.getNext() != null) {
      Sound nextSound=(this.getNext()).collect();
      childSound = nextSound.append(childSound);
    }
    
    return childSound;
  }
}
