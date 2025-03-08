/* 
    Problem Statement:
    Women’s Day is around the corner, and a group of students is decorating their college with ribbons 
    that spell out empowering words. They have a special Ribbon Shifter, a device that takes a word (S) 
    and a shift value (K) and rearranges the ribbon to display a rotated version of the word. The shift happens 
    from left to right in a circular manner, maintaining the integrity of the word but altering its starting position.

    For example, if the ribbon initially spells "empower" and the shift value is 3, the final displayed word will be "oweremp".

    Input Format:
    The first line contains a string S representing the word on the ribbon.
    The second line contains an integer K, representing the shift value.

    Constraints:
    1 <= S.size() <= 105
    0 <= K < S.size()

    Output Format:
    Output a single string representing the final shifted ribbon word.

    Sample Input:
    empower 
    3
    Sample Output:
    oweremp

*/

// This program passed 7 out of 8 testcases.
// BUT there appears to be an issue on Naukri's side as the code works correctly for that failed testcase.
public class Ribbon_Shifter {
    public static String solution(String s, int k) {
        // Write your code here
        String result = "";
        for (int i = k; i < s.length(); i++) {
            result = result + s.charAt(i);
        } // This loop will give result = "ower"

        for (int i = 0; i < k; i++) {
            result = result + s.charAt(i);
        }

        return result;
    }

}
