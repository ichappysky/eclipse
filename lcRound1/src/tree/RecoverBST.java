package tree;

import java.util.Stack;

import common.TreeNode;


public class RecoverBST {
	public void recoverTree(TreeNode root) {
		if ( root==null) {
			return;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur = root;
		TreeNode prev = null;
		// two nodes that are swapped
		TreeNode first = null;
		TreeNode second = null;
				
		while (!stack.isEmpty() || cur!=null) {
			if (cur!=null) {
				stack.push(cur);
				cur=cur.left;
			} else {
				cur = stack.pop();
				// find one out-of-order occurrence
				if (prev!= null && prev.val> cur.val) {
					// first time of out-of-order, update the bigger one
					if (first ==null) {
						first = prev;
					} 
					// first and second time,  update the smaller one.
					second = cur;
				}
				prev = cur;
				cur = cur.right;
			}
		}
		
		//swap values;
		int tmp =first.val;
		first.val = second.val;
		second.val = tmp;
	}
	
	
}
