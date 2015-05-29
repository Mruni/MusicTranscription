/**
 * Class that shows an example of creating a collage
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class MyPicture {

  public static void main(String args[]) {

    Picture canvas = new Picture(600,600);
    Picture swan = new Picture(FileChooser.getMediaPath("swan.jpg"));
    Picture rose = new Picture(FileChooser.getMediaPath("rose.jpg"));
    Picture turtle = new Picture(FileChooser.getMediaPath("turtle.jpg"));

    swan.scale(0.5).compose(canvas,10,10);
    swan.scale(0.5).compose(canvas,350,350);
    swan.flip().scale(0.5).compose(canvas,10,350);
    swan.flip().scale(0.5).compose(canvas,350,10);
    rose.scale(0.25).compose(canvas,200,200);
    turtle.scale(2.0).compose(canvas,10,200);
    canvas.show();
  }
}