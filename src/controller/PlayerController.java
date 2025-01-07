package controller;

import java.util.Scanner;

import static controller.GameController.placeShip;
import static maps.Maps.getPlayerMap;

public class PlayerController {
    public static void placePlayerShips(){
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i <= 5; i++) {
            if (i == 5){
                System.out.println("Please place your carrier.");
                String input = scanner.nextLine();
                convertInputAndCall(input, 5);
            }else if (i == 4){
                System.out.println("Please place your battleship.");
                String input = scanner.nextLine();
                convertInputAndCall(input, 4);
            }else if (i == 3){
                System.out.println("Please place your cruiser.");
                String input = scanner.nextLine();
                convertInputAndCall(input, 3);
            }else if (i == 2){
                System.out.println("Please place your submarine.");
                String input = scanner.nextLine();
                convertInputAndCall(input, 3);
            }else if (i == 1){
                System.out.println("Please place your destroyer.");
                String input = scanner.nextLine();
                convertInputAndCall(input, 2);
            }
        }
    }

    public static void convertInputAndCall(String input, int length){
        String[] parts = input.split(",");
        if (parts.length == 3) {
            try {
                int x = Integer.parseInt(parts[0].trim()); // Parse first number
                int y = Integer.parseInt(parts[1].trim()); // Parse second number
                char direction = parts[2].trim().toUpperCase().charAt(0); // Get first char of third part
                char[][] playerMap = getPlayerMap();
                placeShip(playerMap, x, y, direction, length);
            }catch (NumberFormatException e){
                System.out.println("Invalid input format. x and y must be integers.");
            }
        }
    }
}
