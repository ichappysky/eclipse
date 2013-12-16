package chapter11SortingAndSearching;

import java.util.ArrayList;
import java.util.Iterator;

import common.AssortedMethods;

public class HelpFindRank {

	private static RankNode root = null;

	public static void track(int number) {
		if (root == null) {
			root = new RankNode(number);
		} else {
			root.insert( number);
		}
	}

	public static int getRankOfNumber(int number) {
		return root.getRank( number);
	}

	public static void main(String[] args) {
		int size = 3;
		int[] list = {2,2,3};
		for (int i = 0; i < list.length; i++) {
			track(list[i]);
		}

		int[] tracker = new int[size];
		for (int i = 0; i < list.length; i++) {
			int v = list[i];
			int rank1 = root.getRank( list[i]);
			tracker[rank1] = v;
		}

		for (int i = 0; i < tracker.length - 1; i++) {
			if (tracker[i] != 0 && tracker[i + 1] != 0) {
				if (tracker[i] > tracker[i + 1]) {
					System.out.println("ERROR at " + i);
				}
			}
		}

		System.out.println("Array: " + AssortedMethods.arrayToString(list));
		System.out.println("Ranks: " + AssortedMethods.arrayToString(tracker));
		
		// test farm. irrelevant
		ArrayList<String> b=null;
		Iterator a = b.iterator();
		a.next();
	}

}

class RankNode {
	public int left_size = 0;
	public RankNode left;
	public RankNode right;
	public int data = 0;

	public RankNode(int d) {
		data = d;
	}

	public void insert(int d) {
		if (this.data >= d) {
			if (left == null) {
				left = new RankNode(d);
			} else {
				left.insert(d);
			}
			left_size++;
		} else {
			if (right == null) {
				right = new RankNode(d);
			} else {
				right.insert(d);
			}
		}
	}

	public int getRank(int d) {
		if (this.data == d) {
			return this.left_size ;
		}

		if (this.data > d) {
			if (left == null) {
				return -1;
			}
			return left.getRank(d);
		} else {
			if (right == null) {
				return -1;
			} else {
				return left_size + 1 + right.getRank(d);
			}
		}
	}
}