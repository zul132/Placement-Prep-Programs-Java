/* 
    Write a program to find out the longest word in a sentence.

    Sample Input 0:
    what are you doing
    Sample Output 0:
    doing

    Sample Input 1:
    where are you
    Sample Output 1:
    where
*/

import java.io.*;
import java.util.*;

public class Longest_Words_in_Sentence {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        String max = "", word = "";
        int i = 0;
        while (i < line.length()) {
            if (line.charAt(i) == ' ') {
                if (word.length() > max.length())
                    max = word;
                word = "";
            } else {
                word = word + line.charAt(i);
            }
            i++;
        }
        // Check the last word
        if (word.length() > max.length())
            max = word;
        System.out.println(max);
    }
}
