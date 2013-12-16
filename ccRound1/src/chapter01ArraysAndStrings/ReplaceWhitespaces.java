package chapter01ArraysAndStrings;

public class ReplaceWhitespaces {
	public static void replaceSpaces(char[] str, int length) {
		if (length <= 0 || str == null || str.length == 0) {
			return;
		}

		int count = 0;
		for (int i = 0; i < length; i++) {
			if (str[i] == ' ') {
				count++;
			}
		}

		int newLen = length + count * 2;
		for (int i = length - 1, j = newLen - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				str[j--] = '0';
				str[j--] = '2';
				str[j--] = '%';
			} else {
				str[j--] = str[i];
			}
		}

	}

	public static void main(String[] args) {
		String str = "abc d e f";
		char[] arr = new char[str.length() + 3 * 2 + 1];
		for (int i = 0; i < str.length(); i++) {
			arr[i] = str.charAt(i);
		}
		replaceSpaces(arr, str.length());
		System.out.println("\"" + String.valueOf(arr) + "\"");
	}
}
