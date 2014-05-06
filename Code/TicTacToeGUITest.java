import static org.junit.Assert.assertTrue;

import java.awt.Color;

import org.junit.Test;
/** 
* This is a test class
* \\file -OthelloGUITest.java 
* \author - Jake Daryl Plumley
* \date -22nd Feb 14
* \see OthelloGUI.java, GUI.java
*
* \brief The testing class for the OthelloGUI.java
*
* New players are simulated and the test is to make sure that information about the players
* can be set. This class also tests the GUI.java class as OthelloGUI inherits from this.
* 
*/

public class TicTacToeGUITest {
	HumanPlayer p1 = new HumanPlayer("Jim", Color.BLACK);
	HumanPlayer p2 = new HumanPlayer("Bob", Color.WHITE);
	TicTacToe tictactoe = new TicTacToe();
	GameController game = new GameController(GameController.GameType.TICTACTOE, p1, p2);
	TicTacToeGUI TicTacToeGUI = new TicTacToeGUI(tictactoe, game);

	@Test
	public void testSetOthelloInfo() {
		assertTrue(TicTacToeGUI.setInfo());
	}

	@Test
	public void testSetPanelColour() {
		assertTrue(TicTacToeGUI.setPanelColour());
	}
}
