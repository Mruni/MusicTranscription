/**
 * Class to try out the EventQueue
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class EventQueueExercisor {
  
  public static void main(String[] args) {
    
    // Make an EventQueue
    EventQueue queue = new EventQueue();
    
    // Now, stuff it full of events, out of order.
    SimEvent event = new SimEvent();
    event.setTime(5.0);
    queue.add(event);
    
    event = new SimEvent();
    event.setTime(2.0);
    queue.add(event);
    
    event = new SimEvent();
    event.setTime(1.3);
    queue.add(event);
    
    event = new SimEvent();
    event.setTime(1.1);
    queue.add(event);
    
    event = new SimEvent();
    event.setTime(7.0);
    queue.add(event);
    
    event = new SimEvent();
    event.setTime(0.5);
    queue.add(event);
    
    event = new SimEvent();
    event.setTime(1.0);
    queue.add(event);
    
    // Get the events back, hopefully in order!
    for (int i=0; i < 7; i++) {
      event = queue.pop();
      System.out.println("Popped event time:" + event.getTime());
    }
  }
  
}
