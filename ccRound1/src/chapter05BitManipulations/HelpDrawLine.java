package chapter05BitManipulations;

public class HelpDrawLine {

	public static void drawLineB(byte[] screen, int width, int x1, int x2, int y) {
		int start_offset = x1 % 8;
		int first_full_byte = x1 / 8;
		if (start_offset != 0) {
			first_full_byte++;
		}

		int end_offset = x2 % 8;
		int last_full_byte = x2 / 8;
		if (end_offset != 7) {
			last_full_byte--;
		}

		// Set full bytes
		for (int b = first_full_byte; b <= last_full_byte; b++) {
			screen[(width / 8) * y + b] = (byte) 0xFF;
		}

		byte start_mask = (byte) (0xFF >> start_offset);
		byte end_mask = (byte) ~(0xFF >> (end_offset + 1));

		// Set start and end of line
		if ((x1 / 8) == (x2 / 8)) { // If x1 and x2 are in the same byte
			byte mask = (byte) (start_mask & end_mask);
			screen[(width / 8) * y + (x1 / 8)] |= mask;
		} else {
			if (start_offset != 0) {
				int byte_number = (width / 8) * y + first_full_byte - 1;
				screen[byte_number] |= start_mask;
			}
			if (end_offset != 7) {
				int byte_number = (width / 8) * y + last_full_byte + 1;
				screen[byte_number] |= end_mask;
			}
		}
	}

	public static void drawLine(byte[] screen, int width, int a, int b, int y) {
		int a_offset = a % 8;
		int a_firstFullByte = a / 8;
		if (a_offset != 0) {
			a_firstFullByte++;
		}

		int b_offset = b % 8;
		int b_lastFullByte = b / 8;
		if (b_offset != 7) {
			b_lastFullByte--;
		}

		for (int i = a_firstFullByte; i <= b_lastFullByte; i++) {
			screen[width/8*y+i] = (byte) 0xFF;
		}

		byte aMask = (byte) (0xFF >> a_offset);
		byte bMask = (byte) (~(0xFF >> (b_offset + 1)));
		if (a / 8 == b / 8) {
			byte mask = (byte) (aMask & bMask);
			screen[width / 8 * y + a / 8] |= mask;
		} else {
			if (a_offset != 0) {
				screen[width / 8 * y + a / 8] |= aMask;
			}
			if (b_offset != 7) {
				screen[width / 8 * y + b / 8] |= bMask;
			}
		}

	}

	public static void printByte(byte b) {
		for (int i = 7; i >= 0; i--) {
			System.out.print((b >> i) & 1);
		}
	}

	public static void printScreen(byte[] screen, int width) {
		int height = screen.length * 8 / width;
		for (int r = 0; r < height; r++) {
			for (int c = 0; c < width; c += 8) {
				byte b = screen[computeByteNum(width, c, r)];
				printByte(b);
			}
			System.out.println("");
		}
	}

	public static int computeByteNum(int width, int x, int y) {
		return (width * y + x) / 8;
	}

	public static void main(String[] args) {
		int width = 8 * 4;
		int height = 15;
		byte[] screen = new byte[width * height / 8];


		// screen[1] = 13;

		drawLine(screen, width, 7,15, 2);

		printScreen(screen, width);
	}
}
