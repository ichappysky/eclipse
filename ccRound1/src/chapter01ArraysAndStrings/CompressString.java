package chapter01ArraysAndStrings;

public class CompressString {
	public static String compressBetter(String str) {
		if (str == null || str.length() <= 1) {
			return str;
		}

		StringBuilder sb = new StringBuilder();
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			count++;
			if (i == str.length() - 1 || str.charAt(i) != str.charAt(i + 1)) {
				sb.append(str.charAt(i)).append(count);
				count = 0;
			}

		}

		String result = sb.toString();
		if (result.length() < str.length()) {
			return result;
		}
		return str;
	}

	public static void main(String[] args) {
		String str = "abbccccccde";
		String str2 = compressBetter(str);
		System.out.println("Old String (len = " + str.length() + "): " + str);
		System.out.println("New String (len = " + str2.length() + "): " + str2);

	}
}
