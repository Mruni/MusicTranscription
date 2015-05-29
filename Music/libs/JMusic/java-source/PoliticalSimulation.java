import java.awt.Color;

/**
 * PoliticalSimulation -- using the Simulation class
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class PoliticalSimulation extends Simulation {
  
  /** 
   * Fill the world with 60 persons
   */
  public void setUp() {
    
    // Let the world be set up
    super.setUp();
    
    // declare a political agent
    PoliticalAgent moi;
    
    // 60 people
    for (int num = 0; num < 60; num++) {
      moi = new PoliticalAgent(getWorld(),this);
      // First 30 are red
      if (num < 30) {
        moi.setParty(Color.RED);
        moi.moveTo(100,100);
        PoliticalAgent.getRedPartyList().add(moi);
      }
      else {
        moi.setParty(Color.BLUE);
        moi.moveTo(500,100);
        PoliticalAgent.getBluePartyList().add(moi);
      }
      moi.setColor(moi.getParty());
      
    } // for loop
    
  } // setUp()
  
  /**
   * return an information string 
   * @return the information string with the number of each party 
   */
  public String toString() {
    
    return (PoliticalAgent.getRedPartyList().size() + "\t" +
     PoliticalAgent.getBluePartyList().size());
  }
  
  /**
   * EndStep, count the number of each
   * @param t the current timestep
   */
  public void endStep(int t) {
    super.endStep(t);
    
    System.out.println("Red: " + 
                       PoliticalAgent.getRedPartyList().size() + 
                       " Blue: " + 
                       PoliticalAgent.getBluePartyList().size());
  }
  
}
