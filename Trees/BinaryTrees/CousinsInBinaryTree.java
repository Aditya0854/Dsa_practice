import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class CousinsInBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            TreeNode xParent = null, yParent = null;

            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if(node.left != null) {
                    if(node.left.val == x) xParent = node;
                    if(node.left.val == y) yParent = node;
                    queue.offer(node.left);
                }

                if(node.right != null) {
                    if(node.right.val == x) xParent = node;
                    if(node.right.val == y) yParent = node;
                    queue.offer(node.right);
                }
            }

            if(xParent != null && yParent != null) {
                return xParent != yParent;
            }

            if(xParent != null || yParent != null) {
                return false;
            }
        }

        return false;

    }

    public static void main(String[] args) {
        // Create a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        CousinsInBinaryTree solution = new CousinsInBinaryTree();
        
        // Test case 1: nodes 4 and 5 (should be cousins)
        System.out.println("Are nodes 4 and 5 cousins? " + 
            solution.isCousins(root, 4, 5));  // Expected: true
        
        // Test case 2: nodes 2 and 3 (should not be cousins)
        System.out.println("Are nodes 2 and 3 cousins? " + 
            solution.isCousins(root, 2, 3));  // Expected: false
    }
}