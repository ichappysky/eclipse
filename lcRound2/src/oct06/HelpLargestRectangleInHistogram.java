package oct06;

import java.util.Arrays;
import java.util.Stack;

public class HelpLargestRectangleInHistogram {
	public int largestRectangleArea(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}

		int result = 0;
		// 0 will be defaulted at the end
		int[] heightCopy = Arrays.copyOf(height, height.length + 1);

		Stack<Integer> stack = new Stack<Integer>();
		int index = 0;
		while (index < heightCopy.length) {
			if (stack.isEmpty()
					|| heightCopy[index] >= heightCopy[stack.peek()]) {
				stack.push(index);
				index++;
			} else {
				int topIndex = stack.pop();
				int width = stack.isEmpty() ? index : index - stack.peek() - 1;
				result = Math.max(result, heightCopy[topIndex] * width);
			}
		}

		return result;

	}
}
