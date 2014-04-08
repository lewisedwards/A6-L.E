package piece;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

/** This is a test class
* \\file   -OthelloPieceTest.java
* \author -Mathew Lloyd 711293
* \date   -24th Feb 14
*  \see OthelloPiece.java , GamePiece.java
*
* \brief This class tests the Othello Piece
*
* The OthelloPiece was tested with invalid colours that are valid for 
* the other class. There was also tests of numebrs which shouldn't be allowed
* and there was tests for setting the Icons. As OthelloPiece inherits from
* GamePiece.java therefore this goes towards testing that class.
*/

public class OthelloPieceTest {

	/**Tests both OthelloPiece.java and GamePiece.java*/
	OthelloPiece OthPiece;
	@Test
	public void testGetIcon() {
		OthPiece = new OthelloPiece(Color.BLACK);
		assertTrue(OthPiece.GetIcon() != null);
		OthPiece = new OthelloPiece(Color.WHITE);
		assertTrue(OthPiece.GetIcon() != null);
		/**Tests that there is still a piece being set*/
		OthPiece = new OthelloPiece(Color.RED);
		assertTrue(OthPiece.GetIcon() == null);
		OthPiece = new OthelloPiece(Color.YELLOW);
		assertTrue(OthPiece.GetIcon() == null);
		OthPiece = new OthelloPiece(null);
		assertTrue(OthPiece.GetIcon() == null);
		
	}

	@Test
	public void testSetIcons() {
		System.out.println("SetIcons() Cannot be tested like this" +
				"but instead is tested by attempting to set pieces above.");
	}

	@Test
	public void testOthelloPiece() {
		OthPiece = new OthelloPiece(Color.BLACK);
		assertTrue(OthPiece.SetIcons());
		OthPiece = new OthelloPiece(Color.WHITE);
		assertTrue(OthPiece.SetIcons());
		OthPiece = new OthelloPiece(Color.YELLOW);
	}

}
