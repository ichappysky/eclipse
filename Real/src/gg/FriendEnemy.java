package gg;

public class FriendEnemy {
	final int[] parents;
	final int[] sizes;
	final boolean[] areFriendsWithParent;

	public FriendEnemy(int size) {
		parents = new int[size];
		sizes = new int[size];
		areFriendsWithParent = new boolean[size];

		for (int i = 0; i < size; i++) {
			parents[i] = i;
			sizes[i] = 1;
			areFriendsWithParent[i] = true;
		}
	}

	public Result find(int a) {
		int cur = a;
		boolean finalRelation = areFriendsWithParent[cur];
		while (parents[cur] != cur) {
			int parent = parents[cur];
			// compress tree. set parent index to grandparent.
			parents[cur] = parents[parent];
			boolean areFriendsWithP = areFriendsWithParent[cur];
			areFriendsWithP = !(areFriendsWithP ^ areFriendsWithParent[parent]);
			areFriendsWithParent[cur] = areFriendsWithP;
			if (a == cur) {
				finalRelation = areFriendsWithP;
			} else {
				finalRelation = !(areFriendsWithP ^ finalRelation);
			}
			cur = parents[parent];

		}

		return new Result(cur, finalRelation);
	}

	public void union(int a, int b, boolean areF) {
		Result aResult = find(a);
		Result bResult = find(b);

		int aRoot = aResult.root;
		int bRoot = bResult.root;

		if (aRoot == bRoot) {
			return;
		}
		boolean rootsRelation = areF;
		if (aResult.areFriends != bResult.areFriends) {
			rootsRelation = !areF;
		}

		if (sizes[aRoot] < sizes[bRoot]) {
			parents[aRoot] = bRoot;
			sizes[bRoot] += sizes[aRoot];
			areFriendsWithParent[aRoot] = rootsRelation;
		} else {
			parents[bRoot] = aRoot;
			sizes[aRoot] += sizes[bRoot];
			areFriendsWithParent[bRoot] = rootsRelation;
		}
	}

	public Boolean areFriends(int a, int b) {
		Result aResult = find(a);
		Result bResult = find(b);
		// null means no relation
		if (aResult.root != bResult.root) {
			return null;
		}
		return aResult.areFriends == bResult.areFriends;
	}

	public static void main(String[] x) {
		FriendEnemy t = new FriendEnemy(9);

		t.union(1, 2, true);
		t.union(1, 3, true);
		t.union(1, 4, true);
		
		t.union (5, 6, true);
		t.union(5, 7, true);
		t.union(5, 8, true);

		t.union(3, 7, false);
		
		for (int i = 1; i <= 8; i++) {
			for (int j = i+1; j <= 8; j++) {
				System.out.println(i + " and " + j + " are friends? "
						+ t.areFriends(i, j));
			}
		}
	}

}

class Result {
	int root;
	boolean areFriends;

	public Result(int root, boolean areFriends) {
		this.root = root;
		this.areFriends = areFriends;
	}
}