import java.util.ArrayList;

/**
 * Created by Cody on 12/23/2015.
 */
public class AI {
    private Board board = new Board();

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
                Board placeholder = board3;
                placeholder.move(Character.getNumericValue(((String) moveList.get(i)).charAt(0)), Character.getNumericValue(((String) moveList.get(i)).charAt(1)), 'x');
                int v = miniMax(placeholder, depth - 1, false);
                bestValue = Math.max(bestValue,v);
            }
            return bestValue;
        }
        else /*minimizing player*/ {
            int bestValue = Integer.MAX_VALUE;
            ArrayList moveList = board3.getMoves();
            for (int i = 0; i < moveList.size(); i++) {
                Board placeholder = board3;
                placeholder.move(Character.getNumericValue(((String) moveList.get(i)).charAt(0)), Character.getNumericValue(((String) moveList.get(i)).charAt(1)), 'o');
                int v = miniMax(placeholder, depth - 1, true);
                bestValue = Math.min(bestValue,v);
            }
            return bestValue;
        }
    }
}


