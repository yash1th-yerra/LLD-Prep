package tictactoe.models;

public class Board {

    private int size;
    private PlayingPiece[][] board;

    public Board(int size){
        this.size = size;
        board = new PlayingPiece[size][size];
    }


    public int getSize(){
        return this.size;
    }

    public boolean isFree(int r,int c){
        return board[r][c]==null;
    }


    public void placePiece(int r,int c,PlayingPiece piece){
        board[r][c] = piece;
    }


    public void printBoard(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.print((board[i][j]==null?" ":board[i][j].getPieceType())+ " | ");
            }
            System.out.println();
        }
    }


}
