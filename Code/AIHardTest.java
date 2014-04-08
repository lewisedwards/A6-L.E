import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

/**
 * \\file AIHardTest.java
 * \author Jiaming Dong - 742299
 * \date 27/03/14
 * 
 * \brief A class that tests the AIHard class by placing a 
 * piece into a position that is a valid move
 */

public class AIHardTest {
    
/**
 * Tests the AIHard by making a valid move in Othello
 */
	@Test
	public void test() {
		BoardGame b = new Othello();
		AIHard a = new AIHard("A", Color.black);
		assertTrue(a.takeMove());
		int x = a.getX();
		int y =a.getY();
		assertTrue(
                   ((x == BLACK1X + 1) && (y == BLACK1Y - 1)) ||
                   ((x == WHITE1X + 1) && (y == BLACK1Y)) ||
                   ((x == BLACK1X - 1) && (y == BLACK1Y + 1)) ||
                   ((x == BLACK1X) && (y == WHITE2Y + 1))
                   );
	}
	final int BLACK1X = 3;
	final int BLACK1Y = 3;
	final int WHITE1X = 4;
	final int WHITE2Y = 4 ;
}
