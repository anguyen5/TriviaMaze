import View.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class TriviaMaze {

    public static void main(String[] args) {
        setupGUI();


    }
    public static void setupGUI(){
        MainMenuGUI myMenuListener = new MainMenuGUI();
        myMenuListener.showActionListener();

    }
}
