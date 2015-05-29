import jm.music.data.*;
import jm.JMC;
import jm.util.*;
import jm.music.tools.*;

/**
 * Class that holds phrases that can be used
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class SongPhrase {
  
  /**
   * Class method that returns the first phrase 
   * of Amazing Grace
   * @return the first phrase of Amazing Grace
   */
  public static Phrase AG1() {
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
    
    Phrase myPhrase = new Phrase();
    myPhrase.addNoteList(phrase1Data);
    return myPhrase;
  }
  
  /**
   * Class method that returns the second phrase of 
   * Amazing Grace
   * @return the second phrase of Amazing Grace
   */
  public static Phrase AG2() {
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
    myPhrase.addNoteList(phrase2Data);
    return myPhrase;
  }
  
  /**
   * Class method that returns a phrase from The
   * House of the Rising Sun
   * @return a phrase from The House of the Rising Sun
   */
  public static Phrase house() {
    double [] phraseData = {
      JMC.E4,JMC.EN,JMC.A3,JMC.HN,JMC.B3,JMC.EN,JMC.A3,JMC.EN,
      JMC.C4,JMC.HN,JMC.D4,JMC.EN,JMC.DS4,JMC.EN,
      JMC.E4,JMC.HN,JMC.C4,JMC.EN,JMC.B3,JMC.EN,
      JMC.A3,JMC.HN,JMC.E4,JMC.QN,
      JMC.A4,JMC.HN, JMC.E4, JMC.QN,
      JMC.G4,JMC.HN, JMC.E4,JMC.EN,JMC.D4,JMC.EN,JMC.E4,JMC.DHN,
      JMC.E4,JMC.HN,JMC.GS4,JMC.EN,JMC.G4,JMC.EN,
      JMC.A4,JMC.HN,JMC.A3,JMC.QN,
      JMC.C4,JMC.EN,JMC.C4,JMC.DQN,JMC.E4,JMC.QN,
      JMC.E4,JMC.EN,JMC.E4,JMC.EN,JMC.E4,JMC.QN,JMC.C4,JMC.EN,JMC.B3,JMC.EN,
      JMC.A3,JMC.HN,JMC.E4,JMC.QN,
      JMC.E4,JMC.HN,JMC.E4,JMC.EN,
      JMC.E4,JMC.EN,JMC.G3,JMC.QN,JMC.C4,JMC.EN,JMC.B3,JMC.EN,
      JMC.A3,JMC.DHN
    };
    
    Phrase myPhrase = new Phrase();
    myPhrase.addNoteList(phraseData);
    return myPhrase;
  }
  
  /**
   * Class method that returns a little riff
   * @return a phrase with a little riff in it
   */
  public static Phrase riff1() {
    double[] phraseData = {
      JMC.G3,JMC.EN,JMC.B3,JMC.EN,JMC.C4,JMC.EN,JMC.D4,JMC.EN
    };
    
    Phrase myPhrase = new Phrase();
    myPhrase.addNoteList(phraseData);
    return myPhrase;
  }
  
  /**
   * Class method that returns a second little riff
   * @return a phrase with a second little riff in it
   */
  public static Phrase riff2() {
    double[] phraseData = {
      JMC.D4,JMC.EN,JMC.C4,JMC.EN,JMC.E4,JMC.EN,JMC.G4,JMC.EN
    };
    
    Phrase myPhrase = new Phrase();
    myPhrase.addNoteList(phraseData);
    return myPhrase;
  }
  
  /**
   * Class method that returns a third little riff
   * @return a phrase with a third little riff in it
   */
  public static Phrase riff3() {
    double[] phraseData = {
      JMC.C4,JMC.QN,JMC.E4,JMC.EN,JMC.G4,JMC.EN,JMC.E4,JMC.SN,
      JMC.G4,JMC.SN,JMC.E4,JMC.SN,JMC.G4,JMC.SN,JMC.C4,JMC.QN
    };
    
    Phrase myPhrase = new Phrase();
    myPhrase.addNoteList(phraseData);
    return myPhrase;
  }
  
  /**
   * Class method that returns a fourth little riff
   * @return a phrase with a fourth little riff in it
   */
  public static Phrase riff4() {
    double[] phraseData = {
      JMC.C4,JMC.QN,JMC.E4,JMC.QN,JMC.G4,JMC.QN,JMC.C4,JMC.QN
    };
    
    Phrase myPhrase = new Phrase();
    myPhrase.addNoteList(phraseData);
    return myPhrase;
  }
  
  /**
   * Class method that returns a pattern
   * @return a phrase with a pattern in it
   */
  public static Phrase pattern1() {
    double[] riff1Data = {
      JMC.G3,JMC.EN,JMC.B3,JMC.EN,JMC.C4,JMC.EN,JMC.D4,JMC.EN
    };
    double[] riff2Data = {
      JMC.D4,JMC.EN,JMC.C4,JMC.EN,JMC.E4,JMC.EN,JMC.G4,JMC.EN
    };
    
    int counter1;
    int counter2;
    
    Phrase myPhrase = new Phrase();
    // 3 of riff1, 1 of riff2, and repeat all of it 3 times
    for (counter1 = 1; counter1 <= 3; counter1++) {
      for (counter2 = 1; counter2 <= 3; counter2++) {
        myPhrase.addNoteList(riff1Data);
      }
      myPhrase.addNoteList(riff2Data);
    }
    return myPhrase;
  }
  
  /**
   * Class method that returns a phrase with a second pattern
   * @return a phrase with a second pattern
   */
  public static Phrase pattern2() {
    double[] riff1Data = {
      JMC.G3,JMC.EN,JMC.B3,JMC.EN,JMC.C4,JMC.EN,JMC.D4,JMC.EN
    };
    double[] riff2Data = {
      JMC.D4,JMC.EN,JMC.C4,JMC.EN,JMC.E4,JMC.EN,JMC.G4,JMC.EN
    };
    
    int counter1;
    int counter2;
    
    Phrase myPhrase = new Phrase();
    // 2 of riff1, 2 of riff2, and repeat all of it 3 times
    for (counter1 = 1; counter1 <= 3; counter1++) {
      for (counter2 = 1; counter2 <= 2; counter2++) {
        myPhrase.addNoteList(riff1Data);
      }
      for (counter2 = 1; counter2 <= 2; counter2++) {
        myPhrase.addNoteList(riff2Data);
      }
    }
    return myPhrase;
  }
  
  /**
   * Class method that returns a phrase with a rhythm in it
   * @return a phrase with a rhythm in it
   */
  public static Phrase rhythm1() {
    double[] riff1Data = {
      JMC.G3,JMC.EN,JMC.REST,JMC.HN,JMC.D4,JMC.EN
    };
    double[] riff2Data = {
      JMC.C3,JMC.QN,JMC.REST,JMC.QN
    };
    
    int counter1;
    int counter2;
    
    Phrase myPhrase = new Phrase();
    // 2 of rhythm riff1, 2 of rhythm riff2, and repeat 
    // all of it 3 times 
    for (counter1 = 1; counter1 <= 3; counter1++) {
      for (counter2 = 1; counter2 <= 2; counter2++) {
        myPhrase.addNoteList(riff1Data);
      }
      for (counter2 = 1; counter2 <= 2; counter2++) {
        myPhrase.addNoteList(riff2Data);
      }
    }
    return myPhrase;
  }
  
  /**
   * Class method that returns a phrase with random notes in it
   * @return a phrase with 10 random notes
   */
  public static Phrase random() {
    Phrase ranPhrase = new Phrase();
    Note n = null;
    
    for (int i=0; i < 10; i++) {
      n = new Note((int) (128*Math.random()),0.1);
      ranPhrase.addNote(n);
    }
    return ranPhrase;
  }
  
  /**
   * Class method that returns a phrase with random notes 
   * in it which are above middle C
   * @return a phrase with 10 random notes above middle C
   */
  public static  Phrase randomAboveC() {
    Phrase ranPhrase = new Phrase();
    Note n = null;
    
    for (int i=0; i < 10; i++) {
      n = new Note((int) (60+(5*Math.random())),0.25);
      ranPhrase.addNote(n);
    }
    return ranPhrase;
  }
}
