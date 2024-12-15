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

public class _diameterOfBinaryTree {
    private int res = 0; // Make this an instance variable

    // Method to calculate diameter
    public int diameterOfBinaryTree(TreeNode root) {
        calculateHeight(root);
        return res;
    }

    // Helper method to calculate height and update diameter
    private int calculateHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int l = calculateHeight(root.left);
        int r = calculateHeight(root.right);

        res = Math.max(res, l + r); // Update diameter

        return 1 + Math.max(l, r);
    }

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

    public static void main(String[] args) {
        _diameterOfBinaryTree tree = new _diameterOfBinaryTree();

        // Example: Create a sample tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2,  new TreeNode(4), new TreeNode(5));
        root.right = new TreeNode(3);

        System.out.println("Original Tree:");
        printTree(root);

        System.out.println("Diameter of Tree: " + tree.diameterOfBinaryTree(root));
    }
}
