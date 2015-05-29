import java.util.*; // LinkedList representation

/**
 * Implements a simple queue using a linked list
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class LinkedListQueue<E> extends AbstractQueue<E> {
  
  /** Where we'll store our elements */
  private LinkedList<E> elements;
  
  /**
   * No argument constructor 
   */
  public LinkedListQueue() {
    elements = new LinkedList<E>();
  }
  
  /// Methods
  
  /** 
   * Push an element onto the tail of the Queue 
   * @param element the element to add to the queue
   */
  public void push(E element) {
    elements.addFirst(element);
  }
  
  /** 
   * Peek at, but don't remove, top (first) of queue 
   * @return the first object in the queue
   */
  public E peek() {
    return elements.getLast();
  }
  
  /** 
   * Pop an object from the Queue 
   * @return the top object from the queue (and remove it)
   */
  public E pop() {
    E toReturn = this.peek();
    elements.removeLast();
    return toReturn;
  }
  
  /** 
   * Return the size of a queue 
   * @return the number of elements in the queue
   */
  public int size() { return elements.size(); }
  
  /**
   * Method to see if the queue is empty
   * @return true if the queue is empty, else false
   */
  // commented out since inherited from AbstractQueue
  // public boolean isEmpty() { return size() == 0; }
  
  /** Main method for testing */
  public static void main (String[] args) {
    Queue<String> line = new LinkedListQueue<String>();
    line.push("Fred");
    line.push("Mary");
    line.push("Jose");
    System.out.println(line.size());
    System.out.println(line.peek()); // without ending ';' prints the result
    System.out.println(line.pop());
    System.out.println(line.peek());
    System.out.println(line.pop());
    System.out.println(line.peek());
    System.out.println(line.pop());
  }
}