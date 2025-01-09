package controler;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

import static controler.GameControler.fireShot;
import static controler.GameControler.placeShip;
import static maps.Maps.*;
import static userData.UserData.getPlayerName;

public class PlayerControler {
    public static void placePlayerShips(){
        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i <= 5; i++) {
            char[][] playerMap = getPlayerMap();
            boolean next = false;

           while (!next) {
                if (i == 5) {
                    System.out.println(" ");
                    System.out.println("Please place your carrier.");
                    String input = scanner.nextLine();
                    next = convertInputAndCall(input, 5);
                    printMap(playerMap);
                } else if (i == 4) {
                    System.out.println(" ");
                    System.out.println("Please place your battleship.");
                    String input = scanner.nextLine();
                    next = convertInputAndCall(input, 4);
                    printMap(playerMap);
                } else if (i == 3) {
                    System.out.println(" ");
                    System.out.println("Please place your cruiser.");
                    String input = scanner.nextLine();
                    next = convertInputAndCall(input, 3);
                    printMap(playerMap);
                } else if (i == 2) {
                    System.out.println(" ");
                    System.out.println("Please place your submarine.");
                    String input = scanner.nextLine();
                    next = convertInputAndCall(input, 3);
                    printMap(playerMap);
                } else if (i == 1) {
                    System.out.println(" ");
                    System.out.println("Please place your destroyer.");
                    String input = scanner.nextLine();
                    next = convertInputAndCall(input, 2);
                    printMap(playerMap);
                }
            }
        }
    }

    public static boolean convertInputAndCall(String input, int length) {
        String[] parts = input.split(",");
        boolean next = false;
        if (parts.length == 3) {
            try {
                int y = Integer.parseInt(parts[0].trim()); // Parse y number
                int x = Integer.parseInt(parts[1].trim()); // Parse x number
                char direction = parts[2].trim().toUpperCase().charAt(0); // Get first char of third part
                char[][] playerMap = getPlayerMap();
                next = placeShip(playerMap, x, y, direction, length);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input format. x and y must be integers.");
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("The ship would be out of bounds.");
            }
        }
        return next;
    }

    public static void playerShoot() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Where do you want to hit?");
        boolean next = false;

        while (!next) {
            String input = scanner.nextLine();
            String[] parts = input.split(",");
            char[][] botMap = getBotMap();

            if (parts.length == 2) {
                //X and Y need to be in "Y and then X" as otherwise input is reversed.
                int y = Integer.parseInt(parts[0].trim()); // Parse y number
                int x = Integer.parseInt(parts[1].trim()); // Parse x number

                next = fireShot(botMap, x, y);
            }
        }
    }

    public static boolean wannaPlayMore() {
        Scanner scanner = new Scanner(System.in);
        boolean inputValid = false;

        System.out.println("Do you want to play another round?");

        while (!inputValid){
            String userInput = scanner.nextLine();
            try {
                if (Objects.equals(userInput, "Yes")) {
                    inputValid = true;
                    return true;
                }else if (Objects.equals(userInput, "No")) {
                    inputValid = true;
                    System.out.println("Have a nice Day. :)");
                    return false;
                }else{
                    System.out.println("Please only answer with 'Yes' or 'No'!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Wrong type of input.");
            }
        }
        return false;
    }


}