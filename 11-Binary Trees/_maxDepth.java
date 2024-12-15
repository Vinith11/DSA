import java.util.LinkedList;
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



public class _maxDepth {

    // Method to print the tree (Level-order traversal)
    public static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.val + " ");

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }
        System.out.println();
    }

    /*
     * DFS metodh 
     */
    public static int maxDepth1(TreeNode root) {
        if(root == null){
            return 0;
        }

        return 1 + Math.max(maxDepth1(root.left), maxDepth1(root.right));        
    }

    /*
     * BFS method
     */
    public static int maxDepth2(TreeNode root) {
        if(root == null){
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;

        while(!queue.isEmpty()){
            depth++;
            int levelSize = queue.size();

            for(int i=0; i < levelSize; i++){
                TreeNode node = queue.poll();

                if(node.left != null){
                    queue.add(node.left);
                }
                
                if(node.right != null){
                    queue.add(node.right);
                }
            }
        }

        return depth;        
    }

    public static void main(String[] args) {
        // Example: Create a sample tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));

        System.out.println("Original Tree:");
        printTree(root);

        // System.out.println("Max Depth with DFS: " + maxDepth1(root));
        System.out.println("Max Depth with BFS: " + maxDepth2(root));

    }
    
}
