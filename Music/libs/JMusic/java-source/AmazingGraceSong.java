import jm.music.data.*;
import jm.JMC;
import jm.util.*;
import jm.music.tools.*;

/**
 * Class that represents the song amazing grace
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class AmazingGraceSong {
  
  /** the score for the song */
  private Score myScore = new Score("Amazing Grace");
  
  /** 
   * Constructor to set up the song
   */
  public AmazingGraceSong() {
    myScore.setTimeSignature(3,4);
    
    double[] phrase1Data = {
      JMC.G4, JMC.QN,
      JMC.C5, JMC.HN, JMC.E5,JMC.EN, JMC.C5,JMC.EN,
      JMC.E5,JMC.HN,JMC.D5,JMC.QN,
      JMC.C5,JMC.HN,JMC.A4,JMC.QN,
      JMC.G4,JMC.HN,JMC.G4,JMC.EN,JMC.A4,JMC.EN,
      JMC.C5,JMC.HN,JMC.E5,JMC.EN,JMC.C5,JMC.EN,
      JMC.E5,JMC.HN,JMC.D5,JMC.EN,JMC.E5,JMC.EN,
      JMC.G5,JMC.DHN
    };
    double[] phrase2Data = {
      JMC.G5,JMC.HN,JMC.E5,JMC.EN,JMC.G5,JMC.EN,
      JMC.G5,JMC.HN,JMC.E5,JMC.EN,JMC.C5,JMC.EN,
      JMC.E5,JMC.HN,JMC.D5,JMC.QN,
      JMC.C5,JMC.HN,JMC.A4,JMC.QN,
      JMC.G4,JMC.HN,JMC.G4,JMC.EN,JMC.A4,JMC.EN,
      JMC.C5,JMC.HN,JMC.E5,JMC.EN,JMC.C5,JMC.EN,
      JMC.E5,JMC.HN,JMC.D5,JMC.QN,
      JMC.C5,JMC.DHN
    };
    Phrase myPhrase = new Phrase();
    myPhrase.addNoteList(phrase1Data);
    myPhrase.addNoteList(phrase2Data);
    
    // create a new part and add the phrase to it
    Part aPart = new Part("Parts", 
                          JMC.FLUTE, 1);
    aPart.addPhrase(myPhrase);
    // add the part to the score
    myScore.addPart(aPart);
    
  }
  
  /**
   * Method to show the song 
   */
  public void showMe() {
    View.notate(myScore);
  }
  
  public static void main(String[] args) 
  {
    AmazingGraceSong song = 
      new AmazingGraceSong();
    song.showMe();
  }
  
}
