import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;

/**
 * Created by Cody on 12/23/2015.
 */
public class AI {
    private Board board = new Board();
    private char aiPlayer;

    public AI(Board board) {
        this.board = board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public int miniMax(Board board3, int depth, boolean maximizingPlayer) {
        if (depth == 0 || board3.checkWin() != '-') {
           return board3.getValue();
        }
        if (maximizingPlayer) {
            int bestValue = Integer.MIN_VALUE;
            ArrayList moveList = board3.getMoves();
            for (int i = 0; i < moveList.size(); i++) {
                Board placeholder = board3.copy();
                placeholder.move(Character.getNumericValue(((String) moveList.get(i)).charAt(0)), Character.getNumericValue(((String) moveList.get(i)).charAt(1)), 'O');
                int v = miniMax(placeholder, depth - 1, false);
                bestValue = Math.max(bestValue, v);
            }
            return bestValue;
        } else /*minimizing player*/ {
            int bestValue = Integer.MAX_VALUE;
            ArrayList moveList = board3.getMoves();
            for (int i = 0; i < moveList.size(); i++) {
                Board placeholder = board3.copy();
                placeholder.move(Character.getNumericValue(((String) moveList.get(i)).charAt(0)), Character.getNumericValue(((String) moveList.get(i)).charAt(1)), 'X');
                int v = miniMax(placeholder, depth - 1, true);
                bestValue = Math.min(bestValue, v);
            }
            return bestValue;

        }
    }
    public void aiMove(Board board){
        ArrayList moveList = board.getMoves();
        Integer[] moveScores = new Integer[moveList.size()];
        for(int x = 0; x < moveList.size(); x++){
            Board placeholder = board.copy();
            placeholder.move(Character.getNumericValue(((String) moveList.get(x)).charAt(0)), Character.getNumericValue(((String) moveList.get(x)).charAt(1)), 'O');
            moveScores[x] = miniMax(placeholder, moveList.size()-1, false);
        }
        int index = 0;
        System.out.println("Move List and Scores: ");
        for(int y = 0; y < moveScores.length; y++){
            if(moveScores[y] > moveScores[index]){
                index = y;
            }

            System.out.println(moveScores[y] + " " + moveList.get(y));
        }
        System.out.println("Selected Move and Score: ");
        System.out.println(moveScores[index] + " " + moveList.get(index));
        board.move(Character.getNumericValue(((String) moveList.get(index)).charAt(0)), Character.getNumericValue(((String) moveList.get(index)).charAt(1)), 'O');
    }
}