/**
 * Class to implement a linked list of Turtle-like characters.
 * (Maybe "agents"?)
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class AgentNode extends LLNode {
  
  /** The Turtle being held by the agent node */
  private Turtle myTurtle;
  
  /** A constructor that takes no arguments */
  public AgentNode() {super();}
  
  /**
   * A constuctor that takes an agent
   */
  public AgentNode(Turtle agent) {
    super();
    this.setAgent(agent);
  }
  
  /** 
   * Method to return an information string
   * @return the information string
   */
  public String toString() {
    return "AgentNode with agent (" + myTurtle + 
      ") and next: " + (AgentNode) getNext();
  }
  
  /**
   * Method to set the agent turtle
   * @param agent the agent to use
   */
  public void setAgent(Turtle agent) {
    myTurtle = agent;
  }
  
  /**
   * Method to get the agent (the turtle)
   * @return the turtle used as an agent
   */
  public Turtle getAgent(){return myTurtle;}
  
  /**
   * Remove the node where the passed turtle is found.
   * @param myTurtle the turtle to remove
   */
  public void remove(Turtle myTurtle) {
    
    // Assume we're calling on the head
    AgentNode head = this;
    AgentNode current = (AgentNode) this.getNext();
    
    while (current != null) {
      if (current.getAgent() == myTurtle) {
        // If found the turtle, remove that node
        head.remove(current);
      }
      
      current = (AgentNode) current.getNext();
    }
  }
}
