import java.util.ArrayList;

/**
 * Created by Cody on 12/23/2015.
 */
public class AI {
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
        }
    }
}
