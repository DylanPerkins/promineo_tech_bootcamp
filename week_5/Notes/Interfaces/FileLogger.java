package week_5.Notes.Interfaces;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class FileLogger implements Logger {

    private BufferedWriter writer;

    public FileLogger() {
        try {
            writer = new BufferedWriter(new FileWriter("logs.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void info(String infoString) {
        Date date = new Date();
        try {
            writer.append("INFO: " + infoString + " at " + date);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void warning(String warningString) {
        Date date = new Date();
        try {
            writer.append("WARNING: " + warningString + " at " + date);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void error(String errorString) {
        Date date = new Date();
        try {
            writer.append("ERROR: " + errorString + " at " + date);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void fatal(String fatalString) {
        Date date = new Date();
        try {
            writer.append("FATAL: " + fatalString + " at " + date);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
