package controler;

import static maps.Maps.*;

public class GameControler {
    public static boolean placeShip(char[][] map, int x, int y, char direction, int length) {
        // Validate the placement
        if (direction == 'H') { // Horizontal
            if (y + length > map[0].length) return false; // Out of bounds
            for (int i = 0; i < length; i++) {
                if (map[y][x + i] != '#') return false; // Overlapping
            }
            // Place the ship
            for (int i = 0; i < length; i++) {
                map[y][x + i] = 'S';
            }
        } else if (direction == 'V') { // Vertical
            if (x + length > map.length) return false; // Out of bounds
            for (int i = 0; i < length; i++) {
                if (map[y + i][x] != '#') return false; // Overlapping
            }
            // Place the ship
            for (int i = 0; i < length; i++) {
                map[y + i][x] = 'S';
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