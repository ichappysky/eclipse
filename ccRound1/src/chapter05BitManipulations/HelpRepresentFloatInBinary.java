package chapter05BitManipulations;

public class HelpRepresentFloatInBinary {
	public static String printBinary(double f) {
		StringBuilder sb = new StringBuilder();
		sb.append(".");
		double num = f;
		int count = 0;
		while (num > 0 && count < 32) {
			num *= 2;
			if (num >= 1) {
				sb.append("1");
				num -= 1;
			} else {
				sb.append("0");
			}
			count++;
		}

		return sb.toString();
	}

	public static String printBinary2(double num) {
		if (num >= 1 || num <= 0) {
			return "ERROR";
		}

		StringBuilder binary = new StringBuilder();
		binary.append(".");
		while (num > 0) {
			/* Setting a limit on length: 32 characters */
			if (binary.length() > 32) {
				break;
			}
			double r = num * 2;
			if (r >= 1) {
				binary.append(1);
				num = r - 1;
			} else {
				binary.append(0);
				num = r;
			}
		}
		return binary.toString();
	}

	public static void main(String[] args) {
		String bs = printBinary(.125);
		System.out.println(printBinary2(.125));

		for (int i = 0; i < 1000; i++) {
			double num = i / 1000.0;
			String binary = printBinary(num);
			System.out.println(binary.equals(printBinary2(num)));
			// String binary2 = printBinary2(num);
			if (!binary.equals("ERROR")) {
				System.out.println(binary + "---\n" + printBinary2(num));
			}
		}
	}
}
