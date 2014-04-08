import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

/**
 * \\file - AIHard.java
 * \author Jiaming Dong - 742299
 * \date 27/03/2014
 * 
 * \brief This class pick a move by using logic.
 */

public class AIHard extends Player{

    /**
     * Set the name and color of the AI player
     * \param name - the name of the player
     * \param color - the color of the player used
     */
	public AIHard(String name, Color color) {
		SetPlayerName(name);
		SetPieceColor(color);
	}
	
	/**
	 * Get X coordinate.
	 */
	@Override
	public int getX() {
		return m_X;
	}
	/**
	 * Get Y coordinate.
	 */
	@Override
	public int getY() {
		return m_Y;
	}
	/**
	 * Check is the player a AI player.
	 */
	@Override
	public boolean isAI() {
		return true;
	}
	
	/**
	 * Pick a move.
	 */
	public boolean takeMove(){
		final int XCOORD = 0;
		final int YCOORD = 1;
		final int MOVESCORE = 2;
		ArrayList<int[]> moves = new ArrayList<int[]>();
		char[][] availableMoves = (GetBoard())
				.AvailableMove(GetPieceColour());
		
		for (int y = 0; y < GetBoard().GetHeight(); ++y) {
			for (int x = 0; x < GetBoard().GetWidth(); ++x) {
				if (availableMoves[x][y] == 'O') {
					int score = GetBoard().MoveQuality(x,y,this);
					int[] move = {x, y, score};
					moves.add(move);
				}
			}
		}
		
		int position_max = 0;
		for(int i=0; i < moves.size() ;i++){
			if (moves.get(i)[MOVESCORE] > moves.get(position_max)[MOVESCORE]) {
				position_max = i;
			}
		}
		
		ArrayList<int[]> bestMoves = new ArrayList<int[]>();
		bestMoves.add(moves.get(position_max));
		for (int i = 0; i < moves.size(); i++) {
			if(moves.get(i)[MOVESCORE] == moves.get(position_max)[MOVESCORE]) {
				bestMoves.add(moves.get(i));
			}
		}
		
		Random ran = new Random();
		int random = ran.nextInt(bestMoves.size());
					
		m_X = bestMoves.get(random)[XCOORD];	
		m_Y = bestMoves.get(random)[YCOORD];
		
		return true;
	}
	
	/**
	 * Global variables.
	 */
	private int m_X;
	private int m_Y;
}
