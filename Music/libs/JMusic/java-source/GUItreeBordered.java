import javax.swing.*; // Need this to reach Swing components
import java.awt.*; // Need this to reach BorderLayout

/**
 * A GUI that has various components in it, to demonstrate
 * UI components and layout managers (rendering)
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class GUItreeBordered extends JFrame {
  
  public GUItreeBordered() {
    
    /* create the JFrame with the title */
    super("GUI Tree Bordered Example");
    
    /* set the layout manager to BorderLayout */
    this.getContentPane().setLayout(new BorderLayout());
    
    /* Put in a panel with a label in it */
    JPanel panel1 = new JPanel();
    this.getContentPane().add(panel1,BorderLayout.NORTH);
    JLabel label = new JLabel("This is panel 1!");
    panel1.add(label);
    
    /* Put in another panel with two buttons in it */
    JPanel panel2 = new JPanel();
    this.getContentPane().add(panel2,BorderLayout.SOUTH);
    JButton button1 = new JButton("Make a sound");
    panel2.add(button1);
    JButton button2 = new JButton("Make a picture");
    panel2.add(button2);
    
    /* set the size to fit the contents and show it */
    this.pack();
    this.setVisible(true);
  }
  
  /** test this class */
  public static void main(String[] args){
    GUItreeBordered gt = new GUItreeBordered();
  }
}
