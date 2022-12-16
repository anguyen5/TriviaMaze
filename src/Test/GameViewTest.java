package Test;

import static org.junit.Assert.*;
import View.*;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.FileNotFoundException;

/**
 * @author: An Nguyen
 * @version: 12/16/2022
 */

/**
 * This class tests for GameView, because all levels have the same the setup maze so testing for beginner level
 */
public class GameViewTest {

    private GameView game;
    @Before
    public final void setup() throws FileNotFoundException {
        game = new GameView(1);
    }

    /**
     * if position = 1, that players don't have the path because position < E_FAIL
     * E_FAIL = 2
     */
    @Test
    public final void canGo_0()  {

        boolean expect = false;
        assertEquals(expect, game.canGo(1));
    }

    /**
     * if position = 2, that players don't have the path because position < E_FAIL
     * E_FAIL = 2
     */
    @Test
    public final void canGo_1()  {

        boolean expect = false;
        assertEquals(expect, game.canGo(2));
    }

    /**
     * if position = 3, that players have a path to go because position > E_FAIL
     * E_FAIL
     */
    @Test
    public final void canGo_2()  {
        boolean expect = true;
        assertEquals(expect, game.canGo(3));
    }

    /**
     * if position = 0, that players have a path to go because position = E_PATH
     * E_PATH = 0
     */
    @Test
    public final void canGo_3()  {
        boolean expect = true;
        assertEquals(expect, game.canGo(0));
    }

}