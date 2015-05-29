/**
 * Resource class -- manages agents requesting a resource
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class Resource {
  
  //////////// Fields /////////
  
  /** Amount of resource available */
  private int amount;
  
  /** Queue of who's waiting for resource */
  private Queue blocked; 
  
  //// Constructors ////
  
  /**
   * Start out with no resource and an empty queue
   */
  public Resource() {
    amount = 0;
    blocked = new LinkedListQueue();
  }
  
  /** 
   * Method to get the amount available
   * @return the amount 
   */
  public int amountAvailable() {return amount;}
  
  /** 
   * Consume resource 
   * @param amtDesired the amount desired 
   */
  public void consume(int amtDesired){
    amount = amount - amtDesired;
  }
  
  /**
   * Add more produced resource.
   * Is there enough to unblock the first 
   * Agent in the Queue?
   * @param production the amount produced
   */
  public void add(int production) {
    amount = amount + production;
    
    if (!blocked.isEmpty()) {
      // Ask the next Agent in the queue if it can be unblocked
      DEAgent topOne = (DEAgent) blocked.peek();
      // Is it ready to run given this resource?
      if (topOne.isReady(this)) {
        // Remove it from the queue
        topOne = (DEAgent) blocked.pop();
        // And tell it it's unblocked
        topOne.unblocked(this);
      }
    }
  }
  
  /**
   * addToList -- add this agent to
   * this resource's waiting list.
   * @param agent the agent to add as waiting
   */
  public void addToList(DEAgent agent) {
    blocked.push(agent);
  }
}
