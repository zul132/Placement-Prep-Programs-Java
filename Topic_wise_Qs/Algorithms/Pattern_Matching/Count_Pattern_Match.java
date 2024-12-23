/* 
    Matt is a commander is the army. He gets secret information that a terrorist is planning an attack. The secret 
    info includes a text and the terrorist's name. Matt is told that the number of terrorists is specified by 
    the number of times the terrorist's name appears in the text. 
    Given the text and the terrorist's name, find the number of terrorists. 

    Note: It is case insensitive i.e. Tim = tim. Overlapping of the name in the text is possible.
    
    Sample Input 0: text = TimcookeswithTimatTims
                    name = Tim
    Sample Output 0: 3

    Sample Input 1: text = aamamam
                    name = amam

*/
// Companies asked: SAP Labs (Coding Round)

import java.util.Scanner;

public class Count_Pattern_Match {
    static int secretinfo(String name, String text) {
        int answer = 0;
        int m = name.length(); // length of pattern
        int n = text.length(); // length of text

        // Loop to match name in the text
        for (int i = 0; i < n - m + 1; i++) {
            int j = 0;

            // for current index i, check for pattern match
            while (j < m) {
                if (text.charAt(i + j) != name.charAt(j))
                    break;
                j += 1;
            }

            // If pattern in found, print i
            if (j == m) {
                answer += 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Convert input strings to lowercase
        String text = sc.next().toLowerCase();
        String name = sc.next().toLowerCase();

        int result = secretinfo(name, text);
        System.out.println(result);
    }
}
