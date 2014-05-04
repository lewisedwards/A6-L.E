import java.awt.Color;

import javax.swing.BorderFactory;

import piece.TicTacToePiece;

/**
 * \\file TicTacToeGUI.java 
 * 
 * \author Lewis Edwards 708830
 * 
 * \date -23nd April '14
 * 
 * \see GUI.java
 * 
 * \brief TicTacToeGUI is used to set up and update the background of the TicTacToe
 *  game board. 
 *  
 * This class extends from the GUI class, it changes the background colors of 
 * each square with different available moves.extends GUI.java
 * 
 * Due to problems of trying to test in the main. 
 * Testing is done in another class
 */
public class TicTacToeGUI extends GUI {

	 /**
     * Set the player names, scores, player turn, the pass and new game button
     *  to display on screen.
     * \return boolean  return true if the action complete.
     */	
	public boolean setInfo() {
		boolean test = false;
		if (test || m_test){
			System.out.println("TicTacToeGUI :: SetTicTacToeInfo() BEGIN");
		}
		
		m_playerOneColor.setText(GetGame().GetPlayerName(Color.BLACK) + ":");
		m_playerOneColor.setFont(FONT);
		m_playerOneColor.setVisible(true);
		TicTacToePiece black = new TicTacToePiece(Color.BLACK);
		m_playerOneIcon.setIcon(black.GetIcon());
		m_playerOneIcon.setVisible(true);
		m_playerTwoColor.setText(GetGame().GetPlayerName(Color.WHITE) + ":");
		m_playerTwoColor.setFont(FONT);
		m_playerTwoColor.setVisible(true);
		TicTacToePiece white = new TicTacToePiece(Color.WHITE);
		m_playerTwoIcon.setIcon(white.GetIcon());
		m_playerTwoIcon.setVisible(true);
		m_playerTurnIcon.setIcon(new TicTacToePiece(
				GetGame().GetCurrent().GetPieceColour()).GetIcon());
		m_playerTurnIcon.setVisible(true);
		m_playerTurnLabel.setText(
			GetGame().GetCurrent().GetPlayerName() + "'s TURN");
		m_playerTurnLabel.setFont(FONT);
		m_playerTurnLabel.setVisible(true);
		m_blackIcon.setIcon(black.GetIcon());
		m_blackIcon.setVisible(true);
		//m_blackPieces.setText(((TicTacToe) (GetBoard())).GetBlackScore() + "");
		m_blackPieces.setFont(FONT);
		m_blackPieces.setVisible(true);
		m_whiteIcon.setIcon(white.GetIcon());
		m_whiteIcon.setVisible(true);
		//m_whitePieces.setText(((TicTacToe) (GetBoard())).GetWhiteScore() + "");
		m_whitePieces.setFont(FONT);
		m_whitePieces.setVisible(true);
		PASSMOVE.setVisible(true);
		FRAME.pack();
		
		if (test || m_test){
			System.out.println("TicTacToeGUI :: SetTicTacToeInfo() END");
		}
		
		return true;
	}

	 /**
     * Set the background colour and border of each square in the game board 
     * with regard to available moves of different player. 
     * \return boolean  return true if the action complete.
     */
	public boolean setPanelColour() {
		boolean test=false;
		if (test || m_test){
			System.out.println("TicTacToeGUI :: SetPanelColour() BEGIN");
		}
		
		//char[][] availableMoves = ((TicTacToe) GetBoard())
			//	.AvailableMove(GetGame().GetCurrent().GetPieceColour());
		Color defCol = BACKGROUND_COLOR;
		for (int y = 0; y < GetBoard().GetHeight(); ++y) {
			for (int x = 0; x < GetBoard().GetWidth(); ++x) {
			GetPanel(x, y).setBorder(BorderFactory
					.createLineBorder(Color.black));
					GetPanel(x, y).setBackground(defCol);
				
			}
		}
		
		
		if (test || m_test){
			System.out.println("TicTacToeGUI :: SetPanelColour() END");
		}
		
		return true;
	}
	
    /**
    * Constructor of TicTacToeGUI, calls the constructor of GUI for constructing
    * the game board and sets the player information.
    * \param a BoardGame object which is in TicTacToe type,
    * a GameController object
    */
	public TicTacToeGUI(BoardGame b, GameController g) {
		super(b, g);
		setInfo();
	}
	/** boolean turn to true to print out begining and ends of methods*/
	boolean m_test = false;
	private final int BACK_RED = 170;
	private final int BACK_GREEN = 150;
	private final int BACK_BLUE = 100;
	/** background colour */
	private final Color BACKGROUND_COLOR = 
			new Color(BACK_RED, BACK_GREEN, BACK_BLUE);

}
