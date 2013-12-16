package tree;

import common.TreeNode;

public class LowestCommonAncestor {

	public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		if (root == p || root == q) {
			return root;
		}
		TreeNode L = LCA(root.left, p, q);
		if (L!=null && L!=p && L!=q) {
			return L;
		}
		TreeNode R = LCA(root.right, p, q);
		if (L != null && R != null)
			return root; // if p and q are on both sides
		return L != null ? L : R; // either one of p,q is on one side OR p,q is
									// not in L&R subtrees
	}

	/**
	 *           1
	 *          /\ 
	 *         2  3
	 *        /\  /\
	 *       4 5  6 7
	 *      /\
	 *     8 9
	 * @return
	 */
	public static void main(String[] args) {
		final TreeNode n1 = new TreeNode(1);
		final TreeNode n2 = new TreeNode(2);
		final TreeNode n3 = new TreeNode(3);
		final TreeNode n4 = new TreeNode(4);
		final TreeNode n5 = new TreeNode(5);
		final TreeNode n6 = new TreeNode(6);
		final TreeNode n7 = new TreeNode(7);
		final TreeNode n8 = new TreeNode(8);
		final TreeNode n9 = new TreeNode(9);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left=n6;
		n3.right =n7;
		n4.left=n8;
		n4.right=n9;
		
		LowestCommonAncestor lca = new LowestCommonAncestor();
		System.out.println(lca.LCA(n1, n2, n9));
	}
}
