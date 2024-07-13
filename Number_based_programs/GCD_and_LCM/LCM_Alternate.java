/* Another efficient Approach to find the LCM of two numbers Using conditional for loop */
//Time complexity: O(min(a,b))
//Auxiliary Space: O(1)

import java.util.Scanner;

public class LCM_Alternate {

    static int LCM(int a, int b) {
        int greater = Math.max(a, b);
        int smaller = Math.min(a, b);

        for (int i = greater;; i += greater) {
            if (i % smaller == 0)
                return i;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        System.out.println(LCM(A, B));
        sc.close();
    }
}
