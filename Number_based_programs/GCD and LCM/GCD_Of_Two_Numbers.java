//Non-recursive method to find GCD of two numbers
import java.util.Scanner;

class GCD_Of_Two_Numbers {
    public static int GCD(int a, int b)
    {
        if (a < b){
            int t = a;
            a = b;
            b = t;
        }
        int r;
        while (b != 0)
        {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        System.out.println(GCD(A,B));
    }
}