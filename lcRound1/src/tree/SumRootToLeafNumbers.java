package tree;

import common.TreeNode;

public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return helper(root, 0);
    }
    
    private int helper(TreeNode node, int totalOfUpperLevel) {
    	if (node == null) {
    		return 0;
    	}
    	int curVal = totalOfUpperLevel*10+node.val;
    	if (node.left == null && node.right == null) {
    		return curVal;
    	}
    	return helper(node.left, curVal ) + helper(node.right, curVal);
    }
}
