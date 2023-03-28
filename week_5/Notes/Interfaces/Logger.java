package week_5.Notes.Interfaces;

public interface Logger {

    // Interfaces are a way to define a set of methods that a class must implement.
    // Interfaces are used to achieve abstraction.

    // An interface is like a contract
    // - The class that implements the interface must implement all of the methods in the interface.

    // These are the signatures of the methods that a class must implement.
    public void info(String infoString);
    public void warning(String warningString);
    public void error(String errorString);
    public void fatal(String fatalString);
    public void close();

}
