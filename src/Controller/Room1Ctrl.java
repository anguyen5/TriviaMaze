package Controller;
import Model.Directions;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Color;

public class Room1Ctrl extends JPanel {
    private int mySize;
    private int PlayerPosition;
    private Room[] myRoom;

    private int getPositions(final Directions direct) {
        int tempVar = PlayerPosition;
        switch (direct) {
            case Up : tempVar -= mySize;
            case Down: tempVar += mySize;
            case Left:  tempVar--;
            case Right:tempVar++;
        }
        return tempVar;
    }
    /*
      Need a connection to the Controller
      Using to update before and after the player choose the directions to go
     */
    public void updatePlayerPositions() {

    }
    /*
      Using for update the direction where the door is available or already block
      and the player need to choose another way.
     */
    public void lockRoom(Directions myDirect) {

    }

    private static class Room extends JButton {
        private int[] myLockSides = new int[]{1, 1, 1, 1};

        /*
           This is a constructor for setting up the room
         */
        public Room() {
            this.setBackground(Color.lightGray);
            this.setBorder(BorderFactory.createBevelBorder(1));
            this.setEnabled(false);
        }

        /*
           This method is using for unlock a certain room
         */
        public void unlock() {
            this.setBackground(Color.green);
        }

        public void updateSideBlocked(Directions myDirect) {
            myLockSides[myDirect.getDirectionCode()] += 10;
        }

        public int[] getLockSides() {
            return myLockSides;
        }

    }

}

