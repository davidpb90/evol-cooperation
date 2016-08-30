package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import mundo.Cell;
import mundo.Game;

/**
 * This is the main application window
 */

public class GameGUI extends JFrame
{
	
		public static final int ITERATIONS = 1000;
		
		public static final int GAMES = 30;

	    // -----------------------------------------------------------------
	    // Fields
	    // -----------------------------------------------------------------

	    /**
	     * Main world class
	     */
	    private Game game;

	    // -----------------------------------------------------------------
	    // GUI Fields
	    // -----------------------------------------------------------------

	    /**
	     * Extension Panel
	     */
	    private ExtentionPanel extentionPanel;

	    /**
	     * Header image panel
	     */
	    private ImagePanel imagePanel;

	    /**
	     * Game board Panel
	     */
	    private BoardPanel boardPanel;
	    
	    private int iterations;
	    
	    private int games;

	    // -----------------------------------------------------------------
	    // Constructors
	    // -----------------------------------------------------------------

	    /**
	     * Gui constructor
	     */
	    public GameGUI( )
	    {
	        // Main class is built
	        try
	        {
	        	game = new Game( );
	        }
	        catch(Exception e)
	        {
	        	JOptionPane.showMessageDialog(this, e.getMessage());
	        }

	        // The form is built
	        setLayout( new BorderLayout( ) );
	        setSize( 500, 700 );
	        setResizable( false );
	        setTitle( "Spatial Game" );
	        getContentPane( ).setBackground( Color.BLACK );
	        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	        setLocationRelativeTo( null );

	        // Pane initialization
	        imagePanel = new ImagePanel( );
	        add( imagePanel, BorderLayout.NORTH );

	        extentionPanel = new ExtentionPanel( this );
	        add( extentionPanel, BorderLayout.SOUTH );

	        boardPanel = new BoardPanel( this,game.getPopulation() );
	        add( boardPanel, BorderLayout.CENTER );
	        
	        iterations=	ITERATIONS;
	        
	        games=GAMES;

	        // Auxiliary Panes
	        //JPanel auxiliaryPane1 = new JPanel( );
	        //add( auxiliaryPane1, BorderLayout.WEST );
	        //JPanel auxiliaryPane2 = new JPanel( );
	        //auxiliaryPane2.setPreferredSize( new Dimension( 110, 0 ) );
	        //auxiliaryPane2.setBackground( Color.BLACK );
	        //add( auxiliaryPane2, BorderLayout.EAST );
	    }

	    // -----------------------------------------------------------------
	    // Methods
	    // -----------------------------------------------------------------

	    
	    public void setIterations(int iter)
	    {
	    	iterations=iter;
	    }
	    
	    public void setGames(int number)
	    {
	    	games=number;
	    }
	    
	    public void setPopulation(int population)
	    {
	    	game.setPopulation(population);
	    	
	    }
	    
	    public int getPopulation()
	    {
	    	return game.getPopulation();
	    }
	    
	    public String getDensity()
	    {
	    	return Double.toString(game.cDensity());
	    }
	    
	    public String getCluster()
	    {
	    	return Double.toString(game.clusterIndex());
	    }
	    
	    public void updateBoard()
	    {
	    	boardPanel.repaint();
	    }
	    
	   
	    

	    /**
	     * It ends the game and displays the solution for the simple structure
	     */
	    public void playGame( )
	    {
	    	
	    	
	    	for(int i=0;i<iterations;i++)
	    	{
	    		
	    		try
	    		{
	    			game.defineNeighbors();
	    		}
	    		catch(Exception e)
	    		{
	    			JOptionPane.showMessageDialog(this,e.getMessage()+i);
	    		}
	    		try
	    		{
	    			game.calculateFitness(1,1);
	    		}
	    		catch(Exception e)
	    		{
	    			JOptionPane.showMessageDialog(this,e.getMessage()+i);
	    		}
	    		try
	    		{
	    			game.updateStrategy(1,1	);
	    		}
	    		catch(Exception e)
	    		{
	    			JOptionPane.showMessageDialog(this,e.getMessage());
	    		}
	    		
	    		
	    		
	    	}
	    	try
    		{
    			boardPanel.updateBoard();
    		}
    		catch(Exception e)
    		{
    			JOptionPane.showMessageDialog(this,"mal");
    		}
	    	
	       
	    }
	    
	    /**
	     * It ends the game and displays the solution for the simple structure
	     */
	    public void playGame2( )
	    {
	    	
	    	
	    	for(int i=0;i<iterations;i++)
	    	{
	    		
	    		try
	    		{
	    			game.defineNeighbors();
	    		}
	    		catch(Exception e)
	    		{
	    			JOptionPane.showMessageDialog(this,e.getMessage()+i);
	    		}
	    		try
	    		{
	    			game.calculateFitness(1,1);
	    		}
	    		catch(Exception e)
	    		{
	    			JOptionPane.showMessageDialog(this,e.getMessage()+i);
	    		}
	    		try
	    		{
	    			game.updateStrategy2(1,1);
	    		}
	    		catch(Exception e)
	    		{
	    			JOptionPane.showMessageDialog(this,e.getMessage());
	    		}
	    		
	    		
	    		
	    	}
	    	try
    		{
    			boardPanel.updateBoard();
    		}
    		catch(Exception e)
    		{
    			JOptionPane.showMessageDialog(this,"mal");
    		}
	    	
	       
	    }
	    
	    /**
	     * It ends the game and displays the solution for the simple structure
	     */
	    public void playGameComplex( )
	    {
	    	
	    	
	    	for(int i=0;i<iterations;i++)
	    	{
	    		
	    		try
	    		{
	    			game.defineNeighbors();
	    		}
	    		catch(Exception e)
	    		{
	    			JOptionPane.showMessageDialog(this,e.getMessage()+i);
	    		}
	    		try
	    		{
	    			game.calculateFitness(0.8,1.7);
	    		}
	    		catch(Exception e)
	    		{
	    			JOptionPane.showMessageDialog(this,e.getMessage()+i);
	    		}
	    		try
	    		{
	    			game.updateStrategyComplex();
	    		}
	    		catch(Exception e)
	    		{
	    			JOptionPane.showMessageDialog(this,e.getMessage());
	    		}
	    		
	    		
	    		
	    	}
	    	try
    		{
    			boardPanel.updateBoard();
    		}
    		catch(Exception e)
    		{
    			JOptionPane.showMessageDialog(this,"mal");
    		}
	    	
	       
	    }
	    
	    /**
	     * It shows the final state of the population in the island structure after 1000 iterations. 
	     */
	    public double[] playIsland(double fitness1,double fitness2,double fitness3,double fitness4)
	    {
	    	double[] density=game.playIsland(iterations,fitness1, fitness2, fitness3, fitness4);
	    	
	    	try
    		{
    			boardPanel.updateBoard();
    		}
    		catch(Exception e)
    		{
    			JOptionPane.showMessageDialog(this,"mal");
    		}
	    	return density;
	    }
	    
	    /**
	     * It gives the evolution of the population within a network structure.
	     * @param file: a .txt file where the matrix with the network information will be printed.
	     * @throws IOException
	     */
	    
	    public void playNetwork(File file,double s, double t) throws IOException
	    {
	    	PrintWriter writer=new PrintWriter(new FileWriter (file));
	    	
	    	double[][] matrix=game.initializeNetwork();
	    	
	    	for(int i=0;i<iterations;i++)
	    	{
	    		matrix=game.networkStructure(matrix,s,t);
	    	}
	    	//writer.println(game.cDensity());
	    	for(int i=0;i<matrix.length;i++ )
	    	{
	    		for(int j=0;j<matrix.length;j++ )
	    		{
	    			if(matrix[i][j]<1/(matrix.length*matrix.length)*0.00001)
	    				writer.print(0.0+" ");
	    			//else if (matrix[i][j]!=matrix[j][i])
	    			//	writer.print(0.0+" ");
	    			else	
	    				writer.print(matrix[i][j]+" ");
	    		}
	    		writer.println();
	    	}
	    	writer.close();
	    	try
    		{
    			boardPanel.updateBoard();
    		}
    		catch(Exception e)
    		{
    			JOptionPane.showMessageDialog(this,"mal");
    		}
	    }

	  
	    /**
	     * It returns the cells of the board
	     * @return The cells of the board are returned
	     */
	    
	    public Cell[][] getBoardCells( )
	    {
	        try
	        {	
	        	 return game.getBoard();
	        	 
	        }
	        catch(Exception e)
	        {
	        	JOptionPane.showMessageDialog(this,"error");
	        	Cell[][] board=new Cell[Game.POPULATION][Game.POPULATION];
	        	return board;
	        }
	       
	    }

	   
	    /**
	     * It creates a .txt file with the information of cooperator densities for different types of games in the simple structure.
	     * The games are given by parameters s and t. 
	     */
	    public void reqDataSimple(File file,double den) throws IOException
	    {
	        
	    	PrintWriter writer=new PrintWriter(new FileWriter (file));
	    	for(int i=0;i<41;i++)
	    	{
	    		for(int j=0;j<41;j++)
	    		{
	    			double s=i*1.0000/20.0000-1.0000;
	    			double t=j*1.0000/20.0000;
	    			double density=0.0000;
	    			for(int k=0; k<games; k++)
	    		    {
	    				game.reset(den);
	    				for(int l=0;l<iterations;l++)
	    		    	{
	    		    		
	    		    		try
	    		    		{
	    		    			game.defineNeighbors();
	    		    		}
	    		    		catch(Exception e)
	    		    		{
	    		    			JOptionPane.showMessageDialog(this,e.getMessage()+i);
	    		    		}
	    		    		try
	    		    		{
	    		    			game.calculateFitness(s,t);
	    		    		}
	    		    		catch(Exception e)
	    		    		{
	    		    			JOptionPane.showMessageDialog(this,e.getMessage()+i);
	    		    		}
	    		    		try
	    		    		{
	    		    			game.updateStrategy(s,t);
	    		    		}
	    		    		catch(Exception e)
	    		    		{
	    		    			JOptionPane.showMessageDialog(this,e.getMessage());
	    		    		}
	    		    		
	    		    		
	    		    	}
	    		    	try
	    	    		{
	    	    			boardPanel.updateBoard();
	    	    		}
	    	    		catch(Exception e)
	    	    		{
	    	    			JOptionPane.showMessageDialog(this,"mal");
	    	    		}
	    		        density=density+game.cDensity();
	    		        
	    		    }
	    			density=density/games; 
	    			writer.println(t+" "+s+" "+density);
	    		}
	    	}
	        	
	    		
	        
	       
	    	writer.close();
	    }
	    
	    /**
	     * It creates a .txt file with the information of cooperator densities for different types of games in the simple structure.
	     * The games are given by parameters s and t. 
	     */
	    public void reqDataSimple2(File file,double den) throws IOException
	    {
	        
	    	PrintWriter writer=new PrintWriter(new FileWriter (file));
	    	for(int i=0;i<41;i++)
	    	{
	    		for(int j=0;j<41;j++)
	    		{
	    			double s=i*1.0000/20.0000-1.0000;
	    			double t=j*1.0000/20.0000;
	    			double density=0.0000;
	    			for(int k=0; k<games; k++)
	    		    {
	    				game.reset(den);
	    				for(int l=0;l<iterations;l++)
	    		    	{
	    		    		
	    		    		try
	    		    		{
	    		    			game.defineNeighbors();
	    		    		}
	    		    		catch(Exception e)
	    		    		{
	    		    			JOptionPane.showMessageDialog(this,e.getMessage()+i);
	    		    		}
	    		    		try
	    		    		{
	    		    			game.calculateFitness(s,t);
	    		    		}
	    		    		catch(Exception e)
	    		    		{
	    		    			JOptionPane.showMessageDialog(this,e.getMessage()+i);
	    		    		}
	    		    		try
	    		    		{
	    		    			game.updateStrategy2(s,t);
	    		    		}
	    		    		catch(Exception e)
	    		    		{
	    		    			JOptionPane.showMessageDialog(this,e.getMessage());
	    		    		}
	    		    		
	    		    		
	    		    	}
	    		    	try
	    	    		{
	    	    			boardPanel.updateBoard();
	    	    		}
	    	    		catch(Exception e)
	    	    		{
	    	    			JOptionPane.showMessageDialog(this,"mal");
	    	    		}
	    		        density=density+game.cDensity();
	    		        
	    		    }
	    			density=density/games; 
	    			writer.println(t+" "+s+" "+density);
	    		}
	    	}
	        	
	    		
	        
	       
	    	writer.close();
	    }
	    
	    /**
	     * It creates a .txt file with the information of cooperator densities for different types of games in the simple structure.
	     * The games are given by parameters s and t. 
	     */
	    public void reqDataComplex(File file,double den) throws IOException
	    {
	        
	    	PrintWriter writer=new PrintWriter(new FileWriter (file));
	    	for(int i=0;i<41;i++)
	    	{
	    		for(int j=0;j<41;j++)
	    		{
	    			double s=i*1.0000/20.0000-1.0000;
	    			double t=j*1.0000/20.0000;
	    			double density=0.0000;
	    			for(int k=0; k<games; k++)
	    		    {
	    				game.reset(den);
	    				for(int l=0;l<iterations;l++)
	    		    	{
	    		    		
	    		    		
	    		    		game.defineNeighbors();
	    		    		
	    		    		try
	    		    		{
	    		    			game.calculateFitness(s,t);
	    		    		}
	    		    		catch(Exception e)
	    		    		{
	    		    			JOptionPane.showMessageDialog(this,e.getMessage()+i);
	    		    		}
	    		    		try
	    		    		{
	    		    			game.updateStrategyComplex();
	    		    		}
	    		    		catch(Exception e)
	    		    		{
	    		    			JOptionPane.showMessageDialog(this,e.getMessage());
	    		    		}
	    		    		
	    		    		
	    		    	}
	    		    	try
	    	    		{
	    	    			boardPanel.updateBoard();
	    	    		}
	    	    		catch(Exception e)
	    	    		{
	    	    			JOptionPane.showMessageDialog(this,"mal");
	    	    		}
	    		        density=density+game.cDensity();
	    		        
	    		    }
	    			density=density/games; 
	    			writer.println(t+" "+s+" "+density);
	    		}
	    	}
	        	
	    		
	        
	       
	    	writer.close();
	    }
	    
	    /**
	     * It creates a .txt with the information of cooperator densities for different types of games in the island structure.
	     * The games are given by parameters s and t. 
	     */
	    
	    public void reqDataIsland(File file,double fitness1,double fitness2,double fitness3,double fitness4) throws IOException
	    {
	    	PrintWriter writer=new PrintWriter(new FileWriter (file));
	    	
	    	
	    	
	    	game.randomInitial(0.05);
	    	try
    		{
    			boardPanel.updateBoard();
    		}
    		catch(Exception e)
    		{
    			JOptionPane.showMessageDialog(this,"mal");
    		}
	    	
	    	
	    	for(int i=1;i<20;i++)
	    	{
	    		double density1=0.0000;
	    		double density2=0.0000;
	    		double density3=0.0000;
	    		double density4=0.0000;
	    		double den=i*1.0000/20;
	    		for(int k=0; k<games; k++)
	    	    {
	    			game.randomInitial(den);
	    			double[] rho=game.playIsland(iterations,fitness1, fitness2, fitness3, fitness4);
	    			
	    		     		
	    			density1=density1+rho[0];
	    			density2=density1+rho[1];
	    			density3=density1+rho[2];
	    			density4=density1+rho[3];
	    	    }       
	    		    
	    		density1=density1/games;
	    		density2=density2/games;
	    		density3=density3/games;
	    		density4=density4/games;
	    		writer.println(den+" "+density1+" "+density2+" "+density3+" "+density4);
	    		
	    	}
	    	writer.close();
	    	try
			{
				boardPanel.updateBoard();
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(this,"mal");
			}
	    	
	    }
	    
	    public void reqDataNetwork(File file,double den) throws IOException
	    {
	    	PrintWriter writer=new PrintWriter(new FileWriter (file));
	    	for(int i=0;i<11;i++)
	    	{
	    		for(int j=0;j<11;j++)
	    		{
	    			double s=i*1.0000/5.0000-1.0000;
	    			double t=j*1.0000/5.0000;
	    			double density=0.0000;
	    			
	    			for(int k=0; k<games; k++)
	    		    {
	    				double[][] matrix=game.initializeNetwork();
	    				game.reset(den);
	    				for(int l=0;l<iterations;l++)
	    		    	{
	    		    		
	    		    		matrix=game.networkStructure(matrix, s, t);
	    		    		
	    		    	}
	    		    	try
	    	    		{
	    	    			boardPanel.updateBoard();
	    	    		}
	    	    		catch(Exception e)
	    	    		{
	    	    			JOptionPane.showMessageDialog(this,"mal");
	    	    		}
	    		        density=density+game.cDensity();
	    		        
	    		    }
	    			density=density/games; 
	    			writer.println(t+" "+s+" "+density);
	    		}
	    	}
	        	
	    		
	        
	       
	    	writer.close();
	    }
	    
	    public void randomInitial(double den)
	    {
	    	game.randomInitial(den);
	    	try
    		{
    			boardPanel.updateBoard();
    		}
    		catch(Exception e)
    		{
    			JOptionPane.showMessageDialog(this,"mal");
    		}
	    	
	    }
	    
	    public void reset(double den)
	    {
	    	game.reset(den);
	    	
	    	
	    	try
			{
				boardPanel.updateBoard();
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(this,"mal");
			}
    		
    		
	    	
	    }
	    
	   

	

	    // -----------------------------------------------------------------
	    // Main
	    // -----------------------------------------------------------------

	    /**
	     * this method executes the application, building a new graphical user interface
	     * @param args Arguments for the execution of the application. They are not needed in this case
	     */
	    public static void main( String[] args )
	    {

	        GameGUI gui = new GameGUI( );
	        gui.setVisible( true );
	    }
	}

