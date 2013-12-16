package common;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int x) {
		val = x;
	}

	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append("val = " + val);

		return b.toString();
	}
}
