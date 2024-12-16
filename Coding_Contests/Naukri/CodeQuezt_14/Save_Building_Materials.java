/* 
    Problem Statement
    Cynthia, a skilled architect, has been working on designing a new set of buildings for her city. She has distributed construction 
    materials between several construction sites, each represented by a row of storage containers. The containers are arranged in a 
    straight line, each containing a certain amount of building materials in kilograms.
    However, an unexpected storm has hit the city, and Cynthia must protect as many materials as possible from getting soaked in the rain. 
    
    To do this, she can move the lids between containers as follows: if the i-th container was covered with a lid initially, she can 
    either move the lid from the i-th container to the container (i-1) (if it exists), or keep the lid on the i-th container. 
    Containers with lids will keep the materials inside dry, while uncovered containers risk getting soaked.
    
    Your task is to calculate the maximum Kilograms of building materials Cynthia can save from the rain by strategically 
    rearranging the lids between the containers.
    
    Input Format:
    - The first line of input format contains a single integer N denoting the number of containers
    - The next N lines contain integers a1, a2,...,aN, where ai is the Kilograms of building materials in Container i.
    - The last input is a String of N characters either '1' or '0', where '1' indicates that the the Container is covered with a lid,
      while '0' indicates that the container is uncovered.

    Output Format:
        • Print the maximum Kilograms of building materials Cynthia can save from the storm.
*/

/* 
    Note: This solution only passed 2 out of 4 test cases on Naukri CodeQuezt #14. 
*/

import java.util.*;

public class Save_Building_Materials {
    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // no of containers

        int containers[] = new int[n];
        for (int i = 0; i < n; i++) {
            containers[i] = sc.nextInt(); // building materials in Kilograms in the i-th container
        }

        // String to indicate whether containers are covered with a lid or not
        String lids = sc.next();

        StringBuilder res = new StringBuilder(lids);

        /*
         * Start the loop from the 2nd container. If the 1st (i = 0) container is
         * covered initially, we do not have the option of moving its lid to the
         * container (i-1 = -1)
         */
        for (int i = 1; i < n; i++) {
            // check if container i is covered with a lid
            if ((lids.charAt(i) == '1')) {
                // check if the Kilograms of building material at the prev container is greater
                // and uncovered
                if ((containers[i - 1] > containers[i]) && (lids.charAt(i - 1) == '0')) {
                    // move the lid from container (i) to container (i -1)
                    res.setCharAt(i, '0');
                    res.setCharAt(i - 1, '1');
                }

            }
        }

        // compute the maximum Kilograms of building materials Cynthia can save from the
        // storm.
        int maxSum = 0;
        for (int i = 0; i < n; i++) {
            if (res.charAt(i) == '1')
                maxSum += containers[i];
        }

        System.out.println(maxSum);
    }

}
