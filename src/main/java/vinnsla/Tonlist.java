package vinnsla;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.net.URL;
import java.util.Objects;

/**
 * Manages background music and sound effects in the game.
 */
public class Tonlist {
    MediaPlayer mediaPlayer;

    /**
     * Plays background music while the game is running.
     */
    public void play() {
        String backgroundMusic = "backgroundMusic.mp3";
        playHitSound(backgroundMusic);
    }

    /**
     * Stops the background music.
     */
    public void stop() {
        if (this.mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }

    /**
     * Plays the game over music when the game ends.
     */
    public void gameOverMusic() {
        String gameOverTonlist = "gameOver.mp3";
        playOnceSound(gameOverTonlist);
    }

    /**
     * Plays a sound effect when coal is collected.
     */
    public void kolFoundSound() {
        String kolSound = "kolSound.mp3";
        playOnceSound(kolSound);
    }

    /**
     * Plays a sound effect when gold is collected.
     */
    public void gullFoundSound() {
        String gullSound = "gullSound.mp3";
        playOnceSound(gullSound);
    }

    /**
     * Plays a sound file once.
     *
     * @param fileName the name of the audio file to play
     */
    private void playOnceSound(String fileName) {
        URL resourceUrl = Objects.requireNonNull(getClass().getResource(fileName));
        Media media = new Media(resourceUrl.toExternalForm());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }

    /**
     * Plays a sound file on repeat.
     *
     * @param fileName the name of the audio file to play
     */
    private void playHitSound(String fileName) {
        URL resourceUrl = Objects.requireNonNull(getClass().getResource(fileName));
        Media media = new Media(resourceUrl.toExternalForm());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }
}
