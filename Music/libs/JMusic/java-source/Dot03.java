import jm.music.data.*;
import jm.JMC;
import jm.util.*;
import jm.music.tools.*;
/**
 * Class to show creating a a note and creating
 * two phrases and a part and showing the part
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class Dot03  {
    public static void main(String[] args) { 
        Note n = new Note(JMC.C4, JMC.QUARTER_NOTE);
        Phrase phr = new Phrase(0.0);
        phr.addNote(n); 
        Mod.repeat(phr, 15);
        
        Phrase phr2 = new Phrase(0.0); 
        Note r = new Note(JMC.REST, JMC.EIGHTH_NOTE);
        phr2.addNote(r);
        Note n2 = new Note(JMC.E4, JMC.EIGHTH_NOTE);
        phr2.addNote(n2);
        Note r2 = new Note(JMC.REST, JMC.QUARTER_NOTE);
        phr2.addNote(r2);
        Mod.repeat(phr2, 7);
                
        Part p = new Part();
        p.addPhrase(phr);
        p.addPhrase(phr2);
        
        View.show(p);
    }
}