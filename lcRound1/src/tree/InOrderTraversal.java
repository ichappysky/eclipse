package tree;

import java.util.ArrayDeque;
import java.util.Deque;

import common.TreeNode;

public class InOrderTraversal {
	
	public void traverseIterative(final TreeNode r) {
		Deque<TreeNode> d = new ArrayDeque<TreeNode>();
		
		TreeNode cur = r;
		while(!d.isEmpty() || cur !=null) {
			if(cur!=null) {
				d.push(cur);
				cur = cur.left;
			} else {
				cur = d.pop();
				System.out.println(cur.val);
				cur = cur.right;
			}
		}
	}

	public void traverseRecursive(final TreeNode r) {
		if (r == null ) {
			return;
		}
		traverseRecursive(r.left);
		System.out.println(r.val);
		traverseRecursive(r.right);
	}
}
