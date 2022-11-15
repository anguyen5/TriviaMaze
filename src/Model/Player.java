package Model;
import java.util.HashSet;
import java.io.Serializable;

public class Player implements Serializable {

    private String myPlayerName;
    private int position = 0;
    private final DifficultyLevels levels;
    private HashSet<Integer> UnblockedRoom = new HashSet<Integer>();
    private static Player myPlayer;
    private int myStreak;
    private int myScore;

    /*
     This constructor is built to define the name and level of game which is
     picked from the Player
     */
     private Player (String theName, DifficultyLevels myLevels)
     {
         myPlayerName = theName;
         levels = myLevels;
     }

     public int resetStreak()
     {
         myStreak = 0;
         return  myStreak;
     }

     public int updateMyStreak()
     {
         return myStreak++;
     }

     public int updateTheScore (final int scoreAmount)
     {
         myScore += scoreAmount;
         return myScore;
     }

    public int getMyStreak() {
        return myStreak;
    }

    public int getMyScore() {
        return myScore;
    }

    public static void createNewPlayer (String myName, DifficultyLevels difficultyLevels)
    {
        if (myPlayer == null)
            myPlayer = new Player(myName, difficultyLevels);
    }

    public static void loadPlayer (final Object newObject)
    {
        myPlayer = (Player) newObject;
    }

    public static void deletePlayer ()
    {
        if (myPlayer != null)
        {
            myPlayer = null;
        }
    }

    public static Player getMyPlayer() {
        return myPlayer;
    }

    public DifficultyLevels getLevels() {
        return levels;
    }

    public String getMyPlayerName() {
        return myPlayerName;
    }

    public int getPosition() {
        return position;
    }

    public void movePlayer (final Directions myDir)
    {
        int chances = attemptToMove(myDir);
        position = chances;
        updateRoomsUnclocked(chances);
    }

    public boolean closeDoor (final Directions myDir)
    {
        return true; // after checking the maze
    }
    public int attemptToMove (final  Directions myDir)
    {
        int tempoDir = position;
        if (myDir == Directions.Up) tempoDir -= levels.getValue() + 3;
        else if (myDir == Directions.Down) tempoDir += levels.getValue() + 3;
        else if (myDir == Directions.Right) tempoDir++ ;
        else if (myDir == Directions.Left) tempoDir--;
        // maze
        return position;
    }

    public HashSet<Integer> getUnblockedRoom() {
        return UnblockedRoom;
    }

    private void updateRoomsUnclocked (final int numRoom)
    {
         UnblockedRoom.add(numRoom);
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
