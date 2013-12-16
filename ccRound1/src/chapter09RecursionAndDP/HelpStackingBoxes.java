package chapter09RecursionAndDP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HelpStackingBoxes {

	public static ArrayList<Box> getHighest(Box[] boxes) {
		if (boxes == null) {
			return new ArrayList<Box>();
		}
		Map<Box, ArrayList<Box>> map = new HashMap<Box, ArrayList<Box>>();
		return helper(boxes, null, map);
	}

	private static ArrayList<Box> helper(Box[] boxes, Box curBox,
			Map<Box, ArrayList<Box>> map) {
		if (map.containsKey(curBox)) {
			return map.get(curBox);
		}

		int maxHeight = 0;
		ArrayList<Box> result = new ArrayList<Box>();
		for (Box box : boxes) {
			if (!box.canBeAbove(curBox)) {
				continue;
			}
			ArrayList<Box> subTower = helper(boxes, box, map);
			int height = stackHeight(subTower);
			if (height > maxHeight) {
				maxHeight = height;
				result = subTower;

			}
		}

		if (curBox != null) {
			result.add(0, curBox);
			map.put(curBox, result);
		}

		return (ArrayList<Box>) result.clone();
	}

	public static int stackHeight(ArrayList<Box> boxes) {
		if (boxes == null) {
			return 0;
		}
		int h = 0;
		for (Box b : boxes) {
			h += b.height;
		}
		return h;
	}

	public static void main(String[] args) {
		Box[] boxes = { new Box(1, 7, 4), new Box(2, 6, 9), new Box(4, 9, 6),
				new Box(10, 12, 8), new Box(6, 2, 5), new Box(3, 8, 5),
				new Box(5, 7, 7), new Box(2, 10, 16), new Box(12, 15, 9) };

		ArrayList<Box> stack = getHighest(boxes);
		for (int i = stack.size() - 1; i >= 0; i--) {
			Box b = stack.get(i);
			System.out.println(b.toString());
		}

		System.out.println("==========");
		ArrayList<Box> stackr = createStackR(boxes, null);
		for (int i = stackr.size() - 1; i >= 0; i--) {
			Box b = stackr.get(i);
			System.out.println(b.toString());
		}
	}

	public static ArrayList<Box> createStackR(Box[] boxes, Box bottom) {
		int max_height = 0;
		ArrayList<Box> max_stack = null;
		for (int i = 0; i < boxes.length; i++) {
			if (boxes[i].canBeAbove(bottom)) {
				ArrayList<Box> new_stack = createStackR(boxes, boxes[i]);
				int new_height = stackHeight(new_stack);
				if (new_height > max_height) {
					max_stack = new_stack;
					max_height = new_height;
				}
			}
		}

		if (max_stack == null) {
			max_stack = new ArrayList<Box>();
		}
		if (bottom != null) {
			max_stack.add(0, bottom);
		}

		return max_stack;
	}

}

class Box {
	public int width;
	public int height;
	public int depth;

	public Box(int w, int h, int d) {
		width = w;
		height = h;
		depth = d;
	}

	public boolean canBeUnder(Box b) {
		if (width > b.width && height > b.height && depth > b.depth) {
			return true;
		}
		return false;
	}

	public boolean canBeAbove(Box b) {
		if (b == null) {
			return true;
		}
		if (width < b.width && height < b.height && depth < b.depth) {
			return true;
		}
		return false;
	}

	public String toString() {
		return "Box(" + width + "," + height + "," + depth + ")";
	}
}