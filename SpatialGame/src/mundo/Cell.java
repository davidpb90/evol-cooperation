package mundo;

public class Cell {
	 // -----------------------------------------------------------------
    // Fields
    // -----------------------------------------------------------------

   
    /**
     * Represents the strategy that the cell is using 
     */
	private int strategy;
   
	/**
	 * Represents the current fitness of the cell
	 */
	private double fitness;
	
	private boolean changes;
	

    
    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------

    /**
     * It builds a cell with 0 strategy and fitness. <br>
     * <b> post: </b> The cell was created. <br>
     */
    public Cell() 
    {
        
        strategy=0;
        fitness=0;
        changes=false;
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------
    /**
     * It gives the current strategy of the cell
     * @return 1 if it's a cooperator or 2 if it's a defector, 0 otherwise.
     */
    public int getStrategy( )
    {
        return strategy;
    }
    
    
    /**
     * It gives the current fitness of the cell
     * @return the fitness of the cell.
     */
    public double getFitness()
    {
    	return fitness;
    }
    
    public boolean getChanges()
    {
    	return changes;
    }
    
    

    
    /**
     * It changes the strategy of the cell. <br>
     * @param newStrategy: An integer between 0 and 2, 0->No strategy, 1->COOPERATOR, 2->DEFECTOR
     */
    public void setStrategy( int newStrategy )
    {
        strategy = newStrategy;
    }
    
    public void switchStrategy()
    {
    	if (strategy==1)
    		strategy=2;
    	else if(strategy==2)
    		strategy=1;
    	
    }
    
    public void changes(boolean ans)
    {
    	changes=ans;
    }
    
    /**
     * It changes the fitness of the cell. <br>
     * @param newFitness: A real between 0 and 1.
     */
    public void setFitness( double newFitness )
    {
        fitness = newFitness;
    }
  
}
