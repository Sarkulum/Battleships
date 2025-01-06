package userData;

import java.util.Scanner;

public class UserData {
    public static void collectData(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Please enter you Age: ");
        int age = scanner.nextInt();

    }
}
