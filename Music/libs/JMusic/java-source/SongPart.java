import jm.music.data.*;
import jm.JMC;
import jm.util.*;
import jm.music.tools.*;

/**
 * Class that represents a part of a song
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class SongPart {
  
  /** SongPart has a Part */
  private Part myPart;
  
  /** the first node in the linked list */
  private SongNode myList;
  
  /**
   * Construct a SongPart
   * @param instrument MIDI instrument (program)
   * @param startNode where the song list starts from
   */
  public SongPart(int instrument, SongNode startNode) {
    myPart = new Part(instrument);
    myList = startNode;
  }
  
  /**
   * Method to get the part
   * @ return the part
   */
  public Part getMyPart() {
    return myPart;
  }
  
  /**
   * Collect parts of this SongPart
   * @return all the notes in a phrase
   */
  public Phrase collect() {
    // delegate to SongNode's collect
    return this.myList.collect();
  }
  
  /**
   * Collect all notes in this SongPart and open it up for viewing.
   */
  public void show() {
    
    // Make the Score that we'll assemble the part into
    // We'll set it up with a default time signature and tempo we like
    // (Should probably make it possible to change these -- 
    // maybe with inputs?)
    Score myScore = new Score("My Song");
    myScore.setTimeSignature(3,4);
    myScore.setTempo(120.0);
    
    // Now, construct the part and the score.
    this.myPart.addPhrase(this.collect());
    myScore.addPart(this.myPart);
    
    // At the end, let's see it!
    View.notate(myScore);
  }
  
}