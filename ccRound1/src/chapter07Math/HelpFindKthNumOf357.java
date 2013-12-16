package chapter07Math;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class HelpFindKthNumOf357 {
	public static int findK(int k) {
		if (k <= 0) {
			return -1;
		}

		Queue<Integer> q3 = new LinkedList<Integer>();
		Queue<Integer> q5 = new LinkedList<Integer>();
		Queue<Integer> q7 = new LinkedList<Integer>();
		q3.offer(3);
		q5.offer(5);
		q7.offer(7);
		int val = 0;
		for (int i = 1; i <= k; i++) {
			int min = Math.min(Math.min(q3.peek(), q5.peek()), q7.peek());
			if (min == q3.peek()) {
				val = q3.poll();
				q3.offer(3 * val);
				q5.offer(5 * val);
				q7.offer(7 * val);

			} else if (min == q5.peek()) {
				val = q5.poll();
				q5.offer(5 * val);
				q7.offer(7 * val);

			} else {
				val = q7.poll();
				q7.offer(7 * val);
			}
		}
		return val;
	}

	public static void main(String[] args) {
		Map<Integer, Integer> a = new HashMap<Integer, Integer>();
		Set<Integer> b = new HashSet<Integer>();
		for (int i = 0; i < 14; i++) {
			System.out.println(i + " : " + findK(i));
		}
	}
}
