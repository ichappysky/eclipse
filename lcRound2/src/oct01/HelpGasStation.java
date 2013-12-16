package oct01;

/**
 * There are N gas stations along a circular route, where the amount of gas at
 * station i is gas[i].
 * 
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to
 * travel from station i to its next station (i+1). You begin the journey with
 * an empty tank at one of the gas stations.
 * 
 * Return the starting gas station's index if you can travel around the circuit
 * once, otherwise return -1.
 * 
 * @author yongz
 * 
 */
public class HelpGasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {

		int totalCost = 0;
		int totalGas = 0;
		int curGasLeft = 0;
		int startIndex = 0;
		for (int i = 0; i < gas.length; i++) {
			totalCost += cost[i];
			totalGas += gas[i];
			curGasLeft += (gas[i] - cost[i]);
			if (curGasLeft < 0) {
				curGasLeft = 0;
				startIndex = i + 1;
			}
		}
		if (totalCost > totalGas)
			return -1;
		return startIndex;
	}

	public static void main(String[] x) {
		int[] gas = { 6, 5, 1, 3, 12 };
		int[] cost = { 4, 5, 2, 5, 5 };
		HelpGasStation t = new HelpGasStation();
		System.out.println(t.canCompleteCircuit(gas, cost));
	}
}
