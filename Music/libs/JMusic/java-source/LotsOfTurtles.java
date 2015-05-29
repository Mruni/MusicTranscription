/**
 * Class to show how to make a circle with
 * lots of turtles
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class LotsOfTurtles {
  
  public static void main(String[] args) {
    
    // Create a world
    World myWorld = new World();
    // A flotilla of turtles in an array
    Turtle [] myTurtles = new Turtle[100];
    
    // Make a hundred turtles
    for (int i=0; i < 100; i++) {
      myTurtles[i] = new Turtle(myWorld);
    }
    
    //Tell them all what to do
    for (int i=0; i < 100; i++) {
      // Turn a random amount between 0 and 360
      myTurtles[i].turn((int) (360 * Math.random()));
      // Go 100 pixels
      myTurtles[i].forward(100);
    }
  }
}