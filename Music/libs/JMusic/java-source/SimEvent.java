/**
 * SimulationEvent (SimEvent) -- an event that occurs in a simulation,
 * like a truck arriving at a factory, or a salesperson leaving the
 * market
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class SimEvent implements Comparable<SimEvent> {
  
  //////////////////// Fields /////////////////////////
  
  /** the time that the event occurs */
  private double time;
  
  /** the discrete event agent that the event occurs to */
  private DEAgent whom;
  
  /** the type of event */
  private int message;
  
  ////////////////// Constructors //////////////////////////////
  
  /**
   * Constructor that takes values for all the fields
   * @param moi the agent
   * @param scheduledTime the event time
   * @param eventType the event type 
   */
  public SimEvent(DEAgent moi, double scheduledTime, int eventType){
    whom = moi;
    time = scheduledTime;
    message = eventType;
  }
  
  /**
   * Constructor that takes no arguments
   */
  public SimEvent(){
    whom = null;
    message = 0;
  }
  
  /////////////////////// methods ////////////////////////////////////////
  
  /**
   * Method to compare to another simulation event
   * @return pos if this is greater, 0 if they are equal
   * and negative if this is less than the other
   */
  public int compareTo(SimEvent other) {
    if (this.getTime() > other.getTime()) {
      return 1;
    } else if (this.getTime() < other.getTime()) {
      return -1;
    } else {
      return 0;
    }
  }
  
  /** 
   * Method to get the time the event occurs
   * @return the time the event occurs 
   */
  public double getTime() {return time;}
  
  /**
   * Method to set the time that the event occurs
   * myTime the time to use
   */
  public void setTime(double myTime) {time = myTime;}
  
  /**
   * Method to get the message
   * @return the message
   */
  public int getMessage() {return message;}
  
  /**
   * Method to set the message
   * @param newMsg the new message to use
   */
  public void setMessage(int newMsg) {message = newMsg;}
  
  /**
   * Method to get the discrete event agent
   * @return the discrete event agent 
   */
  public DEAgent getAgent() {return whom;}
  
}