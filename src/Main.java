import java.util.Scanner;

/**
 * Created by Cody on 12/23/2015.
 */
public class Main {
    public static void main(String[] args) {
        Board board1 = new Board();

        char player = 'X';
        String move = "";
        Boolean twoPlayer = false;

        Scanner scan = new Scanner(System.in);

        System.out.println("Would you like to play against the computer? (y/n)");
        String response = scan.nextLine();
        if(response.charAt(0) == 'n'){
            twoPlayer = true;
        }


        while(board1.checkWin() == '-' && twoPlayer){
            board1.print();
            System.out.println("Where would you like to play?");
            move = scan.nextLine();
            while(!board1.validMove(Character.getNumericValue(move.charAt(0)), Character.getNumericValue(move.charAt(1)))){
                board1.print();
                System.out.println("That is an invalid move, try again.");
                move = scan.nextLine();
            }
            board1.move(Character.getNumericValue(move.charAt(0)), Character.getNumericValue(move.charAt(1)), player);
            if(player == 'X'){
                player = 'O';
            }
            else{
                player = 'X';
            }

        }



        while(board1.checkWin() != '-' && !twoPlayer){
            board1.print();
            System.out.println("Where would you like to play?");
            move = scan.nextLine();
            while(!board1.validMove(Character.getNumericValue(move.charAt(0)), Character.getNumericValue(move.charAt(1)))){
                board1.print();
                System.out.println("That is an invalid move, try again.");
                move = scan.nextLine();
            }
            board1.move(Character.getNumericValue(move.charAt(0)), Character.getNumericValue(move.charAt(1)), player);


        }
    }

}
