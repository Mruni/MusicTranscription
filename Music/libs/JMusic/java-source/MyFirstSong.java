import jm.music.data.*;
import jm.JMC;
import jm.util.*;
import jm.JMC;

/**
 * Example class for creating a song
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class MyFirstSong {
  public static void main(String [] args) {
    Song songroot = new Song();
    
    SongNode node1 = new SongNode();
    SongNode riff3 = new SongNode();
    riff3.setPhrase(SongPhrase.riff3());
    node1.repeatNext(riff3,16);
    SongNode riff1 = new SongNode();
    riff1.setPhrase(SongPhrase.riff1());
    node1.weave(riff1,7,1);
    SongPart part1 = new SongPart(JMC.PIANO, node1);
    
    songroot.setFirst(part1);
    
    SongNode node2 = new SongNode();
    SongNode riff4 = new SongNode();
    riff4.setPhrase(SongPhrase.riff4());
    node2.repeatNext(riff4,20);
    node2.weave(riff1,4,5);
    SongPart part2 = new SongPart(JMC.STEEL_DRUMS, node2);
    
    songroot.setSecond(part2);
    songroot.show();
  }
}
