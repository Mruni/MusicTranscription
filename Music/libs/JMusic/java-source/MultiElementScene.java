/**
 * Demonstration of using both SceneElementPositioned and
 * ScenceElementLayered
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class MultiElementScene {
  
  public static void main(String[] args) {
    
    // We'll use this for filling the nodes
    Picture p = null;
    
    p = new Picture(FileChooser.getMediaPath("swan.jpg"));
    SceneElement node1 = new SceneElementPositioned(p.scale(0.25));
                                             
    p = new Picture(FileChooser.getMediaPath("horse.jpg"));
    SceneElement node2 = new SceneElementPositioned(p.scale(0.25));
    
    p = new Picture(FileChooser.getMediaPath("dog.jpg"));
    SceneElement node3 = new SceneElementLayered(p.scale(0.25),10,50);

    p = new Picture(FileChooser.getMediaPath("flower1.jpg"));
    SceneElement node4 = new SceneElementLayered(p.scale(0.5),10,30);

    p = new Picture(FileChooser.getMediaPath("graves.jpg"));
    SceneElement node5 = new SceneElementPositioned(p.scale(0.25));

    node1.setNext(node2); node2.setNext(node3);
    node3.setNext(node4); node4.setNext(node5);
    
    // Now, let's see it!
    Picture bg = new Picture(600,600);
    node1.drawFromMeOn(bg);
    bg.show();
  }
}
