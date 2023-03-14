package week_3.Notes;

public class IntMethods {
    public static void main(String[] args) {
        
        int firstNumber = 683;
        int secondNumber = 5940;

        int result = sumOfTwoSums(firstNumber, secondNumber);
        System.out.println(result);

    }

    public static int sumOfTwoSums(int x, int y) {
        return x + y;
    }
}
