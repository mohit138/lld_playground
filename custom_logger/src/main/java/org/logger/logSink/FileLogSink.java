package org.logger.logSink;

import java.io.FileWriter;
import java.io.PrintWriter;

public class FileLogSink implements LogSink{
    private final String filename;

    public FileLogSink(String filename){
        this.filename=filename;
    }
    @Override
    public void log(String message) {
        try{
            PrintWriter writer = new PrintWriter( new FileWriter(filename,true));
            writer.println(message);
            writer.flush();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
