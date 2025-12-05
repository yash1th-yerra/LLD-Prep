package tictactoe.models;

public class PlayingPiece {

    private PieceType pieceType;
    public PlayingPiece(PieceType pieceType){
        this.pieceType = pieceType;
    }
    public void setPieceType(PieceType pieceType){
        this.pieceType = pieceType;
    }

    public PieceType getPieceType(){
        return this.pieceType;
    }


}
