package userData;

import java.util.Scanner;

public class UserData {
    private static String playerName;

    public static void collectName(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your name: ");
        playerName = scanner.nextLine();
        System.out.println(" ");
    }

    public static boolean collectAge(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter you Age: ");
        int age = scanner.nextInt();

        if (age <= 17){
            System.out.println("I'm sorry but you are to young to play this game. The game will now stop.");
            return false;
        }
        return true;
    }

    public static String getPlayerName(){
        return playerName;
    }
}
