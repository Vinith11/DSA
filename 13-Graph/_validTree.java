import java.util.*;
import java.util.LinkedList;

public class _validTree {
    //DFS
    public static boolean validTree1(int n, int[][] edges) {
        if(edges.length > n-1){
            return false;
        }

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge:edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        if(!dfs(0, -1, visited, adj)){
            return false;
        }

        return visited.size() == n;
    }

    private static boolean dfs(int node,int parent, Set<Integer> visited, List<List<Integer>> adj){
        if(visited.contains(node)){
            return false;
        }

        visited.add(node);
        for(int it:adj.get(node)){
            if(it == parent){
                continue;
            }
            if(!dfs(it, node, visited, adj)){
                return false;
            }
        }
        return true;
    }

    public static boolean validTree2(int n, int[][] edges){
        if(edges.length > n-1){
            return false;
        }

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge:edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, -1});

        visited.add(0);

        while (!q.isEmpty()) {
            int[] pair = q.poll();
            int node = pair[0], parent = pair[1];
            for(int it: adj.get(node)){
                if(it == parent){
                    continue;
                }
                if(visited.contains(it)){
                    return false;
                }
                visited.add(it);
                q.offer(new int[]{it,node});
            }
        }

        return visited.size() == n;
    }


    public static void main(String[] args) {
        int[][] edges = {{0,1},{0,2},{0,3},{1,4}};
        int n = 5;
        System.out.println(validTree2(n, edges));
    }
}
