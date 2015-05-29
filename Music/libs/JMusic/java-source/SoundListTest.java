/**
 * Class to test a sound list 
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class SoundListTest {
  
  /** the starting element in the linked list */
  private SoundElement root;
  
  /**
   * Constructor that sets up the test
   */
  public SoundListTest() {
    setUp();
  }
  
  /** 
   * Method to set up the linked list
   */
  private void setUp(){
    Sound s = null;  // For copying in sounds
    
    s = new Sound(FileChooser.getMediaPath("scratch-h.wav"));
    root = new SoundElement(s);
    
    s = new Sound(FileChooser.getMediaPath("gonga-2.wav"));
    SoundElement one = new SoundElement(s);
    root.repeatNext(one,5);
    
    s = new Sound(FileChooser.getMediaPath("scritch-q.wav"));
    SoundElement two = new SoundElement(s.scale(2.0));
    root.weave(two,3,3);
    
    s = new Sound(FileChooser.getMediaPath("clap-q.wav"));
    SoundElement three = new SoundElement(s);
    root.weave(three,5,2);
    
    root.playFromMeOn();
  } 
  
  /** 
   * Method to get the root
   * @return the root (start) of the linked list
   */
  public SoundElement getRoot() { return root;}
  
  /**
   * Method to test replace one sound with another 
   */
  public void degong() {
    Sound gong = new Sound(FileChooser.getMediaPath("gonga-2.wav"));
    Sound snap = new Sound(FileChooser.getMediaPath("snap-tenth.wav"));
    root.replace(gong,snap);
  }
  
//  public void reverseTest(){
//    FileChooser.setMediaPath("C:/cs1316/MediaSources/");
//    Sound s = null;  // For copying in sounds
//    
//    s = new Sound(FileChooser.getMediaPath("guzdial.wav"));
//    SoundNode root = new SoundNode(s);
//    
//    s = new Sound(FileChooser.getMediaPath("is.wav"));
//    SoundNode one = new SoundNode(s);
//    root.last().insertAfter(one);
//    
//    s = new Sound(FileChooser.getMediaPath("scritch-q.wav"));
//    SoundNode two = new SoundNode(s);
//    root.last().insertAfter(two);
//    
//    s = new Sound(FileChooser.getMediaPath("clap-q.wav"));
//    SoundNode three = new SoundNode(s);
//    two.insertAfter(three);
//    
//    //root.playFromMeOn();
//    
//    SoundNode reversed = (SoundNode) root.reverse2();
//    
//    reversed.playFromMeOn();
//  }
  
  /** Method to test */
  public static void main (String[] args) {
    SoundListTest test = new SoundListTest();
    test.setUp();
  }
  
}
