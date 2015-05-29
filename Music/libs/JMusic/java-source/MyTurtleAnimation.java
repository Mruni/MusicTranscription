/**
 * An exmaple class for creating a turtle
 * animation
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class MyTurtleAnimation {
  
  private Picture canvas;
  private Turtle jenny;
  private FrameSequencer f;
  
  public MyTurtleAnimation() {
    
    canvas = new Picture(600,600);
    jenny = new Turtle(canvas);
    f = new FrameSequencer("C:/Temp/");
  }
  
  public void next() {
    Picture lilTurtle = new Picture(FileChooser.getMediaPath("Turtle.jpg"));
    jenny.turn(-20);
    jenny.forward(30);
    jenny.turn(30);
    jenny.forward(-5);
    jenny.drop(lilTurtle.scale(0.5));
    f.addFrame(new Picture(canvas));  // Try this as
    // f.addFrame(canvas);
  }
  
  public void next(int numTimes) {
    for (int i=0; i < numTimes; i++) {
      this.next();
    }
  }
  
  public void show() {
    f.show();
  }
  
  public void play(int framesPerSecond) {
    f.show();
    f.play(framesPerSecond);
  }
  
  public static void main(String[] args) {
    MyTurtleAnimation anim = new MyTurtleAnimation();
    anim.next(20);
    anim.play(16);
  }
}
