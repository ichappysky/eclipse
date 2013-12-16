package interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import common.Interval;

public class MergeIntervals {
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		ArrayList<Interval> result = new ArrayList<Interval>();
		if (intervals == null || intervals.size() == 0) {
			return result;
		}
		Comparator<Interval> comparator = new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				if (o1.start < o2.start) {
					return -1;
				} else if (o1.start == o2.start) {
					return 0;
				} else {
					return 1;
				}
			}

		};
		Collections.sort(intervals, comparator);
		result.add(intervals.get(0));
		for (int i = 1; i < intervals.size(); i++) {
			int endIndex = result.size() - 1;
			Interval prev = result.get(endIndex);
			Interval cur = intervals.get(i);
			if (prev.end < cur.start) {
				result.add(cur);
			} else {
				if (prev.end >= cur.end) {
					continue;
				} else {
					result.remove(endIndex);
					result.add(new Interval(prev.start, cur.end));
				}
			}
		}

		return result;
	}
}
