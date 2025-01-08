import java.util.Scanner;

import static controler.BotControler.fireBotShot;
import static controler.BotControler.placeBotShips;
import static controler.GameControler.*;
import static controler.PlayerControler.*;
import static maps.Maps.*;
import static userData.UserData.collectAge;
import static userData.UserData.collectName;

public class Main {
    public static void main(String[] args) {

        boolean wannaPlay = true;
        String playerName = collectName();
        Scanner scanner = new Scanner(System.in);
        char[][] playerMap = getPlayerMap();
        char[][] botMap = getBotMap();
        boolean oldEnough = collectAge();

        if(oldEnough) {
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
                playerWon(playerName);
                wannaPlay = wannaPlayMore();
            }
        }
    }
}