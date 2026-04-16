package tictactoe.game;

import tictactoe.enums.Symbol;
import tictactoe.interfaces.IPlayerStrategy;
import tictactoe.strategy.PlayerAStrategy;
import tictactoe.strategy.PlayerBStrategy;

public class TicTacToe {

    public static void main(String[] args) {
        IPlayerStrategy playerA = new PlayerAStrategy(Symbol.X, "Player A");
        IPlayerStrategy playerB = new PlayerBStrategy(Symbol.O, "Player B");
        Board board = new Board(3, playerA, playerB);
        board.play();
        System.out.println("Game Over!");
    }
}
