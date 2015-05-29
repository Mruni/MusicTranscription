import java.util.*;

/**
 * EventQueue
 * It's called an event "queue," but it's not really.
 * Instead, it's a list (could be an array, could be a linked list)
 * that always keeps its elements in time sorted order.
 * When you get the nextEvent, you KNOW that it's the one
 * with the lowest time in the EventQueue
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class EventQueue {

  /** a linked list of elements */
  private LinkedList<Object> elements;

  /// Constructors ////////////////

  /**
   * No argument constructor
   */
  public EventQueue() {
    elements = new LinkedList<Object>();
  }

  /**
   * Add the event.
   * The Queue MUST remain in order, from lowest time to highest.
   * @param myEvent the event to add
   */
  public void add(SimEvent myEvent) {
    // Option one: Add then sort
    elements.add(myEvent);
    this.sort();
    // Option two: Insert into order
    //this.insertInOrder(myEvent);
  }

  /**
   * see the first element but don't remove it
   * @return the first element in the queue
   */
  public SimEvent peek() {
    return (SimEvent) elements.getFirst();
  }

  /**
   * remove the top element from the queue and
   * return it.
   * @return the top element
   */
  public SimEvent pop() {
    SimEvent toReturn = this.peek();
    elements.removeFirst();
    return toReturn;
  }

  /**
   * Return the number of elements in the queue
   * @return the number of elements in the queue
   */
  public int size() {return elements.size();}

  /**
   * Check if the queue is empty
   * @return true if empty else false
   */
  public boolean empty() {return this.size() == 0;}

  /**
   * Add the new element into the linked list of
   * elements, assuming
   * that it's already in order.
   * @param thisEvent the one to add
   */
  public void insertInOrder(SimEvent thisEvent) {
    SimEvent comparison = null;

    // Have we inserted yet?
    boolean inserted = false;
    for (int i=0; i < elements.size(); i++) {
      comparison = (SimEvent) elements.get(i);

      // Assume elements from 0..i are less than thisEvent
      // If the element time is GREATER, insert here and
      // shift the rest down
      if (thisEvent.getTime() < comparison.getTime()) {
        //Insert it here
        inserted = true;
        elements.add(i,thisEvent);
        break; // We can stop the search loop
      }
    } // end for

    // Did we get through the list without finding something
    // greater?  Must be greater than any currently there!
    if (!inserted) {
      // Insert it at the end
      elements.addLast(thisEvent);
    }
  }

  /**
   * Sort the events in the linked list using an insertion
   * sort
   */
  public void sort() {

    // For comparing to elements at smaller indices
    SimEvent considered = null;
    SimEvent compareEvent = null; // Just for use in loop
    // Smaller index we're comparing to
    int compare;

    // Start out assuming that position 0 is "sorted"
    // When position==1, compare elements at indices 0 and 1
    // When position==2, compare at indices 0, 1, and 2, etc.
    for (int position=1; position < elements.size(); position++) {
      considered = (SimEvent) elements.get(position);
      // Now, we look at "considered" versus the elements
      // less than "compare"
      compare = position;

      // While the considered event is greater than the compared event ,
      // it's in the wrong place, so move the elements up one.
      compareEvent = (SimEvent) elements.get(compare-1);
      while (compareEvent.getTime() >
             considered.getTime())  {
        elements.set(compare,elements.get(compare-1));
        compare = compare-1;
        // If we get to the end of the array, stop
        if (compare <= 0) {
          break;
        }
        // else get ready for the next time through the loop
        else {
          compareEvent = (SimEvent) elements.get(compare-1);
        }
      }
      // Wherever we stopped, this is where "considered" belongs
      elements.set(compare,considered);
    } // for all positions 1 to the end
  } // end of sort()

} // end of class