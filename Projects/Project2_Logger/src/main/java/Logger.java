package Projects.Project2_Logger.src.main.java;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static final int MAX_LOG_SIZE = 5000; // bytes
    private static final String LOG_FILE_NAME = "app.log";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public enum Severity {
        INFO, WARNING, ERROR
    }

    public void log(Severity severity, String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE_NAME, true))) {
            writer.write(formatLogEntry(severity, message));
        } catch (IOException e) {
            System.out.println("Error writing to log file: " + e.getMessage());
        }
        checkLogRotation();
    }

    private String formatLogEntry(Severity severity, String message) {
        return LocalDateTime.now().format(formatter) + " [" + severity + "]: " + message + "\n";
    }

    private void checkLogRotation() {
        Path logPath = Paths.get(LOG_FILE_NAME);
        try {
            if (Files.size(logPath) > MAX_LOG_SIZE) {
                rotateLog(logPath);
            }
        } catch (IOException e) {
            System.out.println("Error checking log size: " + e.getMessage());
        }
    }

    private void rotateLog(Path logPath) {
        try {
            String archiveName = "archive-" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")) + ".log";
            Files.move(logPath, logPath.resolveSibling(archiveName));
        } catch (IOException e) {
            System.out.println("Error during log rotation: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Logger logger = new Logger();
        logger.log(Severity.INFO, "This is an informational message.");
        logger.log(Severity.WARNING, "This is a warning.");
        logger.log(Severity.ERROR, "This is an error!");

    }
}

