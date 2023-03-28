package week_5.Notes.Interfaces;

import java.util.Date;

public class ConsoleLogger implements Logger{

    @Override
    public void info(String infoString) {
        Date date = new Date();
        System.out.println("INFO: " + infoString + " at " + date);
    }

    @Override
    public void warning(String warningString) {
        Date date = new Date();
        System.out.println("WARNING: " + warningString + " at " + date);
    }

    @Override
    public void error(String errorString) {
        Date date = new Date();
        System.err.println("ERROR: " + errorString + " at " + date);
    }

    @Override
    public void fatal(String fatalString) {
        Date date = new Date();
        System.err.println("FATAL: " + fatalString.toUpperCase() + " at " + date);
    }

    @Override
    public void close() {
        System.out.println("Closing the logger");
    }
    
}
