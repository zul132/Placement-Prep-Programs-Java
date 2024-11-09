/* 
    Program to check whether a given string is palidrome or not.

    Input 0: malayalam
    Output 0: Palindrome

    Input 1: madam
    Output 1: Palindrome

    Input 2: music
    Output 2: Not a Palindrome
*/
// Companies asked: SAP Labs (Coding Round)

import java.util.Scanner;

public class Palindrome_String {
    static boolean isPalindrome(String input) {
        // Find the reverse of the input string
        String rev = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            rev = rev + input.charAt(i);
        }

        if (input.equals(rev))
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next().toLowerCase();

        if (isPalindrome(str)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a Palindrome");
        }
    }
}
