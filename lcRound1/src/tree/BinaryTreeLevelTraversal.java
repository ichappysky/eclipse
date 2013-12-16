package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

import common.TreeNode;

public class BinaryTreeLevelTraversal {
	   public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		    if (root==null) {
		    	return result;
		    }
		    
	        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
	        int prevLayerNum = 1;
	        queue.offer(root);
	        int curLayerNum =0;
	        ArrayList<Integer> oneLayer = new ArrayList<Integer>();
	        while(!queue.isEmpty()) {
	        	prevLayerNum--;
	        	TreeNode cur = queue.poll();
	        	
	        	oneLayer.add(cur.val);
	        	
	        	if (cur.left!=null) {
	        		queue.offer(cur.left);
	        		curLayerNum++;
	        	}
	        	if (cur.right!=null) {
	        		queue.offer(cur.right);
	        		curLayerNum++;
	        	} 
	        	if (prevLayerNum==0) {
	        		prevLayerNum = curLayerNum;
	        		curLayerNum =0;
	        		ArrayList<Integer> prevLayer = new ArrayList<Integer>(oneLayer);
	        		result.add(prevLayer);
	        		oneLayer.clear();
	        	}
	        }
	        
	        return result;
	    }
}
