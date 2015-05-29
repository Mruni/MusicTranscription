import javax.swing.*; // Need this to reach Swing components
import java.awt.*; // Need this to reach FlowLayout
import java.awt.event.*; // Need this for listeners and events

/**
 * A Rhythm-constructing tool
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class RhythmTool extends JFrame {
  
  /** Base of the sound linked list that we're creating */
  private SoundElement root;
  
  /** Sound that we're creating to add in. */
  private SoundElement newSound;
  
  /** JTextField that holds the filename */
  private JTextField filenameField;
  
  /** JTextField that holds the count for repeat and weave */
  private JTextField countField;
  
  /** the number to use from the count field for repeat and weave */
  private int num;
  
  /**
   * Constructor that takes no arguments 
   */
  public RhythmTool(){
    
    /* init the JFrame with the title */
    super("Rhythm Tool");
    
    /* create the sound elements */
    root = new SoundElement(new Sound(1)); // Nearly empty sound
    newSound = new SoundElement(new Sound(1)); // Ditto
    
    // set the layout
    this.getContentPane().setLayout(new BorderLayout());
    
    /* First panel has new sound field */
    JPanel panel1 = new JPanel();
    // Put panel one at the top
    this.getContentPane().add(panel1,BorderLayout.NORTH);
    
    // Create a space for entering a new sound filename
    filenameField = new JTextField("soundfilename.wav",20);
    filenameField.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        /* When hit return in filename field,
         * create a new sound with that name.
         * Printing is for debugging purposes.
         */
        newSound = new SoundElement(new Sound(
              FileChooser.getMediaPath(filenameField.getText())));
        System.out.println("New sound from " +
                           FileChooser.getMediaPath(filenameField.getText()));
      }
    });
    panel1.add(filenameField);
    
    /* add a button for picking a file */
    JButton pickButton = new JButton("...");
    pickButton.setToolTipText("pick a sound file");
    pickButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String name = FileChooser.pickAFile();
        int posLast = name.lastIndexOf('/');
        if (posLast == -1)
          posLast = name.lastIndexOf('\\');
        filenameField.setText(name.substring(posLast+1));
        newSound = new SoundElement(new Sound(
              FileChooser.getMediaPath(filenameField.getText())));
        System.out.println("New sound from " +
                           FileChooser.getMediaPath(filenameField.getText()));
      }
    });
    panel1.add(pickButton);
    
    /* Put in another panel with number field */
    JPanel panel2 = new JPanel();
    // This layout is for the PANEL, not the WINDOW
    panel2.setLayout(new BorderLayout());
    // Add to MIDDLE of WINDOW
    this.getContentPane().add(panel2,BorderLayout.CENTER);
    // Add a field for arguments for Repeat and Weave
    countField = new JTextField("10");
    num = 10; // Default value
    countField.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // Here's how we convert a string to a number
        num = Integer.parseInt(countField.getText());
      }
    });
    // Add to top of panel
    panel2.add(countField,BorderLayout.NORTH);
    
    // Now do the Repeat button
    JButton button1 = new JButton("Repeat");
    button1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent e) {
        // Repeat the number of times specified
        root.repeatNext(newSound,num);
      }
    });
    // Add to RIGHT of PANEL
    panel2.add(button1,BorderLayout.EAST);
    
    // Now do the Weave button
    JButton button2 = new JButton("Weave");
    button2.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent e) {
        // We'll weave num copies in
        // every other sound
        root.weave(newSound,num,1);
      }
    });
    // Add to LEFT of PANEL
    panel2.add(button2,BorderLayout.WEST);
    
    /* Put in another panel with the Play and 
     * Explore button */
    JPanel panel3 = new JPanel();
    panel3.setLayout(new FlowLayout());
    // Put in bottom of WINDOW
    this.getContentPane().add(panel3,BorderLayout.SOUTH);
    JButton button3 = new JButton("Play");
    button3.addActionListener(new ActionListener() { 
      // If this gets triggered, play the composed sound
      public void actionPerformed(ActionEvent e) {
        root.playFromMeOn();
      }
    });
    panel3.add(button3); // No layout manager here
    
    JButton button4 = new JButton("Explore");
    button4.addActionListener(new ActionListener() { 
      // If this gets triggered, explore the sound
      public void actionPerformed(ActionEvent e) {
        root.collect().explore();
      }
    });
    panel3.add(button4); // No layout manager here
    
    this.pack();
    this.setVisible(true);
  }
  
  /** Main for testing */
  public static void main(String[] args){
    RhythmTool rt = new RhythmTool();
  }
}
