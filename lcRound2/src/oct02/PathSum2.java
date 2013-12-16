package oct02;

import java.util.ArrayList;

import common.TreeNode;
/**
 * Given a binary tree and a sum, find all root-to-leaf paths 
 * where each path's sum equals the given sum.
 *  For example:Given the below binary tree and sum = 22, 
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1

 * return[   [5,4,11,2],   [5,8,4,5]]

 * @author yongz
 *
 */
public class PathSum2 {
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> path = new ArrayList<Integer>();
		helper(root, sum, path, result);
		return result;

	}

	private void helper(TreeNode root, int sum, ArrayList<Integer> path,
			ArrayList<ArrayList<Integer>> result) {
		if (root == null) {
			return;
		}
		path.add(root.val);
		if (root.left == null && root.right == null && root.val == sum) {
			result.add(new ArrayList<Integer>(path));

		}
		helper(root.left, sum - root.val, path, result);
		helper(root.right, sum - root.val, path, result);
		path.remove(path.size() - 1);
	}
}