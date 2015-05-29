import java.awt.Color; // Color for colorizing
import java.util.LinkedList;

/**
 * PoliticalAgent -- Red or Blue Stater as a subclass of Agent
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class PoliticalAgent extends Agent {
  
  /** Red or Blue to indicate this agents political party */
  private Color party;
  
  /** resistance to change this agent's party */
  private int resistance;
  
  /** a linked list of the redParty agents */
  private static LinkedList<PoliticalAgent> redPartyList = 
    new LinkedList<PoliticalAgent>();
  
  /** a linked list of the blueParty agents */
  private static LinkedList<PoliticalAgent> bluePartyList = 
    new LinkedList<PoliticalAgent>();
  
  ////////////////////////////// Constructors ////////////////////////
  // Copy this section AS-IS into subclasses, but rename 
  
  /**
   * Constructor that takes the model display (the original
   * position will be randomly assigned) and the simulation
   * @param modelDisplayer thing that displays the model
   * @param thisSim my simulation
   */
  public PoliticalAgent (ModelDisplay modelDisplayer,
                         Simulation thisSim) {
    super(randNumGen.nextInt(modelDisplayer.getWidth()),
          randNumGen.nextInt(modelDisplayer.getHeight()),
          modelDisplayer, thisSim);
  }
  
  /** Constructor that takes the x and y, a model
    * display to draw it on, and a simulation
    * @param x the starting x position
    * @param y the starting y position
    * @param modelDisplayer the thing that displays the model
    * @param thisSim my simulation
    */
  public PoliticalAgent (int x, int y, ModelDisplay modelDisplayer, 
                         Simulation thisSim) {
    // let the parent constructor handle it
    super(x,y,modelDisplayer,thisSim);
  }
  
  /** 
   * Return the linked list of red party agents
   * @return the linked list of red party agents
   */
  public static LinkedList<PoliticalAgent> getRedPartyList() {
    return redPartyList;
  }
  
  /** 
   * Return the linked list of blue party agents
   * @return the linked list of blue party agents
   */
  public static LinkedList<PoliticalAgent> getBluePartyList() {
    return bluePartyList;
  }
  
  /**
   * Method to get the party
   * @return the party (as a Color)
   */
  public Color getParty() { return this.party; }
  
  /**
   * Initialize the simulation
   * @param thisSim the simulation
   */
  public void init(Simulation thisSim) {
    
    // Do the normal initializations
    super.init(thisSim);
    
    // Don't need to see the trail
    setPenDown(false);
    
    // Speed is 100
    setSpeed(100);
    resistance = 0;
    
  }
  
  /**
   * Set the party
   * @param pref the new party to use
   */
  public void setParty(Color pref) {
    System.out.println("I am " + party + " converting to " + pref);
    
    if (pref == Color.RED) {
      bluePartyList.remove(this);
      redPartyList.add(this);
      this.party = pref;
    }
    else {
      bluePartyList.add(this);
      redPartyList.remove(this);
      this.party = pref;
    }
    this.setColor(pref);
    resistance = 3; 
  }
  
  /**
   * How a PoliticalAgent acts
   */
  public void act() {
    
    // reduce the resistance
    this.resistance--;
    
    // What are the number of blues and red near me?
    int numBlue = countInRange(30,bluePartyList);
    int numRed = countInRange(30,redPartyList);
    /*System.out.println("I am " + politics + " and near me are red:"
     + numRed + " and blue:" + numBlue);*/
    if (party==Color.RED) {
      // If I'm red, and there are more blue than red near me, convert
      if ((numBlue > numRed) && (this.resistance <= 0)) {
        setParty(Color.blue);
      }
    }
    if (party==Color.BLUE) {
      // If I'm blue, and there are more red than blue near me, convert
      if ((numRed > numBlue) && (this.resistance <= 0)) {
        setParty(Color.RED);
      }
    }
    
    // Run the normal act() -- wander aimlessly
    super.act();
    
    // But don't let them wander too far!
    // Let them mix only in the middle
    if (party==Color.RED) {
      if (this.getXPos() > 400) { // Did I go too far right?
        this.moveTo(200,this.getYPos());
      }
    }
    if (party==Color.BLUE) {
      if (this.getXPos() < 200) { // Did I go too far left?
        this.moveTo(400,this.getYPos());
      }
    }
  }
  
}
