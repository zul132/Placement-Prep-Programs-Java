/* 
    PROBLEM STATEMENT:
    You are a tour guide in a city represented as an undirected graph. The graph's vertices represent locations and 
    its edges represent roads between these locations. Your goal is to plan a tour that starts and ends at the same location, 
    traveling each road exactly once. If such a tour is possible, output the tour path. Otherwise, output "None". 
    If multiple tours are possible, choose the lexicographically smallest path.
    
    Input Format:
    - The first line contains an integer n representing the number of locations (vertices) in the city.
    - The second line contains an integer representing the number of roads (edges).
    - The third line contains an integer 2, indicating that each edge is represented by two vertices.
    -  The next n lines each contain two integers u and v representing a road between locations u and v

    Output Format:
        • If a tour is possible, return a string of the tour path as a sequence of vertex indices separated by spaces.
        • If no tour is possible, return the string "None".
    
    Sample Input:
    3
    3
    2
    1 2
    2 3
    3 1

    Sample Output:
    1 2 3 1

    Explanation:
    A valid tour path is 1->2->3->1. Thereby traversing through all the edges exactly once and returning to the starting vertex.

*/

/* 
    Note: This solution only passed 8 out of 9 test cases on Naukri CodeQuezt #14. 

    Refer to the Approach and Code Explanation provided after the program.
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class Tour_Route {
    /*
     * Complete the 'tour_route' function below.
     * 
     * The function is expected to return an STRING.
     * The function accepts following parameters:
     * 1. INTEGER n
     * 2. INTEGER 2D ARRAY edges
     */

    public static String tour_route(int n, List<List<Integer>> edges) {
        // Write your code here
        Map<Integer, PriorityQueue<Integer>> graph = new HashMap<>();
        List<Integer> tourPath = new ArrayList<>();

        /*
         * Adjacency list with Priority Queue for selecting the Lexicographically
         * smallest edge first
         */
        for (int i = 1; i <= n; i++) {
            graph.put(i, new PriorityQueue<>());
        }

        // Build the city graph
        for (List<Integer> edge : edges) {
            // Each edge contains two integers u and v representing a road between locations
            // u and v.
            int u = edge.get(0);
            int v = edge.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // Check if valid tour path exists
        if (!isTourPath(graph, n)) {
            return "None";
        }

        findTourPath(graph, tourPath, 1);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < tourPath.size(); i++) {
            if (i > 0)
                result.append(" ");
            result.append(tourPath.get(i));
        }

        return result.toString();
    }

    public static void findTourPath(Map<Integer, PriorityQueue<Integer>> graph, List<Integer> tourPath, int start) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int u = stack.peek();
            if (graph.get(u).isEmpty()) {
                tourPath.add(u);
                stack.pop();
            } else {
                int v = graph.get(u).poll();
                graph.get(v).remove(u); // Remove the reverse edge
                stack.push(v);
            }
        }
        Collections.reverse(tourPath);
    }

    public static boolean isTourPath(Map<Integer, PriorityQueue<Integer>> graph, int n) {
        // Check if all vertices have even degree and graph is connected
        for (int i = 1; i <= n; i++) {
            if (graph.get(i).size() % 2 != 0)
                return false; // Odd degree vertex
        }

        // Check graph connectivity using DFS
        return isConnected(graph, n);
    }

    public static boolean isConnected(Map<Integer, PriorityQueue<Integer>> graph, int n) {
        boolean[] visited = new boolean[n + 1];
        int startVertex = -1;

        // Find a vertex with edges
        for (int i = 1; i <= n; i++) {
            if (!graph.get(i).isEmpty()) {
                startVertex = i;
                break;
            }
        }

        if (startVertex == -1)
            return true; // No edges, graph is trivially connected

        dfs(graph, startVertex, visited);

        // Verify all vertices with edges are visited
        for (int i = 1; i <= n; i++) {
            if (!graph.get(i).isEmpty() && !visited[i])
                return false;
        }
        return true;
    }

    public static void dfs(Map<Integer, PriorityQueue<Integer>> graph, int u, boolean[] visited) {
        visited[u] = true;
        for (int v : graph.get(u)) {
            if (!visited[v])
                dfs(graph, v, visited);
        }
    }

}

/* 
    APPROACH:
    The given problem is essentially an Eulerian Circuit problem, where:
    
    Eulerian Circuit exists if:
        • All vertices with edges have an even degree.
        • All edges belong to a single connected component.

    Explanation
    1. Graph Initialization:
        • The input edges is processed into an adjacency list (PriorityQueue to ensure lexicographically smallest traversal).
    
    2. Eulerian Circuit Check:
        • Ensures all vertices with edges have an even degree.
        • Verifies graph connectivity using DFS.

    3. Finding the Eulerian Circuit:
        • Uses Hierholzer's Algorithm to build the path while traversing edges.
    
    4. Output:
        • If an Eulerian Circuit exists, the path is returned as a space-separated string.
        • If not, "None" is returned.
*/
