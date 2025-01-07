import java.util.Scanner;

import static controler.BotControler.placeBotShips;
import static controler.PlayerControler.placePlayerShips;
import static maps.Maps.getPlayerMap;
import static maps.Maps.printMap;
import static userData.UserData.collectData;

public class Main {
    public static void main(String[] args) {

        boolean wannaPlay = true;
        collectData();
        Scanner scanner = new Scanner(System.in);
        char[][] playerMap = getPlayerMap();

        while (wannaPlay){
            printMap(playerMap);
            //placeBotShips();
            placePlayerShips();
            printMap(playerMap);

        }
    }
}