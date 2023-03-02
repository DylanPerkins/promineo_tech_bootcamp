package promineo_tech_bootcamp.week_2.Notes;

public class booleanOps {   
    public static void main(String[] args) {
        // == is 'equality'
        System.out.println(2 == 2); // true
        System.out.println(5 == 5); // true
        System.out.println(3 == 9); // flase
        // > is 'greater than'
        System.out.println(2 > 5); // false
        System.out.println(5 > 1); // true
        System.out.println(9 > 462); // false
        // < is 'less than'
        System.out.println(1 < 9); // true
        System.out.println(75 < 12); // false
        System.out.println(69 < 420); // true
        // >= 'greater than or eqaul to'
        System.out.println(27 >= 17); // true
        System.out.println(19 >= 19); // true
        System.out.println(10 >= 19); // false
        // <= 'less than or equal to'
        System.out.println(3 <= 5); // true
        System.out.println(5 <= 5); // true
        System.out.println(16 <= 2); // false
        // && is 'and'
        System.out.println(2 == 2 && 1 < 5); // true
        System.out.println(true && true); // true
        System.out.println(true && false); // false
        System.out.println(2 == 2 && 1 == 5); // false
        // || is 'or'
        System.out.println(true || false); // true
        System.out.println(false || false); // false
        System.out.println(2 == 2 || 1 == 5); // true
    }
    
}