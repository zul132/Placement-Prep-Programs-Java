/* 
    Program to accept an input string and output a string that contains each character in the input followed by its count.

    Input: aaabbc
    Output: a3b2c1
*/
// Companies asked: Presidio (Interview)

import java.util.Scanner;

public class Char_Count_Pattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next(); // get the input string

        String str2 = "";
        int i = 0;
        while (i < str1.length()) {
            char x = str1.charAt(i);
            // append the current character to str2
            str2 = str2 + x;

            // calculate the count of char x in str1
            int count = 0;
            while ((i < str1.length()) && (str1.charAt(i) == x)) {
                count++;
                i++;
            }

            // append this count to str2
            str2 = str2 + count;
        }

        System.out.println(str2);
    }
}
