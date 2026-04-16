package tictactoe.strategy;

import tictactoe.enums.Symbol;
import tictactoe.interfaces.IPlayerStrategy;
import tictactoe.util.Move;

import java.util.Scanner;

public class PlayerAStrategy implements IPlayerStrategy {

    Symbol mySymbol;
    Move move;
    String displayName;
    public PlayerAStrategy(Symbol mySymbol, String displayName) {
        this.mySymbol = mySymbol;
        this.move = new Move();
        this.displayName = displayName;
    }
    @Override
    public void playMove(char[][] board) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println(this.displayName + ": Your turn...");
            int row = sc.nextInt();
            int col = sc.nextInt();
            if(move.validateMove(board, row, col, this)) {
                break;
            }
        }
    }

    @Override
    public Symbol getSymbol() {
        return this.mySymbol;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }
}
