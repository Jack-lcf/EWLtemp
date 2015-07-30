package logger;

import org.apache.log4j.Logger;

public class Log {

    private static final Logger LOG = Logger.getLogger(Log.class);

    public static void error(String message) {
        LOG.error(message);
    }

    public static void warning(String message) {
        LOG.warn(message);
    }

    public static void info(String message) {
       LOG.info(message);
    }

    public static void debug(String message) {
       LOG.debug(message);
    }
}
