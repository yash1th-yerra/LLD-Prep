package tictactoe.game;

import tictactoe.models.Board;

public class MoveValidator {


    public boolean isValid(int r, int c, Board board){
        return r>=0 && r<board.getSize() && c>=0 && c<board.getSize() && board.isFree(r,c);
    }
}
