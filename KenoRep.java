import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
public class KenoRep {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        int balance = 500;
        int bet = 0;
        int max = 40;
        int min = 1;
        int[] board = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26,
                27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40 };
        ArrayList<Integer> list = new ArrayList<>();
        float matches = 0;

        System.out.println(list);
        System.out.println("Welcome to keno!");
        System.out.println("try to guess which numbers will apear on the board");

        System.out.println("would you like to play keno? type yes or no");
        String playgame = s1.nextLine();
        String startgame = "";

        while (playgame.equals("yes")) {
            System.out.println("how much would you like to bet? your balance is: " + "$" + balance);
            bet = s1.nextInt();
            balance -= bet;
            System.out.println("bet placed, your new balance is: " + balance);

            System.out.println("guess 1-10 numbers that you think will be the winning numbers");

            int count = 10;
            for (int i = 0; i < count; i++) {
                System.out.println("Enter your number:");

                try {
                    int number = s1.nextInt();
                    list.add(number);
                } catch (Exception e) {
                    System.out.println("Starting the game!");
                    s1.nextLine();
                    break;
                }

                System.out.println("Would you like to start the game or add more numbers? Type 'start' to start:");

                if (startgame.equals("start")) {

                }
            }

            for (int i = 1; i <= board.length; i++) {
                System.out.print(i + " ");
                if (i <= 10) {
                    System.out.print(" ");
                }
                if (i % 10 == 0) {
                    System.out.println();
                }
            }

            Set<Integer> winningNumbers = new HashSet<Integer>(10); //Hashsets are array lists without duplicates. I googled this heavily!!
            while (winningNumbers.size() < 10) {
                int draw = drawingNumbers();
                
                
                winningNumbers.add(drawingNumbers());
            }
            System.out.println("-----------------------------");
            System.out.println("the winning numbers were:");
            for (int j : winningNumbers) {
                System.out.print(j + ", ");
            }
            System.out.println();

            System.out.println("-----------------------------");
            System.out.println("your numbers were:");
            for (int j : list) {
                System.out.print(j + ", ");
                if (winningNumbers.contains(j)) {
                    matches++;
                }
            }
            System.out.println();

            float percentwin = matches / list.size();
            percentwin *= 100;
            
         if (percentwin == 100) {
            balance += bet * 50;
            System.out.println("crazy good luck your new balance is: " + balance);
        } else if (percentwin > 60) {
            balance += bet * 3;
            System.out.println("you win 3x your bet your new balance is: " + balance);
        }
            else if (percentwin > 30) {
                balance += bet;
                System.out.println("neutral bet goes back to player");
           } 
           else {
                System.out.println("you lose new balance is: " + balance);
            }
        
        
    
    }
}
    public static int drawingNumbers() {
        int min = 1;
        int max = 40;
        return (int) (Math.random() * max + min - 1);
    }
}

