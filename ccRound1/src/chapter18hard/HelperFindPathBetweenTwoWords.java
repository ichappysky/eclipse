package chapter18hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class HelperFindPathBetweenTwoWords {
	public static List<String> findPath(String a, String b, Set<String> words) {
		List<String> result = new LinkedList<String>();
		if (a == null || b == null || words == null || words.size() == 0) {
			return result;
		}
		Queue<String> candidates = new LinkedList<String>();
		Set<String> visited = new HashSet<String>();
		Map<String, String> map = new HashMap<String, String>();
		candidates.offer(a);
		visited.add(a);
		while (!candidates.isEmpty()) {
			String cur = candidates.poll();
			for (String neighbor : getNeighbors(cur)) {
				if (b.equals(neighbor)) {
					result.add(b);
					
					while (cur != null) {
						result.add(0, cur);
						cur = map.get(cur);
					}
					return result;
				}
				if (words.contains(neighbor) && !visited.contains(neighbor)) {
					visited.add(neighbor);
					candidates.add(neighbor);
					map.put(neighbor, cur);
				}
			}
		}

		return result;
	}

	private static Set<String> getNeighbors(String word) {
		Set<String> words = new TreeSet<String>();
		// for every letter
		for (int i = 0; i < word.length(); i++) {
			char[] wordArray = word.toCharArray();
			// change that letter to something else
			for (char c = 'a'; c <= 'z'; c++) {
				if (c != word.charAt(i)) {
					wordArray[i] = c;
					words.add(new String(wordArray));
				}
			}
		}
		return words;
	}

	// ===================
	public static void main(String[] args) {
		String[] words = { "maps", "tan", "tree", "apple", "cans", "help",
				"aped", "free", "apes", "flat", "trap", "fret", "trip", "trie",
				"frat", "fril" };
		HashSet<String> dict = setupDictionary(words);
		String a = "tree";
		String b = "flat";
		List<String> list = findPath(a, b, dict);

		for (String word : list) {
			System.out.println(word);
		}
		System.out.println("expected====");

		List<String> list2 = transform(a, b, dict);
		for (String word : list2) {
			System.out.println(word);
		}
	}

	public static HashSet<String> setupDictionary(String[] words) {
		HashSet<String> hash = new HashSet<String>();
		for (String word : words) {
			hash.add(word);
		}
		return hash;
	}

	public static LinkedList<String> transform(String startWord,
			String stopWord, Set<String> dictionary) {
		Queue<String> actionQueue = new LinkedList<String>();
		Set<String> visitedSet = new HashSet<String>();
		Map<String, String> backtrackMap = new TreeMap<String, String>();

		actionQueue.add(startWord);
		visitedSet.add(startWord);

		while (!actionQueue.isEmpty()) {
			String w = actionQueue.poll();
			// For each possible word v from w with one edit operation
			for (String v : getNeighbors(w)) {
				if (v.equals(stopWord)) {
					// Found our word! Now, back track.
					LinkedList<String> list = new LinkedList<String>();
					// Append v to list
					list.add(v);
					while (w != null) {
						list.add(0, w);
						w = backtrackMap.get(w);
					}
					return list;
				}

				// If v is a dictionary word
				if (dictionary.contains(v)) {
					if (!visitedSet.contains(v)) {
						actionQueue.add(v);
						visitedSet.add(v); // mark visited
						backtrackMap.put(v, w);
					}
				}
			}
		}
		return null;
	}
}
