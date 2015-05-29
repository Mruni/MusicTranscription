/**
 * Class that represents a binary tree node
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class TreeNode {
  
  /** the data stored at this node */
  private String data;
  
  /** the left child */
  private TreeNode left;
  
  /** the right child */
  private TreeNode right;
  
  /**
   * Constructor that takes the string
   * to store 
   * @param something the string to store
   */
  public TreeNode(String something) {
    data = something;
    left = null;
    right = null;
  }
  
  /** 
   * Method to return the data
   * @return the string data at this node 
   */
  public String getData() { return data; }
  
  /**
   * Method to set the data at this node
   * @param something the data to use
   */
  public void setData(String something){data = something;}
  
  /**
   * Method to get the left child
   * @return the left child (may be null)
   */
  public TreeNode getLeft() {return left;}
  
  /**
   * Method to get the right child
   * @return the right child (may be null)
   */
  public TreeNode getRight() {return right;}
  
  /**
   * Method to set the left child
   * @param newLeft the new left child 
   */
  public void setLeft(TreeNode newLeft){left = newLeft;}
  
  /**
   * Method to set the right child
   * @param newRight the new right child
   */
  public void setRight(TreeNode newRight)
  {right = newRight;}
  
  /**
   * Method to return a string of information
   * @return the information string
   */
  public String toString() {
    return
      "This: " + this.getData()+
      " Left: " + this.getLeft() +
      " Right: " + this.getRight();
  }

}