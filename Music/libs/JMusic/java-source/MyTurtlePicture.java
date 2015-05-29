
/**
 * Example class of making a picture
 * using a turtle to drop a picture
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class MyTurtlePicture {
  
  public static void main(String [] args) {
    Picture canvas = new Picture(600,600);
    Turtle jenny = new Turtle(canvas);
    Picture lilTurtle =
      new Picture(
                  FileChooser.getMediaPath("Turtle.jpg"));
    
    for (int i=0; i <=40; i++) {
      
      if (i < 20) {
        jenny.turn(20);
      }
      else {
        jenny.turn(-20);
      }
      
      jenny.forward(40);
      jenny.drop(lilTurtle.scale(0.5));
    }
    canvas.show();
  }
}
