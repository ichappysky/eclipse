package chapter04TreesAndGraphs;

import common.AssortedMethods;
import common.TreeNode;

public class IsSubtree {
	public static boolean containsTree(TreeNode a, TreeNode b) {
		if (b == null) {
			return true;
		}

		if (a == null && b != null) {
			return false;
		}
		if (a.data != b.data) {
			if (a.left == null || a.right == null) {
				return false;
			}
			return containsTree(a.left, b) || containsTree(a.right, b);
		} else {
			return containsTree(a.left, b.left)
					&& containsTree(a.right, b.right);
		}
	}

	public static void main(String[] args) {
		// t2 is a subtree of t1
		int[] array1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
		int[] array2 = { 2, 4, 5, 8, 9, 10, 11 };
		
		 TreeNode t1 = AssortedMethods.createTreeFromArray(array1);
		 TreeNode t2 = AssortedMethods.createTreeFromArray(array2);
		 t1.print();
		 t2.print();
		
		 if (containsTree(t1, t2))
		 System.out.println("t2 is a subtree of t1");
		 else
		 System.out.println("t2 is not a subtree of t1");

		// t4 is not a subtree of t3
		int[] array3 = { 12,14 };
		TreeNode t3 = AssortedMethods.createTreeFromArray(array1);
		 TreeNode t4 = AssortedMethods.createTreeFromArray(array3);
//		TreeNode t4 = new TreeNode(7);
		t3.print();
		t4.print();

		if (containsTree(t3, t4))
			System.out.println("YES");
		else
			System.out.println("NAH");
	}
}
