import jm.music.data.*;
import jm.JMC;
import jm.util.*;

/**
 * Class to show creating a a note and creating
 * a phrase and notating it
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class Dot01 implements JMC {
  public static void main(String [] args) {
    Note n;
    n = new Note(C4,QUARTER_NOTE);
    System.out.println(C4);
    System.out.println(QUARTER_NOTE);
    Phrase phr = new Phrase();
    phr.addNote(n);
    
    View.notate(phr);
  }
}
