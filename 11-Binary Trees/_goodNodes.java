
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


public class _goodNodes {
    
    static int count = 0;
    public static int goodNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        dfs(root, root.val);

        return count;
    }

    public static void dfs(TreeNode root, int curMax){
        if(root == null){
            return;
        }

        if(root.val >= curMax){
            count++;
            curMax = root.val;
        }

        dfs(root.left, curMax);
        dfs(root.right, curMax);
    }

    public static void main(String[] args) {

        // Example: Create a sample tree
        TreeNode p = new TreeNode(3);
        p.left = new TreeNode(1, new TreeNode(3), null);
        p.right = new TreeNode(4, new TreeNode(1), new TreeNode(5));


        System.out.println("No. of good nodes " + goodNodes(p));

    }
}
