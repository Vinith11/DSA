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



public class _isSameTree {

    public static boolean isSameTree(TreeNode p, TreeNode q) {

        if( p == null && q == null){
            return true;
        }

        if(p != null && q != null && p.val == q.val){
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        
        return false;
    }


    
    public static void main(String[] args) {
        // Example: Create a sample tree
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        // System.out.println("Max Depth with DFS: " + maxDepth1(root));
        System.out.println("Is Same Tree: " + isSameTree(p,q));

    }
    
}
