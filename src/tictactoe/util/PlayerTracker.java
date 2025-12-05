package tictactoe.util;

public class PlayerTracker {

    private int[] rowCount;
    private int[] colCount;
    private int diag = 0;
    private int antiDiag = 0;

    public PlayerTracker(int size){
        rowCount = new int[size];
        colCount = new int[size];

    }


    public boolean updateTracker(int r,int c,int size){
        rowCount[r]++;
        colCount[c]++;

        if(r==c) diag++;
        if(r+c==size-1) antiDiag++;

        return rowCount[r]==size || colCount[c]==size || diag==size || antiDiag==size;
    }
}
