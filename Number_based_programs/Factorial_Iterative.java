/* Iterative program find out the factorial of a number.
   Input: 6
   Output: 720
 */

public class Factorial_Iterative {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        System.out.println(fact);
    }
}
