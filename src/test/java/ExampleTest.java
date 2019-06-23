import org.junit.Assert;
import org.junit.Test;

/**
 * @author Krzysztof Ziomek
 * @since 23/11/2017.
 */
public class ExampleTest {

    @Test
    public void cell_0_0_shouldDieWhenHasZeroNeighbours() {

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
    public void cell_7_5_shouldDieWhenHasZeroNeighbours() {

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
    public void cell_3_3_shouldDieWhenHasZeroNeighbours() {

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
    public void cells_0_0_and_0_1shouldDieBecauseHavingOneNeighbour() {

        // GIVEN
        Game game = new Game();
        boolean[][] colony = new boolean[8][6];
        colony[0][0] = true;
        colony[0][1] = true;

        // WHEN
        boolean[][] newColony = game.runIteration(colony);

        // THEN
        Assert.assertFalse(newColony[0][0]);
        Assert.assertFalse(newColony[0][1]);

    }

    @Test
    public void cellWithTwoNeighboursShouldSurvive() {

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

    @Test
    public void cellWithThreeNeighboursShouldBeReproduced() {

        // GIVEN
        Game game = new Game();
        boolean[][] colony = new boolean[8][6];
        colony[2][3] = true;
        colony[3][3] = true;
        colony[4][3] = true;

        // WHEN
        boolean[][] newColony = game.runIteration(colony);

        // THEN
        Assert.assertEquals(true, newColony[3][2]);
        Assert.assertEquals(true, newColony[3][4]);
    }

    @Test
    public void oscilatorShouldnOscilateToNextPhase() {
        // GIVEN
        Game game = new Game();
        boolean[][] colony = new boolean[5][5];
        colony[2][1] = true;
        colony[2][2] = true;
        colony[2][3] = true;

        //WHEN
        boolean[][] newColony = game.runIteration(colony);

        //THEN
        Assert.assertEquals(true, newColony[1][2]);
        Assert.assertEquals(true, newColony[2][2]);
        Assert.assertEquals(true, newColony[3][2]);

        Assert.assertEquals(false, newColony[2][1]);
        Assert.assertEquals(false, newColony[2][3]);
    }


    @Test
    public void stilLiveShouldNotChangeToNextPhase() {
        // GIVEN
        Game game = new Game();
        boolean[][] colony = new boolean[4][4];
        colony[1][1] = true;
        colony[1][2] = true;
        colony[2][1] = true;
        colony[2][2] = true;

        //WHEN
        boolean[][] newColony = game.runIteration(colony);

        //THEN
        Assert.assertEquals(true, newColony[1][1]);
        Assert.assertEquals(true, newColony[1][2]);
        Assert.assertEquals(true, newColony[2][1]);
        Assert.assertEquals(true, newColony[2][2]);
    }

    @Test
    public void cellWithMoreThenThreeNeighboursShouldDieByOverpopulation() {
        Game game = new Game();
        boolean[][] colony = new boolean[4][4];
        colony[1][1] = true;
        colony[1][2] = true;
        colony[2][1] = true;
        colony[2][2] = true;
        colony[3][1] = true;
        colony[3][2] = true;

        //WHEN
        boolean[][] newColony = game.runIteration(colony);

        //THEN
        Assert.assertEquals(false, newColony[2][1]);
        Assert.assertEquals(false, newColony[2][2]);

        Assert.assertEquals(true, newColony[1][1]);
        Assert.assertEquals(true, newColony[1][2]);
        Assert.assertEquals(true, newColony[2][0]);
        Assert.assertEquals(true, newColony[2][3]);
        Assert.assertEquals(true, newColony[3][2]);
        Assert.assertEquals(true, newColony[3][2]);
    }
}

