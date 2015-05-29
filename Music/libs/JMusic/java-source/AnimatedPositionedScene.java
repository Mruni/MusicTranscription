/**
 * Class that uses modification of a linked
 * data structure to animate a scence
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class AnimatedPositionedScene {
  
  /** A FrameSequencer for sequencing the frames */
  private FrameSequencer frames;
  
  /** 
   * We'll need to keep track 
   * of the elements of the scene
   */
  private PositionedSceneElement tree1, tree2, tree3, house, 
    doggy, doggyFlip;
  
  /**
   * Method to set up the animation 
   */
  public void setUp() {
    
    frames = new FrameSequencer("C:/Temp/");
    
    Picture p = null; // Use this to fill elements
    
    p = new Picture(FileChooser.getMediaPath("tree-blue.jpg"));
    tree1 = new PositionedSceneElement(p);
    
    p = new Picture(FileChooser.getMediaPath("tree-blue.jpg"));
    tree2 = new PositionedSceneElement(p);
    
    p = new Picture(FileChooser.getMediaPath("tree-blue.jpg"));
    tree3 = new PositionedSceneElement(p);
    
    p = new Picture(FileChooser.getMediaPath("house-blue.jpg"));
    house = new PositionedSceneElement(p);
    
    p = new Picture(FileChooser.getMediaPath("dog-blue.jpg"));
    doggy = new PositionedSceneElement(p);
    doggyFlip = new PositionedSceneElement(p.flip());
  }
  
  /**
   * Method to do the animation
   */
  public void make() {
    frames.show();
    
    // First frame
    Picture bg = new Picture(FileChooser.getMediaPath("jungle.jpg"));
    tree1.setNext(doggy); doggy.setNext(tree2); tree2.setNext(tree3);
    tree3.setNext(house);
    tree1.drawFromMeOn(bg);
    frames.addFrame(bg);
    
    // Dog moving right
    bg = new Picture(FileChooser.getMediaPath("jungle.jpg"));
    tree1.remove(doggy);
    tree2.insertAfter(doggy);
    tree1.drawFromMeOn(bg);
    frames.addFrame(bg);
    
    bg = new Picture(FileChooser.getMediaPath("jungle.jpg"));
    tree1.remove(doggy);
    tree3.insertAfter(doggy);
    tree1.drawFromMeOn(bg);
    frames.addFrame(bg);
    
    bg = new Picture(FileChooser.getMediaPath("jungle.jpg"));
    tree1.remove(doggy);
    house.insertAfter(doggy);
    tree1.drawFromMeOn(bg);
    frames.addFrame(bg);
    
    //Dog moving left
    bg = new Picture(FileChooser.getMediaPath("jungle.jpg"));
    tree1.remove(doggy);
    house.insertAfter(doggyFlip);
    tree1.drawFromMeOn(bg);
    frames.addFrame(bg);
    
    bg = new Picture(FileChooser.getMediaPath("jungle.jpg"));
    tree1.remove(doggyFlip);
    tree3.insertAfter(doggyFlip);
    tree1.drawFromMeOn(bg);
    frames.addFrame(bg);
    
    bg = new Picture(FileChooser.getMediaPath("jungle.jpg"));
    tree1.remove(doggyFlip);
    tree2.insertAfter(doggyFlip);
    tree1.drawFromMeOn(bg);
    frames.addFrame(bg);
    
    bg = new Picture(FileChooser.getMediaPath("jungle.jpg"));
    tree1.remove(doggyFlip);
    tree1.insertAfter(doggyFlip);
    tree1.drawFromMeOn(bg);
    frames.addFrame(bg);
    
  }
  
  /**
   * Method to replay the animation 
   */
  public void replay() {
    frames.play(100); //3 frames per second
  }
  
  /** main for testing */
  public static void main(String[] args) {
    AnimatedPositionedScene scene = 
      new AnimatedPositionedScene();
    scene.setUp();
    scene.make();
  }
}
