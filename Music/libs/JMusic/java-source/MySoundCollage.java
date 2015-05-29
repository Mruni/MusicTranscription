/**
 * Class that shows an example of creating a sound collage
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class MySoundCollage {
  
  public static void main(String [] args) {
    Sound snap = new Sound(FileChooser.getMediaPath("corkpop-tenth.wav"));
    Sound drum = new Sound(FileChooser.getMediaPath("scritch-q.wav"));
    Sound clink = new Sound(FileChooser.getMediaPath("snap-tenth.wav"));    
    Sound clap = new Sound(FileChooser.getMediaPath("coyote-h.wav"));
    
    Sound drumRev = drum.reverse().scale(0.5);
    Sound mixed = clap.mix(snap,0.5);
    Sound soundA = snap.append(clink).append(mixed).append(clap).append(drumRev);
    Sound soundB = clink.append(clap).append(clap).append(drum).append(snap).append(snap);
    
    Sound collage = soundA.append(soundB).append(soundB).append(soundA).append(soundA).append(soundB);
    collage.play();
  }
}
