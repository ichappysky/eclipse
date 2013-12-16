package string;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	public int ladderLength(String start, String end, HashSet<String> dict) {
		if (start == null || end == null || start.length() != end.length()
				|| start.equals(end)) {
			return 0;
		}

		// BSF
		Queue<String> candidates = new LinkedList<String>();
		Set<String> usedStrings =new HashSet<String> ();
		int steps = 0;
		int prevLayerNodeNum = 1;
		int curLayerNodeNum = 0;
		candidates.offer(start);
		usedStrings.add(start);
		while (!candidates.isEmpty()) {
			String curString = candidates.poll();
			prevLayerNodeNum--;
			for (int i = 0; i < curString.length(); i++) {
				for (char c = 'a'; c <= 'z'; c++) {
					char[] temp = curString.toCharArray();
					if (temp[i] != c) {
						temp[i] = c;
						String candidate = String.valueOf(temp);
						if (candidate.equals(end)) {
							// start and end count for 2 steps
							return steps + 2;
						}
						
						// a valid string and not used yet
						if (dict.contains(candidate) && usedStrings.add(candidate)) {
							curLayerNodeNum++;
							candidates.add(candidate);
						}
					}
				}
			}
			// Done with nodes of previous layer
			if (prevLayerNodeNum==0) {
				prevLayerNodeNum = curLayerNodeNum;
				curLayerNodeNum = 0;
				steps++;
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		WordLadder t = new WordLadder();
		HashSet<String> s = new HashSet<String>();
		s.add("a");
		s.add("b");
		s.add("c");
		System.out.println(t.ladderLength("a", "c", s));
	}
}