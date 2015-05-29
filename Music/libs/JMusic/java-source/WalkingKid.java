/**
 * Class that represents a walking kid
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class WalkingKid {
  
  /** Which character node position are we at? */
  private CharacterNode current; 
  
  /** Starting position for walking */
  private CharacterNode start;
  
  /** x value for the Position for the character */
  private int x;
  
  /** y value for the position for the character */
  private int y;
  
  /** FrameSequence for the display */
  private FrameSequencer frames;
  
  /**
   * Method to get the x value of the position
   * @return the x value of the position 
   */
  public int getX() {return x;}
  
  /**
   * Method to get the y value of the position
   * @return the y value of the position
   */
  public int getY() {return y;}
  
  /**
   * Method to set the position to the new x and y
   * @param newX the new x value to use
   * @param newY the new y value to use
   */
  public void setLoc(int newX, int newY)
  {
    x=newX; 
    y=newY;
  }
  
  /** 
   * We'll do the list setup in the constructor
   */
  public WalkingKid(){
    Picture p = null; // For loading up images
    
    p = new Picture(FileChooser.getMediaPath("jSide.jpg"));
    start = new CharacterNode(p.flip());
    p = new Picture(FileChooser.getMediaPath("jWalk.jpg"));
    CharacterNode rightfoot = new CharacterNode(p.flip());
    p = new Picture(FileChooser.getMediaPath("jSide.jpg"));
    CharacterNode center = new CharacterNode(p.flip());
    p = new Picture(FileChooser.getMediaPath("jWalk2.jpg"));
    CharacterNode leftfoot = new CharacterNode(p.flip());
    start.setNext(rightfoot); rightfoot.setNext(center);
    center.setNext(leftfoot);
    // Now the scary one
    leftfoot.setNext(start);
    
    frames = new FrameSequencer("C:/Temp/");
    setUp();
  }
  
  /**
   * Setup to display walking left to right
   */
  private void setUp(){
    x = 0; // Left side
    y = 300; // 300 pixels down
    frames.show();
    this.start();
  }
  
  /**
   * Start a walking sequence
   */
  public void start() { 
    current = start;
    this.draw();
  }
  
  /**
   * Draw the current character
   */
  public void draw() {
    Picture bg = new Picture(400,400);
    Turtle t = new Turtle(bg);
    t.setPenDown(false); 
    t.moveTo(x,y);
    current.drawWith(t);
    frames.addFrame(bg);
  }
  
  /**
   * Draw the next step
   */
  public void step(){
    current = (CharacterNode) current.getNext();
    x=x+10; // We'll try this
    this.draw();
  }
  
  /**
   * Draw a few steps
   */
  public void steps(int num){
    for (int i=0; i < num; i++) {this.step();}}
  
  /**
   * Delegate replay
   */
  public void replay(int delay){
    frames.replay(delay);
  }
  
  /** Main for testing */
  public static void main(String[] args) {
    WalkingKid j = new WalkingKid(); 
    j.steps(30);
  }
  
}
