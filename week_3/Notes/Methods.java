package week_3.Notes;

public class Methods {
    public static void main(String[] args) {
        
        String firstName = "Mike";
        String lastName = "Smith";
        String fullName = createFullName(firstName, lastName);  // Invoke method with variables
        String fullName2 = createFullName("Bob", "Ross");  // Invoke method with raw data types

        System.out.println(fullName);
        System.out.println(fullName2);

    }

    // This is a method siganture.
    // String represents the data return type
    // Not all methods need to have a return, you'd use 'void' in this case
    // Next is the name of the method, can be used similarly to a variable
    // Good idea to have the name be a verb, and be a good description of what it does
    // Lastly, is the parameters, the things within the ()
    // Here we define x and y, with their data 
    
    // A method is basically just instructions, needs to be called or invoked before it does anything

    public static String createFullName(String x, String y) {
        return x + " " + y;
    }
}
