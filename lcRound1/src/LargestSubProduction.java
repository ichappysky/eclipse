// find largest subsequence of production
public class LargestSubProduction {
    public static void main(String [] args) {
    	double[] a = {1.63,0.68,-3,-2.21,-0.72};
    	System.out.println(getLSP(a));
    }
    
    public static double getLSP(double[] num) {
    	double globalLargest = 0;
    	double curPos = 1;
    	double curNeg = 1;
    	
    	for (int i =0; i< num.length; i++ ) {
    		double curNum = num[i];
    		if (curNum > 0 ) {
    			curPos *= curNum;
    			if (curNeg != 1) {
    				curNeg *= curNum;
    			}
    		} else if ( curNum <0) {
    			if (curNeg == 1) {
    				curNeg = curPos * curNum;
    				curPos  = 1;
    			} else {
    				double temp = curNeg;
    				curNeg = curPos * curNum;
    				curPos = temp* curNum;
    			}
    		} else {
    			curPos = 1;
    			curNeg = 1;
    		}
    		// store curPos to globalLargest if it's larger
    		if (curPos > globalLargest) {
    			globalLargest = curPos;
    		}
    		//reset to 1 if less than 1
    		if (curPos<1) {
    			curPos =1;
    		}
    	}
    	return globalLargest;
    }
}
