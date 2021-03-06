package tw.conway.game;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static tw.conway.enumeration.LifeStatus.DEAD;
import static tw.conway.enumeration.LifeStatus.LIVE;

import org.junit.Before;
import org.junit.Test;

import tw.conway.enumeration.LifeStatus;

public class ConwayGameTest {

    private ConwayGame conway;

    @Before
    public void setUp() {
        conway = new ConwayGame();
    }

    @Test
    public void shouldNextStateBeSameGivenZeroAliveCell() {
        LifeStatus[][] current = {
                {DEAD, DEAD, DEAD},
                {DEAD, DEAD, DEAD},
                {DEAD, DEAD, DEAD}
        };
        LifeStatus[][] expectNext = {
                {DEAD, DEAD, DEAD},
                {DEAD, DEAD, DEAD},
                {DEAD, DEAD, DEAD}
        };

        assertThat(conway.nextGeneration(current), is(expectNext));
    }

    @Test
    public void shouldNextStateBeAllDeadGivenCellWithLessThanTwoAliveNeighbours() {
        LifeStatus[][] current = {
                {LIVE, DEAD, DEAD},
                {DEAD, DEAD, DEAD},
                {DEAD, DEAD, LIVE},
                {DEAD, DEAD, LIVE}
        };
        LifeStatus[][] expectNext = {
                {DEAD, DEAD, DEAD},
                {DEAD, DEAD, DEAD},
                {DEAD, DEAD, DEAD},
                {DEAD, DEAD, DEAD}
        };

        assertThat(conway.nextGeneration(current), is(expectNext));
    }

    @Test
    public void shouldNextStateRemainGivenCellWithOnlyTwoAliveNeighbours() {
        LifeStatus[][] current = {
                {LIVE, DEAD, LIVE},
                {DEAD, DEAD, DEAD},
                {DEAD, DEAD, DEAD},
                {LIVE, LIVE, LIVE}
        };
        LifeStatus[][] expectNext = {
                {DEAD, DEAD, DEAD},
                {DEAD, DEAD, DEAD},
                {DEAD, LIVE, DEAD},
                {DEAD, LIVE, DEAD}
        };

        assertThat(conway.nextGeneration(current), is(expectNext));
    }

    @Test
    public void shouldNextStateBeAliveGivenCellWithOnlyThreeAliveNeighbors() {
        LifeStatus[][] current = {
                {LIVE, DEAD, LIVE},
                {DEAD, LIVE, DEAD},
                {LIVE, DEAD, DEAD}
        };
        LifeStatus[][] expectNext = {
                {DEAD, LIVE, DEAD},
                {LIVE, LIVE, DEAD},
                {DEAD, DEAD, DEAD}
        };

        assertThat(conway.nextGeneration(current), is(expectNext));
    }

    @Test
    public void shouldNextStateBeDeadGivenCellWithMoreThanThreeAliveNeighbors() {
        LifeStatus[][] current = {
                {DEAD, LIVE, DEAD},
                {LIVE, DEAD, LIVE},
                {DEAD, LIVE, DEAD},
                {LIVE, DEAD, LIVE}
        };
        LifeStatus[][] expectNext = {
                {DEAD, LIVE, DEAD},
                {LIVE, DEAD, LIVE},
                {LIVE, DEAD, LIVE},
                {DEAD, LIVE, DEAD}
        };

        assertThat(conway.nextGeneration(current), is(expectNext));
    }

    @Test
    public void shouldNextStateBeDeadGivenCellWithEightAliveNeighborsSurrounded() {
        LifeStatus[][] current = {
                {LIVE, LIVE, LIVE},
                {LIVE, LIVE, LIVE},
                {LIVE, LIVE, LIVE}
        };
        LifeStatus[][] expectNext = {
                {LIVE, DEAD, LIVE},
                {DEAD, DEAD, DEAD},
                {LIVE, DEAD, LIVE}
        };

        assertThat(conway.nextGeneration(current), is(expectNext));
    }
}
