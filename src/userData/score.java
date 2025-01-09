package userData;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;

import static userData.UserData.getPlayerName;

public class score {
    private static final String FILE_NAME = "scores.txt";
    private static int score = 0;
    public static void scoreCount(int input){
        Scanner scanner = new Scanner(System.in);

        if (input == -1){
            score -= 1;
        }else if (input == 0){
            score += 0;
        }else if (input == 1){
            score += 1;
        }else if (input >= 2) {
            System.out.println("You got a score of: " +score+ ". Do you want to save this?");
            String save = scanner.nextLine();

            if (Objects.equals(save, "Yes")) {
                saveScore(score);
                System.out.println("Your score of " +score+ " has been saved.");
            }else if (Objects.equals(save, "No")) {
                System.out.println("Your score will not be saved.");
            }else{
                System.out.println("Please only answer with 'Yes' or 'No'!");
            }
        }
    }

    // Save a score to the file
    public static void saveScore(int score) {
        String playerName = getPlayerName();
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

    public static void ensureFileExists(String fileName) {
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile(); // Create the file if it doesn't exist
                System.out.println(fileName + " created.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating " + fileName);
            e.printStackTrace();
        }
    }
}
