package oct11;

import java.util.ArrayList;

import common.Interval;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the
 * intervals (merge if necessary).
 * 
 * You may assume that the intervals were initially sorted according to their
 * start times.
 * 
 * Example 1: Given intervals [1,3],[6,9], insert and merge [2,5] in as
 * [1,5],[6,9].
 * 
 * Example 2: Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in
 * as [1,2],[3,10],[12,16].
 * 
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * 
 * @author yongz
 * 
 */
public class MistakeInsertInterval {
	public ArrayList<Interval> insert(ArrayList<Interval> intervals,
			Interval newInterval) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		ArrayList<Interval> result = new ArrayList<Interval>();
		for (Interval cur : intervals) {
			// mistake
			if (newInterval == null) {
				result.add(cur);
			} else {
				if (cur.end < newInterval.start) {
					result.add(cur);
				} else if (cur.start > newInterval.end) {
					result.add(newInterval);
					newInterval = null;
					result.add(cur);
				} else {
					newInterval = new Interval(Math.min(cur.start,
							newInterval.start), Math.max(cur.end,
							newInterval.end));
				}
			}
		}

		// mistake
		if (newInterval != null) {
			result.add(newInterval);
		}

		return result;

	}
}