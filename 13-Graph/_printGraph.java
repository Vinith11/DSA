import java.util.ArrayList;
import java.util.List;

public class _printGraph {

    public static List<List<Integer>> printGraph(int V, int edges[][]) {
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0; i<V; i++){
            ans.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            ans.get(edge[0]).add(edge[1]);
            ans.get(edge[1]).add(edge[0]);
        }

        return ans;
    }

    public static void main(String[] args) {
        int v = 5; // Number of vertices
        int[][] edges = {
            {0, 1},
            {1, 2},
            {2, 4},
            {3, 4}
        };

        List<List<Integer>> result = printGraph(v, edges);

        // Print the result
        for (List<Integer> component : result) {
            System.out.println(component);
        }
    }
}
