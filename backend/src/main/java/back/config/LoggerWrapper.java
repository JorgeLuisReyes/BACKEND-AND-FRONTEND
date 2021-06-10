package back.config;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

import java.security.Principal;


public class LoggerWrapper {
    private Logger logger;
    private static String FQCN = LoggerWrapper.class.getName();

    private LoggerWrapper() {
    }

    public static LoggerWrapper getLogger(String name) {
        LoggerWrapper wrapperInstance = new LoggerWrapper();
        wrapperInstance.logger = Logger.getLogger(name);
        return wrapperInstance;

    }

    public void setLevel(Level level) {
        logger.setLevel(level);
    }

    // debug

    public void debug(Object message) {
        logger.log(FQCN, Level.DEBUG, message, null);
    }

    public void debug(String message, Throwable t) {
        logger.log(FQCN, Level.DEBUG, message, t);
    }

    public void debug(String principalName, String message) {
        logger.log(FQCN, Level.DEBUG, LogMessageFormatHelper.formatMessage(principalName, message), null);
    }

    public void debug(String principalName, String id, String message) {
        logger.log(FQCN, Level.DEBUG, LogMessageFormatHelper.formatMessage(principalName, id, message), null);
    }

    public void debug(String principalName, String message, Throwable t) {
        logger.log(FQCN, Level.DEBUG, LogMessageFormatHelper.formatMessage(principalName, message), t);
    }

    public void debug(String principalName, String id, String message, Throwable t) {
        logger.log(FQCN, Level.DEBUG, LogMessageFormatHelper.formatMessage(principalName, id, message), t);
    }

    public void debug(Principal userPrincipal, String message) {
        logger.log(FQCN, Level.DEBUG, LogMessageFormatHelper.formatMessage(userPrincipal, message), null);
    }

    public void debug(Principal userPrincipal, String id, String message) {
        logger.log(FQCN, Level.DEBUG, LogMessageFormatHelper.formatMessage(userPrincipal, id, message), null);
    }

    public void debug(Principal userPrincipal, String message, Throwable t) {
        logger.log(FQCN, Level.DEBUG, LogMessageFormatHelper.formatMessage(userPrincipal, message), t);
    }

    public void debug(Principal userPrincipal, String id, String message, Throwable t) {
        logger.log(FQCN, Level.DEBUG, LogMessageFormatHelper.formatMessage(userPrincipal, id, message), t);
    }

    // info

    public void info(String message) {
        logger.log(FQCN, Level.INFO, message, null);
    }

    public void info(String message, Throwable t) {
        logger.log(FQCN, Level.INFO, message, t);
    }

    public void info(String principalName, String message) {
        logger.log(FQCN, Level.INFO, LogMessageFormatHelper.formatMessage(principalName, message), null);
    }

    public void info(String principalName, String id, String message) {
        logger.log(FQCN, Level.INFO, LogMessageFormatHelper.formatMessage(principalName, id, message), null);
    }

    public void info(String principalName, String message, Throwable t) {
        logger.log(FQCN, Level.INFO, LogMessageFormatHelper.formatMessage(principalName, message), t);
    }

    public void info(String principalName, String id, String message, Throwable t) {
        logger.log(FQCN, Level.INFO, LogMessageFormatHelper.formatMessage(principalName, id, message), t);
    }

    public void info(Principal userPrincipal, Object message) {
        logger.log(FQCN, Level.INFO, LogMessageFormatHelper.formatMessage(userPrincipal, message), null);
    }

    public void info(Principal userPrincipal, String id, String message) {
        logger.log(FQCN, Level.INFO, LogMessageFormatHelper.formatMessage(userPrincipal, id, message), null);
    }

    public void info(Principal userPrincipal, String message, Throwable t) {
        logger.log(FQCN, Level.INFO, LogMessageFormatHelper.formatMessage(userPrincipal, message), t);
    }

    public void info(Principal userPrincipal, String id, String message, Throwable t) {
        logger.log(FQCN, Level.INFO, LogMessageFormatHelper.formatMessage(userPrincipal, id, message), t);
    }

    // warn

    public void warn(String message) {
        logger.log(FQCN, Level.WARN, message, null);
    }

    public void warn(String message, Throwable t) {
        logger.log(FQCN, Level.WARN, message, t);
    }

    public void warn(String principalName, String message) {
        logger.log(FQCN, Level.WARN, LogMessageFormatHelper.formatMessage(principalName, message), null);
    }

    public void warn(String principalName, String id, String message) {
        logger.log(FQCN, Level.WARN, LogMessageFormatHelper.formatMessage(principalName, id, message), null);
    }

    public void warn(String principalName, String message, Throwable t) {
        logger.log(FQCN, Level.WARN, LogMessageFormatHelper.formatMessage(principalName, message), t);
    }

    public void warn(String principalName, String id, String message, Throwable t) {
        logger.log(FQCN, Level.WARN, LogMessageFormatHelper.formatMessage(principalName, id, message), t);
    }

    public void warn(Principal userPrincipal, String message) {
        logger.log(FQCN, Level.WARN, LogMessageFormatHelper.formatMessage(userPrincipal, message), null);
    }

    public void warn(Principal userPrincipal, String id, String message) {
        logger.log(FQCN, Level.WARN, LogMessageFormatHelper.formatMessage(userPrincipal, id, message), null);
    }

    public void warn(Principal userPrincipal, String message, Throwable t) {
        logger.log(FQCN, Level.WARN, LogMessageFormatHelper.formatMessage(userPrincipal, message), t);
    }

    public void warn(Principal userPrincipal, String id, String message, Throwable t) {
        logger.log(FQCN, Level.WARN, LogMessageFormatHelper.formatMessage(userPrincipal, id, message), t);
    }

    // error

    public void error(String message) {
        logger.log(FQCN, Level.ERROR, message, null);
    }

    public void error(String message, Throwable t) {
        logger.log(FQCN, Level.ERROR, message, t);
    }

    public void error(String principalName, String message) {
        logger.log(FQCN, Level.ERROR, LogMessageFormatHelper.formatMessage(principalName, message), null);
    }

    public void error(String principalName, String id, String message) {
        logger.log(FQCN, Level.ERROR, LogMessageFormatHelper.formatMessage(principalName, id, message), null);
    }

    public void error(String principalName, String message, Throwable t) {
        logger.log(FQCN, Level.ERROR, LogMessageFormatHelper.formatMessage(principalName, message), t);
    }

    public void error(String principalName, String id, String message, Throwable t) {
        logger.log(FQCN, Level.ERROR, LogMessageFormatHelper.formatMessage(principalName, id, message), t);
    }

    public void error(Principal userPrincipal, String message) {
        logger.log(FQCN, Level.ERROR, LogMessageFormatHelper.formatMessage(userPrincipal, message), null);
    }

    public void error(Principal userPrincipal, String id, String message) {
        logger.log(FQCN, Level.ERROR, LogMessageFormatHelper.formatMessage(userPrincipal, id, message), null);
    }

    public void error(Principal userPrincipal, String message, Throwable t) {
        logger.log(FQCN, Level.ERROR, LogMessageFormatHelper.formatMessage(userPrincipal, message), t);
    }

    public void error(Principal userPrincipal, String id, String message, Throwable t) {
        logger.log(FQCN, Level.ERROR, LogMessageFormatHelper.formatMessage(userPrincipal, id, message), t);
    }

    // fatal

    public void fatal(String message) {
        logger.log(FQCN, Level.FATAL, message, null);
    }

    public void fatal(String message, Throwable t) {
        logger.log(FQCN, Level.FATAL, message, t);
    }

    public void fatal(String principalName, String message) {
        logger.log(FQCN, Level.FATAL, LogMessageFormatHelper.formatMessage(principalName, message), null);
    }

    public void fatal(String principalName, String id, String message) {
        logger.log(FQCN, Level.FATAL, LogMessageFormatHelper.formatMessage(principalName, id, message), null);
    }

    public void fatal(String principalName, String message, Throwable t) {
        logger.log(FQCN, Level.FATAL, LogMessageFormatHelper.formatMessage(principalName, message), t);
    }

    public void fatal(String principalName, String id, String message, Throwable t) {
        logger.log(FQCN, Level.FATAL, LogMessageFormatHelper.formatMessage(principalName, id, message), t);
    }

    public void fatal(Principal userPrincipal, String message) {
        logger.log(FQCN, Level.FATAL, LogMessageFormatHelper.formatMessage(userPrincipal, message), null);
    }

    public void fatal(Principal userPrincipal, String id, String message) {
        logger.log(FQCN, Level.FATAL, LogMessageFormatHelper.formatMessage(userPrincipal, id, message), null);
    }

    public void fatal(Principal userPrincipal, String message, Throwable t) {
        logger.log(FQCN, Level.FATAL, LogMessageFormatHelper.formatMessage(userPrincipal, message), t);
    }

    public void fatal(Principal userPrincipal, String id, String message, Throwable t) {
        logger.log(FQCN, Level.FATAL, LogMessageFormatHelper.formatMessage(userPrincipal, id, message), t);
    }

    // trace

    public void trace(String message) {
        logger.log(FQCN, Level.TRACE, message, null);
    }

    public void trace(String message, Throwable t) {
        logger.log(FQCN, Level.TRACE, message, t);
    }

    public void trace(String principalName, String message) {
        logger.log(FQCN, Level.TRACE, LogMessageFormatHelper.formatMessage(principalName, message), null);
    }

    public void trace(String principalName, String id, String message) {
        logger.log(FQCN, Level.TRACE, LogMessageFormatHelper.formatMessage(principalName, id, message), null);
    }

    public void trace(String principalName, String message, Throwable t) {
        logger.log(FQCN, Level.TRACE, LogMessageFormatHelper.formatMessage(principalName, message), t);
    }

    public void trace(String principalName, String id, String message, Throwable t) {
        logger.log(FQCN, Level.TRACE, LogMessageFormatHelper.formatMessage(principalName, id, message), t);
    }

    public void trace(Principal userPrincipal, String message) {
        logger.log(FQCN, Level.TRACE, LogMessageFormatHelper.formatMessage(userPrincipal, message), null);
    }

    public void trace(Principal userPrincipal, String id, String message) {
        logger.log(FQCN, Level.TRACE, LogMessageFormatHelper.formatMessage(userPrincipal, id, message), null);
    }

    public void trace(Principal userPrincipal, String message, Throwable t) {
        logger.log(FQCN, Level.TRACE, LogMessageFormatHelper.formatMessage(userPrincipal, message), t);
    }

    public void trace(Principal userPrincipal, String id, String message, Throwable t) {
        logger.log(FQCN, Level.TRACE, LogMessageFormatHelper.formatMessage(userPrincipal, id, message), t);
    }

    // log
    
    public void log(Level level, String message) {
        logger.log(FQCN, level, message, null);
    }

    public void log(Level level, String message, Throwable t) {
        logger.log(FQCN, level, message, t);
    }

    public void log(String principalName, Level level, String message) {
        logger.log(FQCN, level, LogMessageFormatHelper.formatMessage(principalName, message), null);
    }

    public void log(String principalName, Level level, String id, String message) {
        logger.log(FQCN, level, LogMessageFormatHelper.formatMessage(principalName, id, message), null);
    }

    public void log(String principalName, Level level, String message, Throwable t) {
        logger.log(FQCN, level, LogMessageFormatHelper.formatMessage(principalName, message), t);
    }

    public void log(String principalName, Level level, String id, String message, Throwable t) {
        logger.log(FQCN, level, LogMessageFormatHelper.formatMessage(principalName, id, message), t);
    }

    public void log(Principal userPrincipal, Level level, String message) {
        logger.log(FQCN, level, LogMessageFormatHelper.formatMessage(userPrincipal, message), null);
    }

    public void log(Principal userPrincipal, Level level, String id, String message) {
        logger.log(FQCN, level, LogMessageFormatHelper.formatMessage(userPrincipal, id, message), null);
    }

    public void log(Principal userPrincipal, Level level, String message, Throwable t) {
        logger.log(FQCN, level, LogMessageFormatHelper.formatMessage(userPrincipal, message), t);
    }

    public void log(Principal userPrincipal, Level level, String id, String message, Throwable t) {
        logger.log(FQCN, level, LogMessageFormatHelper.formatMessage(userPrincipal, id, message), t);
    }

    // utilities

    public boolean isInfoEnabled() {
        return logger.isInfoEnabled();
    }

    public boolean isDebugEnabled() {
        return logger.isDebugEnabled();
    }

    public boolean isTraceEnabled() {
        return logger.isTraceEnabled();
    }

    public boolean isEnabledFor(Priority level) {
        return logger.isEnabledFor(level);
    }

}