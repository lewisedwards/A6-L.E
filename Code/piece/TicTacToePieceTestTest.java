package piece;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

/** This is a test class
* \\file   TicTacToePieceTest.java
* \author  Lewis Edwards 708830
* \date   4th May '14
*  \see TicTacToePiece.java , GamePiece.java
*
* \brief This class tests the TicTacToe Piece
*
* The TicTacToePiece was tested with invalid colours that are valid for 
* the other class. There was also tests of numebrs which shouldn't be allowed
* and there was tests for setting the Icons. As TicTacToePiece inherits from
* GamePiece.java therefore this goes towards testing that class.
*/

public class TicTacToePieceTestTest {

	/**Tests both TicTacToePiece.java and GamePiece.java*/
	TicTacToePiece OthPiece;
	@Test
	public void testGetIcon() {
		OthPiece = new TicTacToePiece(Color.BLACK);
		assertTrue(OthPiece.GetIcon() != null);
		OthPiece = new TicTacToePiece(Color.WHITE);
		assertTrue(OthPiece.GetIcon() != null);
		/**Tests that there is still a piece being set*/
		OthPiece = new TicTacToePiece(Color.RED);
		assertTrue(OthPiece.GetIcon() == null);
		OthPiece = new TicTacToePiece(Color.YELLOW);
		assertTrue(OthPiece.GetIcon() == null);
		OthPiece = new TicTacToePiece(null);
		assertTrue(OthPiece.GetIcon() == null);
		
	}

	@Test
	public void testSetIcons() {
		System.out.println("SetIcons() Cannot be tested like this" +
				"but instead is tested by attempting to set pieces above.");
	}

	@Test
	public void testTicTacToePiece() {
		OthPiece = new TicTacToePiece(Color.BLACK);
		assertTrue(OthPiece.SetIcons());
		OthPiece = new TicTacToePiece(Color.WHITE);
		assertTrue(OthPiece.SetIcons());
		OthPiece = new TicTacToePiece(Color.YELLOW);
	}

}
