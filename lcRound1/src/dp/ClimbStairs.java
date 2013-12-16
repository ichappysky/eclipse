package dp;


public class ClimbStairs {
	public int climbStairs(int n) {
//        Map<Integer, Integer> ways = new HashMap();
		int[] ways = new int[n+1];
		ways[0] =1;
		ways[1] =1;
        return helper(n, ways);
        
    }
    
    private int helper(int n, int[] ways) {
        if (ways[n] >0) {
            return ways[n];
        }
        
        int result = helper(n-1, ways) + helper(n-2, ways);
        ways[n] = result;
        return result;
        
    }
    
    
}