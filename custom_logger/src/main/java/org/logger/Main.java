package org.logger;

import org.logger.logSink.FileLogSink;
import org.logger.types.LogLevel;

public class Main {
    public static void main(String[] args) {
        System.out.println("Testing our logger !");

        Logger logger = Logger.getInstance();
        logger.setLogLevel(LogLevel.INFO);

        logger.log(LogLevel.INFO, "This is Info message");
        logger.log(LogLevel.WARNING, "This is a Warning message.");
        logger.log(LogLevel.ERROR, "This is an Error message !");

        logger.setLogSink(new FileLogSink("log.txt"));
        logger.log(LogLevel.INFO, "This is an Info Log");
    }
}