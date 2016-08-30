package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import interfaz.GameGUI;


import mundo.Cell;
import mundo.Game;


public class BoardPanel extends JPanel {
	 // -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------

   

    // -----------------------------------------------------------------
    // Fields
    // -----------------------------------------------------------------

    /**
     * Main application window
     */
    private GameGUI principal;

    /**
     * It represents the cells color when the sudoku is solved
     */
    private Color cooperatorColor;

    /**
     * It represents the cells color when the sudoku has errors
     */
    private Color defectorColor;
    
    private Color bDefectorColor;
    
    private Color bCooperatorColor;

    /**
     * It represents the cells color when they are empty
     */
    private Color emptyColor;
    
   

    // -----------------------------------------------------------------
    // GUI Fields
    // -----------------------------------------------------------------

    /**
     * The board cells
     */
    private JPanel[][] dCells;

    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------
    /**
     * Constructor using fields.
     * @param mainWindow Main application window
     */
    public BoardPanel( GameGUI mainWindow,int population )
    {
       
    	// the fields and properties of the panel are initialized
        principal = mainWindow;
        setLayout( new GridLayout(population,population));
        setBackground( Color.BLACK );
        setSize(500,500);
        // Colors
        cooperatorColor = Color.RED;
        defectorColor = Color.GREEN;
        bCooperatorColor= Color.BLUE;
        bDefectorColor=Color.YELLOW;
        emptyColor = new Color( 229, 132, 15 );

        dCells = new JPanel[population][population];

        
        Cell[][] initial=principal.getBoardCells();
    
        
        
        for( int i = 0; i < population; i++ )
        {
            for( int j = 0; j < population; j++ )
            {
                dCells[ i ][ j ] = new JPanel( );
                if (initial[i][j].getStrategy()==mundo.Game.COOPERATOR)
                {
                	dCells[i][j].setBackground(cooperatorColor);
                }
                else
                {
                	dCells[i][j].setBackground(defectorColor);
                }
                add( dCells[ i ][ j ] );
            }
        }

      
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------
    /**
     * It repaints the cells
     */
    public void updateBoard( ) throws Exception
    {
        
        	
    	removeAll();
    	Cell[][] initial = principal.getBoardCells( );

    	dCells = new JPanel[principal.getPopulation()][principal.getPopulation()];
    	this.setLayout( new GridLayout(principal.getPopulation(),principal.getPopulation()));
        for( int i = 0; i < principal.getPopulation(); i++ )
        {
            for( int j = 0; j < principal.getPopulation(); j++ )
            {
              
                dCells[i][j]=new JPanel();
            	if (initial[i][j].getStrategy()==mundo.Game.COOPERATOR)
                {
                	if(initial[i][j].getChanges()==true)
                		dCells[i][j].setBackground(bDefectorColor);
                	else	
                		dCells[i][j].setBackground(cooperatorColor);
                }
                else
                {
                	if(initial[i][j].getChanges()==true)
                		dCells[i][j].setBackground(bCooperatorColor);
                	else
                		dCells[i][j].setBackground(defectorColor);
                }
                this.setSize(500,500);
            	this.add(dCells[ i ][ j ]);
                
            }
        }
        revalidate();
    }

   

   

}
