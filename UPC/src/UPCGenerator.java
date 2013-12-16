import java.util.List;

public class UPCGenerator {

	/**
	 * a.\u4ece\u4ee3\u7801\u4f4d\u7f6e\u5e8f\u53f72\u5f00\u59cb\uff0c
	 * \u6240\u6709\u5076\u6570\u4f4d\u7684\u6570\u5b57\u4ee3\u7801\u6c42\u548c
	 * \u3002 b.\u5c06\u6b65\u9aa4a\u7684\u548c\u4e58\u4ee53\u3002
	 * c.\u4ece\u4ee3\u7801\u4f4d\u7f6e\u5e8f\u53f73\u5f00\u59cb\uff0c
	 * \u6240\u6709\u5947\u6570\u4f4d\u7684\u6570\u5b57\u4ee3\u7801\u6c42\u548c
	 * \u3002
	 * d.\u5c06\u6b65\u9aa4b\u4e0e\u6b65\u9aa4c\u7684\u7ed3\u679c\u76f8\u52a0
	 * \u3002 e.
	 * \u7528\u5927\u4e8e\u6216\u7b49\u4e8e\u6b65\u9aa4d\u6240\u5f97\u7ed3\u679c\u4e14\u4e3a10\u6700\u5c0f\u6574\u6570\u500d\u7684\u6570\u51cf\u53bb\u6b65\u9aa4d\u6240\u5f97\u7ed3\u679c
	 * \uff0c
	 * \u5176\u5dee\u5373\u4e3a\u6240\u6c42\u6821\u9a8c\u7801\u7684\u503c\u3002
	 * 
	 * @param a
	 */
	public static void genenateOneUPC(String a) {
		char[] digits = a.toCharArray();
		// array starts with index 0 which is 13th digit (counted from right)
		int even = Character.getNumericValue(digits[1])
				+ Character.getNumericValue(digits[3])
				+ Character.getNumericValue(digits[5])
				+ Character.getNumericValue(digits[7])
				+ Character.getNumericValue(digits[9])
				+ Character.getNumericValue(digits[11]);
		int odd = Character.getNumericValue(digits[0])
				+ Character.getNumericValue(digits[2])
				+ Character.getNumericValue(digits[4])
				+ Character.getNumericValue(digits[6])
				+ Character.getNumericValue(digits[8])
				+ Character.getNumericValue(digits[10]);
		int total = even * 3 + odd;
		int result = total;
		while (result > 0) {
			result = result - 10;
		}

		result = Math.abs(result);

		System.out.println(a + result);
	}

	// generate in DECREASING order
	public static void genenateUPC(long seed, int total) {
		for (int i = 0; i < total; i++) {
			String strSeed = String.valueOf(seed);

			genenateOneUPC(strSeed);
			seed--;
		}
	}

	public static void main(String[] args) {
		genenateUPC(695409585800L, 1000);
		
	}
}
