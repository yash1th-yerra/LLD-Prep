package tictactoe.game;

import jdk.jshell.spi.ExecutionControlProvider;
import tictactoe.models.Board;
import tictactoe.models.Player;
import tictactoe.util.PlayerTracker;

import java.util.*;

public class TicTacToeGame {

    private Board board;
    private Deque<Player> players;
    private MoveValidator validator;
    private WinnerChecker winnerChecker;
    private Map<String, PlayerTracker> playerTrackerMap;
    private int moves=0;

    public TicTacToeGame(int size, List<Player> players){
        this.board = new Board(size);
        this.players = new LinkedList<>(players);
        this.validator = new MoveValidator();
        this.winnerChecker = new WinnerChecker();
        this.playerTrackerMap = new HashMap<>();

        for(Player p: players){
            playerTrackerMap.put(p.getPlayerName(),new PlayerTracker(size));
        }
    }

    public String start(){
        Scanner sc = new Scanner(System.in);
        int totalCells = board.getSize()* board.getSize();
        while(true){
            board.printBoard();

            if(moves==totalCells) return "TIE";
            Player current = players.removeFirst();
            int[] move = getValidInput(sc,board.getSize());

            if(move==null){
                return "Game Ended";
            }



//            String[] arr = input.split(",");
            int r = move[0];
            int c = move[1];

            if(!validator.isValid(r,c,board)){
                System.out.println("Invalid move . Try again!!!");
                players.addFirst(current);
                continue;
            }

            board.placePiece(r,c,current.getPlayingPiece());
            moves++;
            boolean win = winnerChecker.checkWinner(r,c,board,playerTrackerMap, current.getPlayerName());
            if(win){
                board.printBoard();
                return "WINNER: "+current.getPlayerName();
            }

            players.addLast(current);
        }
    }

    private int[] getValidInput(Scanner sc,int size){
        while(true){
            try{
                System.out.println("Enter Row,Col or exit: ");
                String input = sc.nextLine().trim();

                if(input.equalsIgnoreCase("exit")) return null;

                String[] parts = input.split(",");

                if(parts.length!=2) {
                    System.out.println("Invalid Input.Try again!!!");
                }
                int r = Integer.parseInt(parts[0].trim());
                int c = Integer.parseInt(parts[1].trim());

                return new int[]{r,c};
            }catch (Exception e){
                System.out.println("Invalid Input. Example: 1,2");
            }
        }
    }


}
