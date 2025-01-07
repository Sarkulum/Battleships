package controler;

import java.util.Random;

import static controler.GameControler.placeShip;
import static maps.Maps.getBotMap;

public class BotControler {
    public static void placeBotShips(){
        char horizontal = 'H';
        char vertical = 'V';
        boolean next = false;

        while (!next) {
            for (int i = 0; i <= 5; i++) {
                if (i == 5) {
                    char[][] botMap = getBotMap();
                    int rows = botMap.length;
                    int columns = botMap[0].length;

                    // Randomly generate a x and y index
                    Random random = new Random();
                    int x = random.nextInt(rows);
                    int y = random.nextInt(columns);
                    char orientation = random.nextBoolean() ? horizontal : vertical;

                    next = placeShip(botMap, x, y, orientation, 5);
                } else if (i == 4) {
                    char[][] botMap = getBotMap();
                    int rows = botMap.length;
                    int columns = botMap[0].length;

                    // Randomly generate a x and y index
                    Random random = new Random();
                    int x = random.nextInt(rows);
                    int y = random.nextInt(columns);
                    char orientation = random.nextBoolean() ? horizontal : vertical;

                    next = placeShip(botMap, x, y, orientation, 4);
                } else if (i == 3) {
                    char[][] botMap = getBotMap();
                    int rows = botMap.length;
                    int columns = botMap[0].length;

                    // Randomly generate a x and y index
                    Random random = new Random();
                    int x = random.nextInt(rows);
                    int y = random.nextInt(columns);
                    char orientation = random.nextBoolean() ? horizontal : vertical;

                    next = placeShip(botMap, x, y, orientation, 3);
                } else if (i == 2) {
                    char[][] botMap = getBotMap();
                    int rows = botMap.length;
                    int columns = botMap[0].length;

                    // Randomly generate a x and y index
                    Random random = new Random();
                    int x = random.nextInt(rows);
                    int y = random.nextInt(columns);
                    char orientation = random.nextBoolean() ? horizontal : vertical;

                    next = placeShip(botMap, x, y, orientation, 3);
                } else if (i == 1) {
                    char[][] botMap = getBotMap();
                    int rows = botMap.length;
                    int columns = botMap[0].length;

                    // Randomly generate a x and y index
                    Random random = new Random();
                    int x = random.nextInt(rows);
                    int y = random.nextInt(columns);
                    char orientation = random.nextBoolean() ? horizontal : vertical;

                    next = placeShip(botMap, x, y, orientation, 2);
                }
            }
        }
    }
}