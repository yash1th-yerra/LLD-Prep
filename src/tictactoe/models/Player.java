package tictactoe.models;

public class Player {
    private String playerId;
    private String playerName;
    private PlayingPiece playingPiece;

    public Player(String playerId, String playerName, PlayingPiece playingPiece) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.playingPiece = playingPiece;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public PlayingPiece getPlayingPiece() {
        return playingPiece;
    }

    public void setPlayingPiece(PlayingPiece playingPiece) {
        this.playingPiece = playingPiece;
    }
}
