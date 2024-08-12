/*
    Consider the below series : 0, 0, 2, 1, 4, 2, 6, 3, 8, 4, 10, 5, 12, 6, 14, 7, 16, 8 This series is a mixture of 
    2 series - all the odd terms in this series form even numbers in ascending order and every even terms is 
    derived from the previous term using the formula (x/2)

    Sample Input:
    10
    Sample Output:
    4
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Find_nth_term_1 {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        // if n is odd, then its value is n-1
        if (n % 2 != 0){   
            System.out.println(n-1);
        }
        // if n is even, it's value is half of the prev no, which is n-2 
        else{
            System.out.println((n-2)/2);
        }
    }
}