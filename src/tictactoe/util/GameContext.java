package tictactoe.util;

import tictactoe.enums.State;
import tictactoe.interfaces.IPlayerStrategy;

public class GameContext {

    public static IPlayerStrategy currentPlayer;
    public static State currentGameState;

    public void setCurrentPlayer(IPlayerStrategy iPlayerStrategy) {
        currentPlayer = iPlayerStrategy;
    }
    public IPlayerStrategy getCurrentPlayer() {
        return currentPlayer;
    }
    public void setCurrentGameState(State state) {
        currentGameState = state;
    }
    public State getCurrentGameState() {
        return currentGameState;
    }
    public void printBoard(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                System.out.print("|  " + board[i][j] + "  |");
            }
            System.out.println();
        }
    }
}
