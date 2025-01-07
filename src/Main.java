import java.util.Scanner;

import static controller.BotController.placeBotShips;
import static controller.PlayerController.placePlayerShips;
import static maps.Maps.getPlayerMap;
import static maps.Maps.printMap;
import static userData.UserData.collectData;

public class Main {
    public static void main(String[] args) {

        boolean wannaPlay = true;
        collectData();
        Scanner scanner = new Scanner(System.in);

        while (wannaPlay == true){
            placeBotShips();
            placePlayerShips();
            char[][] playerMap = getPlayerMap();
            printMap(playerMap);
        }
    }
}