import java.io.*;

/** 
 * DSSimulation is a Discrete Event Simulation
 * Instead of asking each agent to act(),
 * we simply process events from a queue.
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class DESimulation extends Simulation {
  
  /** Queue for Events */
  private EventQueue events;
  
  /** current time */
  private double now;
  
  ///// Constructors ////
  
  /**
   * No argument constructor 
   */
  public DESimulation() {
    super(); // call the parent constructor
    now = 0.0;
    events = new EventQueue();
  }
  
  /**
   * No argument constructor 
   */
  public DESimulation(Picture bg) {
    super(bg);
    now = 0.0;
    events = new EventQueue();
  }
  
  //// Methods ////
  
  /** getTime -- return what time it is now. */
  public double getTime() {return now;}
  
  /** 
   * addEvent -- add an event to the queue 
   * @param newEvent the event to add 
   */
  public void addEvent(SimEvent newEvent) {
    events.add(newEvent);
  }
  
  /**
   * Log something -- write to the console or interactions pane,
   * And to the output file, if it exists.
   * @param msg the message to write
   */
  public void log(String msg) {
    BufferedWriter output = getOutput();
    String timeNow="Time: " + getTime() + ", ";
    System.out.println(timeNow + msg);
    
    // If we have an open file, write the msg to it
    if (output != null) {
      try {
        output.write(timeNow+msg);
        output.newLine();
      } catch (Exception ex) {
        System.out.println("Couldn't write the data!");
        System.out.println(ex.getMessage());
        // Make output null so that we don't keep trying
        output = null;
      }
    }
  }
  
  /**
   * Run until a certain time step is reached,
   * by calling setUp (which we hope creates the base
   * agents and schedules the first round of events), then
   * repeatedly processing an event from the eventQueue.
   * @param stopTime the time to stop
   */
  public void run(double stopTime) {
    SimEvent topEvent = null;
    DEAgent topAgent = null;
    World world = getWorld();
    
    // Set up the simulation
    this.setUp();
    
    // While we're not yet at the stop time,
    // and there are more events to process
    while ((now < stopTime) && 
           (!events.empty())) {
      topEvent = events.pop();
      
      // Whatever event is next, that time is now
      now = topEvent.getTime();
      
      // Let the agent know that its event has occurred
      topAgent = topEvent.getAgent();
      topAgent.processEvent(topEvent.getMessage());
      
      // repaint the world to show the movement
      // IF there is a world
      if (world != null) {
        world.repaint();
      }
      
      // Do the end of step processing
      this.endStep((int) now);
    }
  }
  
  /**
   * Run, by simply 
   */
  /*public void run()
   {
   // For storing the current agent
   Agent current = null;
   
   // Set up the simulation
   this.setUp();
   
   // loop for a set number of timesteps 
   for (int t = 0; t < timeRange; t++)
   {
   // loop through all the agents, and have them
   // act()
   for (int index=0; index < agents.size(); index++) {
   current = (Agent) agents.get(index);
   if (!current.blocked) { // NEW for resources
   current.act(t);} // pass in timestep
   }
   // Could separate acting from updating...
   
   // repaint the world to show the movement
   // IF there is a world
   if (world != null) {
   world.repaint();}
   
   // Do the end of step processing
   this.endStep(t);
   
   // Wait for one second
   //Thread.sleep(1000);
   }
   
   }*/
  
}
