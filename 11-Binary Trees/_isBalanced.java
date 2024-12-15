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

public class _isBalanced {

    public static boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        if (Height(root) == -1) {
            return false;
        }

        return true;
    }

    public static int Height(TreeNode root) {
        if (root == null)
            return 0;

        int leftHeight = Height(root.left);
        int rightHeight = Height(root.right);

        if (leftHeight == -1 || rightHeight == -1) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        // Example: Create a sample tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));

        // System.out.println("Max Depth with DFS: " + maxDepth1(root));
        System.out.println("Is Balanced: " + isBalanced(root));

    }
}
