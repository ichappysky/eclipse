package oct17;

import java.util.ArrayList;
import java.util.List;

public class HelpDivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		long divd = Math.abs((long)dividend);
		long divs = Math.abs((long)divisor);

		List<Long> divisors = new ArrayList<Long>();
		while (divd >= divs) {
			divisors.add(divs);
			divs = divs << 1;
		}

		int result = 0;
		int cur = divisors.size() - 1;
		while (cur >= 0 && divd > 0) {
			if (divd >= divisors.get(cur)) {
				divd -= divisors.get(cur);
				result += 1 << cur;
			}
			cur--;
		}

		return (dividend > 0) ^ (divisor > 0) ? -result : result;
	}
	
	
	public static void main(String[] x) {
		HelpDivideTwoIntegers t = new HelpDivideTwoIntegers();
		int a = 1;
		int b = -1;
		System.out.println(t.divide(a, b) );
		System.out.println(a/b );
	}
}
