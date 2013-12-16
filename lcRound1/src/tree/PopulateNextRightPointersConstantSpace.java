package tree;

public class PopulateNextRightPointersConstantSpace {
	public void connect(TreeLinkNode root) {
		TreeLinkNode leftMost = root;
		while (leftMost != null) {
			TreeLinkNode cross = leftMost;
			TreeLinkNode prev = null;

			while (cross != null) {
				if (cross.left != null) {
					if (prev == null) {
						prev = cross.left;
					} else {
						prev.next = cross.left;
						prev = prev.next;
					}
				}
				if (cross.right != null) {
					if (prev == null) {
						prev = cross.right;
					} else {
						prev.next = cross.right;
						prev = prev.next;
					}
				}

				cross = cross.next;
			}
			prev = null;
			// keep moving leftMost to its next right if its both children are
			// null
			while (leftMost != null && leftMost.left == null
					&& leftMost.right == null) {
				leftMost = leftMost.next;
			}
			if (leftMost == null) {
				break;
			}
			// move down to its non-null child
			leftMost = leftMost.left != null ? leftMost.left : leftMost.right;
		}
	}
}
