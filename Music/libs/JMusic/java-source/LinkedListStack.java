import java.util.LinkedList; // Need for LinkedList

/**
 * Class that represents a stack using a linked list
 * of objects
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class LinkedListStack<E> implements Stack<E> {
  
  /** Where we store the elements */
  private LinkedList<E> elements;
  
  /**
   * Constructor that takes no arguments
   */
  public LinkedListStack() {
    elements = new LinkedList<E>();
  }
  
  //// Methods ///
  
  /**
   * Method to add an element to the stack
   * @param element the element to add
   */
  public void push(E element) {
    // New elements go at the front
    elements.addFirst(element);
  }
  
  /**
   * Method to return the top element on the stack
   * but leave the element on the stack
   * @return the top element on the stack
   */
  public E peek() {
    return elements.getFirst();
  }
  
  /**
   * Method to remove the top element from a stack
   * and return it
   * @return the top element from the stack and remove it
   */
  public E pop() {
    E toReturn = this.peek();
    elements.removeFirst();
    return toReturn;
  }
  
  /**
   * Method to get the number of elements in the stack
   * @return the number of elements in the stack
   */
  public int size(){return elements.size();}
  
  /**
   * Method to test if the stack is empty
   * @return true if the stack is empty, else false
   */
  public boolean isEmpty() {
    return (size() == 0);
  }
}
