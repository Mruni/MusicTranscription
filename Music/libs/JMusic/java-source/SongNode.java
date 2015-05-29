import jm.music.data.*;
import jm.JMC;
import jm.util.*;
import jm.music.tools.*;

/**
 * Represents a node in a flexible song structure
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class SongNode {
  
  /** the next SongNode in the list */
  private SongNode next;
  
  /** the Phrase containing the notes and durations */
  private Phrase myPhrase;
  
  /**
   * Construct a new song node.
   * The next part is empty, and ours is a 
   * blank new part.
   */
  public SongNode() {
    this.next = null;
    this.myPhrase = new Phrase();
  }
  
  /**
   * setPhrase takes a Phrase and makes it the one for 
   * this node 
   * @param thisPhrase the phrase for this node
   */
  public void setPhrase(Phrase thisPhrase) {
    this.myPhrase = thisPhrase;
  }
  
  /**
   * Creates a link between the current node and the 
   * input node
   * @param nextOne the node to link to
   */
  public void setNext(SongNode nextOne) {
    this.next = nextOne;
  }
  
  /**
   * copyNode returns a copy of this node
   * @return another song node with the same notes
   */
  public SongNode copyNode() {
    SongNode returnMe = new SongNode();
    returnMe.setPhrase(this.getPhrase());
    return returnMe;
  }
  
  /**
   * Repeat the input phrase for the number of times specified.
   * But do an insertion, to save the rest of the list.
   * @param nextOne node to be copied into the list
   * @param count number of times to copy it in.
   */
  public void repeatNextInserting(SongNode nextOne, int count) {
    SongNode current = this; // Start from here
    SongNode copy; // Where we keep the current copy
    
    for (int i=1; i <= count; i++) {
      copy = nextOne.copyNode(); // Make a copy
      current.insertAfter(copy); // INSERT after current
      current = copy; // now move on to the copy
    }
  }
  
  /**
   * Repeat the input phrase for the number of times specified.
   * It always inserts the repeated node after the 
   * current node
   * @param nextOne node to be copied in to list
   * @param count number of times to copy it in.
   */
  public void repeatNext(SongNode nextOne,int count) {
    SongNode current = this; // Start from here
    SongNode copy; // Where we keep the current copy
    
    for (int i=1; i <= count; i++) {
      copy = nextOne.copyNode(); // Make a copy
      current.setNext(copy); // Set as next
      current = copy; // Now append to copy
    }
  }
  
  /**
   * Insert the input SongNode AFTER this node, 
   * and make whatever node comes NEXT become the next of 
   * the input node.
   * @param nextOne SongNode to insert after this one
   */
  public void insertAfter(SongNode nextOne) {
    SongNode oldNext = this.getNext(); // Save its next
    this.setNext(nextOne); // Insert the copy
    nextOne.setNext(oldNext); // Make the copy point on to the rest
  }
  
  /**
   * Weave the input song node count times every skipAmount nodes
   * @param nextOne node to be copied into the list
   * @param count how many times to copy
   * @param skipAmount how many nodes to skip per weave
   */
  public void weave(SongNode nextOne, int count, int skipAmount) { 
    
    SongNode current = this; // Start from here
    SongNode copy; // Where we keep the one to be weaved in
    
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
   * Get the next song node
   * @return the next song node or null if none
   */
  public SongNode getNext() {
    return this.next;
  }
  
  /**
   * Accessor for the node's Phrase
   * @return internal phrase
   */
  private Phrase getPhrase() {
    return this.myPhrase;
  }
  
  /**
   * Accessor for the notes inside the node's phrase
   * @return array of notes and durations inside the phrase
   */
  private Note[] getNotes() {
    return this.myPhrase.getNoteArray();
  }
  
  /**
   * Collect all the notes from this node on
   * in an part (then a score) and open it up for viewing.
   * @param instrument the MIDI instrument (program) to 
   * be used in playing 
   */
  public void showFromMeOn(int instrument) {
    
    // Make the Score that we'll assemble the elements into
    // We'll set it up with a default time signature and 
    // tempo we like
    // (Should probably make it possible to change these -- 
    // maybe with inputs?)
    Score myScore = new Score("My Song");
    myScore.setTimeSignature(3,4);
    myScore.setTempo(120.0);
    
    // Make the Part that we'll assemble things into
    Part myPart = new Part(instrument);
    
    // Make a new Phrase that will contain the notes from 
    // all the phrases
    Phrase collector = new Phrase();
    
    // Start from this element (this)
    SongNode current = this;
    // While we're not through...
    while (current != null) {
      collector.addNoteList(current.getNotes());
      
      // Now, move on to the next element
      current = current.getNext();
    }
    
    // Now, construct the part and the score.
    myPart.addPhrase(collector);
    myScore.addPart(myPart);
    
    // At the end, let's see it!
    View.notate(myScore);
    
  }
  
  /**
   * Collect all nodes in this SongPart and return the composite Phrase
   * @return the phrase with all the notes in it
   */
  public Phrase collect() {
    
    // Make a new Phrase that will contain the notes from all the phrases
    Phrase collector = new Phrase();
    
    // Start from this element (this)
    SongNode current = this;
    // While we're not through...
    while (current != null) {
      collector.addNoteList(current.getNotes());
      
      // Now, move on to the next element
      current = current.getNext();
    }
    
    return collector;
  }
  
  public static void main(String[] args)
  {
    SongNode node1 = new SongNode();
    node1.setPhrase(SongPhrase.riff1());
    SongNode node2 = new SongNode();
    node2.setPhrase(SongPhrase.riff2());
    SongNode node3 = new SongNode();
    node3.setPhrase(SongPhrase.riff1());
    node1.setNext(node2);
    node2.setNext(node3);
    node1.showFromMeOn(JMC.SAX);
  }
  
}
