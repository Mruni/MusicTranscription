import jm.music.data.*;
import jm.JMC;
import jm.util.*;
import jm.music.tools.*;

/**
 * Class that represents a song
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class Song {
  
  /** first Channel */
  private SongPart first; 
  
  /** second Channel */
  private SongPart second;
  
  /**
   * Take in a SongPart to make the first channel in the song
   * @param channel1 the first channel in the song
   */
  public void setFirst(SongPart channel1) {
    first = channel1;
    first.getMyPart().setChannel(1);
  }
  
  /**
   * Take in a SongPart to make the second channel in the song
   * @param channel2 the second channel in the song
   */
  public void setSecond(SongPart channel2) {
    second = channel2;
    first.getMyPart().setChannel(2);
  }
  
  /**
   * Make the score and show it
   */
  public void show() {
    
    // Make the Score that we'll assemble the parts into
    // We'll set it up with a default time signature and tempo we like
    // (Should probably make it possible to change these -- 
    // maybe with inputs?)
    Score myScore = new Score("My Song");
    myScore.setTimeSignature(3,4);
    myScore.setTempo(120.0);
    
    // Now, construct the part and the score.
    first.getMyPart().addPhrase(first.collect());
    second.getMyPart().addPhrase(second.collect());
    myScore.addPart(first.getMyPart());
    myScore.addPart(second.getMyPart());
    
    // At the end, let's see it!
    View.notate(myScore);
  }
  
}
