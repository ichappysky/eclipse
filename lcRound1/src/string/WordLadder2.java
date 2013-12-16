package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder2 {

	public ArrayList<ArrayList<String>> findLadders(String start, String end,
			HashSet<String> dict) {
		dict.add(start);
		dict.add(end);

		HashMap<String, HashSet<String>> routes = new HashMap<String, HashSet<String>>();

		generateRoutes(dict, routes);

		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(new Node(null, 0, start));

		// word ==> its level
		Map<String, Integer> visited = new HashMap<String, Integer>();

		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			if (cur.val.equals(end)) {
				generateResults(cur, result);

			} else {
				Set<String> neighbors = routes.get(cur.val);

				if (neighbors == null || neighbors.size() == 0)
					continue;

				Set<String> removeSet = new HashSet<String>();

				for (String neighbor : neighbors) {

					if (visited.containsKey(neighbor)
							&& cur.level + 1 > visited.get(neighbor)) {
						removeSet.add(neighbor);
					} else {
						queue.add(new Node(cur, cur.level + 1, neighbor));
						visited.put(neighbor, cur.level + 1);
					}
				}

				neighbors.removeAll(removeSet);
			}
		}

		return result;

	}

	private void generateResults(Node node, ArrayList<ArrayList<String>> result) {
		ArrayList<String> list = new ArrayList<String>();
		while (node != null) {
			list.add(0, node.val);
			node = node.parent;
		}
		result.add(list);
	}

	// get mapping for each word ==> all words that can be reached by altering
	// one char
	private void generateRoutes(HashSet<String> words,
			HashMap<String, HashSet<String>> routes) {

		for (String word : words) {

			char[] c = word.toCharArray();
			for (int i = 0; i < c.length; i++) {
				char old = c[i];

				for (char t = 'a'; t <= 'z'; t++) {
					if (t == old) {
						continue;
					}
					c[i] = t;
					String newWord = new String(c);
					if (words.contains(newWord)) {
						HashSet<String> s = routes.get(word);
						if (s == null) {
							s = new HashSet<String>();
							routes.put(word, s);
						}
						s.add(newWord);
					}
				}

				c[i] = old;
			}
		}
	}

	public static void main(String[] args) {
		WordLadder2 t = new WordLadder2();
		HashSet<String> s = new HashSet<String>();
		s.add("ab");
		s.add("bb");
		s.add("bc");
		System.out.println(t.findLadders("ab", "bc", s));
	}
}

class Node {
	Node parent;
	int level;
	String val;

	public Node(Node parent, int level, String val) {
		this.parent = parent;
		this.level = level;
		this.val = val;
	}
}
