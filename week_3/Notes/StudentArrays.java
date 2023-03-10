package week_3.Notes;

// Notes about arrays at the bottom!

public interface StudentArrays {
    public static void main(String[] args) {

        // Slow, repetative and boring
        String studentName1 = "Tom Sawyer";
        String studentName2 = "Mike Smith";
        String studentName3 = "John Brown";

        System.out.println(studentName1);
        System.out.println(studentName2);
        System.out.println(studentName3);

        // An array is an object, not a primative data type
        // An array is not dynamic, cannot grow or shrink
        String[] students = new String[3];

        // Index based, this example goes from 0-2.
        students[0] = "Tom Sawyer";
        students[1] = "Mike Smith";
        students[2] = "John Brown";

        System.out.println(students[0]);
        System.out.println(students[1]);
        System.out.println(students[2]);

        // Iterates through the array, printing each element
        System.out.println("Start of basic for loop:");
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }

        // Enchanced for loop, will iterate for each element in an array
        // For each student in students do ...
        // : represents "in"
        System.out.println("Start of enchanced for loop:");
        for (String student : students) {
            System.out.println(student);
        }
    }
}




/* Useful ARRAY vocabulary and information:
 * Square Brackets, or [], tell Java that we are declaring or calling an array.
 * Element: Each item that is stored in an array. Must all be the SAME data type.
 * Index: Each element in an array can be accessed by its numerical index. Indexing always starts at 0
 * 
 * The first element in an array is located at index: 0
 * The last element in an array is located at index: arrayName.length() - 1.
 * 
 * An array must be declared. It must have a data type, a variable name, and an array size.
 * 
 * All three of these examples declare the same data type, name, and size, but in different ways:
 * Ex. 1 - int[] gradesArray = new int[5]
 * 
 * Ex. 2 - int[] gradesArray;
 *         gradesArray = new int[5];
 * 
 * Ex. 3 - int[] gradesArray = {100, 79, 80, 90, 100}
 * 
 */