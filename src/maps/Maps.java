package maps;

public class Maps {
    //Private 2D char Array.
    private static char[][] botMap;
    private static char[][] playerMap;

    //ANSI colors
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    //Fill the 2D Array with # for empty fields and make it 10x10 based on normal battleships map.
    static {
        botMap = new char[10][10];
        playerMap = new char[10][10];

        for (int x = 0; x < 10; x++){
            for (int y = 0; y < 10; y++){
                botMap[x][y] = '#';
                playerMap[x][y] = '#';
            }
        }
    }

    //A function to get the botMap.
    public static char[][] getBotMap(){
        return botMap;
    }

    //A function to get the playerMap.
    public static char[][] getPlayerMap(){
        return playerMap;
    }

    //A function to set a value inside the Array. Takes 2 Int numbers for row and column plus a char for the value of the cell.
    public static void setMapValue(char[][] map,int row, int col, char value){
        if (row >= 0 && row < map.length && col >= 0 && col < map[0].length){
            map[row][col] = value;
        }else{
            throw new IndexOutOfBoundsException("Invalid row or column index.");
        }
    }

    //A function to get the value of a char to see if it is a ship or not.
    public static int getMapValue(char[][] map, int row, int col) {
        if (row >= 0 && row < map.length && col >= 0 && col < map[0].length) {
            return map[row][col];
        } else {
            throw new IndexOutOfBoundsException("Invalid row or column index.");
        }
    }

    //A function to print the 2D Array in the console. Don't have a clue how it works.
    public static void printMap(char[][] map){
        int rows = map.length;
        int cols = map[0].length;

        // Print column headers
        System.out.print("  "); // Align the column headers with the row headers
        for (int col = 0; col <= cols -1; col++) {
            System.out.print(col % 10); // Only display the last digit for double-digit numbers
        }
        System.out.println();

        // Print rows with headers and map content
        for (int row = 0; row < rows; row++) {
            System.out.print((row) % 10 + " "); // Row headers (use modulo for 1-digit alignment)
            for (int col = 0; col < cols; col++) {
                if (map[row][col] == '#'){
                    System.out.print('#');
                }else if (map[row][col] == 'S'){
                    System.out.print(GREEN+ 'S' +RESET);
                }else if (map[row][col] == 'O'){
                    System.out.print(BLUE+ 'O' +RESET);
                }else if (map[row][col] == 'X'){
                    System.out.print(RED+ 'X' +RESET);
                }
                //System.out.print(map[row][col]);
            }
            System.out.println();
        }
    }

    // Method to display the bot map with "fog of war"
    public static void displayMapFogOfWar(char[][] map) {
        int rows = map.length;
        int cols = map[0].length;

        System.out.print("  "); // Align the column headers with the row headers
        for (int col = 0; col <= cols -1; col++) {
            System.out.print(col % 10); // Only display the last digit for double-digit numbers
        }
        System.out.println();

        // Print rows with headers and "fog of war"
        for (int row = 0; row < rows; row++) {
            System.out.print((row) % 10 + " "); // Row headers
            for (int col = 0; col < cols; col++) {
                char tile = map[row][col];
                if (tile == 'S') { // Hide the ships
                    System.out.print('#');
                } else if (tile == 'X'){ // Show hits ('X') and misses ('O')
                    System.out.print(RED+map[row][col]+RESET);
                } else if (tile == 'O') {
                    System.out.print(BLUE+map[row][col]+RESET);
                }else if (tile == '#'){
                    System.out.print(map[row][col]);
                }
            }
            System.out.println();
        }
    }
}
