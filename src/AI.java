import java.util.ArrayList;

/**
 * Created by Cody on 12/23/2015.
 */
public class AI {
<<<<<<< HEAD
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
=======
    Board staticBoard;
    char player;

    public AI(char player) {
        this.player = player;
    }

    public String miniMax(Board board, char player) {
        ArrayList moveList = board.getMoves();
        this.staticBoard = board;
        if (board.checkWin() != '-') {
            
        }

        else {


            for (int i = 0; i < moveList.size(); i++) {
                Board dynaBoard = staticBoard;
                String move = (String) moveList.get(i);
                dynaBoard.move(move.charAt(0), move.charAt(1), player);
                if (player == 'X') {
                    player = 'O';
                } else {
                    player = 'X';
                }
                miniMax(dynaBoard, player);


            }
>>>>>>> 6421b7c22bee7a1298861df7f38f3160fabe5ed4
        }
    }
}


