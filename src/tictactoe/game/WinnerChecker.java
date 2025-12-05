package tictactoe.game;

import tictactoe.models.Board;
import tictactoe.util.PlayerTracker;

import java.util.Map;

public class WinnerChecker {


    public boolean checkWinner(int r, int c, Board board, Map<String, PlayerTracker> trackerMap,String playerName){
        PlayerTracker playerTracker = trackerMap.get(playerName);
        return playerTracker.updateTracker(r,c,board.getSize());
    }
}
