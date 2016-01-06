import java.lang.reflect.Array;

/**
 * Created by Cody on 12/23/2015.
 */
import java.util.ArrayList;
public class Board {
    private char[][] board = new char[3][3];

    public Board(){
        for(int i = 0; i < 3; i++){
            for(int x = 0; x < 3; x++){
                board[i][x] = '-';
            }
        }
    }


    public ArrayList getMoves() {
        ArrayList moveList = new ArrayList(0);
        for(int i = 0; i < 3; i++){
            for(int x = 0; x < 3; x++){
                if(board[i][x] == '-'){
                    moveList.add("" + i + "" + x);
                }
            }
        }
        return moveList;
    }

    public char checkWin() {
        char winner = '-';
        for(int i = 0; i < 3; i++){
            if(board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') {
                winner = board[i][0];
            }
            else if(board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != '-'){
                winner = board[0][i];
            }
        }
        if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-'){
            winner = board[0][0];
        }
        if(board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != '-'){
            winner = board[0][0];
        }
        return winner;
    }

    public boolean validMove(int r, int c){
        if(r > 2 || r < 0 || c > 2 || c < 0){
            return false;
        }
        if(board[r][c] == '-'){
            return true;
        }
        return false;
    }

    public void move(int r, int c, char player){
        board[r][c] = player;
    }

    public void print(){
        System.out.println("  0 1 2");
        for(int i = 0; i < 3; i++){
            System.out.print(i + " ");
            for(int x = 0; x < 3; x++){
                System.out.print(board[i][x] + " ");
            }
            System.out.println();
        }
    }

    public int getValue(){
        if(this.checkWin() == 'x'){
            return 100;
        }
        else if(this.checkWin() == 'o'){
            return -100;
        }
        else{
            //do eval
            return 0;
        }
    }




}
