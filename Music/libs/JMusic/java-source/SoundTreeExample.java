/**
 * Class to test the sound tree
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class SoundTreeExample {
  
  /** branch that scales the children */
  private ScaleBranch scaledBranch; 
  
  /** the root of the tree */
  private SoundBranch root;
  
  /**
   * Constructor to set up the example
   */
  public SoundTreeExample() {
    setUp();
  }
  
  /** 
   * Method to get the root of the tree
   * @return the root of the tree
   */
  public SoundBranch getRoot() { return root; }
  
  /**
   * Method to set up the tree
   */
  private void setUp() {
    Sound clap = 
      new Sound(FileChooser.getMediaPath("clap-q.wav"));
    Sound chirp = 
      new Sound(FileChooser.getMediaPath("chirp-2.wav"));
    Sound rest = 
      new Sound(FileChooser.getMediaPath("rest-1.wav"));
    Sound snap = 
      new Sound(FileChooser.getMediaPath("snap-tenth.wav"));
    Sound clink = 
      new Sound(FileChooser.getMediaPath("clink-tenth.wav"));
    Sound clave = 
      new Sound(FileChooser.getMediaPath("clave-twentieth.wav"));
    Sound gong = 
      new Sound(FileChooser.getMediaPath("gongb-2.wav"));
    Sound bassoon = 
      new Sound(FileChooser.getMediaPath("bassoon-c4.wav")); 
    Sound is = new Sound(FileChooser.getMediaPath("is.wav")); 
    Sound aah = new Sound(FileChooser.getMediaPath("aah.wav")); 
    
    // create the root
    root = new SoundBranch();
    SoundNode sn;
    
    // create the first branch
    SoundBranch branch1 = new SoundBranch();
    sn = new SoundNode(clap.append(rest).append(snap));
    branch1.addChild(sn);
    sn = new SoundNode(aah.append(snap).append(rest));
    branch1.addChild(sn);
    
    // create a scaled branch
    scaledBranch = new ScaleBranch(1.0);
    sn = new SoundNode(clink.append(clave).append(gong));
    scaledBranch.addChild(sn);
    sn = new SoundNode(is.append(chirp).append(clap));
    scaledBranch.addChild(sn);
    
    // create a second sound branch
    SoundBranch branch2 = new SoundBranch();
    sn = new SoundNode(clap.append(snap).append(snap));
    branch2.addChild(sn);
    sn = new SoundNode(bassoon.append(snap).append(clap));
    branch2.addChild(sn);
    
    // add the children to the tree
    root.addChild(branch1); 
    root.addChild(scaledBranch);
    root.addChild(branch2);
  }
  
  /**
   * Method to set up the tree 
   */
  public void setUp2() {
    Sound clap = 
      new Sound(FileChooser.getMediaPath("clap-q.wav"));
    Sound chirp = 
      new Sound(FileChooser.getMediaPath("chirp-2.wav"));
    Sound rest = 
      new Sound(FileChooser.getMediaPath("rest-1.wav"));
    Sound snap = 
      new Sound(FileChooser.getMediaPath("snap-tenth.wav"));
    Sound clink = 
      new Sound(FileChooser.getMediaPath("clink-tenth.wav"));
    Sound clave = 
      new Sound(FileChooser.getMediaPath("clave-twentieth.wav"));
    Sound gong = 
      new Sound(FileChooser.getMediaPath("gongb-2.wav"));
    Sound guzdial = 
      new Sound(FileChooser.getMediaPath("guzdial.wav"));
    Sound is = new Sound(FileChooser.getMediaPath("is.wav"));
    
    // create the root of the tree
    root = new SoundBranch();
    SoundNode sn;
    
    // create the first branch
    SoundBranch branch1 = new SoundBranch();
    sn = new SoundNode(guzdial.append(is).append(snap));
    branch1.addChild(sn);
    sn = new SoundNode(clink.append(snap).append(clave));
    branch1.addChild(sn);
    sn = new SoundNode(guzdial.append(is).append(is));
    branch1.addChild(sn);
    root.addChild(branch1);
    
    // create a scaled branch
    scaledBranch = new ScaleBranch(2.0);
    sn = new SoundNode(clink.append(clave).append(gong));
    scaledBranch.addChild(sn);
    sn = new SoundNode(rest.append(chirp).append(clap));
    scaledBranch.addChild(sn);
    root.addChild(scaledBranch);
    
    // create a second scaled branch
    scaledBranch = new ScaleBranch(0.5);
    sn = new SoundNode(guzdial.append(is).append(gong));
    scaledBranch.addChild(sn);
    branch1.addChild(scaledBranch);
    
    // create a second sound branch
    SoundBranch branch2 = new SoundBranch();
    sn = new SoundNode(clap.append(clap).append(clave));
    branch2.addChild(sn);
    sn = new SoundNode(snap.append(snap).append(clave));
    branch2.addChild(sn);
    sn = new SoundNode(snap.append(snap).append(clave));
    branch2.addChild(sn);
    root.addChild(branch2);
    
    // play it
    root.playFromMeOn();
  }
  
  /** 
   * Method to play the tree
   */
  public void play() {
    root.playFromMeOn();
  }

  /**
   * Method to play the tree but change the
   * scale factor
   * @param factor the new factor to use
   */
  public void playScaled(double factor) {
    scaledBranch.setFactor(factor);
    root.playFromMeOn();
  }

  /**
   * Method to play after the current node
   */
  public void playAfter() {
    root.collectAfter().play();
  }
  
  /**
   * Method to play with the next nodes 
   * before the child nodes
   */
  public void playSwapped() {
    root.collectSwap().play();
  }
  
  /**
   * Method to test the tree 
   */
  public static void main(String[] args) {
    SoundTreeExample tree = new SoundTreeExample();
    tree.getRoot().collect().play();
  }
}
