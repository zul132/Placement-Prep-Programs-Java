/*
    Michael has a beautiful house. There is only one staircase to reach his bedroom. He used to climb either 
    1 stair or 2 stairs at a time. If we consider all possible combinations of climbing, 
    in how many ways can Michael reach to the top?

    Sample Input 0:
    5
    Sample Output 0:
    8

    Sample Input 1:
    22
    Sample Output 1:
    Wrong Infrastructure
*/
import java.io.*;
import java.util.*;

public class Count_Michaels_Stairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();   // no of steps in the staircase
        
        if (p > 20) {
            System.out.println("Wrong Infrastructure");
        } else {
            int count = 0;
            
            // no of ways taking 1 stair at a time
            for(int i = 0; i < p; i++)
                count++;
            
            // no of ways taking 2 or 1 stair at a time
            for(int i = 2; i < p; i += 2)
                count++;
            if (p % 2 != 0)
                count = count + 1;
            
            System.out.println(count);
        }
    }
}
