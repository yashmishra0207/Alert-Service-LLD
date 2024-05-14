package alertMonitor.services;

import alertMonitor.constants.LoggerConstants;
import alertMonitor.enums.LogType;

public interface LoggerService {
    default void logInfo(String message) {
        System.out.println(String.format(LoggerConstants.FORMATTED_LOG, LogType.INFO.name(), this.getClass().getSimpleName(), message));
    }

    default void logWarning(String message) {
        System.out.println(String.format(LoggerConstants.FORMATTED_LOG, LogType.WARN.name(), this.getClass().getSimpleName(), "`" + message + "`"));
    }

    default void logSourceWarning(String message, String logSource) {
        System.out.println(String.format(LoggerConstants.FORMATTED_LOG, LogType.WARN.name(), logSource, "`" + message + "`"));
    }
}
