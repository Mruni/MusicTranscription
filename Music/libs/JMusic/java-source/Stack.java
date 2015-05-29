/**
 * An abstract definition of a stack
 * @author Barb Ericson
 */
public interface Stack<E> {

  /**
   * Method to add the element to the top of the stack
   * @param element the element to add
   */
  public void push(E element);

  /**
   * Method to return the top element on the
   * stack, but not remove it from the stack
   * @return the top object from the stack
   */
  public E peek();

  /**
   * Method to remove the top element from the
   * stack and return it
   * @return the top element from the stack
   */
  public E pop();

  /**
   * Method to return the number of elements in
   * the stack
   * @return the number of elements in the stack

   */
  public int size();

  /**
   * Method to check if the stack is empty
   * @return true if empty, else false
   */
  public boolean isEmpty();
}