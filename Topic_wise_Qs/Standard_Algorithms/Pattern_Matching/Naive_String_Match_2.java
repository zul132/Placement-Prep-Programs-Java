/* 
    Given a text and pattern, we need to find all occurances of the pattern in the string.

    Sample Input:
    txt = "AABAACAADAABAAABAA"
    pat = "AABA"
*/
// Companies asked: SAP Labs (Coding Round)

import java.util.Scanner;

public class Naive_String_Match_2 {
    static void naiveSearch(String pat, String txt) {
        int m = pat.length(); // length of pattern
        int n = txt.length(); // length of text

        // Loop to match pattern character by character
        int flag = 0;
        for (int i = 0; i < n - m + 1; i++) {
            int j = 0;

            // for current index i, check for pattern match
            while (j < m) {
                if (txt.charAt(i + j) != pat.charAt(j))
                    break;
                j += 1;
            }

            // If pattern in found, print i
            if (j == m) {
                System.out.println("Pattern found at index " + i);
                flag = 1;
            }
        }

        // Pattern not found even once
        if (flag == 0)
            System.out.println("Pattern not found in the text!");
    }

    public static void main(String[] args) {
        // Driver code to test the program
        String text = "AABAACAADAABAAABAA";
        String pattern = "AABA";
        naiveSearch(pattern, text);
    }
}
