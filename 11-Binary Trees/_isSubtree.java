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

public class _isSubtree {

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (root == null) {
            return false;
        }

        if (root.val == subRoot.val) {
            if (isIdentical(root, subRoot)) {
                return true;
            }
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static boolean isIdentical(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        } else if (root == null || subRoot == null || root.val != subRoot.val) {
            return false;
        }

        return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
    }

    public static void main(String[] args) {

        // Example: Create a sample tree
        TreeNode p = new TreeNode(3);
        p.left = new TreeNode(4, new TreeNode(1), new TreeNode(2));
        p.right = new TreeNode(5);

        TreeNode q = new TreeNode(4);
        q.left = new TreeNode(1);
        q.right = new TreeNode(5);

        // System.out.println("Max Depth with DFS: " + maxDepth1(root));
        System.out.println("Is is a sub Tree: " + isSubtree(p, q));

    }

}
