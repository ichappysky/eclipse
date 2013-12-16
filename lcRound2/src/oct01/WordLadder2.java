package oct01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Given two words (start and end), and a dictionary, find all shortest
 * transformation sequence(s) from start to end, such that:
 * 
 * Only one letter can be changed at a time Each intermediate word must exist in
 * the dictionary
 * 
 * For example,
 * 
 * Given: start = "hit" end = "cog" dict = ["hot","dot","dog","lot","log"]
 * 
 * Return
 * 
 * [ ["hit","hot","dot","dog","cog"], ["hit","hot","lot","log","cog"] ]
 * 
 * @author yongz
 * 
 */
public class WordLadder2 {
	public ArrayList<ArrayList<String>> findLadders(String start, String end,
			HashSet<String> dict) {

		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		Queue<String> candidates = new LinkedList<String>();
		candidates.offer(start);

		int prevLayerNum = 1;
		int curLayerNum = 0;
		Map<String, String> visited = new HashMap<String, String>();
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
						ArrayList<String> onePath = new ArrayList<String>();
						onePath.add(0, end);
						String prev = cur;
						do {
							onePath.add(0, prev);
						} while (!prev.equals(start));
						result.add(onePath);

					}
					if (dict.contains(neighbor)
							&& !visited.containsKey(neighbor)) {
						candidates.add(neighbor);
						visited.put(neighbor, cur);
						curLayerNum++;
					}
				}
			}

			if (prevLayerNum == 0) {
				if (!result.isEmpty()) {
					break;
				}
				prevLayerNum = curLayerNum;
				curLayerNum = 0;
			}
		}
		return result;
	}
}
