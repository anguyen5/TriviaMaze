package View;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Sound {
    private boolean soundOn = true;
    private String myBgMusicFile = "kim-lightyear-angel-eyes-chiptune-edit-110226-_1_.wav";
    private AudioInputStream myBackgroundMusic = AudioSystem.getAudioInputStream(new File(myBgMusicFile));
    private Clip clip = AudioSystem.getClip();
    private long myMusicPauseTime = 0;

    public Sound() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        playMusic();
    }

    void playMusic() throws IOException, LineUnavailableException {
        if(soundOn) {
            clip.open(myBackgroundMusic);
            clip.setMicrosecondPosition(myMusicPauseTime);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }else{
            myMusicPauseTime = clip.getMicrosecondLength();
            clip.stop();
            soundOn = false;
        }
    }
}
