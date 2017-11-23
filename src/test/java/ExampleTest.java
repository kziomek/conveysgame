import org.junit.Assert;
import org.junit.Test;

/**
 * @author Krzysztof Ziomek
 * @since 23/11/2017.
 */
public class ExampleTest {


    // Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.


    @Test
    public void cell_0_0_shouldDieWhenHasZeroNeighbours(){

        // GIVEN
        Game game = new Game();
        boolean[][] colony = new boolean[8][6];
        colony[0][0] = true;

        // WHEN
        boolean[][] newColony = game.runIteration(colony);

        // THEN
        Assert.assertEquals(false, newColony[0][0]);

    }

    @Test
    public void cell_7_5_shouldDieWhenHasZeroNeighbours(){

        // GIVEN
        Game game = new Game();
        boolean[][] colony = new boolean[8][6];
        colony[7][5] = true;

        // WHEN
        boolean[][] newColony = game.runIteration(colony);

        // THEN
        Assert.assertEquals(false, newColony[7][5]);

    }

    @Test
    public void cell_3_3_shouldDieWhenHasZeroNeighbours(){

        // GIVEN
        Game game = new Game();
        boolean[][] colony = new boolean[8][6];
        colony[3][3] = true;

        // WHEN
        boolean[][] newColony = game.runIteration(colony);

        // THEN
        Assert.assertEquals(false, newColony[3][3]);

    }

    @Test
    public void cellWithTwoNeighboursShouldSurvive(){

        // GIVEN
        Game game = new Game();
        boolean[][] colony = new boolean[8][6];
        colony[2][3] = true;
        colony[3][3] = true;
        colony[4][3] = true;

        // WHEN
        boolean[][] newColony = game.runIteration(colony);

        // THEN
        Assert.assertEquals(false, newColony[2][3]);
        Assert.assertEquals(true, newColony[3][3]);
        Assert.assertEquals(false, newColony[4][3]);

    }

}
