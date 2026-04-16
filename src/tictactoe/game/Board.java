package tictactoe.game;

import tictactoe.enums.State;
import tictactoe.enums.Symbol;
import tictactoe.interfaces.IPlayerStrategy;
import tictactoe.strategy.PlayerAStrategy;
import tictactoe.util.GameContext;

import java.util.Arrays;

public class Board {
    int sizeOfBoard;
    char[][] board;
    IPlayerStrategy playerA;
    IPlayerStrategy playerB;
    GameContext gameContext;

    public Board(int sizeOfBoard, IPlayerStrategy playerA, IPlayerStrategy playerB) {
        this.sizeOfBoard = sizeOfBoard;
        this.board = new char[sizeOfBoard][sizeOfBoard];
        for(int i = 0; i < sizeOfBoard; i++) {
            Arrays.fill(board[i], Symbol.E.name().charAt(0));
        }
        this.playerA = playerA;
        this.playerB = playerB;
        gameContext = new GameContext();
        gameContext.setCurrentGameState(State.InProgress);
        gameContext.setCurrentPlayer(playerA);
    }

    public void play() {
        do {
            IPlayerStrategy currentPlayer = gameContext.getCurrentPlayer();
            currentPlayer.playMove(board);
            gameContext.printBoard(board);
            switchPlayer();
        }while (gameContext.getCurrentGameState() == State.InProgress);
    }

    private void switchPlayer() {
        if (gameContext.getCurrentPlayer() instanceof PlayerAStrategy) {
            gameContext.setCurrentPlayer(playerB);
        } else {
            gameContext.setCurrentPlayer(playerA);
        }
    }


}
