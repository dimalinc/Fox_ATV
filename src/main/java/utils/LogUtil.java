package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogUtil {

    private static final Logger log =  LogManager.getLogger(LogUtil.class);

    public static void logInfo(String message) {
        log.info("Info " + message);
    }

}
