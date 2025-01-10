package controler;

import static maps.Maps.*;
import static userData.UserData.getPlayerName;
import static userData.score.scoreCount;

// I swapped x and y in the following code because it seamed to fix an issue where  the player input would be reversed. I found out that it might be the cause of a few issues.
public class GameControler {

    public static boolean placeShip(char[][] map, int x, int y, char direction, int length) {
        // Validate the placement
        if (direction == 'H') { // Horizontal
            if (y + length > map[0].length) {
                return false; // Out of bounds
            }
            for (int i = 0; i < length; i++) {
                if (map[x][y + i] != '#') {
                    return false; // Overlapping
                }
            }
            // Place the ship
            for (int i = 0; i < length; i++) {
                map[x][y + i] = 'S';
            }
        } else if (direction == 'V') { // Vertical
            if (x + length > map.length) {
                return false; // Out of bounds
            }
            for (int i = 0; i < length; i++) {
                if (map[x + i][y] != '#') {
                    return false; // Overlapping
                }
            }
            // Place the ship
            for (int i = 0; i < length; i++) {
                map[x + i][y] = 'S';
            }
        } else {
            return false; // Invalid direction
        }
        return true; // Successfully placed
    }

    public static boolean fireShot(char[][] map, int x, int y){
        char val = (char) getMapValue(map, x, y);


        if (val == '#') {
            System.out.println("You missed!!!");
            scoreCount(0);
            setMapValue(map, x, y, 'O');
            return true;
        } else if (val == 'S') {
            System.out.println("You hit!!!");
            scoreCount(1);
            setMapValue(map, x, y, 'X');
            return true;
        } else if (val == 'X') {
            System.out.println("You have already hit this position.");
            return false;
        } else if (val == 'O') {
            System.out.println("You have already hit this position.");
            return false;
        } else {
            System.out.println("Invalid position.");
            return false;
        }
    }

    public static boolean playerShipRemaining() {
        char[][] playerMap = getPlayerMap();
        for (int x = 0; x < playerMap.length; x++) {
            for (int y = 0; y < playerMap[x].length; y++) {
                if (playerMap[x][y] == 'S') {
                    //System.out.println("playerShip found");
                    return true; // Found a ship segment
                }
            }
        }
        //System.out.println("No player ship found"); Only used for Debugging
        return false;
    }

    public static boolean botShipRemaining(){
        char[][] botMap = getBotMap();
        for (int a = 0; a < botMap.length; a++) {
            for (int b = 0; b < botMap[a].length; b++) {
                if (botMap[a][b] == 'S') {
                    //System.out.println("botShip found");
                    return true;// Found a ship segment
                }
            }
        }
        //System.out.println("No Bot ship found"); Only used for Debugging
        return false;
    }

    public static void botWon(){
        char[][] playerMap = getPlayerMap();

        for (int a = 0; a < playerMap.length; a++) {
            for (int b = 0; b < playerMap[a].length; b++) {
                if (playerMap[a][b] == 'S') {
                    return; // Found a ship segment
                }
            }
        }
        System.out.println("The bot has won.");
    }

    public static void playerWon(){
        String name = getPlayerName();
        char[][] botMap = getBotMap();

        for (int a = 0; a < botMap.length; a++) {
            for (int b = 0; b < botMap[a].length; b++) {
                if (botMap[a][b] == 'S') {
                    return; // Found a ship segment
                }
            }
        }
        System.out.println("You have won " +name+ "!!! :)");
    }
}