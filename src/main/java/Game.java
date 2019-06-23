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
                } else if (livingNeighbours == 2) {
                    newColony[row][col] = colony[row][col];
                } else if (livingNeighbours == 3) {
                    newColony[row][col] = true;
                }
            }
        }
        return newColony;

    }

    private int livingNeighbours(boolean[][] colony, int row, int col) {

        int count = 0;
        int rowLength = colony.length;
        int colLength = colony[0].length;

        for (int i = row - 1; i <= row + 1; i++) {
            if (i < 0 || i >= rowLength) {
                continue;
            }
            for (int j = col - 1; j <= col + 1; j++) {
                if (j < 0 || j >= colLength) {
                    continue;
                }
                if (i == row && j == col) {
                    continue; // self ignore
                }
                if (colony[i][j]) {
                    count++;
                }

            }
        }
        return count;
    }

}
