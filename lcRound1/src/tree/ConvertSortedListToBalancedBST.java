package tree;

import java.util.ArrayList;
import java.util.List;

import common.ListNode;
import common.TreeNode;

public class ConvertSortedListToBalancedBST {
	public TreeNode sortedListToBST(ListNode head) {

		if (head == null) {
			return null;
		}

		List<TreeNode> allNodes = new ArrayList<TreeNode>();
		while (head != null) {
			allNodes.add(new TreeNode(head.val));
			head = head.next;
		}
		return helper(0, allNodes.size() - 1, allNodes);
	}

	private TreeNode helper(int start, int end, List<TreeNode> allNodes) {
		if (start > end) {
			return null;
		}

		int mid = start + (end - start) / 2;
		TreeNode root = allNodes.get(mid);

		root.left = helper(start, mid - 1, allNodes);
		root.right = helper(mid + 1, end, allNodes);
		return root;

	}
}
