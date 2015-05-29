/**
 * Implements a simple queue using an array
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class ArrayQueue<E> extends AbstractQueue<E> {
  
  /** constant for the size of the queue */
  private static final int ARRAY_SIZE = 20;
  
  /** Where we'll store our elements */
  private Object[] elements;
  
  /** The index of the head */
  private int head;
  
  /** The index of the tail */
  private int tail;
  
  /**
   * No argument constructor
   */
  public ArrayQueue() {
    elements = new Object[ARRAY_SIZE];
    head = 0;
    tail = 0;
  }
  
  /// Methods
  
  /** 
   * Push an element onto the tail of the Queue
   * @param element the element to add to the queue
   */
  public void push(E element) {
    if ((tail + 1) >= ARRAY_SIZE) {
      System.out.println("Queue underlying implementation failed");
    }
    else {
      // Store at the tail,
      // then increment to a new open position
      elements[tail] = element;
      tail++;
    }
  }
  
  /** 
   * Peek at, but don't remove, the head of the queue 
   * @return the head of the queue (top)
   */
  public E peek() {
    // this will give a warning but there is no way around it
    return (E) elements[head];
  }
  
  /** 
   * Pop an object from the Queue 
   * @return the head (top) of the queue and 
   * remove it from the queue
   */
  public E pop() {
    E toReturn = this.peek();
    if (((head + 1) >= ARRAY_SIZE) || 
        (head > tail)) {
      System.out.println("Queue underlying implementation failed.");
      return toReturn;
    }
    else {
      // Increment the head forward, too.
      head++;
      return toReturn;
    }
  }
  
  /** 
   * Return the size of a queue
   * @return the number of elements in the queue
   */
  public int size() { return tail-head;}
  
  /**
   * Method to see if the queue is empty
   * @return true if the queue is empty, else false
   */
  // commented out since inherited from AbstractQueue
  // public boolean isEmpty() { return size() == 0; }
  
  /** Main method for testing */
  public static void main (String[] args) {
    Queue<String> line = new ArrayQueue<String>();
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