package piece;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.ImageIcon;
/**
 * \\file   TicTacToePiece.java
 * \author  Lewis Edwards 708830
 * \date   -27th April '14
 * 
 * \brief Tic Tac Toe game piece used in a game of TicTacToe,
 * extends GamePiece.java
 * 
 * This is an extension of the GamePiece class, where the icons
 * differ from other piece types.
 */
public class TicTacToePiece extends GamePiece{
    
	
	/**
     * Accessor method to retrieve the ImageIcon of the piece
     * \return Icon depending on piece colour
     */
    public Icon GetIcon() {
        boolean test = false;
        if (test || m_test) {
            System.out.println("OthelloPiece :: getIcon() BEGIN");
        }
        if (m_iconsSet) {
            if (GetColour() == Color.BLACK) {
                if (test || m_test) {
                System.out.println("OthelloPiece :: getIcon() END");
                }
                return m_blackpiece;
            } else if (GetColour() == Color.WHITE){
                if (test || m_test) {
                System.out.println("OthelloPiece :: getIcon() END");
                }
                return m_whitepiece;
            } else {
            	return null;
            }
        }
        return null;
    }
    
    /**
     * Accessor method to set the ImageIcons of a piece
     * \return boolean on success
     * \throws NullPointerException
     */
    public boolean SetIcons()  throws NullPointerException {
        boolean test = false;
        if (test || m_test) {
            System.out.println("OthelloPiece :: setIcons() BEGIN");
        }
        
        String crossImageURL = "cross.png";
        String naughtImageURL = "naught.png";
        
        try {
            m_blackpiece = new ImageIcon
            (getClass().getResource(crossImageURL));
            m_whitepiece = new ImageIcon
            (getClass().getResource(naughtImageURL));
            
            if (test || m_test) {
            System.out.println("OthelloPiece :: setIcons() END");
            }
            
            return true;
        } catch (NullPointerException e) {
            System.out.println("Images Not Found");
        }
        
        if (test || m_test) {
        	System.out.println("OthelloPiece :: setIcons() END");
        }
        
        return false;
    }
    
    /**
     * Constructor of OthelloPiece, calls  setColour() and setIcons()
     * \param col a String to set colour using setColour() of the superclass
     */
    public TicTacToePiece(Color col) {
        boolean test = false;
        if (test || m_test) {
            System.out.println("OthelloPiece :: OthelloPiece() BEGIN");
        }
        
        if (col == Color.WHITE || col == Color.BLACK) {
            SetColour(col);
            m_iconsSet = SetIcons();
        } else {
            System.out.println("Invalid Colours");
        }
        
        if (test || m_test) {
            System.out.println("OthelloPiece :: OthelloPiece() END");
        }
    }
       
    /** main method for tests */
    public static void main(String[] args) {
        OthelloPiece a = new OthelloPiece(Color.RED);
        a.GetIcon();
        a.SetIcons();
        a.GetColour();
        
        OthelloPiece b = new OthelloPiece(Color.BLACK);
        b.GetIcon();
        b.SetIcons();
        b.GetColour();
    }
    
    //variable declarations
    /** flaf for the seting of the icons */
    private boolean m_iconsSet = false;
    /** Strings for colours */
    private final String m_white = "white";
    private final String m_black = "black";
    /** store the black icon */

    private Icon m_blackpiece;
    /** store the white icon */
    private Icon m_whitepiece;
    /** Indicates whether to run tests */
    private boolean m_test = false;
}