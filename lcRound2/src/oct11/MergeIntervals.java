package oct11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import common.Interval;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * For example, Given [1,3],[2,6],[8,10],[15,18], return [1,6],[8,10],[15,18].
 * 
 * @author yongz
 * 
 */
public class MergeIntervals {
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		ArrayList<Interval> result = new ArrayList<Interval>();
		if (intervals == null || intervals.isEmpty()) {
			return result;
		}
		Comparator<Interval> comparator = new Comparator<Interval>() {
			public int compare(Interval t1, Interval t2) {
				if (t1.start == t2.start) {
					return 0;
				}
				if (t1.start < t2.start) {
					return -1;
				}
				return 1;
			}
		};

		Collections.sort(intervals, comparator);
		Interval candidate = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
			Interval cur = intervals.get(i);
			if (candidate.end < cur.start) {
				result.add(candidate);
				candidate = cur;
			} else {
				candidate.end = Math.max(candidate.end, cur.end);
			}
		}

		result.add(candidate);

		return result;
	}
}