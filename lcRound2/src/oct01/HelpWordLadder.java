package oct01;

import java.util.HashSet;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Given two words (start and end), and a dictionary, find the length of
 * shortest transformation sequence from start to end, such that:
 * 
 * Only one letter can be changed at a time Each intermediate word must exist in
 * the dictionary
 * 
 * For example,
 * 
 * Given: start = "hit" end = "cog" dict = ["hot","dot","dog","lot","log"]
 * 
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * 
 * Note:
 * 
 * Return 0 if there is no such transformation sequence. All words have the same
 * length. All words contain only lowercase alphabetic characters.
 * 
 * @author yongz
 * 
 */
public class HelpWordLadder {
	public int ladderLength(String start, String end, HashSet<String> dict) {
		Queue<String> candidates = new LinkedList<String>();
		candidates.offer(start);
		int steps = 0;
		int prevLayerNum = 1;
		int curLayerNum = 0;
		Set<String> visited = new HashSet<String>();
		while (!candidates.isEmpty()) {
			String cur = candidates.poll();
			prevLayerNum--;
			for (int i = 0; i < cur.length(); i++) {
				for (char c = 'a'; c <= 'z'; c++) {
					char[] curChars = cur.toCharArray();
					if (curChars[i] == c) {
						continue;
					}
					curChars[i] = c;
					String neighbor = String.valueOf(curChars);
					if (neighbor.equals(end)) {
						return steps + 2;
					}
					if (dict.contains(neighbor) && visited.add(neighbor)) {
						candidates.add(neighbor);
						curLayerNum++;
					}
				}
			}

			if (prevLayerNum == 0) {
				prevLayerNum = curLayerNum;
				curLayerNum = 0;
				steps++;
			}
		}
		return 0;
	}

	public static void main(String[] x) {
		String start = "a";
		String end = "c";
		HashSet<String> dict = new HashSet<String>();
		dict.add("a");
		dict.add("b");
		dict.add("c");

		WordLadder2 t = new WordLadder2();
		t.findLadders(start, end, dict);
	}

}
