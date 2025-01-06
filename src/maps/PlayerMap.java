package maps;

public class PlayerMap {
    //Private 2D char Array.
    private static char[][] playerMap;

    //Fill the 2D Array with # for empty fields and make it 10x10 based on normal battleships map.
    static {
        playerMap = new char[10][10];

        for (int x = 0; x < playerMap.length; x++){
            for (int y = 0; y < playerMap[x].length; y++){
                playerMap[x][y] = '#';
            }
        }
    }

    //A function to get the map.
    public static char[][] getPlayerMap(){
        return playerMap;
    }

    //A function to set a value inside the Array. Takes 2 Int numbers for row and column plus a char for the value of the cell.
    public static void setMapValue(int row, int col, char value){
        if (row >= 0 && row < playerMap.length && col >= 0 && col < playerMap[0].length){
            playerMap[row][col] = value;
        }else{
            throw new IndexOutOfBoundsException("Invalid row or column index.");
        }
    }

    //A function to get the value of a char to see if it is a ship or not.
    public static int getMapValue(int row, int col) {
        if (row >= 0 && row < playerMap.length && col >= 0 && col < playerMap[0].length) {
            return playerMap[row][col];
        } else {
            throw new IndexOutOfBoundsException("Invalid row or column index.");
        }
    }

    //A function to print the 2D Array in the console. Don't have a clue how it works.
    public static void printMap(){
        for (char[] row : playerMap){
            for (char cell : row){
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
