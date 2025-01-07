import java.util.Scanner;

import static controler.BotControler.placeBotShips;
import static controler.PlayerControler.placePlayerShips;
import static controler.PlayerControler.playerShoot;
import static maps.Maps.*;
import static userData.UserData.collectData;

public class Main {
    public static void main(String[] args) {

        boolean wannaPlay = true;
        collectData();
        Scanner scanner = new Scanner(System.in);
        char[][] playerMap = getPlayerMap();
        char[][] botMap = getBotMap();

        //while (wannaPlay){
            //printMap(playerMap);
            placeBotShips();
            printMap(botMap);
            placePlayerShips();
            //playerShoot();
        //}
    }
}