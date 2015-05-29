/**
 * Implementation of a stack as an array
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class ArrayStack<E> implements Stack<E> {
  
  /** default size of the array */
  private static final int ARRAY_SIZE = 20;
  
  /** Where we'll store our elements */
  private Object[] elements;

  /** Index where the top of the stack is */
  private int top;
  
  /**
   * No argument constructor 
   */
  public ArrayStack() {
    elements = new Object[ARRAY_SIZE];
    top = 0;
  }
  
  //// Methods ///
  
  /**
   * Method to add an element to the top of the stack
   * @param element the element to add
   */
  public void push(E element) {
    
    // New elements go at the top
    elements[top]=element;
    // then add to the top
    top++;
    if (top==ARRAY_SIZE) {
      System.out.println("Stack overflow!");
    }
  }
  
  /**
   * Method to return the top element on the stack
   * but not remove it.
   * @return the object at the top of the stack
   */
  public E peek() {
    if (top==0) {
      System.out.println("Stack empty!");
      return null;
    } else {
      // this will give a warning but it is unavoidable
      return (E) elements[top-1];
    }
  }
  
  /**
   * Method to remove and return the top element on the stack
   * @return the element on the top of the stack
   */
  public E pop() {
    E toReturn = this.peek();
    top--;
    return toReturn;
  }
  
  /** 
   * Method to return the number of elements in the stack
   * @return the number of elements in the stack
   */
  public int size(){return top;}
  
  /**
   * Method to check if the stack is empty
   * @return true if the stack is empty else false
   */
  public boolean isEmpty() {return this.size() == 0;}
  
  public static void main(String[] args) {
    Stack<String> stack = new ArrayStack<String>();
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
