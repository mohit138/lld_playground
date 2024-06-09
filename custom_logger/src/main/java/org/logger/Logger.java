package org.logger;

import org.logger.logSink.ConsoleLogSink;
import org.logger.logSink.LogSink;
import org.logger.types.LogLevel;

import java.util.Date;

public class Logger {
    private static Logger instance;
    private LogSink logSink;
    private LogLevel logLevel;

    public Logger(){
        this.logLevel = LogLevel.INFO;
        this.logSink = new ConsoleLogSink();
    }

    public static Logger getInstance(){
        if(instance==null){
            instance =  new Logger();
        }
        return instance;
    }

    public void setLogSink(LogSink logSink){
        this.logSink = logSink;
    }

    public void setLogLevel(LogLevel logLevel){
        this.logLevel = logLevel;
    }

    public void log(LogLevel logLevel, String message){
        if(logLevel.ordinal()>=this.logLevel.ordinal()){
            String logMessage = "["+new Date()+"] ["+logLevel+"] : "+message;
            logSink.log(logMessage);
        }
    }
}
