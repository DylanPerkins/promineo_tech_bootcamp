package week_4.Notes;

public class StringAndStringBuilder {
    public static void main(String[] args) {
        
        String firstName = "Dylan";
        String lastName = "Perkins";
        String fullName = firstName + " " + lastName;
        System.out.println(fullName);

        String tripleHi = multiplyString("Hi", 3); 
        System.out.println(tripleHi); // HiHiHi
        String tripleHi2 = multiplyStringBuilder("Hi", 3);
        System.out.println(tripleHi2); // HiHiHi

        // String is immutable, so it cannot be changed unless it is reassigned
        System.out.println(firstName.concat(lastName)); // DylanPerkins
        System.out.println(firstName); // Dylan

        // StringBuilder is mutable, so it can be changed
        StringBuilder sb = new StringBuilder("Heidi");
        sb.append(" Zelayandia");
        System.out.println(sb.toString()); 

        System.out.println(sb.charAt(3)); // d
        System.out.println(sb.indexOf("Z")); // 6
        System.out.println(sb.substring(0, 4)); // Heidi
        System.out.println(sb.substring(6)); // Zelayandia
        System.out.println(sb.length()); // 16
        System.out.println(sb.reverse()); // aidnayaleZ idieH
        System.out.println(sb.reverse()); // Heidi Zelayandia
        System.out.println(sb.delete(0, 6)); // Zelayandia
        System.out.println(sb.insert(0, "Heidi")); // HeidiZelayandia
        System.out.println(sb.replace(0, 5, "Dylan")); // DylanZelayandia
        System.out.println(sb.toString()); // DylanZelayandia
    }

    public static String multiplyString(String str, int num) {
        String result = "";
        for (int i = 0; i < num; i++) {
            result += str;
        }
        return result;
    }

    public static String multiplyStringBuilder(String str, int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}