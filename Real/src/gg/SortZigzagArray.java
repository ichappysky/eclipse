package gg;

import java.util.Arrays;

/**
 * sort array so such that a1<=a2>=a3<=a4>=...
 * 
 * @author yongz
 * 
 */
public class SortZigzagArray {
	public static int[] sortArray(int[] s) {
		int n = s.length;
		boolean needSmallerCurrent = true;
		for (int i = 0; i < n - 1; i++) {
			int current = s[i];
				
			if ((needSmallerCurrent && (current > s[i + 1]))
					|| (!needSmallerCurrent && (current < s[i + 1]))) {
				s[i] = s[i + 1];
				s[i+1] = current;
			} 
			needSmallerCurrent = !needSmallerCurrent;
		}
		
		return s;
	}

	public static void main(String[] x) {
		System.out.println(Arrays
				.toString(sortArray(new int[] { 1, 3, 2, 2, 4 })));
	}
}
