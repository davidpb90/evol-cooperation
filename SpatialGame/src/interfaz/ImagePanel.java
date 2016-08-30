package interfaz;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class ImagePanel extends JPanel{
	
	  public ImagePanel( )
	    {
	        JLabel image = new JLabel( );
	        ImageIcon icono = new ImageIcon( "data/title.png" );
	        // The label is added
	        image = new JLabel( "" );
	        image.setIcon( icono );
	        add( image );

	        setBackground( Color.BLACK );
	        setBorder( new LineBorder( Color.BLACK ) );
	    }

}
