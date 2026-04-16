package tictactoe.interfaces;

import tictactoe.enums.Symbol;

public interface IPlayerStrategy {

    public void playMove(char[][] board);
    public Symbol getSymbol();
    public String getDisplayName();
}
