package vidmot;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Manages reading and writing the high score to a file outside the packaged app.
 */
public class HiscoreManager {
    private final Path hiScoreFile;

    /**
     * Creates a high score manager that stores data in the user's home directory.
     */
    public HiscoreManager() {
        this(Paths.get(System.getProperty("user.home"), ".goldrush", "hiscores.txt"));
    }

    /**
     * Creates a high score manager with a custom file path.
     * Useful for testing.
     *
     * @param hiScoreFile path to the high score file
     */
    public HiscoreManager(Path hiScoreFile) {
        this.hiScoreFile = hiScoreFile;
        initializeFile();
    }

    /**
     * Creates the directory and file if they do not already exist.
     */
    private void initializeFile() {
        try {
            Path parent = hiScoreFile.getParent();
            if (parent != null) {
                Files.createDirectories(parent);
            }

            if (Files.notExists(hiScoreFile)) {
                Files.writeString(
                        hiScoreFile,
                        "0" + System.lineSeparator(),
                        StandardCharsets.UTF_8,
                        StandardOpenOption.CREATE
                );
            }
        } catch (IOException e) {
            throw new IllegalStateException("Could not initialize high score file.", e);
        }
    }

    /**
     * Reads the current high score from file.
     *
     * @return the stored high score, or 0 if the file is empty or invalid
     */
    public int readHiScore() {
        try {
            String line = Files.readString(hiScoreFile, StandardCharsets.UTF_8).trim();
            if (line.isEmpty()) {
                return 0;
            }
            return Integer.parseInt(line);
        } catch (IOException | NumberFormatException e) {
            return 0;
        }
    }

    /**
     * Updates the high score if the new score is higher.
     *
     * @param newScore the new score to compare
     * @return the updated high score
     */
    public int updateHiScore(int newScore) {
        int currentHighScore = readHiScore();

        if (newScore <= currentHighScore) {
            return currentHighScore;
        }

        try {
            Files.writeString(
                    hiScoreFile,
                    newScore + System.lineSeparator(),
                    StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING
            );
            return newScore;
        } catch (IOException e) {
            return currentHighScore;
        }
    }
}