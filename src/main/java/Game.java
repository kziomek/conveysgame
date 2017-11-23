/**
 * @author Krzysztof Ziomek
 * @since 23/11/2017.
 */
public class Game {

    public boolean[][] runIteration(boolean[][] colony) {

        boolean[][] newColony = new boolean[colony.length][colony[0].length];

        for (int row = 0; row < colony.length; row++) {
            for (int col = 0; col < colony[row].length; col++) {

                int livingNeighbours = livingNeighbours(colony, row, col);
                if (livingNeighbours == 0) {
                    newColony[row][col] = false;
                } else if (livingNeighbours == 2 || livingNeighbours == 3) {
                    newColony[row][col] = colony[row][col];
                }

            }
        }
        return newColony;

    }

    private int livingNeighbours(boolean[][] colony, int row, int col) {

        int count = 0;
        int rowLength = colony.length;
        int colLength = colony[0].length;

        //top-left
        if (row - 1 >= 0 && col - 1 >= 0){
            if (colony[row - 1][col - 1]){
                count++;
            }
        }
        //top
        if (row - 1 >= 0){
            if (colony[row-1][col]){
                count++;
            }
        }
        //top-rigth
        if (row - 1 >= 0 && col + 1 < colLength ){
            if (colony[row - 1][col + 1]){
                count++;
            }
        }
        //right
        if ( col + 1 < colLength ){
            if (colony[row][col + 1]){
                count++;
            }
        }
        //right-bottom
        if (row + 1 < rowLength && col + 1 < colLength ){
            if (colony[row + 1][col + 1]){
                count++;
            }
        }

        //bottom
        if (row + 1 < rowLength){
            if (colony[row+1][col]){
                count++;
            }
        }
        //bottom-leff
        if (row + 1 < rowLength && col -1 >= 0){
            if (colony[row+1][col-1]){
                count++;
            }
        }

        //left
        if ( col - 1 >=0 ){
            if (colony[row][col - 1]){
                count++;
            }
        }

        return count;
    }

}
