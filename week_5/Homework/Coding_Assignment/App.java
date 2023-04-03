package week_5.Homework.Coding_Assignment;

public class App {
    
    public static void main(String[] args) {
        
        AsteriskLogger asteriskLogger = new AsteriskLogger();
        System.out.println("AsteriskLogger:");
        asteriskLogger.log("Luna");
        asteriskLogger.error("Loki");
        
        SpacedLogger spacedLogger = new SpacedLogger();
        System.out.println("\nSpacedLogger:");
        spacedLogger.log("Lilo");
        spacedLogger.error("Stich");
    }
}
