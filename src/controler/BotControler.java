package controler;

import java.util.Random;

import static controler.GameControler.placeShip;
import static maps.Maps.*;
import static maps.Maps.setMapValue;
import static userData.score.scoreCount;

public class BotControler {
    //Function that should automatically place ships on the botMap based on randomness.
    public static void placeBotShips(){
        char horizontal = 'H';
        char vertical = 'V';
        char[][] botMap = getBotMap();
        int rows = botMap.length;
        int columns = botMap[0].length;

        for (int i = 1; i <= 5; i++) { //Gets repeated 5 times as there are 5 ships to place.
            try{
                boolean next = false; //Boolean to keep track of error cases like out of bounds.
                while (!next) {
                    //A hole lot of if statements to trigger different println and also set the length of the ship correctly.
                    if (i == 5) {
                        // Randomly generate a x, y and orientation value.
                        Random random = new Random();
                        int x = random.nextInt(rows);
                        int y = random.nextInt(columns);
                        char orientation = random.nextBoolean() ? horizontal : vertical; //Don't have a clue how this works.

                        next = placeShip(botMap, x, y, orientation, 5); //PlaceShip returns boolean based on if the placement was successful.
                    } else if (i == 4) {
                        // Randomly generate a x and y index
                        Random random = new Random();
                        int x = random.nextInt(rows);
                        int y = random.nextInt(columns);
                        char orientation = random.nextBoolean() ? horizontal : vertical;

                        next = placeShip(botMap, x, y, orientation, 4);
                    } else if (i == 3) {
                        // Randomly generate a x and y index
                        Random random = new Random();
                        int x = random.nextInt(rows);
                        int y = random.nextInt(columns);
                        char orientation = random.nextBoolean() ? horizontal : vertical;

                        next = placeShip(botMap, x, y, orientation, 3);
                    } else if (i == 2) {
                        // Randomly generate a x and y index
                        Random random = new Random();
                        int x = random.nextInt(rows);
                        int y = random.nextInt(columns);
                        char orientation = random.nextBoolean() ? horizontal : vertical;

                        next = placeShip(botMap, x, y, orientation, 3);
                    } else if (i == 1) {
                        // Randomly generate a x and y index
                        Random random = new Random();
                        int x = random.nextInt(rows);
                        int y = random.nextInt(columns);
                        char orientation = random.nextBoolean() ? horizontal : vertical;

                        next = placeShip(botMap, x, y, orientation, 2);
                    }
                }
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                return;
            }
        }
    }

    public static void fireBotShot(){
        char[][] map = getBotMap();
        int rows = map.length;
        int columns = map[0].length;
        boolean valid = false;

        while (!valid) {
            Random random = new Random();
            int x = random.nextInt(rows);
            int y = random.nextInt(columns);
            char val = (char) getMapValue(map, x, y);


            if (val == '#') {
                System.out.println("The bot missed!!!");
                setMapValue(map, x, y, 'O');
                valid = true;
            } else if (val == 'S') {
                System.out.println("The bot hit you at: " +x+ ", " +y+ "!!!");
                scoreCount(-1);
                setMapValue(map, x, y, 'X');
                valid = true;
            }
        }
    }
}
