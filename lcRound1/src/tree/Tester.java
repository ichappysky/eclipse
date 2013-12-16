package tree;

import common.TreeNode;

public class Tester {
	public static void main(String[] args) {
		final TreeNode testTree = createTestTree(); 
		
		MaxPathSum t = new MaxPathSum();

		System.out.println(t.maxPathSum(testTree));
	}
	
	/**
	 *           1
	 *          /\ 
	 *         2  3
	 *        /\  /\
	 *       4 5  6 7
	 * @return
	 */
	private static TreeNode createTestTree() {
		TreeNode r = new TreeNode(1);
		TreeNode t = new TreeNode(2);
		r.left = t;
		t = new TreeNode(3);
		r.right = t;
		
		t = new TreeNode(4);
		r.left.left = t;
		t = new TreeNode(5);
		r.left.right = t;
		t = new TreeNode(6);
		r.right.left = t;
		t = new TreeNode(7);
		r.right.right = t;
		
		return r;
	}
}
