import java.util.Scanner;

import static controler.BotControler.fireBotShot;
import static controler.BotControler.placeBotShips;
import static controler.GameControler.*;
import static controler.PlayerControler.*;
import static maps.Maps.*;
import static userData.UserData.collectData;

public class Main {
    public static void main(String[] args) {

        boolean wannaPlay = true;
        collectData();
        Scanner scanner = new Scanner(System.in);
        char[][] playerMap = getPlayerMap();
        char[][] botMap = getBotMap();

        while (wannaPlay) {
            boolean shipsRemaining = true;
            placeBotShips();
            printMap(botMap);
            printMap(playerMap);
            placePlayerShips();
            while (shipsRemaining) {
                playerShoot();
                displayMapFogOfWar(botMap);
                fireBotShot();
                printMap(playerMap);
                shipsRemaining = areShipsRemaining(playerMap, botMap);
            }
            botWon();
            playerWon();
            wannaPlay = wannaPlayMore();
        }
    }
}