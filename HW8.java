import java.util.*;

public class HW8 {    
    public static void main(String[] args) {
        // create a solution instance
        Solution sol = new Solution();

        // Example test case
        BSTNode tree = new BSTNode(3);
        tree.left  = new BSTNode(0);
        tree.right = new BSTNode(0);

        System.out.println(sol.distribute(tree)); // Expected output: 2

        // Additional test case
        BSTNode tree2 = new BSTNode(0);
        tree2.left  = new BSTNode(3);
        tree2.right = new BSTNode(0);
        System.out.println(sol.distribute(tree2)); // Expected output: 3
    }
}

// ===============================================
// DO NOT MODIFY TREE BELOW THIS LINE
// ===============================================
class BSTNode {
   int val;
   BSTNode left;
   BSTNode right;
   BSTNode(int x) { val = x; }
}
// ===============================================
// DO NOT MODIFY TREE ABOVE THIS LINE
// ===============================================

class Solution {

    // global variable to count moves
    private int moves;

    /**
     * PURPOSE: Returns the minimum number of PPE moves needed 
     *          so that each hospital node gets exactly one PPE.
     * PARAMETERS: BSTNode root — root of the hospital binary tree
     * RETURN VALUES: int — number of moves required
     */
    public int distribute(BSTNode root) {
        moves = 0;
        if (root == null) return 0;
        postOrder(root);
        return moves;
    }

    /**
     * PURPOSE: Performs a post order traversal to calculate 
     *          the PPE balance for each node.
     * Each node returns its balance = (node.val + leftBalance + rightBalance - 1)
     * Moves are counted as the absolute values of left and right balances,
     * representing PPE transfers between parent and children.
     */
    private int postOrder(BSTNode node) {
        if (node == null) return 0;

        int leftBalance = postOrder(node.left);
        int rightBalance = postOrder(node.right);

        // Count the moves needed for left and right children
        moves += Math.abs(leftBalance) + Math.abs(rightBalance);

        // Return this node’s balance (positive = surplus, negative = deficit)
        return node.val + leftBalance + rightBalance - 1;
    }
}
