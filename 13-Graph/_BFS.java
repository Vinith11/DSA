import java.util.*;


public class _BFS {
    
    public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        //Result and visited array
        ArrayList<Integer> bfsResult = new ArrayList<>();
        boolean[] visited = new boolean[V];

        //Queue to hold nodes
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0]=true;

        while(!queue.isEmpty()){
            int node = queue.poll();
            bfsResult.add(node);

            for(int neighbour: adj.get(node)){
                if(!visited[neighbour]){
                    queue.offer(neighbour);
                    visited[neighbour]=true;
                }
            }
        }
        

        return bfsResult;
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

        ArrayList<Integer> result = bfsOfGraph(V, adj);

        System.out.println("Breadth First Traversal: " + result);
    }
}
