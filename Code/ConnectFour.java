import java.awt.Color;

import javax.swing.JPanel;

import piece.ConnectFourPiece;
import piece.GamePiece;
/**
 * \\file -ConnectFour.java 
 * \author - Lam Chak Yan 667271
 * \date -21st Feb 14
 * 
 * \see BoardGame.java
 * 
 * \brief ConnectFour is used to store the game rules and control the game board 
 * extends BoardGame.java
 * 
 * This class extends from the BoardGame class. It will check the whether a 
 * column is full when the player place the pieces.
 */
public class ConnectFour extends BoardGame {
	/**
	 * This is the constructor for the ConnectFour It passes the height and the
	 * width to the BoardGame class for constructing the game board.
	 * 
	 */
	public ConnectFour() {
		super(INITIAL_X, INITIAL_Y);
	
        boolean test = false;
        if (test || m_Test) {
            System.out.println("ConnectFour :: ConnectFour() BEGIN");
        }		        
        if (test || m_Test) {
            System.out.println("ConnectFour :: ConnectFour() END");
        }
	}

	/**
	 * Place the ConnectFour piece on the game board \param x the x axis in the
	 * game board. 
	 * \param y the y axis in the game board. \param col the color
	 * of the game piece. 
	 * \return boolean return true if the action complete.
	 */
	public boolean SetPiece(int x, int y, Color col) {
        boolean test = false;
        if (test || m_Test) {
            System.out.println("ConnectFour :: SetPiece() BEGIN");
        }
        if(x < GetWidth() && x >= 0 && y < GetHeight() && y >= 0) {
		m_board[x][y] = new ConnectFourPiece(col);
        	if (test || m_Test) {
        		System.out.println("ConnectFour :: SetPiece() END");
        	}
		return true;
        } else {
        	if (test || m_Test) {
        		System.out.println("ConnectFour :: SetPiece() END");
        	}
		return false;
        }
	}

	/**
	 * Search a sequence of four pieces of the same color in all eight directions. 
	 *  \param x the x axis in the game board. 
	 *  \param index_y the lowest possible point in a column. 
	 *  \param col the color of the game piece.
	 * \return boolean return true if there is a sequence of four pieces of the
	 *  same color, false while the game is on.
	 */
	private boolean allDirection(Color col, int x, int index_y) {
        boolean test = false;
        if (test || m_Test) {
            System.out.println("ConnectFour :: allDirection() BEGIN");
        }
        
		// Search each direction (total : 8 direction)
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if(singleDirection(col, x , index_y, i ,j)){
					if (test || m_Test) {
			        System.out.println("ConnectFour :: allDirection() END");
			        }
					return true;
				}
			}
		}
        if (test || m_Test) {
            System.out.println("ConnectFour :: allDirection() END");
        }
		return false;
	}
	
	/**
	 * Search a sequence of pieces of the same color in a single direction. 
	 * \param x the x axis in the game board. 
	 * \param index_y the lowest possible point in a column. 
	 * \param col the color of the game piece.
	 * \param i the difference of width between the searching piece and 
	 * the current piece
	 * \param j the difference of height between the searching piece and the 
	 * current piece
	 * \return boolean return true if there is a sequence of four pieces of the 
	 * same color, false while the game is on.
	 */
	private boolean singleDirection(Color col, int x,int index_y,int i, int j){
        boolean test = false;
        if (test || m_Test) {
            System.out.println("ConnectFour :: singleDirection() BEGIN");
        }

		GamePiece searchPiece;
		boolean found = true;
		// boolean found = false;
		m_searchY = index_y + i;
		m_searchX = x + j;
		m_counter = 0;
		while (found) {

			if ((m_searchX >= GetWidth() || m_searchX < 0)
				|| (m_searchY >= GetHeight() ||
				m_searchY < 0)) {
				found = false;
			} else {
				searchPiece = m_board[m_searchX][m_searchY];

				// skip the search if i and j is 0.
				// skip the search if one of the direction is
				// empty
				// skip the search if one of the direction is
				// same color
				// piece
				if ((i == 0 && j == 0) || searchPiece == null
					|| searchPiece.GetColour() != col) {
					found = false;
				} else if (searchPiece.GetColour() == col) {
					found = true;
					m_counter++;
					if (m_counter ==  NUM_IN_ROW_WIN) {
					m_WinningColour = col;
				    if (test || m_Test) {
				    System.out.println(col + " wins");
				    System.out.println("ConnectFour :"
				    + ": singleDirection() END");
				    }
					return true;
					}
					m_searchY = m_searchY + i;
					m_searchX = m_searchX + j;
				}
			}
		}
        if (test || m_Test) {
            System.out.println("ConnectFour :: singleDirection() END");
        }
		return false;
	}
	
	/**
	 * Check the winning condition by searching a sequence of pieces of the 
	 * same color in the game board. 
	 * \param col the color of the game piece.
	 * \return boolean return true if there is a sequence of four pieces of the
	 * same color, false while the game is on.
	 */
	private boolean checkWin(Color col){
        boolean test = false;
        if (test || m_Test) {
            System.out.println("ConnectFour :: checkWin() BEGIN");
        }

		for (int x = 0; x <= GetWidth(); x++) {
			for (int index_y = 0; index_y <= GetHeight(); index_y++) {
				if(allDirection(col, x , index_y)){
			        if (test || m_Test) {
			        System.out.println("ConnectFour :"
			        + ": singleDirection() END");
			        }
					return true;
				}
			}
		}
        if (test || m_Test) {
            System.out.println("ConnectFour :: checkWin() END");
        }
		return false;
	}
	
	
		
	/**
	 * If the move is valid, place the piece on the game board and check the
	 * winning condition. \param x the x axis in the game board. \param y the y
	 * axis in the game board. \param col the color of the game piece. \return
	 * boolean return true if the move is valid and the piece has been placed on
	 * the game board, false if the column is full.
	 */
	public boolean Move(int x, int y, Color col) {
        boolean test = false;
        if (test || m_Test) {
            System.out.println("ConnectFour :: Move() BEGIN");
        }
        
		int index = 0;
		if (m_board[x][0] == null) {
			for (int h = 0; h < GetHeight(); ++h) {
				if (m_board[x][h] == null) {
					index = h;
				}
			}
			//TODO GetAnimationController().animate(x,index,col) here?
			GetAnimationController().animate(x,index,col,0);
			
			SetPiece(x, index, col);
			
			checkWin(col);
            if (test || m_Test) {
                System.out.println("ConnectFour :: Move() END :: true");
            }
			return true;
		} else {
			System.out.println("Space Occupied");
            if (test || m_Test) {
                System.out.println("ConnectFour :: Move() END :: false");
            }
			return false;
		}
	
	}
	
	/**
	 * Highlights the winner 4 pieces of the winning player
	 * \param panels - the array of the board
	 * \param winner - the colour of the winner
	 */
	public void HighlightWinners(JPanel[][] panels, Color winner) {
		System.out.println("ConnectFour :: HighlightWinners");
		for (int y = 0; y < GetHeight(); y++) {
			for (int x = 0; x < GetWidth(); x++) {
				if (RightHighlight(panels, winner, x, y)) return;
				if (DownHighlight(panels, winner, x, y)) return;
				if (DiagHighlight1(panels, winner, x, y)) return;
				if (DiagHighlight2(panels, winner, x, y)) return;
			}
		}
	}
	
	/**
	 * Highlight the 4 winning pieces starting from the left most piece
	 * and moving right
	 * \param p - array of JPanels (the board)
	 * \param winner - Colour of the winning player
	 * \param x - x coordinate of left most piece
	 * \param y - y coordinate of left most piece
	 * \return true if successful
	 */
	private boolean RightHighlight(JPanel[][] p, Color winner, int x, int y) {
		if (x + 3 >= GetWidth()) { return false; }
		
		if (
			(GetNonNullPiece(x,y).GetColour() == winner) &&
			(GetNonNullPiece(x+1,y).GetColour() == winner) &&
			(GetNonNullPiece(x+2,y).GetColour() == winner) &&
			(GetNonNullPiece(x+3,y).GetColour() == winner)
		) {
			p[x][y].setBackground(Color.CYAN);
			p[x+1][y].setBackground(Color.CYAN);
			p[x+2][y].setBackground(Color.CYAN);
			p[x+3][y].setBackground(Color.CYAN);
			return true;
		}
		
		return false;
	}
	
	/**
	 * Highlight the 4 winning pieces starting from the top piece
	 * and moving down
	 * \param p - array of JPanels (the board)
	 * \param winner - Colour of the winning player
	 * \param x - x coordinate of top piece
	 * \param y - y coordinate of top piece
	 * \return true if successful
	 */
	private boolean DownHighlight(JPanel[][] p, Color winner, int x, int y) {
		if (y + 3 >= GetHeight()) { return false; }
		
		if (
			(GetNonNullPiece(x,y).GetColour() == winner) &&
			(GetNonNullPiece(x,y+1).GetColour() == winner) &&
			(GetNonNullPiece(x,y+2).GetColour() == winner) &&
			(GetNonNullPiece(x,y+3).GetColour() == winner)
		) {
			p[x][y].setBackground(Color.CYAN);
			p[x][y+1].setBackground(Color.CYAN);
			p[x][y+2].setBackground(Color.CYAN);
			p[x][y+3].setBackground(Color.CYAN);
			return true;
		}
		
		return false;
	}

	/**
	 * Highlight the 4 winning pieces starting from top left most one
	 * and moving down and right
	 * \param p - array of JPanels (the board)
	 * \param winner - Colour of the winning player
	 * \param x - x coordinate of top left most piece
	 * \param y - y coordinate of top left most piece
	 * \return true if successful
	 */
	private boolean DiagHighlight1(JPanel[][] p, Color winner, int x, int y) {
		// go down and right
		if (x + 3 >= GetWidth()) { return false; }
		if (y + 3 >= GetHeight()) { return false; }
		
		if (
			(GetNonNullPiece(x,y).GetColour() == winner) &&
			(GetNonNullPiece(x+1,y+1).GetColour() == winner) &&
			(GetNonNullPiece(x+2,y+2).GetColour() == winner) &&
			(GetNonNullPiece(x+3,y+3).GetColour() == winner)
		) {
			p[x][y].setBackground(Color.CYAN);
			p[x+1][y+1].setBackground(Color.CYAN);
			p[x+2][y+2].setBackground(Color.CYAN);
			p[x+3][y+3].setBackground(Color.CYAN);
			return true;
		}
		
		return false;
	}

	/**
	 * Highlight the 4 winning pieces starting from bottom left most one
	 * and moving up and right
	 * \param p - array of JPanels (the board)
	 * \param winner - Colour of the winning player
	 * \param x - x coordinate of bottom left most piece
	 * \param y - y coordinate of bottom left most piece
	 * \return true if successful
	 */
	private boolean DiagHighlight2(JPanel[][] p, Color winner, int x, int y) {
		// go up and right
		if (x + 3 >= GetWidth()) { return false; }
		if (y -3 <= 0) { return false; }
		
		if (
			(GetNonNullPiece(x,y).GetColour() == winner) &&
			(GetNonNullPiece(x+1,y-1).GetColour() == winner) &&
			(GetNonNullPiece(x+2,y-2).GetColour() == winner) &&
			(GetNonNullPiece(x+3,y-3).GetColour() == winner)
		) {
			p[x][y].setBackground(Color.CYAN);
			p[x+1][y-1].setBackground(Color.CYAN);
			p[x+2][y-2].setBackground(Color.CYAN);
			p[x+3][y-3].setBackground(Color.CYAN);
			return true;
		}
		
		return false;
	}
	
	/**
	 * Call the setWinner method to set the winning color when the game ends.
	 * \return boolean return true if one of the players wins the game, false if
	 * the game is on.
	 */
	@Override
	public boolean WinningCondition() {
        boolean test = false;
        if (test || m_Test) {
            System.out.println("ConnectFour :: WinningCondition() BEGIN");
        }

		if (m_counter >= NUM_IN_ROW_WIN) {
			SetWinner();
	        if (test || m_Test) {
	            System.out.println("ConnectFour :: singleDirection() END");
	        }
			return true;
		}
		m_Draw = true;
		for (int x = 0; x < GetWidth(); x++) {
			if (m_board[x][0] == null) {
				m_Draw = false;
		        if (test || m_Test) {
		            System.out.println("ConnectFour :: singleDirection() END");
		        }
				return m_Draw;
			}
		}
		if (m_Draw == true) {
			m_WinningColour = null;
			SetWinner();
	        if (test || m_Test) {
	            System.out.println("ConnectFour :: singleDirection() END");
	        }
			return true;
		}
        if (test || m_Test) {
            System.out.println("ConnectFour :: WinningCondition() END");
        }
		return false;
	}
	
	@Override
	public char[][] AvailableMove(Color col) {
		char grid[][] = new char[GetWidth()][GetHeight()];
		for(int x = 0; x < GetWidth(); x++) {
			boolean rowPieceEnd = false;
			for (int y = GetHeight() - 1; y >= 0; y--) {
				if(m_board[x][y] != null || rowPieceEnd) {
					grid[x][y] = 'X';
				}
				else if (m_board[x][y] == null) {
					grid[x][y] = 'O';
					rowPieceEnd = true;
				} 
			}
		}
		return grid;
	}

	/**
	 * Set the winning color for access from superclass. \return boolean return
	 * true if one of the players wins the game, false if the game is on.
	 */
	@Override
	public boolean SetWinner() {
        boolean test = false;
        if (test || m_Test) {
            System.out.println("ConnectFour :: SetWinner() BEGIN");
        }
		SetWinningColour(m_WinningColour);
		if (test || m_Test) {
			System.out.println("ConnectFour :: SetWinner() END");
		}
		return true;
		
	}
	

	@Override
	public int MoveQuality(int x, int y, Player current) {
		int moveScoreHor = 0;
		int moveScoreVer = 0;
		int moveScoreLDia = 0;
		int moveScoreRDia = 0;
		final int MOVE_UP = 1;
		final int MOVE_DOWN = -1;
		
		Color color = current.GetPieceColour();
		moveScoreHor += lineQuality(x, y, 0, MOVE_UP, color);
		moveScoreHor += lineQuality(x, y, 0, MOVE_DOWN, color);
		moveScoreVer += lineQuality(x, y, MOVE_UP, 0, color);
		moveScoreVer += lineQuality(x, y, MOVE_DOWN, 0, color);
		moveScoreLDia += lineQuality(x, y, MOVE_UP, MOVE_UP, color);
		moveScoreRDia += lineQuality(x, y, MOVE_DOWN, MOVE_UP, color);
		moveScoreRDia += lineQuality(x, y, MOVE_UP, MOVE_DOWN, color);
		moveScoreLDia += lineQuality(x, y, MOVE_DOWN, MOVE_DOWN, color);
		return Math.max(moveScoreHor, Math.max(moveScoreVer, Math.max(moveScoreLDia, moveScoreRDia)));
	}
	
	/**
	 * Retrieve the quality of a move on a single plane
	 * \param dx - x coordinate of the piece
	 * \param dy - y coordinate of the piece
	 * \param deltaX - how much to move in the x direction
	 * \param deltaY - how much to move in the y direction
	 * \param color - Colour of the current piece
	 * \return score of the move
	 */
	private int lineQuality(int dx, int dy, int deltaX, int deltaY, Color color) {
		int moveScore = 0;
		int score = 0;
		boolean notWall = true;
		do {
			dx += deltaX;
			dy += deltaY;
			if (dx < 0 || dy < 0 || dx >= GetWidth() || dy >= GetHeight()) {
				moveScore = score;
				break;
			}
			if (GetPiece(dx,dy) == null) {
				moveScore = score;
				break;
			}
			if(GetPiece(dx,dy).GetColour() == color) {
				score++;
			} else {
				moveScore = score;
				notWall = false;
			}
		} while (notWall);
		return moveScore;
	}
    
    /** main method for tests */
    public static void main(String[] args) {
        ConnectFour a = new ConnectFour();
        a.SetPiece(3,3,Color.RED);
        a.allDirection(Color.YELLOW,4,4);
        a.singleDirection(Color.RED,2,3,4,5);
        a.checkWin(Color.YELLOW);
        a.Move(2,4,Color.RED);
        a.WinningCondition();
        a.SetWinner();
    }

    /**checks to see if there is available space to draw a piece, draw means no winner (true = draw)*/
	private boolean m_Draw;
	/** integers to store the values to search next on the board for the winning conditions*/
	private int m_searchY, m_searchX;
	/**Counts the current pieces in a sequence to check for a win*/
	private int m_counter;
	/**Stores the winning colour to output on the message dialogue*/
	private Color m_WinningColour;
	//The following two int's are static due to calling the BoardGame in method.
	/**Sets the Size in BoardGame (is static due to calling the BoardGame in method*/
	private final static int INITIAL_X = 10;
	/**Sets the Size in BoardGame (is static due to calling the BoardGame in method*/
	private final static int INITIAL_Y = 7;
	/**The number of pieces in a row required to have a win*/
	private final int NUM_IN_ROW_WIN = 4;
	/**Used for testing purposes*/
    private boolean m_Test = false;
}
