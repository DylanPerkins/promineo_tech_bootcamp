package week_5.Homework.Coding_Assignment;

public class AsteriskLogger implements Logger{

    public void log(String str) {
        System.out.println("***" + str + "***");
    }

    public void error(String str) {
        int askCount = str.length();
        String asterisks = "*************";
        for (int i = 0; i < askCount; i++) {
            asterisks += "*";
        }
        System.out.println(asterisks);
        System.out.println("***ERROR: " + str + "***");
        System.out.println(asterisks);
    }
}

