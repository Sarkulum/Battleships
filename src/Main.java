import java.util.Scanner;

import static controler.BotControler.fireBotShot;
import static controler.BotControler.placeBotShips;
import static controler.GameControler.*;
import static controler.PlayerControler.*;
import static maps.Maps.*;
import static userData.UserData.*;
import static userData.score.*;

public class Main {
    public static void main(String[] args) {
        boolean wannaPlay = true;
        Scanner scanner = new Scanner(System.in);
        char[][] playerMap = getPlayerMap();
        char[][] botMap = getBotMap();

        ensureFileExists("scores.txt");
        System.out.println("Previous scores:");
        displayScores();
        System.out.println(" ");
        collectName();
        boolean oldEnough = collectAge();

        if(oldEnough) {
            while (wannaPlay) {
                placeBotShips();
                //printMap(botMap);
                printMap(playerMap);
                System.out.println(" ");
                placePlayerShips();
                while (playerShipRemaining() && botShipRemaining()) {
                    playerShoot();
                    displayMapFogOfWar(botMap);
                    System.out.println(" ");
                    try {
                        Thread.sleep(2000); // Pauses program for 2000 milliseconds.
                    } catch (InterruptedException e) {
                        e.printStackTrace(); // Handle the exception if the thread is interrupted
                    }
                    fireBotShot();
                    printMap(playerMap);
                    System.out.println(" ");
                }
                botWon();
                playerWon();
                scoreCount(2);
                System.out.println(" ");
                wannaPlay = wannaPlayMore();
            }
        }
    }
}