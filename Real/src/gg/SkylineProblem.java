package gg;

public class SkylineProblem {
	public static Skyline FindSkyline(Bldg[] B, int lo, int hi) {
		if (lo == hi) {
			Skyline sk = new Skyline(2);
			sk.Append(new strip(B[lo].lx, B[lo].h));
			sk.Append(new strip(B[lo].rx, 0));
			return sk;
		}
		int mid = (lo + hi) / 2;
		Skyline sk1 = FindSkyline(B, lo, mid);
		Skyline sk2 = FindSkyline(B, mid + 1, hi);
		return MergeSkyline(sk1, sk2);
	}

	static Skyline MergeSkyline(Skyline list1, Skyline list2) {
		Skyline SK = new Skyline(list1.Count + list2.Count); // Allocate array
																// space
		int curH1 = 0;
		int curH2 = 0;
		while ((list1.Count > 0) && (list2.Count > 0))
			if (list1.Head().lx < list2.Head().lx) {
				int CurX = list1.Head().lx;
				curH1 = list1.Head().h;
				
				SK.Append(new strip(CurX, Math.max(curH1, curH2)));
				list1.RemoveHead();
			} else {
				int CurX = list2.Head().lx;
				curH2 = list2.Head().h;

				SK.Append(new strip(CurX, Math.max(curH1, curH2)));
				list2.RemoveHead();
			}
		while (list1.Count > 0) // Append SK1 to Skyline
		{
			strip str = list1.RemoveHead();
			SK.Append(str);
		}
		while (list2.Count > 0) // Append SK2 to Skyline
		{
			strip str = list2.RemoveHead();
			SK.Append(str);
		}
		return SK;
	}

	public static void main(String[] x) {
		Bldg[] B = new Bldg[4];
		B[0] = new Bldg(1, 11, 5);
		B[1] = new Bldg(2,6,7);
		B[2] = new Bldg(3, 13, 9);
		B[3] = new Bldg(12,7,16);
		System.out.println(FindSkyline(B, 0 ,3));
	}

}

class Bldg {
	int lx, rx, h;

	public Bldg(int x1, int h1, int x2) {
		lx = x1;
		h = h1;
		rx = x2;
	}
}

class strip {
	int lx, h;

	public strip(int x1, int h1) {
		lx = x1;
		h = h1;
	}
}

class Skyline {
	strip[] strips;
	public int Count;
	int StartLoc;

	public Skyline(int n) {
		Count = 0;
		StartLoc = 0;
		strips = new strip[n];
	}

	public void Append(strip str) {
		strips[StartLoc + Count] = str;
		Count++;
	}

	public strip Head() {
		return strips[StartLoc];
	}

	public strip RemoveHead() {
		strip str = strips[StartLoc];
		Count--;
		StartLoc++;
		return str;
	}

	public String toString() {
		String str = "";
		for (int i = StartLoc; i < StartLoc + Count; i++) {
			if (i > StartLoc)
				str = str + ",";
			str = str + strips[i].lx + "," + strips[i].h;
		}
		return "(" + str + ")";
	}
}
