/* 
	Given an integer num, return the number of steps to reduce it to zero.
	In one step, if the current number is even, you have to divide it by 2, otherwise, you have to subtract 1 from it.

	Example 1:
	Input: num = 14
	Output: 6
	Explanation: 
	Step 1) 14 is even; divide by 2 and obtain 7. 
	Step 2) 7 is odd; subtract 1 and obtain 6.
	Step 3) 6 is even; divide by 2 and obtain 3. 
	Step 4) 3 is odd; subtract 1 and obtain 2. 
	Step 5) 2 is even; divide by 2 and obtain 1. 
	Step 6) 1 is odd; subtract 1 and obtain 0.

	Example 2:
	Input: num = 8
	Output: 4

	Example 3:
	Input: num = 123
	Output: 12
*/
import java.util.Scanner;

class Number_Steps_to_Reduce_Number_to_Zero {
	public static int numberOfSteps(int num) {
		int count = 0;
		while (num != 0) {
			if (num % 2 == 0) {
				num = (int) num / 2;
			} else {
				num = num - 1;
			}
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		// print the number of steps required to reduce N to zero
		System.out.println(numberOfSteps(n));
	}
}