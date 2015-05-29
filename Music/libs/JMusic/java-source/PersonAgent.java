import java.awt.Color; // Color for colorizing
import java.util.LinkedList;
import java.util.Iterator;

/**
 * PersonAgent -- Person as a subclass of Agent
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class PersonAgent extends Agent {
  
  /** true if infected */
  private boolean infected;
  
  ////////////////////////////// Constructors ////////////////////////
  // Copy this section AS-IS into subclasses, but rename 
  
  /**
   * Constructor that takes the model display (the original
   * position will be randomly assigned) and the simulation
   * @param modelDisplayer thing that displays the model
   * @param thisSim my simulation
   */
  public PersonAgent (ModelDisplay modelDisplayer,Simulation thisSim) {
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
  public PersonAgent (int x, int y, ModelDisplay modelDisplayer, 
                      Simulation thisSim) {
    // let the parent constructor handle it
    super(x,y,modelDisplayer,thisSim);
  }
  
  /**
   * Initialize, by setting color and making the person 
   * move fast
   */
  public void init(Simulation thisSim) {
    
    // Do the normal initializations
    super.init(thisSim);
    
    // Make it lightGray
    setColor(Color.LIGHT_GRAY);
    
    // Don't need to see the trail
    setPenDown(false);
    
    // Start out uninfected
    infected = false;
    
    // Make the speed large
    setSpeed(100);
  }
  
  /**
   * Count the number infected
   * @return the number of people infected
   */
  public int getNumInfected() {
    int count = 0;
    LinkedList agents = getSimulation().getAgents();
    PersonAgent check;
    Iterator itr = agents.iterator();
    
    while (itr.hasNext()) {
      check = (PersonAgent) itr.next();
      if (check.infected) {count++;}
    }
    return count;
  }
  
  /**
   * Become infected - set infected to true
   */
  public void infect() {
    this.infected = true;
    this.setColor(Color.RED);
    
    // Print out count of number infected
    System.out.println("Number infected: " + getNumInfected());
  }
  
  /**
   * How a Person acts
   */
  public void act() {
    
    // Is there a person within infection range of me?
    Simulation sim = getSimulation();
    PersonAgent closePerson = 
      (PersonAgent) getClosest(20,
                               sim.getAgents());
    
    if (closePerson != null) {
      // If this person is infected, and I'm not infected
      if (closePerson.infected && !this.infected) {
        // I become infected
        this.infect();
      }
    }
    
    // Run the normal act() -- wander aimlessly
    super.act();
  }
  
}
