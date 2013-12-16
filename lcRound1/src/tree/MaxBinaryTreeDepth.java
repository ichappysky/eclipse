package tree;

import java.util.ArrayDeque;
import java.util.Deque;

import common.TreeNode;

public class MaxBinaryTreeDepth {
    public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		// DFS it
		Deque<TreeNode> d = new ArrayDeque<TreeNode>();
		int max = 0;
		TreeNode cur = root;
		TreeNode prev = null;
		d.push(root);

		while (!d.isEmpty()) {
			cur = d.peek();
			if (prev == null || prev.left == cur || prev.right == cur) {
				if (cur.left != null) {
					d.push(cur.left);
				} else if (cur.right != null) {
					d.push(cur.right);
				}
			} else if (cur.left == prev) {
				if (cur.right != null) {
					d.push(cur.right);
				}
			} else {
    			if (cur.left==null && cur.right== null &&d.size() > max) {
    				max = d.size();
    			}
    			d.pop();
			}

			prev = cur;
		}
		return max;

        
    }
    
}
