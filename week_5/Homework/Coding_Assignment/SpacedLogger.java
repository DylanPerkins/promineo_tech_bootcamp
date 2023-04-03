package week_5.Homework.Coding_Assignment;

public class SpacedLogger implements Logger{
    
    public void log(String str){
        String spaced = "";
        for (int i = 0; i < str.length(); i++) {
            spaced += str.charAt(i) + " ";
        }
        System.out.println(spaced);
    }

    public void error(String str){
        String spaced = "";
        for (int i = 0; i < str.length(); i++) {
            spaced += str.charAt(i) + " ";
        }
        System.out.println("ERROR: " + spaced);
    }

}
