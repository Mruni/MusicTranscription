import java.util.*;

/**
 * Implementation of a stack as an ArrayList
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class ArrayListStack<E> implements Stack<E> {
  
  /** Where we'll store our elements */
  private List<E> list = new ArrayList<E>();
  
  /**
   * No argument constructor 
   */
  public ArrayListStack() {
  }
  
  //// Methods ///
  
  /**
   * Method to add an element to the top of the stack
   * @param element the element to add
   */
  public void push(E element) {
    list.add(element);
  }
  
  /**
   * Method to return the top element on the stack
   * but not remove it.
   * @return the object at the top of the stack
   */
  public E peek() {
    return list.get(list.size() - 1);
  }
  
  /**
   * Method to remove and return the top element on the stack
   * @return the element on the top of the stack
   */
  public E pop() {
    return list.remove(list.size() - 1);
  }
  
  /** 
   * Method to return the number of elements in the stack
   * @return the number of elements in the stack
   */
  public int size(){return list.size();}
  
  /**
   * Method to check if the stack is empty
   * @return true if the stack is empty else false
   */
  public boolean isEmpty() {return this.size() == 0;}
  
  public static void main(String[] args) {
    Stack<String> stack = new ArrayListStack<String>();
    stack.push("Matt");
    stack.push("Katie");
    stack.push("Jenny");
    System.out.println(stack.size()); 
    System.out.println(stack.peek());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
  }
}
