package mundo;

//import java.util.Properties;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;


public class Game {
	



	/**
	 * Class that represents a game
	 */
	
	    // -----------------------------------------------------------------
	    // Constants
	    // -----------------------------------------------------------------



	    /**
	     * It represents the number of rows of the board
	     */
	    public static final int POPULATION = 32;
	    
	    /** 
	     * It represents the strategy of cooperation
	     */
	    public static final int COOPERATOR = 1;
	    
	    /**
	     * It represents the strategy of defection
	     */
	    public static final int DEFECTOR = 2;
	    
	    /**
	     * It gives the matrix element for cooperator-cooperator interaction
	     */
	    public static final double CC = 1;//R
	    
	    /**
	     * It gives the matrix element for cooperator-defector interaction
	     */
	    public static final double CD = 1;//S
	    
	    /**
	     * It gives the matrix element for defector-cooperator interaction
	     */
	    public static final double DC = 1;//T
	    
	    /**
	     * It gives the matrix element for defector-defector interaction
	     */
	    public static final double DD = 0;//P
	    
	    
	    public static final double THRESHOLD=0.5;

	   
 
	    // -----------------------------------------------------------------
	    // Fields
	    // -----------------------------------------------------------------

	    
	    /**
	     * The matrix of cells of the board
	     */
	    private Cell[][] cells;
	    
	    /**
	     * Number of cells 
	     */
	    
	    private Cell[][][] neighbors;
	    
	    private double density;
	    
	    private int population;

	    // -----------------------------------------------------------------
	    // Constructors
	    // -----------------------------------------------------------------

	    /**
	     * Constructor method of the game. <br>
	     * <b> post: </b> cells!=null.<br>
	     * @throws Null Pointer Exception if a cell doesn't exist. 
	     */
	    public Game( ) throws Exception
	    {
	    	population=POPULATION;
	    	cells = new Cell[population][population];
	        neighbors= new Cell[population][population][8];
	        density=0;
	        
	        
	        //Initializes the game with a small population of cooperators in the center
	        
	        /**
	        for (int i=0;i<population;i++)
	        {
	        	for (int j=0;j<population;j++)
	        	{
	        		cells[i][j]=new Cell();
	        		
	        		
	        		cells[i][j].setStrategy(DEFECTOR);
	        		
	        		if(48<=i && i<=51)
	        		{
	        			if(48<=j && j<=51)
	        			{
	        				cells[i][j].switchStrategy();
	        			}
	        		}
	        		for(int k=0;k<8;k++)
	        		{
	        			neighbors[i][j][k]=new Cell();
	        		}
	        	}
	        }
	        */
	        
	        //Initializes the game with approximately the same population of cooperators and defectors
	        
	        Random randomGenerator = new Random();
	        for (int i=0;i<population;i++)
	        {
	        	for (int j=0;j<population;j++)
	        	{
	        		cells[i][j]=new Cell();
	        		double random = randomGenerator.nextDouble();
	        		if(random<0.1)
	        		{
	        			cells[i][j].setStrategy(COOPERATOR);
	        		}
	        		else
	        		{
	        			cells[i][j].setStrategy(DEFECTOR);
	        		}
	        		for(int k=0;k<8;k++)
	        		{
	        			neighbors[i][j][k]=new Cell();
	        		}
	        	}
	        }
	        
	        
	    	
	        
	    }

	    // -----------------------------------------------------------------
	    // Methods
	    // -----------------------------------------------------------------

	  
	    public int getPopulation()
	    {
	    	return population;
	    }
	    
	    public void setPopulation(int pop)
	    {
	    	population=pop;
	    }
	    
	    /**
	     * It generates an initial state with random population of certain density.
	     */
	    public void randomInitial(double den)
	    {
	    	 Random randomGenerator = new Random();
		        for (int i=0;i<population;i++)
		        {
		        	for (int j=0;j<population;j++)
		        	{
		        		cells[i][j]=new Cell();
		        		double random = randomGenerator.nextDouble();
		        		if(random<den)
		        		{
		        			cells[i][j].setStrategy(COOPERATOR);
		        		}
		        		else
		        		{
		        			cells[i][j].setStrategy(DEFECTOR);
		        		}
		        		for(int k=0;k<8;k++)
		        		{
		        			neighbors[i][j][k]=new Cell();
		        		}
		        	}
		        }
	    }
	    
	    private int mod(int x)
	    {
	        int result = x % population;
	        if (result < 0)
	        {
	            result += population;
	        }
	        return result;
	    }
	    /**
	     * It creates the lists of the neighbors of each cell. 
	     * @return neighbors: the list of the neighbors of each cell.
	     */
	    public void defineNeighbors() 
	    {
	    	
	    	
	    	for (int i=0;i<population;i++)
	    	{	
	    		for (int j=0;j<population;j++)
	    		{
	    			
	    			for (int k=0;k<3;k++)
	    			{
	    				
	    				neighbors[i][j][k]=cells[mod(i-1)][mod(j-1+k)];
	    				
	    			
	    				
	    				neighbors[i][j][k+3]=cells[i][mod(j-1+k)];
	    				
	    				
	    				
	    				
	    				neighbors[i][j][k+5]=cells[mod(i+1)][mod(j-1+k)];
	    				
	    			
	    				
	    				
	    				
	    			}
	    				
	    			
	    		}
	    	}
	    	
	    }
	    
	    
	   
	    /**
	     * It corresponds to one time step in which the fitness of each cell is calculated.
	     */
	    public void calculateFitness(double s, double t) throws Exception
	    {
	   
	    	
	    	
	    	for(int i=0;i<population;i++)
	    	{
	    		
	    		for(int j=0;j<population;j++)
		    	{
	    			double fitness=0;
	    			
	    			if(cells[i][j].getStrategy()==COOPERATOR)
	    			{
	    				
	    				for(int k=0;k<8 ;k++)
	    				{
	    					if(k!=4)
	    					{	
	    						if(neighbors[i][j][k].getStrategy()==COOPERATOR)
	    						{
	    							fitness=fitness+CC;
	    						}
	    						else if(neighbors[i][j][k].getStrategy()==DEFECTOR)
	    						{
	    							fitness=fitness+s;
	    						}
	    						else
	    						{	
	    							throw new Exception("The cell has no defined strategy1"+k);
	    						}
	    					}
	    				}
	    				
	    			}
	    			
	    			else if(cells[i][j].getStrategy()==DEFECTOR)
	    			{
	    				
	    				for(int k=0;k<8;k++)
	    				{
	    					if(k!=4)
	    					{
	    						if(neighbors[i][j][k].getStrategy()==COOPERATOR)
		    					{
		    						fitness=fitness+t;
		    					}
		    					else if(neighbors[i][j][k].getStrategy()==DEFECTOR)
		    					{
		    						fitness=fitness+DD;
		    					}
		    					else
		    					{	
		    						throw new Exception("The cell has no defined strategy2");
		    					}
	    					}
	    					
	    				}
	    				
	    			}
	    			else
					{	
						throw new Exception("The cell has no defined strategy3"+i+j+cells[i][j].getStrategy()+neighbors[i][j][0].getStrategy());
					}
	    			
	    			
	    			cells[i][j].setFitness(fitness/8);
		    	}
	    	}
	    	
	    }
	    
	    /**
	     * It updates the strategy of each cell using a more sophisticated rule.
	     */
	    public void updateStrategyComplex() throws Exception
	    {
	    	Cell[][] temporal=new Cell[population][population];
	    	for(int i=0;i<population;i++)
	    	{
	    		for(int j=0;j<population;j++)
	    		{
	    			temporal[i][j]=new Cell();
	    		}
	    	}
	    	
	    	for(int i=0;i<population;i++)
	    	{
	    		for(int j=0;j<population;j++)
	    		{
	    			
	    			double greaterFitness=cells[i][j].getFitness();
	    			temporal[i][j]=cells[i][j];
	    			for(int k=0;k<8 ;k++)
	    			{
	    				
	    				if(k!=4)
	    				{
	    					if(neighbors[i][j][k].getStrategy()==0)
	    						throw new Exception("mal update"+i+j+k);
	    					else
	    					{
	    						if(neighbors[i][j][k].getFitness()>greaterFitness)
	    						{
	    							greaterFitness=neighbors[i][j][k].getFitness();
	    							temporal[i][j]=neighbors[i][j][k];
		    					
	    						}
	    					}
	    				}
	    				
	    			}
	    			if (temporal[i][j].getStrategy()==cells[i][j].getStrategy())
	    				temporal[i][j].changes(false);
	    			else
	    				temporal[i][j].changes(true);
	    		}
	    	}
	    	for(int i=0;i<population;i++)
	    	{
	    		for(int j=0;j<population;j++)
	    		{
	    			cells[i][j]=temporal[i][j];
	    		
	    			cells[i][j].setFitness(0);
	    		}
	    	}
	    }
	    
	    /**
	     * It gives the strategy of each cell after one round using the simplest updating rule.
	     * @param s: parameter of the payoff matrix.
	     * @param t: parameter of the payoff matrix.
	     * @throws Exception
	     */
	    
	    public void updateStrategy(double s, double t) throws Exception
	    {
	    	Cell[][] temporal=new Cell[population][population];
	    	for(int i=0;i<population;i++)
	    	{
	    		for(int j=0;j<population;j++)
	    		{
	    			temporal[i][j]=new Cell();
	    		}
	    	}
	    	
	    	for(int i=0;i<population;i++)
	    	{
	    		for(int j=0;j<population;j++)
	    		{
	    			
	    			
	    			temporal[i][j]=cells[i][j];
	    			
	    			if(cells[i][j].getFitness()<(s+t+1)/4)
		    		{
	    				temporal[i][j].switchStrategy();
	    				temporal[i][j].changes(true);
	    			}
	    			else
	    				temporal[i][j].changes(false);
	    					
	    				
	    				
	    			
	    		}
	    	}
	    	for(int i=0;i<population;i++)
	    	{
	    		for(int j=0;j<population;j++)
	    		{
	    			cells[i][j]=temporal[i][j];
	    		
	    			cells[i][j].setFitness(0);
	    		}
	    	}
	    }
	    
	    public void updateStrategy2(double s, double t) throws Exception
	    {
	    	Cell[][] temporal=new Cell[population][population];
	    	for(int i=0;i<population;i++)
	    	{
	    		for(int j=0;j<population;j++)
	    		{
	    			temporal[i][j]=new Cell();
	    		}
	    	}
	    	
	    	for(int i=0;i<population;i++)
	    	{
	    		for(int j=0;j<population;j++)
	    		{
	    			
	    			
	    			temporal[i][j]=cells[i][j];
	    			
	    			if(cells[i][j].getFitness()<(s+t+1)/4)
		    		{
	    				Random randomGenerator = new Random();
	    				int random = randomGenerator.nextInt(8);
	    				if(neighbors[i][j][random].getStrategy()!=cells[i][j].getFitness())
	    				{	
	    					temporal[i][j]=neighbors[i][j][random];
	    					temporal[i][j].changes(true);
	    				}
	    				else
		    				temporal[i][j].changes(false);
	    			}
	    			
	    					
	    				
	    				
	    			
	    		}
	    	}
	    	for(int i=0;i<population;i++)
	    	{
	    		for(int j=0;j<population;j++)
	    		{
	    			cells[i][j]=temporal[i][j];
	    		
	    			cells[i][j].setFitness(0);
	    		}
	    	}
	    }
	    
	    /**
	     * It reproduces the Moran process in some population given by the array cell.
	     * @param cell: the population within which the process takes place. 
	     * @param fitness: The relative fitness of cooperators within the population.
	     * @return cell: the final state of the population after one Moran process.
	     */
	    
	    public Cell[][] moranProcess(Cell[][] cell, double fitness)
	    {
	    	int pop=population/2;
	    	
	        //Generates random number  
	    	
	    	Random randomGenerator = new Random();
	        
	    	//These numbers give the indexes for the cells that will die and reproduce.
	    	
	    	int randomDeadi = randomGenerator.nextInt(pop);
	        int randomDeadj = randomGenerator.nextInt(pop);
	        int randomRepi = randomGenerator.nextInt(pop);
	        int randomRepj = randomGenerator.nextInt(pop);
	        
	        Random randomGenerator2 = new Random();
			double prob=randomGenerator2.nextDouble();
			
			boolean condition=true;
			int num=0;
			while(condition && num<5)
			{
				if(cell[randomRepi][randomRepj].getStrategy()==COOPERATOR)
				{
					if(prob<fitness)
					{
						cell[randomDeadi][randomDeadj]=cell[randomRepi][randomRepj];
						condition=false;
					}
					else
					{
						randomRepi=randomGenerator.nextInt(pop);
						randomRepj=randomGenerator.nextInt(pop);
						num++;
					}
					
				}
				else if(cell[randomRepi][randomRepj].getStrategy()==DEFECTOR)
				{
					if(prob>fitness)
					{
						cell[randomDeadi][randomDeadj]=cell[randomRepi][randomRepj];
						condition=false;
					}
					else
					{
						randomRepi=randomGenerator.nextInt(pop);
						randomRepj=randomGenerator.nextInt(pop);
						num++;
					}
					
				}
			}
			
			
	        return cell;
	        
	         
	        
	    }
	    
	   
	    
	  
	    
	    /**
	     * It updates the cells using the complex structure for the population
	     * @param iterations: The number of iterations that will be used.
	     * @param fitness: The relative fitness of cooperators within the population.
	     */
	    
	    public double[] playIsland(int iterations, double fitness1,double fitness2, double fitness3, double fitness4)
	    {
	    	
	    	//pop: square root of the population of each island. 
	    	int pop=0;
	    	if(population%2==0)
	    		pop=population/2;
	    	else
	    	    pop=(population-1)/2;
	    	
	    	//temp#: the cells of each island.
	    	
	    	Cell[][] temp1=new Cell[pop][pop];
	    	Cell[][] temp2=new Cell[pop][pop];
	    	Cell[][] temp3=new Cell[pop][pop];
	    	Cell[][] temp4=new Cell[pop][pop];
	    	for(int i=0;i<pop;i++)
	    	{
	    		for(int j=0;j<pop;j++)
	    		{
	    			temp1[i][j]=cells[i][j];
	    			temp2[i][j]=cells[i][j+pop];
	    			temp3[i][j]=cells[i+pop][j];
	    			temp4[i][j]=cells[i+pop][j+pop];
	    			
	    		}
	    	}
	    	
	    	for(int k=0;k<iterations;k++)
	    	{
	    	
	    		temp1=moranProcess(temp1,fitness1);
	    		temp2=moranProcess(temp2,fitness2);
	    		temp3=moranProcess(temp3,fitness3);
	    		temp4=moranProcess(temp4,fitness4);
	    	
	    		//Generates random number.
	    		Random randomGenerator = new Random();
	    		
	    		//These numbers give the indexes for the cells that will die and reproduce.
	    		int randomDeadi = randomGenerator.nextInt(pop);
	    		int randomDeadj = randomGenerator.nextInt(pop);
	    		int randomRepi = randomGenerator.nextInt(pop);
	    		int randomRepj = randomGenerator.nextInt(pop);
	        
	    		temp2[randomDeadi][randomDeadj]=temp1[randomRepi][randomRepj];
				temp3[randomDeadi][randomDeadj]=temp2[randomRepi][randomRepj];
				temp4[randomDeadi][randomDeadj]=temp3[randomRepi][randomRepj];
				temp1[randomDeadi][randomDeadj]=temp4[randomRepi][randomRepj];
	    				
	    			
	    					
	    		
	    	}
	        double num1=0;
	        double num2=0;
	        double num3=0;
	        double num4=0;
	        
	    	for(int i=0;i<population;i++)
	    	{
	    		for(int j=0;j<population;j++)
	    		{
	    			if(i<pop && j<pop)
	    			{
	    				if(temp1[i][j].getStrategy()==COOPERATOR)
	    					num1++;
	    				cells[i][j]=temp1[i][j];
	    				
	    			}
	    			else if(i<pop && j>=pop)
	    			{
	    				if(temp2[i][j-pop].getStrategy()==COOPERATOR)
	    					num2++;
	    				cells[i][j]=temp2[i][j-pop];
	    				
	    			}
	    			else if(i>=pop && j<pop)
	    			{
	    				if(temp3[i-pop][j].getStrategy()==COOPERATOR)
	    					num3++;
	    				cells[i][j]=temp3[i-pop][j];
	    				
	    			}
	    			else if(i>=pop && j>=pop)
	    			{
	    				if(temp4[i-pop][j-pop].getStrategy()==COOPERATOR)
	    					num4++;
	    				cells[i][j]=temp4[i-pop][j-pop];
	    				
	    			}
	    			
	    		}
	    	}
	    	double[] rho=new double[4];
	    	rho[0]=num1/(pop*pop);
	    	rho[1]=num2/(pop*pop);
	    	rho[2]=num3/(pop*pop);
	    	rho[3]=num4/(pop*pop);
	    	return rho;
	    	
	    }
	    
	    /**
	     * It initializes the cells using the network structure for the population
	     */
	    
	    public double[][] initializeNetwork()
	    {
	    	int pop=population*population;
	    	double[][] matrix=new double[pop][pop];
	    	for(int i=0;i<pop; i++)
	    	{
	    		for(int j=i;j<pop; j++)
	    		{
	    			if(i!=j)
	    			{
	    				matrix[i][j]=1;
	    				matrix[j][i]=1;
	    			}
	    			else
	    			{
	    				matrix[i][j]=0;
	    			}
	    		}
	    	}
	    	return matrix;
	    }
	    
	    /**
	     * Method for the evolution of the population within an evolving network.
	     * @param matrix: represents the probabilities of interaction between cells.
	     * @return matrix: the values of the probabilities after one round.
	     */
	    public double[][] networkStructure(double[][] matrix, double s, double t)
	    {
	    	int pop=population*population;
	    	Random randomGenerator = new Random();
	    	
	    	//It is the sum of all matrix elements for each cell, it gives the sum of their connections.
	    	double[] sum=new double[pop];
	    	
	    	//It gives the payoff for a cell in one round.
	    	double[] payoff=new double[pop];
	    	
	    	//It gives the number of cells that interact with a specific cell in one round.
	    	double[] num=new double[pop];
	    	
	    	
	    	
	    	
	    	for(int i=0;i<pop; i++) 
	    	{
	    		sum[i]=0;
	    		payoff[i]=0;
	    		num[i]=0;
	    	}
 	    	
	    	for(int i=0;i<pop; i++)
	    	{
	    		for(int j=0;j<pop; j++)
	    		{
	    			sum[i]=sum[i]+matrix[i][j];
	    		}
	    	}
	    	
	    	for(int i=0;i<pop; i++)
	    	{
	    		for(int j=0;j<pop; j++)
	    		{
	    			double random = randomGenerator.nextDouble();
	    			double fitness=0;
	    			if(random<matrix[i][j]/sum[i])
	    			{
	    				int I1=i/population;
	    				int J1=i%population;
	    				int I2=j/population;
	    				int J2=j%population;
	    				
		    			if(cells[I1][J1].getStrategy()==COOPERATOR)
		    			{
		    				if(cells[I2][J2].getStrategy()==DEFECTOR)
		    				{
		    					fitness=s;
		    				}
		    				else if(cells[I2][J2].getStrategy()==COOPERATOR)
		    				{
		    					fitness=CC;
		    				}
		    				
		    				
		    			}
		    			
		    			else if(cells[I1][J1].getStrategy()==DEFECTOR)
		    			{
		    				
		    				if(cells[I2][J2].getStrategy()==DEFECTOR)
		    				{
		    					fitness=DD;
		    				}
		    				else if(cells[I2][J2].getStrategy()==COOPERATOR)
		    				{
		    					fitness=t;
		    				}
		    				
		    			}
		    			matrix[i][j]=matrix[i][j]+fitness;
		    			
		    			payoff[i]=payoff[i]+fitness;
		    			num[i]=num[i]+1;
	    			}
	    		}
	    	}

	    	
	    	for(int i=0;i<pop;i++)
	    	{
	    		int I=i/population;
				int J=i%population;
	    		
	    		if(payoff[i]/num[i]<(s+t+1)/4)
	    		{
	    			cells[I][J].switchStrategy();
	    			cells[I][J].changes(true);
	    		}
	    		else
	    		{
	    			cells[I][J].changes(false);
	    		}
	    	}
	    	
	    	for(int i=0;i<pop; i++)
	    	{
	    		sum[i]=0;
	    		for(int j=0;j<pop; j++)
	    		{
	    			sum[i]=sum[i]+matrix[i][j];
	    		}
	    	}
	    	
	    	for(int i=0;i<pop; i++)
	    	{
	    		for(int j=0;j<pop; j++)
	    		{
	    			if(sum[i]!=0)
	    				matrix[i][j]=matrix[i][j]/sum[i];
	    			
	    		}
	    	}
	    	
	    	return matrix;
    		
	    }
	    
	    public double[][] networkStructureComplex(double[][] matrix)
	    {
	    	int pop=population*population;
	    	Random randomGenerator = new Random();
	    	
	    	//It is the sum of all matrix elements for each cell, it gives the sum of their connections.
	    	double[] sum=new double[pop];
	    	
	    	//It gives the payoff for a cell in one round.
	    	double[] payoff=new double[pop];
	    	
	    	//It gives the number of cells that interact with a specific cell in one round.
	    	double[] num=new double[pop];
	    	
	    	
	    	for(int i=0;i<pop; i++) 
	    	{
	    		sum[i]=0;
	    		payoff[i]=0;
	    		num[i]=0;
	    	}
 	    	
	    	for(int i=0;i<population; i++)
	    	{
	    		for(int j=0;j<population; j++)
	    		{
	    			sum[i]=sum[i]+matrix[i][j];
	    		}
	    	}
	    	
	    	for(int i=0;i<population; i++)
	    	{
	    		for(int j=0;j<i; j++)
	    		{
	    			double random = randomGenerator.nextDouble();
	    			if(random<matrix[i][j]/sum[i])
	    			{
	    				double fitness=0;
		    			if(cells[i/population][i%population].getStrategy()==COOPERATOR)
		    			{
		    				if(cells[j/population][j%population].getStrategy()==DEFECTOR)
		    				{
		    					fitness=CD;
		    				}
		    				else if(cells[j/population][j%population].getStrategy()==COOPERATOR)
		    				{
		    					fitness=CC;
		    				}
		    				
		    				
		    			}
		    			
		    			else if(cells[i/population][i%population].getStrategy()==DEFECTOR)
		    			{
		    				
		    				if(cells[j/population][j%population].getStrategy()==DEFECTOR)
		    				{
		    					fitness=DD;
		    				}
		    				else if(cells[j/population][j%population].getStrategy()==COOPERATOR)
		    				{
		    					fitness=DC;
		    				}
		    				
		    			}
		    			matrix[i][j]=matrix[i][j]+fitness;
		    			matrix[j][i]=matrix[i][j];
		    			payoff[i]=payoff[i]+fitness;
		    			num[i]=num[i]+1;
	    			}
	    		}
	    	}
	    	
	    	return matrix;
    		
	    }
	   
	    /**
	     * It recovers the initial random state of the population
	     */
	    
	    public void reset(double den)
	    {
		    cells = new Cell[population][population];
	        neighbors= new Cell[population][population][8];
	        density=0;
	        
	        
	        //For the equalized populations.
	        
	        Random randomGenerator = new Random();
	        for (int i=0;i<population;i++)
	        {
	        	for (int j=0;j<population;j++)
	        	{
	        		cells[i][j]=new Cell();
	        		double random = randomGenerator.nextDouble();
	        		if(random<den)
	        		{
	        			cells[i][j].setStrategy(COOPERATOR);
	        		}
	        		else
	        		{
	        			cells[i][j].setStrategy(DEFECTOR);
	        		}
	        		for(int k=0;k<8;k++)
	        		{
	        			neighbors[i][j][k]=new Cell();
	        		}
	        	}
	        }
	        
	        
	    }
	    
	    /**
	     * It recovers the initial state of the population for a located population of cooperators
	     */
	    
	    public void resetCenter()
	    {
		   cells = new Cell[population][population];
	        neighbors= new Cell[population][population][8];
	        density=0;
	        
	        //For the small cooperator's population.
	        
	        
	        for (int i=0;i<population;i++)
	        {
	        	for (int j=0;j<population;j++)
	        	{
	        		cells[i][j]=new Cell();
	        		
	        		
	        		cells[i][j].setStrategy(DEFECTOR);
	        		
	        		if(48<=i && i<=51)
	        		{
	        			if(48<=j && j<=51)
	        			{
	        				cells[i][j].switchStrategy();
	        			}
	        		}
	        		for(int k=0;k<8;k++)
	        		{
	        			neighbors[i][j][k]=new Cell();
	        		}
	        	}
	        }
	    }
	    
	    
	    /**
		    * It calculates the density of cooperators within the population. 
		    * @return density: density of cooperators.
		    */
		   
		    public double cDensity()
		    {
			    double num=0.0000;
			    for(int i=0;i<population;i++)
		    	{
		    		for(int j=0;j<population;j++)
		    		{
		    			if(cells[i][j].getStrategy()==COOPERATOR)
		    			{
		    				num=num+1.0000;
		    			}
		    		}
		    	}
			    density=num/(population*population);
			    
			    return density;
		    }
		    
		    /**
		     * It returns the indexes of the first cooperator within the population.
		     * @param population: A population of cells.
		     * @return index: indexes of the first cooperator within population.
		     */
		    
		    public int[] findFirstCooperator(Cell[][] cell)
		    {
		    	int[] index=new int[2];
		    	int pop=cell.length;
		    	Random randomGenerator = new Random();
	    		int random = randomGenerator.nextInt(pop);
	    		Random randomGenerator2 = new Random();
	    		int random2=randomGenerator2.nextInt(pop);
	    		for(int i=random;i<pop;i++)
		    	{
		    		
		    		for(int j=random2;j<pop;j++)
		    		{
		    			if(cell[i][j].getStrategy()==COOPERATOR)
		    			{
		    				index[0]=i;
		    				index[1]=j;
		    				return index;
		    				
		    			}
		    			if(i==pop-1 && j==pop-1)
		    			{
		    				i=0;
		    				j=0;
		    			}
		    			if(i==random-1 && j==random-1)
		    			{
		    				return null;
		    			}
		    			
		    		}
		    	}
		    	return null;
		    }
		    
		    /**
		     * It gives the current state of the population.
		     * @return cells: current state of the population.
		     * @throws Exception
		     */
		    public Cell[][] getBoard() throws Exception
		    {
		    	return cells;
		    }
		    
		    /**
		     * It returns the indexes of the first defector within the population.
		     * @param population: A population of cells.
		     * @return index: indexes of the first defector within population.
		     */
		    
		    public int[] findFirstDefector(Cell[][] cell)
		    {
		    	int[] index=new int[2];
		    	int pop=cell.length;
		    	Random randomGenerator = new Random();
	    		int random = randomGenerator.nextInt(pop);
	    		Random randomGenerator2 = new Random();
	    		int random2=randomGenerator2.nextInt(pop);
	    		for(int i=random;i<pop;i++)
		    	{
		    		
		    		for(int j=random2;j<pop;j++)
		    		{
		    			if(cell[i][j].getStrategy()==DEFECTOR)
		    			{
		    				index[0]=i;
		    				index[1]=j;
		    				return index;
		    				
		    			}
		    			if(i==pop-1 && j==pop-1)
		    			{
		    				i=0;
		    				j=0;
		    			}
		    			if(i==random-1 && j==random-1)
		    			{
		    				return null;
		    			}
		    			
		    		}
		    	}
		    	return null;
		    }
		    
		    public double clusterIndex()
		    {
		    	double num=0;
		    	for(int i=0;i<population;i++)
		    	{
		    		for(int j=0;j<population;j++)
		    		{
		    			if(cells[i][j].getStrategy()==COOPERATOR)
		    			{
		    				for(int k=0;k<8 ;k++)
			    			{
			    				if(neighbors[i][j][k].getStrategy()==COOPERATOR)
			    				{
			    					num=num+1;
			    				}
			    			}
		    			}
		    			
		    		}
		    	}
		    	return num/(population*population*8);
		    }
	    

	}





