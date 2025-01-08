package controler;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

import static controler.GameControler.fireShot;
import static controler.GameControler.placeShip;
import static maps.Maps.*;

public class PlayerControler {
    private static final String FILE_NAME = "scores.txt";
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
        System.out.println("Do you want to play another round?");
        String userInput = scanner.nextLine();
        boolean inputValid = false;

        while (!inputValid){
            try {
                if (userInput == "Yes") {
                    inputValid = true;
                    return true;
                }else if (userInput == "No") {
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

    public static void scoreCount(int input, String playerName){
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        if (input == -1){
            score -= 1;
        }else if (input == 0){
            score += 0;
        }else if (input == 1){
            score += 1;
        }else if (input >= 2) {
            System.out.println("You got a score of: " +score+ ". Do you want to save this?");
            String save = scanner.nextLine();

            if (save == "Yes") {
                saveScore(playerName, score);
                System.out.println("Your score of " +score+ " has been saved.");
            }else if (save == "No") {
                System.out.println("Your score will not be saved.");
            }else{
                System.out.println("Please only answer with 'Yes' or 'No'!");
            }
        }
    }

    // Save a score to the file
    public static void saveScore(String playerName, int score) {
        try (FileWriter writer = new FileWriter(FILE_NAME, true)) { // 'true' enables appending
            writer.write(playerName + ": " + score + "\n");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the score.");
            e.printStackTrace();
        }
    }


    // Read and display all scores
    public static void displayScores() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the scores.");
            e.printStackTrace();
        }
    }
}