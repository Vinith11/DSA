import java.util.*;
import java.util.LinkedList;

public class _canFinishCourseI {

    public static boolean canFinish(int n, int[][] prerequisites) {
        List<Integer>[] adj = new List[n];
        int[] indegree = new int[n];

        //indegree
        for(int[] pair:prerequisites){
            int course = pair[0];
            int prerequisite = pair[1];
            if(adj[prerequisite] == null){
                adj[prerequisite] = new ArrayList<>();
            }
            adj[prerequisite].add(course);
            indegree[course]++;
        }

        //add to queue
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }

        //solve 
        int count = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            count++;

            if(adj[node] != null){
                for(int it:adj[node]){
                    indegree[it]--;
                    if(indegree[it]==0){
                        q.offer(it);
                    }
                }
            }
        }

        return count == n;
    }

    public static void main(String[] args) {
        int[][] prerequisites = {{1,0}};
        int numCources = 2;

        System.out.println(canFinish(numCources, prerequisites));
    }
}
