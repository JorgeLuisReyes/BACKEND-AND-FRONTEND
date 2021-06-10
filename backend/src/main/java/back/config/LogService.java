package back.config;

import org.apache.log4j.Level;

public class LogService {

    private static final String LOGGER_NAME = "Back";

    private static final Level LOG_LEVEL = Level.ALL;

    public static LoggerWrapper logger = LoggerWrapper.getLogger(LOGGER_NAME);

    static {
        try {
            System.out.println("[" + LOGGER_NAME + "] INFO: LogService: Initializing...");
            logger.setLevel(LOG_LEVEL);
            System.out.println("[" + LOGGER_NAME + "] INFO: LogService: Log oa level : " + LOG_LEVEL.toString());
        } catch (Exception e) {
            System.err.println("[" + LOGGER_NAME + "] ERROR: LogService: Can't initialize: " + e);
        }
    }
}