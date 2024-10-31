/* 
    Given a text and pattern, we need to return the index of the first occurance of the pattern in the string.

    NAIVE STRING MATCHING ALGO (Brute Force):
    Scan the text sequentially from left to right to find occurrences of a pattern by comparing it character by character 
    at every possible position in the text. If a mismatch is found, the pattern shifts one position forward, 
    and the process repeats until a match is found or the entire text is checked.

    Time Complexity: 
    O(n × m), where 𝑛 is the length of the text and 𝑚 is the length of the pattern.

    Constraint: Do not consider the case of words i.e. G == g in the string.

    Sample Input:
    txt = "AABAACAADAABAAABAA"
    pat = "AABA"
*/
// Companies asked: SAP Labs (Online Coding Test)

import java.util.Scanner;

public class Naive_String_Match_1 {
    static int naiveSearch(String pat, String txt) {
        int m = pat.length(); // length of pattern
        int n = txt.length(); // length of text

        // Loop to match pattern character by character
        for (int i = 0; i < n - m + 1; i++) {
            int j = 0;

            // for current index i, check for pattern match
            while (j < m) {
                if (txt.charAt(i + j) != pat.charAt(j))
                    break;
                j += 1;
            }
            // if pattern is found, return index i
            if (j == m)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Convert input strings to lowercase
        String text = sc.next().toLowerCase();
        String pattern = sc.next().toLowerCase();

        int pos = naiveSearch(pattern, text);
        if (pos != -1)
            System.out.println("Pattern found at index " + pos);
        else
            System.out.println("Pattern not found in the text!");
    }

}
