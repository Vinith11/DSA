import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _connectedcomponents {

    private static void dfs(int node, List<List<Integer>> adj, List<Integer> temp, boolean[] visited) {
        visited[node] = true;
        temp.add(node);

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, temp, visited);
            }
        }

    }

    public static List<List<Integer>> connectedcomponents(int v, List<int[]> edges) {

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[v];

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                List<Integer> temp = new ArrayList<>();
                dfs(i, adj, temp, visited);
                Collections.sort(temp);
                ans.add(temp);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int v = 5; // Number of vertices
        List<int[]> edges = Arrays.asList(
                new int[] { 0, 1 },
                new int[] { 1, 2 },
                new int[] { 3, 4 });

        List<List<Integer>> result = connectedcomponents(v, edges);

        // Print the result
        for (List<Integer> component : result) {
            System.out.println(component);
        }
    }
}