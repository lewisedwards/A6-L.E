import java.awt.Color;

import javax.swing.JPanel;

import piece.ConnectFourPiece;
import piece.GamePiece;
/**
 * \\file -BoardGame.java 
 * \author Chun Kit So 742666
 * \date -20nd Feb 14
 * 
 * \see ConnectFour.java
 * \see Othello.java
 * 
 * \brief BoardGame is an abstract class 
 * 
 * BoardGame is the superclass of both Othello and Connect Four class
 */
public abstract class BoardGame {
	
	 /**
     * Set the board height.
     * \return boolean  return true if the action completes..
     */
	public boolean SetHeight(int y){
		boolean test = false;
        
        if (test || m_test) {
            System.out.println("BoardGame :: SetHeight() BEGIN");
        }
        if (y > 0) {
            m_height= y;
        }
        
        if (test || m_test) {
            System.out.println("BoardGame :: SetHeight() END");
        }
		return true;
	}

	 /**
     * Get the board height.
     * \return int  return the board height.
     */
	public int GetHeight() {
        boolean test = false;
        if (test || m_test) {
            System.out.println("BoardGame :: GetHeight() BEGIN");
        }
        if (test || m_test) {
            System.out.println("BoardGame :: GetHeight() END");
        }
        
	    return m_height;
	}

	/**
	 * Set the m_animationController object
	 * \param a - Animation object to set the AnimationController object to
	 */
	public void SetAnimationController(Animation a) {
		m_animationController = a;
	}
	
	/**
	 * Get the animation controller
	 * \return the variable m_animationController
	 */
	public Animation GetAnimationController() {
		return m_animationController;
	}
	
	/**
	 * Abstract method to highlight the winning pieces in a game
	 * \param panels - the array of the board
	 * \param winner - the colour of the winner
	 */
	public abstract void HighlightWinners(JPanel[][] panels, Color winner);
	
	/**
	 * Gets a non-null piece, if the piece is null
	 * return an arbirtary colour (in this case pink)
	 * \param x - the x coordinate of the piece
	 * \param y - the y coordinate of the piece
	 * \return 
	 */
	public GamePiece GetNonNullPiece(int x, int y) {
		if (m_board[x][y] == null) {
			return new ConnectFourPiece(Color.PINK); // HACK
		}
		else {
			return GetPiece(x, y);
		}
	}
	
	 /**
     * Get the board height.
     * \param x and y, the position of the GamePiece.
     * \return GamePiece  return the GamePiece object of relative position.
     */
	public GamePiece GetPiece(int x, int y) {
        boolean test = false;
        if (test || m_test) {
            System.out.println("BoardGame :: GamePiece() BEGIN");
        }

	    if  (m_board[x][y] != null) {
	        if (test || m_test) {
	            System.out.println("BoardGame :: GamePiece() END");
	        }
	        
	        return m_board[x][y];
	    } else {
	        if (test || m_test) {
	            System.out.println("BoardGame :: GamePiece() END");
	        }
	        
	        return null;
	    }
	}
	
	/**
	 * Set a location of the board to a certain piece
	 * \param x - the x coordinate of the piece
	 * \param y - the y coordinate of the piece
	 * \param piece - The piece to set the coordinate to
	 * \return true
	 */
	public boolean SetPiece(int x, int y, GamePiece piece) {
		m_board[x][y] = piece;
		return true;
	}
	
	/**
	 * Abstract method to find out how good a certain move is
	 * \param x - x coordinate of move
	 * \param y - y coordinate of move
	 * \param current - current player
	 * \return an integer how good the move is, higher means better move
	 */
	public abstract int MoveQuality(int x, int y, Player current);

	/**
     * Abstract method
     * \param x and y, the position of the GamePiece, the colour of the piece.
     * \return boolean
     */
	public abstract boolean SetPiece(int x, int y, Color col);

	 /**
     * Get the total number of pieces on the game board.
     * \return int  return the number of pieces on the game board.
     */
	public int GetTotalPieces() {
        boolean test = false;
        if (test || m_test) {
            System.out.println("BoardGame :: GetTotalPieces() BEGIN");
        }

	    int count = 0;
	    for (int y = 0; y < m_height; ++y) {
	        for (int x = 0; x < m_width; ++x) {
	            if (m_board[x][y] != null) {
	                count++;
	            }
	        }
	    }
	    if (test || m_test) {
            System.out.println("BoardGame :: GetTotalPieces() END");
        }  
	    
	    return count;               
	}

	/**
     * Set the board width.
     * \return boolean  return true if the action completes..
     */
	public boolean SetWidth(int x){
        boolean test = false;
        if (test || m_test) {
            System.out.println("BoardGame :: SetWidth() BEGIN");
        }
        if (x > 0) {
            m_width = x;
        }
		
		if (test || m_test) {
            System.out.println("BoardGame :: SetWidth() END");
        }
		
		return true;        
    }

	 /**
     * Get the board width.
     * \return int  return the board width.
     */
	public int GetWidth() {
        boolean test = false;
        if (test || m_test) {
            System.out.println("BoardGame :: GetWidth() BEGIN");
        }
        if (test || m_test) {
            System.out.println("BoardGame :: GetWidth() END");
        }
        
	    return m_width;
	}

	/**
     * Set the colour of pieces meet the winning condition to winningColour.
     * \param the winning colour.
     * \return boolean  return true if the action completes..
     */
	public boolean SetWinningColour(Color winningColour) {
        boolean test = false;
        
        if (test || m_test) {
            System.out.println("BoardGame :: SetWinningColour() BEGIN");
        }

	    m_winningColour = winningColour;
	   
	    if (test || m_test) {
            System.out.println("BoardGame :: SetWinningColour() END");
        }
	    return true;
	}

	/**
     * Get the winning colour.
     * \return String  return the colour.
     */
	public Color GetWinningColour() {
        boolean test = false;
        
        if (test || m_test) {
            System.out.println("BoardGame :: GetWinningColour() BEGIN");
        }
        if (test || m_test) {
            System.out.println("BoardGame :: GetWinningColour() END");
        }
        
	    return m_winningColour;        
	}
		 
	/**
     * Abstract method.
     * \return boolean
     */
	public abstract boolean SetWinner();

	/**
     * Constructor of BoardGame, create a game board that stores the game pieces.
     * \param width and the height of the game board.
     */
	public BoardGame(int x, int y) {
        boolean test = false;
        
        if (test || m_test) {
            System.out.println("BoardGame :: BoardGame() BEGIN");
        }

	   SetWidth(x);
	   SetHeight(y);
	   m_board = new GamePiece[m_width][m_height];
        
        if (test || m_test) {
            System.out.println("BoardGame :: BoardGame() END");
        }
	}
	
	/**
     * Abstract method.
     * \param X,y position and the colour of the piece.
     * \return boolean
     */
	public abstract boolean Move(int x, int y, Color col);

	/**
     * Abstract method.
     * \return boolean
     */
	public abstract boolean WinningCondition();

	/**
	 * Provides an array map of the available moves for the indicated colour.
	 * @param col The player's colour which the available moves should be computed for
	 * @return A two dimensional array grid indicating available moves. An 'O' indicates this
	 * grid position is a valid move while an 'X' indicates it is not.
	 */
	public abstract char[][] AvailableMove(Color col);
	
	/**
     * This method is used for testing
     * \return String  gameBoard consists of texts.
     */
	@Override
	public String toString() {
        boolean test = false;
        
        if (test || m_test) {
            System.out.println("BoardGame :: toString() BEGIN");
        }

	    String boardStateString = "";
	    String newline = System.getProperty("line.separator");
	    
	    for (int y = 0; y < m_height; ++y) {
	        for (int x = 0; x < m_width; ++x) {
	            if (m_board[x][y] != null) {
	                boardStateString += "[" + m_board[x][y].GetColour() + "] ";
	            } else {
	                boardStateString += "[" + null + "] "; 
	            }
	            
	            if (x == m_width-1) {
	                boardStateString += newline;
	            }
	        }
	    }
	    
	    if (test || m_test) {
            System.out.println("BoardGame :: toString() END");
        }
	    return boardStateString;
	}

	/**The piece position on the board*/
	protected GamePiece[][] m_board;
	/**The board width*/
    private int m_width;
    /**The board height*/
    private int m_height;
    /**The winning colour string value is stored here*/
    private Color m_winningColour;
    /**For testing purposes*/
    private boolean m_test = false;
    /**For triggering animations*/
    private Animation m_animationController;
}
