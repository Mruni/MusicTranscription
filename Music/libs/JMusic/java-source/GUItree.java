import javax.swing.*; // Need this to reach Swing components

/**
 * A GUI that has various components in it, to demonstrate
 * UI components and layout managers (rendering)
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class GUItree extends JFrame {
  
  /**
   * Constructor that takes no arguments
   */
  public GUItree() {
    
    /* create the JFrame with the title */
    super("GUI Tree Example");
    
    /* Put in a panel with a label in it */
    JPanel panel1 = new JPanel();
    this.getContentPane().add(panel1);
    JLabel label = new JLabel("This is panel 1!");
    panel1.add(label);
    
    //NOTICE THAT THIS IS COMMENTED OUT!
    // Put in another panel with two buttons in it 
    JPanel panel2 = new JPanel();
    this.getContentPane().add(panel2);
    JButton button1 = new JButton("Make a sound");
    panel2.add(button1);
    JButton button2 = new JButton("Make a picture");
    panel2.add(button2);
    //
    
    /* set the size to fit the contents and show it */
    this.pack();
    this.setVisible(true);
  }
  
  /** test this class */
  public static void main(String[] args){
    GUItree gt = new GUItree();
  }
}

