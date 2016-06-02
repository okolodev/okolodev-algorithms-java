package meetup_32_tic_tac_toe_and_find_sum.tictactoe;

public class TicTacToe {
    private static final byte X_PLAYER_TURN = 1;
    private static final byte O_PLAYER_TURN = -1;

    private final int boardSize;
    private final byte[][] board;

    private int lastPlayerTurn;

    private int[] verticalSums;
    private int[] horizontalSums;
    private int diagonalSum;
    private int antiDiagonalSum;

    public TicTacToe(int boardSize) {
        checkBoardSize(boardSize);

        this.boardSize = boardSize;
        board = new byte[boardSize][boardSize];

        verticalSums = new int[boardSize];
        horizontalSums = new int[boardSize];
    }

    private void checkBoardSize(int boardSize) {
        if (boardSize < 3) {
            throw new IllegalBoardSizeException("Illegal board size: " + boardSize);
        }
    }

    public boolean takeXTurnAndCheckIfWon(int x, int y) {
        return takeTurnAndCheckIfWon(X_PLAYER_TURN, x, y);
    }

    public boolean takeOTurnAndCheckIfWon(int x, int y) {
        return takeTurnAndCheckIfWon(O_PLAYER_TURN, x, y);
    }

    private boolean takeTurnAndCheckIfWon(byte playerTurn, int x, int y) {
        checkBoardBoundary(playerTurn, x, y);
        checkPlayerTurn(playerTurn);
        checkOccupancy(x, y);
        takeTurn(playerTurn, x, y);

        return checkIfWon(playerTurn, x, y);
    }

    private void checkBoardBoundary(byte playerTurn, int x, int y) {
        if (x < 0 || x >= boardSize
                || y < 0 || y >= boardSize) {
            char player = 'O';
            if (playerTurn == X_PLAYER_TURN) {
                player = 'X';
            }

            String message = player + " cannot take position outside the board: [" + x + ", " + y + "]";
            throw new IllegalPositionException(message);
        }
    }

    private void checkPlayerTurn(byte playerTurn) {
        if (lastPlayerTurn == playerTurn) {
            char player = 'O';
            if (playerTurn == X_PLAYER_TURN) {
                player = 'X';
            }

            String message = "Player " + player + " tried to take 2 turns in a row";
            throw new SamePlayerTwoTurnsInARowException(message);
        }

        lastPlayerTurn = playerTurn;
    }

    private void checkOccupancy(int x, int y) {
        if (board[y][x] != 0) {
            String message = "Cannot take an already occupied position: [" + x + ", " + y + "]";
            throw new IllegalPositionException(message);
        }
    }

    private void takeTurn(byte playerTurn, int x, int y) {
        board[y][x] = playerTurn;
        verticalSums[x] += playerTurn;
        horizontalSums[y] += playerTurn;

        if (x == y) {
            diagonalSum += playerTurn;
        }

        // anti diagonal formula for 0-based matrices.
        if (x + y == boardSize - 1) {
            antiDiagonalSum += playerTurn;
        }
    }

    private boolean checkIfWon(int playerTurn, int x, int y) {
        int winSum = playerTurn * boardSize;

        return verticalSums[x] == winSum
                || horizontalSums[y] == winSum
                || diagonalSum == winSum
                || antiDiagonalSum == winSum;
    }

    public int getBoardSize() {
        return boardSize;
    }

}
