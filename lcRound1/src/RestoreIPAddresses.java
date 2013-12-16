import java.util.ArrayList;

public class RestoreIPAddresses {
	public ArrayList<String> restoreIpAddresses(String s) {
		if (s == null) {
			return new ArrayList<String>();
		}

		return helper(s, 0, 4);
	}

	private ArrayList<String> helper(String s, int startIndex,
			int numOfSegsNeeded) {
		ArrayList<String> result = new ArrayList<String>();
		if (startIndex > s.length() - 1) {
			return result;
		}
		if (numOfSegsNeeded == 1) {
			String curSeg = s.substring(startIndex, s.length());
			if (isStringInRange(curSeg)) {
				result.add(curSeg);
			}
			return result;
		}

		for (int i = 1; i < 4; i++) {
			if (startIndex + i > s.length()) {
				break;
			}
			String curSeg = s.substring(startIndex, startIndex + i);
			if (isStringInRange(curSeg)) {
				ArrayList<String> restSegsList = helper(s, startIndex + i,
						numOfSegsNeeded - 1);
				for (String restSegs : restSegsList) {
					String oneIp = curSeg + "." + restSegs;
					result.add(oneIp);
				}

			}
		}
		return result;
	}

	private boolean isStringInRange(String s) {
		// 0xx is not okay
		if (s.startsWith("0") && s.length() > 1) {
			return false;
		}
		if (s.length()>3) {
			return false;
		}
		int tmp = Integer.valueOf(s);
		return tmp < 256;
	}

	public static void main(String[] args) {
		RestoreIPAddresses t = new RestoreIPAddresses();
		System.out.println(t.restoreIpAddresses("0279245587303"));

	}
}