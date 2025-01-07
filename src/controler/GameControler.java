package controler;

import static maps.Maps.*;

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
            setMapValue(map, x, y, 'O');
            return true;
        } else if (val == 'S') {
            System.out.println("You hit!!!");
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
}