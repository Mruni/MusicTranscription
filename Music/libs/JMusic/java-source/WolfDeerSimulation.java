import java.io.*;  // For BufferedWriter

/** 
 * Class that does a predator and prey simulation
 * with wolves and deer
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class WolfDeerSimulation {
  
  /** a linked list of wolves */
  private AgentNode wolves;
  
  /** a linked list of deer */
  private AgentNode deer;
  
  /** Method to get the wolf linked list 
    * @return the first wolf in the linked list */
  public AgentNode getWolves(){return wolves;}
  
  /** Method to get the deer linked list
    * @return the first deer in the linked list */
  public AgentNode getDeer(){return deer;}
  
  /**
   * Run the simulation
   */
  public void run() {

    World w = new World();
    w.setAutoRepaint(false);
    
    // Start the lists
    wolves = new AgentNode();
    deer = new AgentNode();
    
    // create some deer
    int numDeer = 20;
    for (int i = 0; i < numDeer; i++) {
      deer.add(new AgentNode(new Deer(w,this)));
    }
    
    // create some wolves
    int numWolves = 5;
    for (int i = 0; i < numWolves; i++) {
      wolves.add(new AgentNode(new Wolf(w,this)));
    }
    
    // declare a wolf and deer
    Wolf currentWolf = null;
    Deer currentDeer = null;
    AgentNode currentNode = null;
    
    // loop for a set number of timesteps (50 here)
    for (int t = 0; t < 50; t++) {

      // loop through all the wolves
      currentNode = (AgentNode) wolves.getNext();
      while (currentNode != null) {
        currentWolf = (Wolf) currentNode.getAgent();
        currentWolf.act();
        currentNode = (AgentNode) currentNode.getNext();
      }
      
      // loop through all the deer
      currentNode = (AgentNode) deer.getNext();
      while (currentNode != null) {
        currentDeer = (Deer) currentNode.getAgent();
        currentDeer.act();
        currentNode = (AgentNode) currentNode.getNext();
      }
     
      // repaint the world to show the movement
      w.repaint();
      
      // Let's figure out where we stand...
      System.out.println(">>> Timestep: "+t);
      System.out.println("Wolves left: "+wolves.getNext().count());
      System.out.println("Deer left: "+deer.getNext().count());
      
      // Wait for one second
      //Thread.sleep(1000);
    }
  }
  
  /** Main for testing */
  public static void main(String[] args) {
    WolfDeerSimulation wds = new WolfDeerSimulation();
    wds.run();
  }
 
}
