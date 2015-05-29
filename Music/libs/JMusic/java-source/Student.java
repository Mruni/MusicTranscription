/**
 * Class that represents a student.  A student
 * is a person and has a unique id
 * @author Mark Guzdial
 * @author Barb Ericson
 */
  public class Student extends Person {
  
  /////////////////// fields ///////////////////
  
  /** a unique identifier for this person */
  private int id;
  
  /////////////////// constructors  ////////////
  
  /** 
   * Constructor that takes no arguments
   */
  public Student() {
    super(); //Call the parent's constructor
    id = -1;
  }
  
  /**
   * Constructor that takes the student's name
   * @param name the name for this student
   */
  public Student(String name) {
    super(name);
    id = -1;
  }
  
  //////////// methods //////////////////////////
  
  /**
   * Method to get the id
   * @return the identifier
   */
  public int getId() { return this.id;}
  
  /**
   * Method to set the identifier
   * @param theId the identifier to use
   */
  public void setId(int theId) {this.id = theId;}

  /**
   * Method to greet someone
   */
  public void greet() {
    System.out.println("Hi! I'm " + this.getName() +
                       " but I have to run to class...");
  }
}