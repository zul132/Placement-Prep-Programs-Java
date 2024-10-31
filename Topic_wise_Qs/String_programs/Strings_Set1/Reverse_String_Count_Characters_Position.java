/* 
    Reverse the string and find the number of characters that didn’t change their position.

    Example:
    Geeta after reversing would be ateeg. Here second ‘e’ at index 2 didn’t change its position.
    So the output is 1.

    Input 0: alphxxdida
    Output 0: Reverse is adidxxhpla => 4

    Input 1: pool
    Output 1: Reverse is loop => 2
*/
/* Time Complexity: O(n),
                    where n is the length of the string
*/     
// Companies asked: SAP Labs (Online Coding Test)

import java.util.Scanner;

public class Reverse_String_Count_Characters_Position {
    static int countSamePositionChars(String input) {
        // First find the reverse of the input string using StringBuilder method
        StringBuilder reversed = new StringBuilder(input);
        reversed.reverse();

        /*
         * Now iterate through both the strings and compare input[i] with reversed[i].
         * Increment a counter for each time they are equal.
         */
        int count = 0;
        for(int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == reversed.charAt(i))
                count++;    // increment count if the characters at i are the same
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int result = countSamePositionChars(str);
        System.out.println(result);
    }
}
