/* 
    A company wants to provide cab service for its N employees. Employees have IDs ranging from 0...N-1. Given array of the distances 
    of each employee's house from the company, where the distance for employees who live on the left side of the company 
    is marked by negative sign, and the distance for employees who live on the right side of the company is marked by positive sign. 
    The company is alloted a distance range for its cab. 
    Give the start distance and end distance, write a program to find the distances of the employees who live within the distance range.

    Sample Input: distances = [-10, -5, 3, 8, -2]
                  start_distance = -5
                  end_distance = 5
    Sample Output: [-5, 3, -2]
*/
// Companies asked: SAP Labs (coding round)

import java.util.Scanner;

public class Company_Cab_Distance_Range {
    static int[] findDistancesInRange(int[] inputDist, int start, int end) {
        int answer[] = new int[100];

        int i = 1; // counter for result distances
        for (int distance : inputDist) {
            if (distance >= start && distance <= end) {
                answer[i] = distance;
                i++;
            }
        }
        answer[0] = i; // indicates the number of distances in the result

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // no of employees

        // Array to store distances of each employee's house from the company
        int[] inputDist = new int[n];
        for (int i = 0; i < n; i++) {
            inputDist[i] = sc.nextInt();
        }

        // Input for the start and end distance range
        int start = sc.nextInt();
        int end = sc.nextInt();

        System.out.println();
        int result[] = findDistancesInRange(inputDist, start, end);
        for (int i = 1; i < result[0]; i++)
            System.out.print(result[i] + " ");
        System.out.println();
    }

}
