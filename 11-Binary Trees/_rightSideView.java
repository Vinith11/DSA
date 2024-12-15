import java.util.ArrayList;
import java.util.List;

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

public class _rightSideView {

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        rightView(root, ans, 0);

        return ans;
    }

    public static void rightView(TreeNode curr, List<Integer> ans, int currDepth) {

        if (curr == null) {
            return;
        }

        if (currDepth == ans.size())
            ans.add(curr.val);

        System.out.println(currDepth);

        rightView(curr.right, ans, currDepth + 1);
        rightView(curr.left, ans, currDepth + 1);
    }

    public static void main(String[] args) {

        // Example: Create a sample tree
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2, new TreeNode(4, new TreeNode(5), null), null);
        p.right = new TreeNode(3);

        // System.out.println("Max Depth with DFS: " + maxDepth1(root));
        System.out.println("Level order : " + rightSideView(p));

    }

}
