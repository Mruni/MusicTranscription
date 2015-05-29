/**
 * Class to define an abstract queue
 * @author Barb Ericson
 */
public abstract class AbstractQueue<E> implements Queue<E> {
  
  /** 
   * Push an object onto the Queue
   * @param element the element to add to the queue
   */
  public abstract void push(E element);
  
  /** 
   * Peek at, but don't remove, the head of the queue 
   * @return the head of the queue (top)
   */
  public abstract E peek();
  
  /** 
   * Pop an object from the Queue 
   * @return the head (top) of the queue and 
   * remove it from the queue
   */
  public abstract E pop();
  
  /** 
   * Return the size of a queue
   * @return the number of elements in the queue
   */
  public abstract int size();
  
  /**
   * Method to see if the queue is empty
   * @return true if the queue is empty, else false
   */
  public boolean isEmpty() {
    return (size() == 0);
  }
  
}