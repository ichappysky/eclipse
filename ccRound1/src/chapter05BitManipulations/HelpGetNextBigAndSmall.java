package chapter05BitManipulations;

public class HelpGetNextBigAndSmall {

	public static int getNext(int n) {
		int countZeros = 0;
		int countOnes = 0;
		int tmp = n;
		while ((tmp & 1) == 0 && (tmp) != 0) {
			countZeros++;
			tmp >>= 1;
		}
		while ((tmp & 1) == 1) {
			countOnes++;
			tmp >>= 1;
		}

		if ((countZeros + countOnes) == 31) {
			return -1;
		}

		n |= (1 << (countZeros + countOnes));
		n &= ~((1 << (countZeros + countOnes)) - 1);
		n |= (1 << (countOnes - 1)) - 1;
		return n;
	}

	public static int getPrev(int n) {
		int countZeros = 0;
		int countOnes = 0;
		int tmp = n;
		while ((tmp & 1) == 1 && (tmp) != 0) {
			countOnes++;
			tmp >>= 1;
		}

		if (tmp == 0) {
			return -1;
		}
		while ((tmp & 1) == 0 && (tmp) != 0) {
			countZeros++;
			tmp >>= 1;
		}

		n |= ((~0) << (countZeros + countOnes + 1));
		int mask = (1 << (countOnes + 1)) - 1;
		mask <<= (countZeros - 1);
		n |= mask;
		return n;
	}

	public static void binPrint(int i) {
		System.out.println(i + ": " + Integer.toBinaryString(i));
	}

	public static void main(String[] args) {
		int i = ~1;
		binPrint(i);
		System.out.println(getNext(i));
		// for (int i = 0; i < 200; i++) {
		// int p1 = getPrevSlow(i);
		// int p2 = getPrev(i);
		//
		// int n1 = getNextSlow(i);
		// int n2 = getNext(i);
		//
		// if (p1 != p2 || n1 != n2) {
		// binPrint(i);
		// binPrint(p1);
		// binPrint(p2);
		// binPrint(n1);
		// binPrint(n2);
		// System.out.println("");
		// }
		// }
		// System.out.println("Done!");
	}

	// copied. no need to look into
	public static int getNextSlow(int i) {
		if (!hasValidNext(i)) {
			return -1;
		}
		int num_ones = countOnes(i);
		i++;
		while (countOnes(i) != num_ones) {
			i++;
		}
		return i;
	}

	public static int getPrevSlow(int i) {
		if (!hasValidPrev(i)) {
			return -1;
		}
		int num_ones = countOnes(i);
		i--;
		while (countOnes(i) != num_ones) {
			i--;
		}
		return i;
	}

	public static boolean hasValidNext(int i) {
		if (i == 0) {
			return false;
		}
		int count = 0;
		while ((i & 1) == 0) {
			i >>= 1;
			count++;
		}
		while ((i & 1) == 1) {
			i >>= 1;
			count++;
		}
		if (count == 31) {
			return false;
		}
		return true;
	}

	public static boolean hasValidPrev(int i) {
		while ((i & 1) == 1) {
			i >>= 1;
		}
		if (i == 0) {
			return false;
		}
		return true;
	}

	public static int countOnes(int i) {
		int count = 0;
		while (i > 0) {
			if ((i & 1) == 1) {
				count++;
			}
			i = i >> 1;
		}
		return count;
	}
}
