package week_5.Notes.Interfaces;

public class Application {

    static Logger logger;

    public static void main(String[] args) {

        Logger logger = new FileLogger();

        logger.info("This is an info message");
        logger.warning("This is a warning message");
        logger.error("This is an error message");
        logger.fatal("This is a fatal message");
        logger.close();

        setLogger(new ConsoleLogger());
        setLogger(new FileLogger());

    }

    private static void setLogger(Logger l) {
        logger = l;
    }
}
