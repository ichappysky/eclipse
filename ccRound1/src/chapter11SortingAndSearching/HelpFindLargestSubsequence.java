package chapter11SortingAndSearching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HelpFindLargestSubsequence {
	public static ArrayList<Item> getLargest(ArrayList<Item> items) {
		ArrayList<Item> result = new ArrayList<Item>();
		if (items == null || items.isEmpty()) {
			return result;
		}
		List<ArrayList<Item>> solutions = new ArrayList<ArrayList<Item>>();
		helper(items, 0, solutions);

		for (ArrayList<Item> sol : solutions) {
			result = getMax(sol, result);
		}

		return result;
	}

	private static void helper(ArrayList<Item> items, int curIndex,
			List<ArrayList<Item>> solutions) {
		if (curIndex >= items.size()) {
			return;
		}
		ArrayList<Item> max = new ArrayList<Item>();
		Item curItem = items.get(curIndex);
		for (int i = 0; i < curIndex; i++) {
			if (items.get(i).isBefore(curItem)) {
				max = getMax(max, solutions.get(i));
			}
		}
		ArrayList<Item> curSol = new ArrayList<Item>(max);
		curSol.add(curItem);
		solutions.add(curSol);
		helper(items, curIndex+1, solutions);
		
	}

	// /////////////////////////////////////////////////////////////////////

	public static void main(String[] args) {
		ArrayList<Item> items = initialize();

		Collections.sort(items);
		printList(items);
		ArrayList<Item> solution = getIncreasingSequence(items);
		System.out.println("\nexpected result:");
		printList(solution);
		solution = getLargest(items);
		System.out.println("\ngot result:");
		printList(solution);
		
	}

	// ///////////////////////////////////////////////////////////////////////
	// Returns longer sequence
	private static ArrayList<Item> getMax(ArrayList<Item> seq1,
			ArrayList<Item> seq2) {
		if (seq1 == null) {
			return seq2;
		} else if (seq2 == null) {
			return seq1;
		}
		return seq1.size() > seq2.size() ? seq1 : seq2;
	}

	private static void longestIncreasingSubsequence(ArrayList<Item> array,
			ArrayList<Item>[] solutions, int current_index) {
		if (current_index >= array.size() || current_index < 0) {
			return;
		}
		Item current_element = array.get(current_index);

		// Find longest sequence that we can append current_element to
		ArrayList<Item> best_sequence = null;
		for (int i = 0; i < current_index; i++) {
			if (array.get(i).isBefore(current_element)) {
				best_sequence = getMax(best_sequence, solutions[i]);
			}
		}

		// Append current_element
		ArrayList<Item> new_solution = new ArrayList<Item>();
		if (best_sequence != null) {
			new_solution.addAll(best_sequence);
		}
		new_solution.add(current_element);

		// Add to list and recurse
		solutions[current_index] = new_solution;
		longestIncreasingSubsequence(array, solutions, current_index + 1);
	}

	private static ArrayList<Item> longestIncreasingSubsequence(
			ArrayList<Item> array) {
		ArrayList<Item>[] solutions = new ArrayList[array.size()];
		longestIncreasingSubsequence(array, solutions, 0);

		ArrayList<Item> best_sequence = null;
		for (int i = 0; i < array.size(); i++) {
			best_sequence = getMax(best_sequence, solutions[i]);
		}

		return best_sequence;
	}

	public static ArrayList<Item> initialize() {
		ArrayList<Item> items = new ArrayList<Item>();

		Item item = new Item(65, 60);
		items.add(item);

		item = new Item(70, 150);
		items.add(item);

		item = new Item(56, 90);
		items.add(item);

		item = new Item(75, 190);
		items.add(item);

		item = new Item(60, 95);
		items.add(item);

		item = new Item(68, 110);
		items.add(item);

		item = new Item(35, 65);
		items.add(item);

		item = new Item(40, 60);
		items.add(item);

		item = new Item(45, 63);
		items.add(item);

		return items;
	}

	public static void printList(ArrayList<Item> list) {
		for (Item item : list) {
			System.out.print(item.toString() + " ");
		}
	}

	public static ArrayList<Item> getIncreasingSequence(ArrayList<Item> items) {

		return longestIncreasingSubsequence(items);
	}
}

class Item implements Comparable {
	private int height;
	private int weight;

	public Item(int h, int w) {
		height = h;
		weight = w;
	}

	public int compareTo(Object s) {
		Item second = (Item) s;
		if (this.height != second.height) {
			return ((Integer) this.height).compareTo(second.height);
		} else {
			return ((Integer) this.weight).compareTo(second.weight);
		}
	}

	public String toString() {
		return "(" + height + ", " + weight + ")";
	}

	/*
	 * Returns true if ¡°this¡± should be lined up before ¡°other¡±. Note that it¡¯s
	 * possible that this.isBefore(other) and other.isBefore(this) are both
	 * false. This is different from the compareTo method, where if a < b then b
	 * > a.
	 */
	public boolean isBefore(Item other) {
		if (this.height < other.height && this.weight < other.weight) {
			return true;
		} else {
			return false;
		}
	}
}