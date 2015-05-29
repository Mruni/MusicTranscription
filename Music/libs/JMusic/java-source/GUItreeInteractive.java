import javax.swing.*; // Need this to reach Swing components
import java.awt.*; // Need this to reach FlowLayout
import java.awt.event.*; // Need this for listeners and events

/**
 * A GUI that has various components in it, to demonstrate
 * UI components and layout managers (rendering).
 * Now with Interactivity!
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class GUItreeInteractive extends JFrame {
  
  /**
   * Constructor that takes no arguments 
   */
  public GUItreeInteractive() {
    
    /* create the JFrame with the title */
    super("GUI Tree Interactive Example");
    
    /* set the layout to flow layout */
    this.getContentPane().setLayout(new FlowLayout());
    
    /* Put in a panel with a label in it */
    JPanel panel1 = new JPanel();
    this.getContentPane().add(panel1);
    JLabel label = new JLabel("This is panel 1!");
    panel1.add(label);
    
    /* Put in another panel with two buttons in it */
    JPanel panel2 = new JPanel();
    this.getContentPane().add(panel2);
    JButton button1 = new JButton("Make a sound");
    // Here's the listener
    button1.addActionListener(
                              new ActionListener() { 
      // Here's the method we're overriding
      public void actionPerformed(ActionEvent fred) {
        Sound s = new Sound(FileChooser.getMediaPath("aah.wav"));
        s.play();
      }
    }
    );
    panel2.add(button1);
    
    JButton button2 = new JButton("Make a picture");
    // Here's the listener
    button2.addActionListener(
                              new ActionListener() { 
      // Here's the method we're overriding
      public void actionPerformed(ActionEvent mabel) {
        Picture p = new Picture(FileChooser.getMediaPath("shops.jpg"));
        p.show();
      }
    }
    );
    panel2.add(button2);
    
    /* set the size to fit the contents and show it */
    this.pack();
    this.setVisible(true);
  }
  
  /** test this class */
  public static void main(String[] args){
    GUItreeInteractive gt = new GUItreeInteractive();
  }
}
