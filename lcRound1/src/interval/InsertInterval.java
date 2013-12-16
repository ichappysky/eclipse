package interval;
import java.util.ArrayList;

import common.Interval;

public class InsertInterval {
	public ArrayList<Interval> insert(ArrayList<Interval> intervals,
			Interval newInterval) {
		ArrayList<Interval> result = new ArrayList<Interval>();
		if (intervals == null) {
			return result;
		}
		if (intervals.isEmpty()) {
			result.add(newInterval);
			return result;
		}
		// find starting pos
		int low = 0;
		int high = intervals.size() - 1;
		int mid = 0;
		while (low <= high) {
			mid = low + (high - low) / 2;
			Interval cur = intervals.get(mid);
			if (cur.start == newInterval.start) {
				break;
			} else if (cur.start > newInterval.start) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		int deleteStartIndex = 0;
		int targetStartValue = 0;
		if (intervals.get(mid).start == newInterval.start) {
			deleteStartIndex = mid;
			targetStartValue = intervals.get(mid).start;
		} else if (high < mid) {
			if (mid == 0 || intervals.get(mid - 1).end < newInterval.start) {
				deleteStartIndex = mid;
				targetStartValue = newInterval.start;
			} else {
				deleteStartIndex = mid - 1;
				targetStartValue = intervals.get(mid - 1).start;
			}
		} else {
			if (intervals.get(mid).end < newInterval.start) {
				deleteStartIndex = mid + 1;
				targetStartValue = newInterval.start;
			} else {
				deleteStartIndex = mid;
				targetStartValue = intervals.get(mid).start;
			}
		}
		// find ending pos
		low = 0;
		high = intervals.size() - 1;
		while (low <= high) {
			mid = low + (high - low) / 2;
			Interval cur = intervals.get(mid);
			if (cur.end == newInterval.end) {
				break;
			} else if (cur.end > newInterval.end) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		int deleteEndIndex = 0;
		int targetEndValue = 0;
		if (intervals.get(mid).end == newInterval.end) {
			deleteEndIndex = mid;
			targetEndValue = intervals.get(mid).end;
		} else if (low > mid) {
			if (mid == intervals.size() - 1
					|| intervals.get(mid + 1).start > newInterval.end) {
				deleteEndIndex = mid;
				targetEndValue = newInterval.end;
			} else {
				deleteEndIndex = mid + 1;
				targetEndValue = intervals.get(mid + 1).end;
			}
		} else {
			if (intervals.get(mid).start > newInterval.end) {
				deleteEndIndex = mid - 1;
				targetEndValue = newInterval.end;
			} else {
				deleteEndIndex = mid;
				targetEndValue = intervals.get(mid).end;
			}
		}

		Interval targetInterval = new Interval(targetStartValue, targetEndValue);
		for (int i = 0; i < deleteStartIndex; i++) {
			result.add(intervals.get(i));
		}
		result.add(targetInterval);
		for (int i = deleteEndIndex + 1; i < intervals.size(); i++) {
			result.add(intervals.get(i));
		}

		return result;
	}
	
	//[[0,5],[8,9]], [3,4]	[[0,4],[8,9]]	[[0,5],[8,9]]

	public static void main(String[] a) {
		InsertInterval t = new InsertInterval();
		ArrayList<Interval> s = new ArrayList<Interval>();
		s.add(new Interval(0, 5));
		s.add(new Interval(8, 9));
		t.insert(s, new Interval(3, 4));
	}
}