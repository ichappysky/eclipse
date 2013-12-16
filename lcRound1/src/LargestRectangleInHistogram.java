import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram {
	public int largestRectangleArea(int[] h) {
		if (h == null || h.length == 0) {
			return 0;
		}

		Stack<Integer> stack = new Stack<Integer>();
		int i = 0, result = 0;
		// 0 will be defaulted at the end
		int[] height = Arrays.copyOf(h, h.length+1);
		
		while (i < height.length ) {
			if (stack.empty()
					|| (i < height.length && height[stack.peek()] <= height[i]))
				stack.push(i++);
			else {
				int t = stack.pop();
				result = Math.max(result, height[t]
						* (stack.empty() ? i : i - stack.peek() - 1));
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] h = {2,3,4,5,1,1,1,1,1,1,0};
		
		LargestRectangleInHistogram t = new LargestRectangleInHistogram();
		System.out.print(t.largestRectangleArea(h));
	}
}