import java.util.ArrayList;

public class _DFS {

    public static void dfsTraverse(ArrayList<ArrayList<Integer>> adj,boolean[] visited,ArrayList<Integer> dfsResult, int node){

        visited[node] = true;
        dfsResult.add(node);

        for(int i=0; i<adj.get(node).size(); i++){
            if(!visited[adj.get(node).get(i)]){
                dfsTraverse(adj, visited, dfsResult, adj.get(node).get(i));
            }
        }
    }

    public static ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
        ArrayList<Integer> dfsResult = new ArrayList<>();

        dfsTraverse(adj, visited, dfsResult, 0);

        return dfsResult;
    }


    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(3);
        adj.get(2).add(4);

        ArrayList<Integer> result = dfsOfGraph(adj);

        System.out.println("Breadth First Traversal: " + result);
    }
}
