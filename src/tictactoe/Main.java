package tictactoe;

import tictactoe.game.TicTacToeGame;
import tictactoe.models.PieceType;
import tictactoe.models.Player;
import tictactoe.models.PlayingPiece;

import java.util.List;

public class Main {


    public static void main(String[] args) {
        Player p1 = new Player("p1","Player-1",new PlayingPiece(PieceType.X));
        Player p2 = new Player("p2","Player-2",new PlayingPiece(PieceType.O));

        TicTacToeGame game = new TicTacToeGame(3, List.of(p1,p2));
        System.out.println(game.start());
    }
}
