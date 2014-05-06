import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.awt.Color;

import org.junit.Test;

/** This is a test class
* \\file -TicTacToeTest.java 
* \author Lewis Edwards
* \date 4th May '14
* \see TicTacToe.java
*
* \brief Testing the TicTacToe game class
*
* The test simulates the potential moves that the player might make by placing random pieces
* the pieces are sometimes there to throw an error. It also checks that the winning condition
* is found.
*/

public class TicTacToeTest {

	HumanPlayer p1 = new HumanPlayer("Jim", Color.BLACK);
	HumanPlayer p2 = new HumanPlayer("Bob", Color.WHITE);
	GameController g = new GameController(GameController.GameType.TICTACTOE);
	TicTacToe tic = new TicTacToe();
	
	/**
	 * Invalid colour is tested in TicTacToeTest
	 */
	@Test
	public void testSetPiece() {
		/**Valid Test Cases*/
		assertTrue(tic.SetPiece(9,6,Color.BLACK));
		assertTrue(tic.SetPiece(0,0,Color.WHITE));
		
		/**Invalid Test Cases*/
		assertFalse(tic.SetPiece(9, 7, Color.BLACK));
		assertFalse(tic.SetPiece(10, 8, Color.WHITE));
		assertFalse(tic.SetPiece(-1, -1, Color.WHITE));
	}
	
	@Test
	public void testGetWidth() {
		/**Valid Test Cases*/
		assertEquals(10, tic.GetWidth());

		/**Invalid Test Cases*/
		assertThat(0, not(tic.GetWidth()));
		assertThat(-5, not(tic.GetWidth()));
		assertThat(9, not(tic.GetWidth()));
		assertThat(999, not(tic.GetWidth()));
	}
	
	@Test
	public void testGetHeight() {
		/**Valid Test Cases*/
		assertEquals(7, tic.GetHeight());

		/**Invalid Test Cases*/
		assertThat(0, not(tic.GetHeight()));
		assertThat(-2, not(tic.GetHeight()));
		assertThat(9, not(tic.GetHeight()));
		assertThat(999, not(tic.GetHeight()));
	}
	
	@Test
	public void testMove() {
		/**Valid Test Cases*/
		assertTrue(tic.Move(9,6,Color.BLACK));
		assertTrue(tic.Move(9,1,Color.WHITE));
		assertTrue(tic.Move(9,6,Color.BLACK));
		assertTrue(tic.Move(9,1,Color.WHITE));
		assertTrue(tic.Move(9,2,Color.BLACK));
		assertTrue(tic.Move(9,3,Color.WHITE));
		assertTrue(tic.Move(9,4,Color.BLACK));
		
		/**Invalid Test Cases*/
		assertFalse(tic.Move(9,7,Color.BLACK));
	}
	
	@Test
	public void testWinningCondition() {
		/**Invalid Test Cases*/
		assertFalse(tic.WinningCondition());
		
		/**Valid Test Cases*/
		tic.Move(9,6,Color.BLACK);
		tic.Move(9,5,Color.BLACK);
		tic.Move(9,6,Color.BLACK);
		tic.Move(9,6,Color.BLACK);
		assertTrue(tic.WinningCondition());
	}
	
	@Test
	public void testSetWinner(){
		/**Invalid Test Cases*/
		assertFalse(tic.SetWinner());
		
		/**Valid Test Cases*/
		tic.Move(9,6,Color.BLACK);
		tic.Move(9,5,Color.BLACK);
		tic.Move(9,6,Color.BLACK);
		tic.Move(9,6,Color.BLACK);
		assertTrue(tic.SetWinner());
	}
	
	@Test
	public void testGetPiece(){
		assertEquals(null ,tic.GetPiece(2, 2));
		tic.Move(9,3,Color.BLACK);
		assertEquals(Color.BLACK ,tic.GetPiece(9, 6).GetColour());
	}
	
	@Test
	public void testGetWinningColour(){
		assertThat(Color.BLACK, not(tic.GetWinningColour()));
		tic.Move(9,6,Color.BLACK);
		tic.Move(9,6,Color.BLACK);
		tic.Move(9,6,Color.BLACK);
		tic.Move(9,6,Color.BLACK);
		tic.SetWinner();
		assertEquals(Color.BLACK, tic.GetWinningColour());
	}
	
	@Test
	public void testGetTotalPieces(){
		assertEquals(0, tic.GetTotalPieces());
		tic.Move(9,6,Color.BLACK);
		tic.Move(9,6,Color.BLACK);
		assertEquals(2, tic.GetTotalPieces());
	}

}
