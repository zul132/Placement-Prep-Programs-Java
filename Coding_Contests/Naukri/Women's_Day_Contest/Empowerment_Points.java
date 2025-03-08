/* 
    Problem Statement:
    In a university, a special Women's Day event is being planned, where participants can gain Empowerment Points (EP) 
    through different activities. There are three types of activities:
        - Workshops, which grant 3 EP each.
        - Networking Sessions, which grant 5 EP each.
        - Leadership Talks, which grant 10 EP each.
    
    Given a total target EP value, determine the number of distinct ways participants can achieve exactly that score 
    using these activities. The order of activities does not matter.

    Input Format:
    The first line contains an integer n denoting the size of the array(arr) whose each indices contain the 
    Empowerment Points (EP) required. The next n lines each contain a single integer each.
    
    Constraints:
    1<=n<=100
    1<=arr[i]<=1000

    Output Format:
    Return an array representing the output for each indices of the input array.
    
    Sample Input 1:
    3
    8
    20
    13
    Sample Output 1:
    1
    4
    2

    Explanation:
    1st array element= 8:
    {3, 5} and {5, 3} are the same combination. Hence, the output is 1.

    2nd array element= 20:
    {5,5,5,5}, {10,5,5}, {10,10}, and {3,3,3,3,3,5} are possible valid combinations. Output: 4.

    3rd array element= 13:
    {10,3} and {5,5,3} are valid combinations. Output: 2.
*/

public class Empowerment_Points {

}
