/**
 * DiseaseSimulation -- using the Simulation class
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class DiseaseSimulation extends Simulation {
  
  /** 
   * Initialize the world for the simulation.
   * Fill the world with 60 persons, one sick
   */
  public void setUp() {
    
    // Let the world be set up
    super.setUp();
    // or Set it up with a smaller world
    //world = new World(300,300);
    //world.setAutoRepaint(false);
    
    PersonAgent moi;
    
    // 60 people
    for (int num = 0; num < 60; num++) {
      moi = new PersonAgent(getWorld(),this);
    }
    
    // Infect the first one
    moi = (PersonAgent) getAgents().get(0);
    moi.infect(); 
  }
  
  /**
   * create an information string with the number infected
   * @return the number infected as a string
   */
  public String toString() {
    PersonAgent first;
    first = (PersonAgent) getAgents().get(0);
    return (new Integer(first.getNumInfected()).toString());
  }
  
  /** Main for testing */
  public static void main(String[] args) {
    DiseaseSimulation ds2 = new DiseaseSimulation();
    ds2.openFile("C:/dsBook/disease-fullsize.txt");
    ds2.run();
  }
  
}
