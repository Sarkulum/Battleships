package controller;

import java.util.Random;

import static controller.GameController.placeShip;
import static maps.Maps.getBotMap;

public class BotController {
    public static void placeBotShips(){
        char horizontal = 'H';
        char vertical = 'V';

        for (int i = 0; i <= 5; i++) {
            if (i == 5){
                char[][] botMap = getBotMap();
                int rows = botMap.length;
                int columns = botMap[0].length;

                // Randomly generate a x and y index
                Random random = new Random();
                int x = random.nextInt(rows);
                int y = random.nextInt(columns);
                char orientation = random.nextBoolean() ? horizontal : vertical;

                placeShip(botMap, x, y, orientation, 5);
            }else if (i == 4){
                char[][] botMap = getBotMap();
                int rows = botMap.length;
                int columns = botMap[0].length;

                // Randomly generate a x and y index
                Random random = new Random();
                int x = random.nextInt(rows);
                int y = random.nextInt(columns);
                char orientation = random.nextBoolean() ? horizontal : vertical;

                placeShip(botMap, x, y, orientation, 4);
            }else if (i == 3){
                char[][] botMap = getBotMap();
                int rows = botMap.length;
                int columns = botMap[0].length;

                // Randomly generate a x and y index
                Random random = new Random();
                int x = random.nextInt(rows);
                int y = random.nextInt(columns);
                char orientation = random.nextBoolean() ? horizontal : vertical;

                placeShip(botMap, x, y, orientation, 3);
            }else if (i == 2){
                char[][] botMap = getBotMap();
                int rows = botMap.length;
                int columns = botMap[0].length;

                // Randomly generate a x and y index
                Random random = new Random();
                int x = random.nextInt(rows);
                int y = random.nextInt(columns);
                char orientation = random.nextBoolean() ? horizontal : vertical;

                placeShip(botMap, x, y, orientation, 3);
            }else if (i == 1){
                char[][] botMap = getBotMap();
                int rows = botMap.length;
                int columns = botMap[0].length;

                // Randomly generate a x and y index
                Random random = new Random();
                int x = random.nextInt(rows);
                int y = random.nextInt(columns);
                char orientation = random.nextBoolean() ? horizontal : vertical;

                placeShip(botMap, x, y, orientation, 2);
            }
        }
    }
}