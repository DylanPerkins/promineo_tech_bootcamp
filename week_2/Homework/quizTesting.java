package week_2.Homework;

public class quizTesting {
    public static void main(String[] args) {
        
        double moneyInWallet = 4.50;

        double costOfMilk = 1.99;
      
        if (moneyInWallet >= costOfMilk * 2) {
      
          System.out.println("Let's buy two gallons.");
      
        } else if (moneyInWallet >= costOfMilk) {
      
          System.out.println("Let's buy one gallon.");
      
        } else {
      
          System.out.println("Way too expensive!");
      
        }
      
      
    }
}
