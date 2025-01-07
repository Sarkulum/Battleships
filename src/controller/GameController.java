package controller;

public class GameController{
    public static boolean placeShip(char[][] map, int x, int y, char direction, int length) {
        // Validate the placement
        if (direction == 'H') { // Horizontal
            if (y + length > map[0].length) return false; // Out of bounds
            for (int i = 0; i < length; i++) {
                if (map[x][y + i] != 'S') return false; // Overlapping
            }
            // Place the ship
            for (int i = 0; i < length; i++) {
                map[x][y + i] = 'S';
            }
        } else if (direction == 'V') { // Vertical
            if (x + length > map.length) return false; // Out of bounds
            for (int i = 0; i < length; i++) {
                if (map[x + i][y] != 'S') return false; // Overlapping
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
}