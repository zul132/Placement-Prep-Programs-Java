/*  
    Write a program to check whether the given strings are anagram or not. An anagram is a word or phrase formed by rearranging the letters
    of a different word or phrase, typically using all the original letters exactly once.

    Input Format:
    INTEGRAL
    TRIANGLE
    Output Format:
    It is an anagram

    Sample Input 0:
    xyzab
    axyzh
    Sample Output 0:
    It is not an anagram
*/
import java.util.Scanner;

public class Anagram {
    static boolean isAnagram(String s1, String s2) {
        // Check if the lengths of the two strings are equal
        if (s1.length() != s2.length())
            return false;
        else { 
            int hash[] = new int[26];
            for (int i = 0; i < s1.length(); i++) {
                hash[s1.charAt(i) - 97]++;
                hash[s2.charAt(i) - 97]--;
            }
            for (int i = 0; i < 26; i++)
                if (hash[i] != 0)
                    return false;
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input1 = sc.next();
        String input2 = sc.next();

        // Convert the input strings to Lowercase
        input1 = input1.toLowerCase();
        input2 = input2.toLowerCase();

        if (isAnagram(input1, input2))
            System.out.println("It is an anagram");
        else
            System.out.println("It is not an anagram");
        sc.close();
    }
}