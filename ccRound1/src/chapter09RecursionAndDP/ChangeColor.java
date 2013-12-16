package chapter09RecursionAndDP;

public class ChangeColor {
	public enum Color {
		Black, White, Red, Yellow, Green
	}

	public static String PrintColor(Color c) {
		switch (c) {
		case Black:
			return "B";
		case White:
			return "W";
		case Red:
			return "R";
		case Yellow:
			return "Y";
		case Green:
			return "G";
		}
		return "X";
	}

	public static void PrintScreen(Color[][] screen) {
		for (int i = 0; i < screen.length; i++) {
			for (int j = 0; j < screen[0].length; j++) {
				System.out.print(PrintColor(screen[i][j]));
			}
			System.out.println();
		}
	}

	public static int randomInt(int n) {
		return (int) (Math.random() * n);
	}

	public static void PaintFill(Color[][] screen, int x, int y, Color ncolor) {
		if (screen[x][y] == ncolor) {
			return ;
		}
		PaintFill(screen, x, y, screen[x][y], ncolor);
	}

	public static void PaintFill(Color[][] screen, int x, int y, Color ocolor,
			Color ncolor) {
		if (x < 0 || x >= screen.length || y < 0 || y >= screen[0].length) {
			return;
		}

		if (screen[x][y] == ocolor) {
			screen[x][y] = ncolor;
			PaintFill(screen, x - 1, y, ocolor, ncolor);
			PaintFill(screen, x + 1, y, ocolor, ncolor);
			PaintFill(screen, x, y - 1, ocolor, ncolor);
			PaintFill(screen, x, y + 1, ocolor, ncolor);
		}
	}

	public static void main(String[] args) {
		int N = 4;
		Color[][] screen = new Color[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				screen[i][j] = Color.Black;
			}
		}
		for (int i = 0; i < N*N; i++) {
			screen[randomInt(N)][randomInt(N)] = Color.Green;
		}
		PrintScreen(screen);
		PaintFill(screen, 2, 2, Color.White);
		System.out.println();
		PrintScreen(screen);
	}
}
