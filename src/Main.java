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
        displayScores();
        System.out.println(" ");
        collectName();
        String playerName = getPlayerName();
        boolean oldEnough = collectAge();

        if(oldEnough) {
            while (wannaPlay) {
                boolean shipsRemaining = true;
                placeBotShips();
                printMap(botMap);
                //printMap(playerMap);
                //placePlayerShips();
                while (shipsRemaining) {
                    playerShoot();
                    //displayMapFogOfWar(botMap);
                    //fireBotShot();
                    //printMap(playerMap);
                    shipsRemaining = areShipsRemaining(playerMap, botMap);
                }
                botWon();
                playerWon();
                scoreCount(2);
                wannaPlay = wannaPlayMore();
            }
        }
    }
}