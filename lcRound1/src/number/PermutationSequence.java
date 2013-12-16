package number;

public class PermutationSequence {
	public String getPermutation(int n, int k) {
		if (n <= 0 || k <= 0) {
			return "";
		}
		int[] num= new int[n];
		for (int i=0;i <n;i++) {
			num[i]=i+1;
		}
		
		k = k-1;
		String result = "";
		for (int i = n-1; i>=0; i--) {
			int fac = factorial(i);
			int quotient = k/fac;
			for (int j=0;j<=quotient;j++) {
				if (num[j]==-1) {
					quotient++;
				}
			}
			result += num[quotient];
			k %= fac;
			num[quotient] = -1;
		}
		
		return result;
	}

	private int factorial(int n) {
		int result = 1;
		for (int i = 1; i <= n; i++) {
			result *= i;
		}
		return result;
	}

	public static void main(String[] x) {
		PermutationSequence t = new PermutationSequence();
		System.out.print(t.getPermutation(3, 2));
	}
}