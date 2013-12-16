package fb;

public class RemoveNodeInBST {
	public boolean remove(Node root, int value) {
		if (root == null)
			return false;
		else {
			if (root.value == value) {
				Node auxRoot = new Node(0);
				auxRoot.left = root;
				boolean result = root.remove(value, auxRoot);
				root = auxRoot.left;
				return result;
			} else {
				return root.remove(value, null);
			}
		}
	}
	
	public static void main(String[] x) {
		
	}
}

class Node {
	public int value;
	public Node left;
	public Node right;

	public Node(int v) {
		this.value = v;
	}

	public boolean remove(int value, Node parent) {
		if (value < this.value) {
			if (left != null)
				return left.remove(value, this);
			else
				return false;
		} else if (value > this.value) {
			if (right != null)
				return right.remove(value, this);
			else
				return false;
		} else {
			if (left != null && right != null) {
				this.value = right.minValue();
				right.remove(this.value, this);
			} else if (parent.left == this) {
				parent.left = (left != null) ? left : right;
			} else if (parent.right == this) {
				parent.right = (left != null) ? left : right;
			}
			return true;
		}
	}

	public int minValue() {
		if (left == null)
			return value;
		else
			return left.minValue();
	}
}