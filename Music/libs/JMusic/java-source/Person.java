/**
 * Class the represents a person
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class Person {
  
  /** the name of this person */
  private String name;
  
  /**
   * Constructor that takes no arguments
   */
  public Person() {
    this.setName("Not-yet-named");
  }
  
  /**
   * Constructor that takes a name
   * @param name the name to use
   */
  public Person(String name) {
    this.setName(name);
  }
  
  /**
   * Method that sets the name
   * @param someName the name to use
   */
  public void setName(String someName) {
    this.name = someName;
  }
  
  /**
   * Method to get the name
   * @return the name of this person
   */
  public String getName() {
    return this.name;
  }
  
  /**
   * Method to get an information string
   * @return the information string
   */
  public String toString() {
    return "Person named " + this.name;
  }
  
  /**
   * Method to greet another person
   */
  public void greet() {
    System.out.println("Hi! I am "+ this.name);
  }
  
  /** Main method for testing */
  public static void main(String [] args) {
    Person fred = new Person("Fred");
    Person barney = new Person("Barney");
    
    System.out.println("Fred is "+fred);
    System.out.println("Barney is "+barney);
  }
}