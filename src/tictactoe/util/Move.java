package tictactoe.util;


import tictactoe.enums.State;
import tictactoe.enums.Symbol;
import tictactoe.interfaces.IPlayerStrategy;
import tictactoe.strategy.PlayerAStrategy;

public class Move {
    GameContext gameContext;

    public Move() {
        this.gameContext = new GameContext();
    }

    public Boolean validateMove(char[][] board, int row, int col, IPlayerStrategy player) {
        if (gameContext.getCurrentGameState() != State.InProgress) {
            System.out.println("IllegalMoveError: Game has already finished!");
            return false;
        }
        if (player != this.gameContext.getCurrentPlayer()) {
            System.out.println("IllegalMoveError: Not your turn!");
            return false;
        }
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
            System.out.println("IllegalMoveError: Incorrect row or col index!");
            return false;
        }
        if (board[row][col] != 'E') {
            System.out.println("IllegalMoveError: Cannot play on Occupied spot!");
            return false;
        }
        board[row][col] = player.getSymbol().name().charAt(0);
        checkGameStatus(board, row, col, player);
        return true;
    }

    private void checkGameStatus(char[][] board, int row, int col, IPlayerStrategy playerStrategy) {
        if (!isWinner(board, row, col, playerStrategy)) {
            isGameDraw(board);
        }
    }

    private void isGameDraw(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == Symbol.E.name().charAt(0)) {
                    return;
                }
            }
        }
        System.out.println("Game Draw");
        gameContext.setCurrentGameState(State.Draw);
    }
    private boolean isWinner(char[][] board, int row, int col, IPlayerStrategy playerStrategy) {
        if(checkRow(board, row, playerStrategy) || checkCol(board, col, playerStrategy) || checkLeftDiagonal(board, row, col, playerStrategy) || checkRightDiagonal(board, row, col, playerStrategy)) {
            State state = (playerStrategy instanceof PlayerAStrategy) ? State.PlayerAWon : State.PlayerBWon;
            System.out.println("We got the winner: " + playerStrategy.getDisplayName());
            gameContext.setCurrentGameState(state);
            return true;
        }
        return false;
    }
    private boolean checkRow(char[][] board, int row, IPlayerStrategy playerStrategy) {
        for(int i = 0; i < board[0].length; i++) {
            if(board[row][i] != playerStrategy.getSymbol().name().charAt(0)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkCol(char[][] board, int col, IPlayerStrategy playerStrategy) {
        for(int i = 0; i < board.length; i++) {
            if(board[i][col] != playerStrategy.getSymbol().name().charAt(0)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkLeftDiagonal(char[][] board,int row, int col, IPlayerStrategy playerStrategy) {
        if(row == col) {
            for(int i = 0; i < board.length; i++) {
                if(board[i][i] != playerStrategy.getSymbol().name().charAt(0)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private boolean checkRightDiagonal(char[][] board,int row, int col, IPlayerStrategy playerStrategy) {
        if(row + col == board.length - 1) {
            for(int i = 0; i < board.length; i++) {
                if(board[i][board.length - 1 - i] != playerStrategy.getSymbol().name().charAt(0)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

}