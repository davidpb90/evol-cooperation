package interfaz;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import interfaz.GameGUI;

public class ExtentionPanel extends JPanel implements ActionListener
{
	// -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------

    /**
     * Command option 1
     */
    private static final String DATASIMPLE = "DATASIMPLE";
    
    private static final String DATASIMPLE2 = "DATASIMPLE2";
    
    private static final String DATACOMPLEX = "DATACOMPLEX";
    
    private static final String DATAISLAND = "DATAISLAND";
    
    private static final String DATANETWORK = "DATANETWORK";
    
    

    /**
     * Command option 2
     */
    private static final String RESET = "RESET";
    
    private static final String ITER = "ITER";
    
    private static final String POPULATION = "POPULATION";
    
    private static final String HELP = "HELP";

    /**
     * Command for playing a new game 
     */
    private static final String PLAYSIMPLE = "PLAYSIMPLE";
    
    private static final String PLAYSIMPLE2 = "PLAYSIMPLE2";
    
    private static final String PLAYCOMPLEX = "PLAYCOMPLEX";
    
    private static final String PLAYISLAND = "PLAYISLAND";
    
    private static final String PLAYNETWORK = "PLAYNETWORK";
    
    private static final String RANDOM = "RANDOM";

    /**
     * Command to validate the sudoku
     */
    //private static final String VALIDATE = "VALIDATE";

    /**
     * Command to display the solution
     */
    //private static final String LOAD_GAME = "LOAD_GAME";

    // -----------------------------------------------------------------
    // Fields
    // -----------------------------------------------------------------

    /**
     * Main application window
     */
    private GameGUI principal;

    // -----------------------------------------------------------------
    // GUI Fields
    // -----------------------------------------------------------------

    /**
     * Button Option 1
     */
    private JButton btnDataSimple;
    
    private JButton btnDataSimple2;
    
    private JButton btnDataComplex;
    
    private JButton btnDataIsland;
    
    private JButton btnDataNetwork;

    /**
     * Button Option 2
     */
    private JButton btnReset;

    private JButton btnRandom;
    
    /**
     * Button to open a new file
     */
    private JButton btnPlaySimple;
    
    private JButton btnPlaySimple2;
    
    private JButton btnPlayComplex;
    
    private JButton btnPlayIsland;
    
    private JButton btnPlayNetwork;
    
    private JButton btnIterations;
    
    private JButton btnPopulation;
    
    private JButton btnHelp;
    
    //private JLabel labInitialDensity;
    
    private JLabel labFinalDensity;
    
    private JLabel labCluster;
    
    
    
    private JTextField txtInitialDensity;
    
    private JTextField txtFinalDensity;
    
    private JTextField txtCluster;
    
    private JTextField txtIterations;
    
    private JTextField txtPopulation;
    
    

   

    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------

    /**
     * Pane constructor
     * @param window Main window. window!=null
     */
    public ExtentionPanel( GameGUI window )
    {
        principal = window;

        TitledBorder border = new TitledBorder( "Options" );
        border.setTitleColor( Color.WHITE );
        setBorder( border );
        setSize(500,500);
        setLayout( new GridLayout( 11, 2 ) );
        setBackground( Color.BLACK );

        //labInitialDensity = new JLabel("Initial Density");
        //add(labInitialDensity);
        
        
        btnPopulation = new JButton("Set Population");
        btnPopulation.setActionCommand( POPULATION );
        btnPopulation.addActionListener( this );
        add(btnPopulation);
        
        txtPopulation = new JTextField();
        txtPopulation.setEditable(true);
        add(txtPopulation);
        
        btnIterations = new JButton("Set Iterations");
        btnIterations.setActionCommand( ITER );
        btnIterations.addActionListener( this );
        add(btnIterations);
        
        txtIterations = new JTextField();
        txtIterations.setEditable(true);
        add(txtIterations);
        
        btnRandom=new JButton( "Random Population" );
        btnRandom.setActionCommand( RANDOM );
        btnRandom.addActionListener( this );
        add( btnRandom );
        
        txtInitialDensity = new JTextField();
        txtInitialDensity.setEditable(true);
        add(txtInitialDensity);
        
        
       
        // Button play game
        btnPlaySimple = new JButton( "Play Simple" );
        btnPlaySimple.setActionCommand( PLAYSIMPLE );
        btnPlaySimple.addActionListener( this );
        add( btnPlaySimple );
        
     
        
        // Bot�n option 1
        btnDataSimple = new JButton( "Data Simple" );
        btnDataSimple.setActionCommand( DATASIMPLE );
        btnDataSimple.addActionListener( this );
        add( btnDataSimple);
        
     // Button play game
        btnPlaySimple2 = new JButton( "Play Simple 2" );
        btnPlaySimple2.setActionCommand( PLAYSIMPLE2 );
        btnPlaySimple2.addActionListener( this );
        add( btnPlaySimple2 );
        
     // Bot�n option 1
        btnDataSimple2 = new JButton( "Data Simple 2" );
        btnDataSimple2.setActionCommand( DATASIMPLE2 );
        btnDataSimple2.addActionListener( this );
        add( btnDataSimple2);
        
        btnPlayComplex = new JButton( "Play Complex" );
        btnPlayComplex.setActionCommand( PLAYCOMPLEX );
        btnPlayComplex.addActionListener( this );
        add( btnPlayComplex );
        
        // Bot�n option 1
        btnDataComplex = new JButton( "Data Complex" );
        btnDataComplex.setActionCommand( DATACOMPLEX );
        btnDataComplex.addActionListener( this );
        add( btnDataComplex);
        
        btnPlayIsland = new JButton( "Play Island" );
        btnPlayIsland.setActionCommand( PLAYISLAND );
        btnPlayIsland.addActionListener( this );
        add( btnPlayIsland );
        
        // Bot�n option 1
        btnDataIsland = new JButton( "Data Island" );
        btnDataIsland.setActionCommand( DATAISLAND );
        btnDataIsland.addActionListener( this );
        add( btnDataIsland );
        
        btnPlayNetwork = new JButton( "Play Network" );
        btnPlayNetwork.setActionCommand( PLAYNETWORK );
        btnPlayNetwork.addActionListener( this );
        add( btnPlayNetwork );

        // Bot�n option 1
        btnDataNetwork = new JButton( "Data Network" );
        btnDataNetwork.setActionCommand( DATANETWORK );
        btnDataNetwork.addActionListener( this );
        add( btnDataNetwork);
        
        labFinalDensity = new JLabel("Final Density");
        labFinalDensity.setForeground(Color.WHITE);
        add(labFinalDensity);
        
        txtFinalDensity = new JTextField();
        txtFinalDensity.setEditable(false);
        add(txtFinalDensity);
        
        labCluster = new JLabel("Cluster Density");
        labCluster.setForeground(Color.WHITE);
        add(labCluster);
        
        txtCluster = new JTextField();
        txtCluster.setEditable(false);
        add(txtCluster);
        
        // Bot�n opci�n 2
        btnReset = new JButton( "Reset" );
        btnReset.setActionCommand( RESET );
        btnReset.addActionListener( this );
        add( btnReset );
        
        // Bot�n opci�n 2
        btnHelp = new JButton( "Help" );
        btnHelp.setActionCommand( HELP );
        btnHelp.addActionListener( this );
        add( btnHelp );

    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Event managing method
     * @param event Action generated by the event. event!=null
     */
    public void actionPerformed( ActionEvent event )
    {
        if( DATASIMPLE.equals( event.getActionCommand( ) ) )
        {
            File tesis=new File("simple.dat");
            
           	String games = JOptionPane.showInputDialog(this, "Introduce number of games per case:" );
            if(games!=null)
            {
            	try
            	{
            		int number=Integer.valueOf(games);
            		if(number<0)
            			JOptionPane.showMessageDialog(this, "The value must be a natural number.","Error",JOptionPane.ERROR_MESSAGE);
            		else
            		{	
            			principal.setGames(number);
            			try
            			{
            				principal.reqDataSimple(tesis,Double.valueOf(txtInitialDensity.getText()));
            			}
            			catch(IOException e)
            			{
            				e.printStackTrace();
            			}
            		}
            	}
            
            	catch(Exception e)
            	{
            		JOptionPane.showMessageDialog(this, "The value must be a natural number.","Error",JOptionPane.ERROR_MESSAGE);
            	}
            }
            
        }
        
        if( DATASIMPLE2.equals( event.getActionCommand( ) ) )
        {
            File tesis=new File("simple2.dat");
            String games = JOptionPane.showInputDialog(this, "Introduce number of games per case:" );
            if(games!=null)
            {
            	try
            	{
            		int number=Integer.valueOf(games);
            		principal.setGames(number);
            		try
            		{
            			principal.reqDataSimple2(tesis,Double.valueOf(txtInitialDensity.getText()));
            		}
            		catch(IOException e)
            		{
            			e.printStackTrace();
            		}
            	}
                
            	catch(Exception e)
            	{
            		JOptionPane.showMessageDialog(this, "The value must be a natural number.","Error",JOptionPane.ERROR_MESSAGE);
            	}
            }
        }
        
        if( DATACOMPLEX.equals( event.getActionCommand( ) ) )
        {
            File tesis=new File("complex.dat");
            String games = JOptionPane.showInputDialog(this, "Introduce number of games per case:" );
            if(games!=null)
            {
            	try
            	{
            		int number=Integer.valueOf(games);
            		principal.setGames(number);
            		try
            		{
            			principal.reqDataComplex(tesis,Double.valueOf(txtInitialDensity.getText()));
            		}
            		catch(IOException e)
            		{
            			e.printStackTrace();
            		}
            	}
            
            
            	catch(Exception e)
            	{
            		JOptionPane.showMessageDialog(this, "The value must be a natural number.","Error",JOptionPane.ERROR_MESSAGE);
            	}
            }
        }    
        
        else if( DATAISLAND.equals( event.getActionCommand( ) ) )
        {
            File tesis=new File("island.dat");
            String games = JOptionPane.showInputDialog(this, "Introduce number of games per case:" );
            if(games!=null)
            {
            	try
            	{
            		int number=Integer.valueOf(games);
            		principal.setGames(number);
            		String fit1 = JOptionPane.showInputDialog(this, "Introduce relative fitness for island 1, it must be a real between 0 and 1" );
            		
            		
            		String fit2 = JOptionPane.showInputDialog(this, "Introduce relative fitness for island 2, it must be a real between 0 and 1" );
            		
            		String fit3 = JOptionPane.showInputDialog(this, "Introduce relative fitness for island 3, it must be a real between 0 and 1" );
            		
            		String fit4 = JOptionPane.showInputDialog(this, "Introduce relative fitness for island 4, it must be a real between 0 and 1" );
            		
            		try
            		{
            			double fitness1=Double.valueOf(fit1);
            			double fitness2=Double.valueOf(fit2);
            			double fitness3=Double.valueOf(fit3);
            			double fitness4=Double.valueOf(fit4);
            			principal.reqDataIsland(tesis,fitness1,fitness2,fitness3,fitness4);
            		}
            		catch(Exception e)
            		{
            			
                    	JOptionPane.showMessageDialog(this, "One ore more of the fitness' values are not appropiate.","Error",JOptionPane.ERROR_MESSAGE);
                    	
            		}
            	}
            	catch(Exception e)
            	{
            		JOptionPane.showMessageDialog(this, "The value must be a natural number.","Error",JOptionPane.ERROR_MESSAGE);
            	}
            }
        }
        else if( DATANETWORK.equals( event.getActionCommand( ) ) )
        {
            File tesis=new File("datanetwork.dat");
            String games = JOptionPane.showInputDialog(this, "Introduce number of games per case:" );
            if(games!=null)
            {
            	try
            	{
            		int number=Integer.valueOf(games);
            		double den=Double.valueOf(txtInitialDensity.getText());
            
            		principal.setGames(number);
            		try
            		{
            			principal.reqDataNetwork(tesis,den);
            		}
            		catch(IOException e)
            		{
            			e.printStackTrace();
            		}
            	}
            	catch(Exception e)
            	{
            		JOptionPane.showMessageDialog(this, "The value must be a natural number.","Error",JOptionPane.ERROR_MESSAGE);
            	}
            }
            	
        }
        else if( RESET.equals( event.getActionCommand( ) ) )
        {
            if(txtInitialDensity.getText().equals(""))
            	principal.reset(0.1);
            else
            {	
            	try
            	{
            		double initial=Double.valueOf(txtInitialDensity.getText());
            	
            		if(initial>=0 && initial<=1)
            		{
            			principal.reset(Double.valueOf(txtInitialDensity.getText()) );
            		}
            		else
            		{
            			JOptionPane.showMessageDialog(this, "The number in 'Random Population' must be a real between 0 and 1.","Error",JOptionPane.ERROR_MESSAGE);
            		}
            	}
            		
            	catch(Exception e)
            	{
            		JOptionPane.showMessageDialog(this, "The number in 'Random Population' must be a real between 0 and 1.","Error",JOptionPane.ERROR_MESSAGE);
            	}
            }
            	
        }
        else if( PLAYSIMPLE.equals( event.getActionCommand( ) ) )
        {
            principal.playGame( );
            txtFinalDensity.setText(principal.getDensity());
            txtCluster.setText(principal.getCluster());
        }
        
        else if( PLAYSIMPLE2.equals( event.getActionCommand( ) ) )
        {
            principal.playGame2( );
            txtFinalDensity.setText(principal.getDensity());
            txtCluster.setText(principal.getCluster());
        }
        
        else if( PLAYCOMPLEX.equals( event.getActionCommand( ) ) )
        {
            principal.playGameComplex( );
            txtFinalDensity.setText(principal.getDensity());
            txtCluster.setText(principal.getCluster());
        }
        
        else if( PLAYISLAND.equals( event.getActionCommand( ) ) )
        {
        	String fit1 = JOptionPane.showInputDialog(this, "Introduce relative fitness for island 1, it must be a real between 0 and 1" );
            
            if(fit1!=null)
            {
            	String fit2 = JOptionPane.showInputDialog(this, "Introduce relative fitness for island 2, it must be a real between 0 and 1" );
            	if(fit2!=null)
            	{ 
            		String fit3 = JOptionPane.showInputDialog(this, "Introduce relative fitness for island 3, it must be a real between 0 and 1" );
            		if(fit3!=null) 
            		{ 
            			 String fit4 = JOptionPane.showInputDialog(this, "Introduce relative fitness for island 4, it must be a real between 0 and 1" );
            			if(fit4!=null )
            			{
            				try
                        	{
                        		double fitness1=Double.valueOf(fit1);
                        		double fitness2=Double.valueOf(fit2);
                        		double fitness3=Double.valueOf(fit3);
                        		double fitness4=Double.valueOf(fit4);
                        		double[] density=principal.playIsland(fitness1,fitness2,fitness3,fitness4 );
                        		txtFinalDensity.setText(density[0]+" "+density[1]+" "+density[2]+" "+density[3]);
                        	}
                        	catch(Exception e)
                        	{
                        		JOptionPane.showMessageDialog(this, "One ore more of the fitness' values are not appropiate.","Error",JOptionPane.ERROR_MESSAGE);
                        	}
            			}
            		}
            	}
            }
        	
        }
        
        else if( PLAYNETWORK.equals( event.getActionCommand( ) ) )
        {
        	File tesis=new File("network.dat");
        	String ss = JOptionPane.showInputDialog(this, "Introduce the value of the parameter s, it must be a real number" );
            
            
            if(ss!=null)
            {  
            	String tt = JOptionPane.showInputDialog(this, "Introduce the value of the parameter t, it must be a real number" );
            	if(tt!=null)
            	{
            		try
                	{
                		double s=Double.valueOf(ss);
                		double t=Double.valueOf(tt);
                		principal.playNetwork(tesis,s,t );
                		txtFinalDensity.setText(principal.getDensity());
                	}
                	catch(Exception e)
                	{
                		JOptionPane.showMessageDialog(this, "The values of the parameters are not appropiate.","Error",JOptionPane.ERROR_MESSAGE);
                	}
                }
            }
            
            
            	
        	
        
        }
        else if(RANDOM.equals( event.getActionCommand( ) )) 
        {
        	if(txtInitialDensity.getText().equals(""))
        		principal.randomInitial(0.5);
        	else
        	{	
        		try
            	{
            		double initial=Double.valueOf(txtInitialDensity.getText());
            	
            		if(initial>=0 && initial<=1)
            		{
            			principal.reset(Double.valueOf(txtInitialDensity.getText()) );
            		}
            		else
            		{
            			JOptionPane.showMessageDialog(this, "The number in 'Random Population' must be a real between 0 and 1.","Error",JOptionPane.ERROR_MESSAGE);
            		}
            	}
            		
            	catch(Exception e)
            	{
            		JOptionPane.showMessageDialog(this, "The number in 'Random Population' must be a real between 0 and 1.","Error",JOptionPane.ERROR_MESSAGE);
            	}
        	}
        	
        		
        }
        else if(ITER.equals( event.getActionCommand( ) )) 
        {
        	if(!txtIterations.getText().equals(""))
        	try
        	{
        		principal.setIterations(Integer.valueOf(txtIterations.getText()));
        	}
        	catch(Exception e)
        	{
        		JOptionPane.showMessageDialog(this, "The number of iterations must be a natural number.","Error",JOptionPane.ERROR_MESSAGE);
        	}
        	
        		
        }
        else if(POPULATION.equals( event.getActionCommand( ) )) 
        {
        	if(!txtPopulation.getText().equals(""))
        	{	
        		try
        		{
        			principal.setPopulation(Integer.valueOf(txtPopulation.getText()));
        			try
            		{
            			if(txtInitialDensity.getText().equals(""))
                        	principal.reset(0.1);
                        else
                        	principal.reset(Double.valueOf(txtInitialDensity.getText()) );
            		}
            		catch(Exception e)
                	{
                		JOptionPane.showMessageDialog(this, "The number in 'Random Population must be a real between 0 and 1.","Error",JOptionPane.ERROR_MESSAGE);
                	}
        		}
        		catch(Exception e)
            	{
            		JOptionPane.showMessageDialog(this, "The population must be a natural number.","Error",JOptionPane.ERROR_MESSAGE);
            	}
        		
        		
        		
        		
        	}
        	
        	
        		
        }
        
        else if(HELP.equals( event.getActionCommand( ) )) 
        {
        	try {
                Desktop desktop = null;
            // Before more Desktop API is used, first check 
            // whether the API is supported by this particular 
            // virtual machine (VM) on this particular host.
            if (Desktop.isDesktopSupported()) {
                desktop = Desktop.getDesktop();
               
                		File help=new File("help.txt");
                        
                        desktop.open(help);
                }
            }               
        	catch (IOException e) 
        	{
        		e.printStackTrace();
        	}
        }
        	
        	
        
    }
}
