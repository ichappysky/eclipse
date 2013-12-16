package chapter09RecursionAndDP;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

import common.AssortedMethods;

public class PathBetweenMatrixCorners {
	public static int[][] maze = new int[10][10];

	public static boolean getPath(int x, int y, ArrayList<Point> path,
			Map<Point, Boolean> cache) {
		Point p = new Point(x, y);
		if (cache.containsKey(p)) {
			return cache.get(p);
		}

		boolean result = false;
		if (x == 0 && y == 0) {
			result = true;
		}
		if (x >= 1 && maze[x - 1][y] > 0) {
			result = getPath(x - 1, y, path, cache);
		}
		if (!result && y >= 1 && maze[x][y - 1] > 0) {
			result = getPath(x, y - 1, path, cache);
		}

		cache.put(p, result);
		if (result) {
			path.add(p);
		}
		return result;
	}

	public static boolean isFree(int x, int y) {
		if (maze[x][y] == 0) {
			return false;
		} else {
			return true;
		}
	}

	public static void main(String[] args) {
		maze = AssortedMethods.randomMatrix(5, 5, 0, 5);
		AssortedMethods.printMatrix(maze);
		ArrayList<Point> path = new ArrayList<Point>();
		Hashtable<Point, Boolean> cache = new Hashtable<Point, Boolean>();
		boolean success = getPath(4, 4, path, cache);
		if (success) {
			String s = AssortedMethods.listOfPointsToString(path);
			System.out.println(s);
		} else {
			System.out.println("No path found.");
		}
	}

}
