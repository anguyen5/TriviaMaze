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
 * This class tests for GameView
 */
public class GameViewTest {

    /**
     * setup(): void
     * because all levels have the same the setup maze so testing for beginner level
     */
    private GameView game;
    @Before
    public final void setup() throws FileNotFoundException {
        game = new GameView(1);
    }

    /**
     * canGo_0(): void
     * canGo_0(): test for Beginner level
     * if position = 1, that players don't have the path because position < E_FAIL
     * E_FAIL = 2
     */
    @Test
    public final void canGo_0()  {

        boolean expect = false;
        assertEquals(expect, game.canGo(1));
    }

    /**
     * canGo_1(): test for Beginner level
     * if position = 2, that players don't have the path because position < E_FAIL
     * E_FAIL = 2
     */
    @Test
    public final void canGo_1()  {

        boolean expect = false;
        assertEquals(expect, game.canGo(2));
    }

    /**
     * canGo_2(): test for Beginner level
     * if position = 3, that players have a path to go because position > E_FAIL
     * E_FAIL = 2
     */
    @Test
    public final void canGo_2()  {
        boolean expect = true;
        assertEquals(expect, game.canGo(3));
    }

    /**
     * canGo_3(): test for Beginner level
     * if position = 0, that players have a path to go because position = E_PATH
     * E_PATH = 0
     */
    @Test
    public final void canGo_3()  {
        boolean expect = true;
        assertEquals(expect, game.canGo(0));
    }

    /**
     * canGo_4(): test for Beginner level
     * if position = -1, that players don't have a path
     */
    @Test
    public final void canGo_4()  {
        boolean expect = false;
        assertEquals(expect, game.canGo(-1));
    }

    /**
     * canGo_5(): test for Beginner level
     * if position = 4, that players have a path to go because position > E_FAIL
     * E_FAIL = 2
     */
    @Test
    public final void canGo_5()  {
        boolean expect = true;
        assertEquals(expect, game.canGo(4));
    }

    /**
     * canGo_6(): test for Medium level so instance GameView
     * if position = 3, that players have a path to go because position > E_FAIL
     * E_FAIL = 2
     */
    @Test
    public final void canGo_6()  {
        try {
            GameView temp = new GameView(2);
            boolean expect = true;
            assertEquals(expect, temp.canGo(3));
        }
        catch (FileNotFoundException ex){
            System.out.println(ex);
        }
    }

    /**
     * canGo_7(): test for hard level so instance GameView
     * if position = 3, that players have a path to go because position > E_FAIL
     * E_FAIL = 2
     */
    @Test
    public final void canGo_7()  {
        try {
            GameView temp = new GameView(3);
            boolean expect = true;
            assertEquals(expect, temp.canGo(3));
        }
        catch (FileNotFoundException ex){
            System.out.println(ex);
        }
    }

    /**
     * SearchPath_0(): Test for case temporary maze that maze doesn't have any path.
     * set up new maze that don't have any path to go to destination.
     * @return: boolean
     */
    @Test
    public final void searchPath_0()  {
        int[][] tempMaze = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 5, 1, 0, 4, 0, 0, 0, 0, 0, 4, 0, 1},
                {1, 0, 1, 0, 0, 0, 0, 4, 1, 1, 1, 0, 1},
                {1, 0, 4, 0, 1, 1, 0, 0, 0, 0, 4, 0, 1},
                {1, 0, 1, 0, 0, 0, 4, 0, 1, 1, 1, 0, 1},
                {1, 0, 1, 0, 1, 1, 1, 0, 4, 0, 0, 4, 1},
                {1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1},
                {1, 0, 1, 4, 1, 1, 1, 4, 1, 4, 1, 1, 1},
                {1, 4, 1, 1, 1, 4, 1, 1, 1, 1, 1, 6, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        GameView tempview = new GameView();
        tempview.setMaze(tempMaze);
        assertEquals(false, tempview.searchPath());
    }

    /**
     * SearchPath_1(): Test for case medium level
     * @return: boolean
     */
    @Test
    public final void searchPath_1() {
        try {
            GameView tempview = new GameView(2);
            assertEquals(true, tempview.searchPath());
        }
        catch (FileNotFoundException ex){
            System.out.println(ex);
        }
    }

    /**
     * SearchPath_2(): Test for case hard level
     * @return: boolean
     */
    @Test
    public final void searchPath_2() {
        try {
            GameView tempview = new GameView(3);
            assertEquals(true, tempview.searchPath());
        }
        catch (FileNotFoundException ex){
            System.out.println(ex);
        }
    }

    /**
     * SearchPath_3(): Test for case temporary maze that maze doesn't have any path.
     * set up new maze that don't have any path to go to destination.
     * The wall is filled at first Room
     * @return: boolean
     */
    @Test
    public final void searchPath_3()  {
        int[][] tempMaze = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 5, 1, 0, 4, 0, 0, 0, 0, 0, 4, 0, 1},
                {1, 0, 1, 0, 0, 0, 0, 4, 1, 1, 1, 0, 1},
                {1, 0, 4, 1, 1, 1, 0, 0, 0, 0, 4, 0, 1},
                {1, 1, 1, 0, 0, 0, 4, 0, 1, 1, 1, 0, 1},
                {1, 1, 1, 0, 1, 1, 1, 0, 4, 0, 0, 4, 1},
                {1, 1, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1},
                {1, 1, 1, 4, 1, 1, 1, 4, 1, 4, 1, 0, 1},
                {1, 4, 0, 0, 0, 4, 0, 0, 0, 0, 0, 6, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        GameView tempview = new GameView();
        tempview.setMaze(tempMaze);
        assertEquals(false, tempview.searchPath());
    }

    /**
     * SearchPath_4(): Test for case temporary maze that maze doesn't have any path.
     * set up new maze that don't have any path to go to destination.
     * The wall is filled at two first Rooms
     * @return: boolean
     */
    @Test
    public final void searchPath_4()  {
        int[][] tempMaze = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 5, 1, 0, 4, 0, 0, 0, 0, 0, 4, 0, 1},
                {1, 0, 1, 0, 0, 0, 0, 4, 1, 1, 1, 0, 1},
                {1, 0, 4, 1, 1, 1, 1, 1, 1, 1, 4, 1, 1},
                {1, 0, 1, 0, 0, 0, 4, 0, 1, 1, 1, 0, 1},
                {1, 0, 1, 0, 1, 1, 1, 0, 4, 0, 0, 4, 1},
                {1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 4, 1, 1, 1, 4, 1, 4, 1, 0, 1},
                {1, 4, 1, 1, 1, 4, 1, 1, 1, 1, 1, 6, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        GameView tempview = new GameView();
        tempview.setMaze(tempMaze);
        assertEquals(false, tempview.searchPath());
    }

    /**
     * SearchPath_5(): Test for case temporary maze that maze opens just one path to go
     * @return: boolean
     */
    @Test
    public final void searchPath_5()  {
        int[][] tempMaze = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 5, 1, 0, 4, 0, 0, 0, 0, 0, 4, 0, 1},
                {1, 0, 1, 0, 0, 0, 0, 4, 1, 1, 1, 0, 1},
                {1, 0, 4, 1, 1, 1, 1, 1, 1, 1, 4, 1, 1},
                {1, 0, 1, 0, 0, 0, 4, 0, 1, 1, 1, 0, 1},
                {1, 0, 1, 0, 1, 1, 1, 0, 4, 0, 0, 4, 1},
                {1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 4, 1, 1, 1, 4, 1, 4, 1, 0, 1},
                {1, 4, 0, 0, 0, 4, 0, 0, 0, 0, 0, 6, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        GameView tempview = new GameView();
        tempview.setMaze(tempMaze);
        assertEquals(true, tempview.searchPath());
    }

    /**
     * SearchPath_6(): Test for case temporary maze that maze opens just two paths to go
     * @return: boolean
     */
    @Test
    public final void searchPath_6()  {
        int[][] tempMaze = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 5, 1, 1, 4, 1, 1, 1, 0, 0, 4, 0, 1},
                {1, 0, 1, 1, 1, 1, 1, 4, 1, 1, 1, 1, 1},
                {1, 0, 4, 0, 0, 0, 0, 0, 0, 0, 4, 0, 1},
                {1, 0, 1, 1, 1, 1, 4, 1, 1, 1, 1, 0, 1},
                {1, 0, 1, 0, 1, 1, 1, 0, 4, 0, 0, 4, 1},
                {1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 4, 1, 1, 1, 4, 1, 4, 1, 0, 1},
                {1, 4, 0, 0, 0, 4, 0, 0, 0, 0, 0, 6, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        GameView tempview = new GameView();
        tempview.setMaze(tempMaze);
        assertEquals(true, tempview.searchPath());
    }



}