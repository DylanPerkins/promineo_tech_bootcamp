package week_3.Notes;

public class MoreMethods {
    public static void main(String[] args) {
        
        int[] dataSetOne = new int[3];
        dataSetOne[0] = 9;
        dataSetOne[1] = 3;
        dataSetOne[2] = 7;

        System.out.println(sumIntArray(dataSetOne));

        String[] dataSetTwo = new String[3];
        dataSetTwo[0] = "My";
        dataSetTwo[1] = "Goodbye";
        dataSetTwo[2] = "Hello";

        System.out.println(sumStringArray(dataSetTwo));

        double[] dataSetThree = new double[5];
        dataSetThree[0] = 99.37;
        dataSetThree[1] = 87.90;
        dataSetThree[2] = 77.50;
        dataSetThree[3] = 81.75;
        dataSetThree[4] = 92.81;

        System.out.println(calculateAverage(dataSetThree));

        System.out.println(multiplyString("Hello", 5));
    }

    public static int sumIntArray(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    public static String sumStringArray(String[] names) {
        String sum = "";
        for (String name : names) {
            sum += (name + " ");
        }
        return sum;
    }

    public static double calculateAverage(double[] numbers) {
        double sum = 0;
        for (double number : numbers) {
            sum += number;
        }
        return sum / numbers.length;
    }

    public static String multiplyString(String str, int num) {
        String result = "";
        for (int i = 0; i < num; i++) {
            result += str;
        }
        return result;
    }
}
