package Test;

import static org.junit.Assert.*;
import Model.*;
import org.junit.Test;

/**
 * @author: An Nguyen
 * @version: 12/16/2022
 */

/**
 * This class tests for maze
 */
public class MazeTest {

    @Test
    public final void getMAZE_0() {
        int[][] expected =  {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 5, 1, 0, 4, 0, 0, 0, 0, 0, 4, 0, 1},
                {1, 0, 1, 0, 0, 0, 0, 4, 1, 1, 1, 0, 1},
                {1, 0, 4, 0, 1, 1, 0, 0, 0, 0, 4, 0, 1},
                {1, 0, 1, 0, 0, 0, 4, 0, 1, 1, 1, 0, 1},
                {1, 0, 1, 0, 1, 1, 1, 0, 4, 0, 0, 4, 1},
                {1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 4, 1, 1, 1, 4, 1, 4, 0, 0, 1},
                {1, 4, 0, 0, 0, 4, 0, 0, 0, 0, 1, 6, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };

        Maze maze = new Maze();
        int[][] mazeArr = maze.getMAZE();
        assertArrayEquals(expected,mazeArr);

    }


    
}