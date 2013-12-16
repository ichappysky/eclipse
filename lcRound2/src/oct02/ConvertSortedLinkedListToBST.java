package oct02;

import java.util.ArrayList;
import java.util.List;

import common.ListNode;
import common.TreeNode;

public class ConvertSortedLinkedListToBST {
	public TreeNode sortedListToBST(ListNode head) {
	        if (head==null) {
				return null;
			}
			
			List<TreeNode> allNodes = new ArrayList<TreeNode>();
			while (head!=null) {
				allNodes.add(new TreeNode(head.val));
				head = head.next;
				}
				
				return helper (allNodes, 0, allNodes.size()-1);
			
	        
	    }

	private TreeNode helper(List<TreeNode> nodes, int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = start + (end - start) / 2;
		TreeNode root = nodes.get(mid);
		root.left = helper(nodes, start, mid - 1);
		root.right = helper(nodes, mid + 1, end);
		return root;
	}
}
