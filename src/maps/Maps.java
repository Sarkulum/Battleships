package maps;

public class Maps {
    //Private 2D char Array.
    private static char[][] botMap;
    private static char[][] playerMap;

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
        for (char[] row : map){
            for (char cell : row){
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
