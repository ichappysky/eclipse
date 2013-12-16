package tree;

import java.util.ArrayList;
import java.util.List;

import common.TreeNode;

public class PathSum2 {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();
    	
    	List<Integer> path = new ArrayList<Integer>();
    	findPath(root, sum, path, result);
    	
        return result;
    }

	private void findPath(TreeNode root, int sum, List<Integer> path,
			ArrayList<ArrayList<Integer>> result) {
		if (root == null) {
			return ;
		}
		path.add(root.val);
		if (root.val==sum && root.left==null && root.right==null) {
			ArrayList<Integer> newPath = new ArrayList<Integer> (path);
			result.add(newPath);
		}
		findPath(root.left,sum-root.val, path, result);
		findPath(root.right,sum-root.val, path, result);
		
		// remove current end node before returning/popping up
		path.remove(path.size()-1);
	}
    
    
}
