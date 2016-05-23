package meetup_32_tic_tac_toe_and_find_sum.tictactoe;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class TicTacToeTest {
    @Rule
    public ExpectedException thrownException = ExpectedException.none();

    @Test
    @Parameters({
            "2",
            "1",
            "0",
            "-1",
            "-2",
            "-3"
    })
    public void itShouldNotAllowCreatingBoardWithSizeLessThanTree(int illegalBoardSize) {
        thrownException.expect(IllegalBoardSizeException.class);
        thrownException.expectMessage("Illegal board size: " + illegalBoardSize);

        new TicTacToe(illegalBoardSize);
    }

    @Test
    @Parameters({
            "3",
            "4",
            "5",
            "6",
            "7",
            "100"
    })
    public void itShouldAllowCreatingBoardWithSizeGreaterThanOrEqualToTree(int boardSize) {
        TicTacToe ticTacToe = new TicTacToe(boardSize);

        assertThat(ticTacToe.getBoardSize(), is(boardSize));
    }

    @Test
    @Parameters({
            "3, -1, 0",
            "3, 0, -2",
            "4, 1, 4",
            "4, 4, 1"
    })
    public void itShouldNotAllowTakingPositionOutsideBoardForX(int boardSize,
                                                               int x,
                                                               int y) {
        TicTacToe ticTacToe = new TicTacToe(boardSize);

        thrownException.expect(IllegalPositionException.class);
        String message = "X cannot take position outside the board: [" + x + ", " + y + "]";
        thrownException.expectMessage(message);

        ticTacToe.takeXTurnAndCheckIfWon(x, y);
    }

    @Test
    @Parameters({
            "3, -1, 0",
            "3, 0, -2",
            "4, 1, 4",
            "4, 4, 1"
    })
    public void itShouldNotAllowTakingPositionOutsideBoardForO(int boardSize,
                                                               int x,
                                                               int y) {
        TicTacToe ticTacToe = new TicTacToe(boardSize);

        thrownException.expect(IllegalPositionException.class);
        String message = "O cannot take position outside the board: [" + x + ", " + y + "]";
        thrownException.expectMessage(message);

        ticTacToe.takeOTurnAndCheckIfWon(x, y);
    }

    @Test
    @Parameters({
            "0, 1",
            "1, 1",
            "1, 2"
    })
    public void itShouldNotAllowTakingXTwoTurnsInARow(int x, int y) {
        TicTacToe ticTacToe = new TicTacToe(3);
        ticTacToe.takeXTurnAndCheckIfWon(x, y);

        thrownException.expect(SamePlayerTwoTurnsInARowException.class);
        thrownException.expectMessage("Player X tried to take 2 turns in a row");

        ticTacToe.takeXTurnAndCheckIfWon(x, y);
    }

    @Test
    @Parameters({
            "0, 1",
            "1, 1",
            "1, 2"
    })
    public void itShouldNotAllowTakingOTwoTurnsInARow(int x, int y) {
        TicTacToe ticTacToe = new TicTacToe(3);
        ticTacToe.takeOTurnAndCheckIfWon(x, y);

        thrownException.expect(SamePlayerTwoTurnsInARowException.class);
        thrownException.expectMessage("Player O tried to take 2 turns in a row");

        ticTacToe.takeOTurnAndCheckIfWon(x, y);
    }

    @Test
    @Parameters({
            "0, 1",
            "1, 1",
            "1, 2"
    })
    public void itShouldNotAllowTakingOccupiedPosition(int x, int y) {
        TicTacToe ticTacToe = new TicTacToe(3);
        ticTacToe.takeXTurnAndCheckIfWon(x, y);

        thrownException.expect(IllegalPositionException.class);
        String message = "Cannot take an already occupied position: [" + x + ", " + y + "]";
        thrownException.expectMessage(message);

        ticTacToe.takeOTurnAndCheckIfWon(x, y);
    }

    @Test
    public void XShouldWinOnDiagonal() {
        TicTacToe ticTacToe = new TicTacToe(4);

        /*
         x  o
         xx
         oox
         o  x
         */

        assertThat(ticTacToe.takeXTurnAndCheckIfWon(0, 1), is(false));
        assertThat(ticTacToe.takeOTurnAndCheckIfWon(0, 3), is(false));

        assertThat(ticTacToe.takeXTurnAndCheckIfWon(0, 0), is(false));
        assertThat(ticTacToe.takeOTurnAndCheckIfWon(0, 2), is(false));

        assertThat(ticTacToe.takeXTurnAndCheckIfWon(1, 1), is(false));
        assertThat(ticTacToe.takeOTurnAndCheckIfWon(1, 2), is(false));

        assertThat(ticTacToe.takeXTurnAndCheckIfWon(3, 3), is(false));
        assertThat(ticTacToe.takeOTurnAndCheckIfWon(3, 0), is(false));

        assertThat(ticTacToe.takeXTurnAndCheckIfWon(2, 2), is(true));
    }

    @Test
    public void OShouldWinOnAntiDiagonal() {
        TicTacToe ticTacToe = new TicTacToe(3);

        /*
         x o
         xo
         o
         */

        assertThat(ticTacToe.takeOTurnAndCheckIfWon(2, 0), is(false));
        assertThat(ticTacToe.takeXTurnAndCheckIfWon(0, 0), is(false));

        assertThat(ticTacToe.takeOTurnAndCheckIfWon(0, 2), is(false));
        assertThat(ticTacToe.takeXTurnAndCheckIfWon(0, 1), is(false));

        assertThat(ticTacToe.takeOTurnAndCheckIfWon(1, 1), is(true));
    }

    @Test
    @Parameters({
            "0",
            "1",
            "2",
            "3",
            "4"
    })
    public void XShouldWinOnHorizontalLine(int xRow) {
        TicTacToe ticTacToe = new TicTacToe(5);

        int oRow = (xRow + 1) % ticTacToe.getBoardSize();

        assertThat(ticTacToe.takeXTurnAndCheckIfWon(0, xRow), is(false));
        assertThat(ticTacToe.takeOTurnAndCheckIfWon(0, oRow), is(false));

        assertThat(ticTacToe.takeXTurnAndCheckIfWon(1, xRow), is(false));
        assertThat(ticTacToe.takeOTurnAndCheckIfWon(1, oRow), is(false));

        assertThat(ticTacToe.takeXTurnAndCheckIfWon(2, xRow), is(false));
        assertThat(ticTacToe.takeOTurnAndCheckIfWon(2, oRow), is(false));

        assertThat(ticTacToe.takeXTurnAndCheckIfWon(4, xRow), is(false));
        assertThat(ticTacToe.takeOTurnAndCheckIfWon(4, oRow), is(false));

        assertThat(ticTacToe.takeXTurnAndCheckIfWon(3, xRow), is(true));
    }

    @Test
    @Parameters({
            "0",
            "1",
            "2",
            "3"
    })
    public void OShouldWinOnVerticalLine(int oColumn) {
        TicTacToe ticTacToe = new TicTacToe(4);

        int xColumn = (oColumn + 1) % ticTacToe.getBoardSize();

        assertThat(ticTacToe.takeOTurnAndCheckIfWon(oColumn, 2), is(false));
        assertThat(ticTacToe.takeXTurnAndCheckIfWon(xColumn, 2), is(false));

        assertThat(ticTacToe.takeOTurnAndCheckIfWon(oColumn, 3), is(false));
        assertThat(ticTacToe.takeXTurnAndCheckIfWon(xColumn, 3), is(false));

        assertThat(ticTacToe.takeOTurnAndCheckIfWon(oColumn, 1), is(false));
        assertThat(ticTacToe.takeXTurnAndCheckIfWon(xColumn, 1), is(false));

        assertThat(ticTacToe.takeOTurnAndCheckIfWon(oColumn, 0), is(true));
    }

}
