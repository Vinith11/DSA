import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class _zigzagLevelOrder {

     public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if(root == null){
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int size = queue.size();

            for(int i=0; i<size; i++){
                TreeNode current = queue.poll();

                temp.add(current.val);

                if(current.left != null){
                    queue.offer(current.left);
                }

                if(current.right != null){
                    queue.offer(current.right);
                }
            }

            ans.add(temp);
        }

        for(int i=1; i<ans.size(); i+=2){
            Collections.reverse(ans.get(i));
        }

        return ans;
     }

    public static void main(String[] args) {

        // Example: Create a sample tree
        TreeNode p = new TreeNode(3);
        p.left = new TreeNode(9);
        p.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));


        // System.out.println("Max Depth with DFS: " + maxDepth1(root));
        System.out.println("Is is a sub Tree: " + zigzagLevelOrder(p));

    }
    
}
