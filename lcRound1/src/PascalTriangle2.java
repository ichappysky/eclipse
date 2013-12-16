import java.util.ArrayList;


public class PascalTriangle2 {
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        if (rowIndex<0) {
        	return result;
        }
        
        result.add(1);
        for(int i=1; i<=rowIndex; i++) {
        	int prev =1;
        	for (int j=1; j<i; j++) {
        		int curNewVal = prev + result.get(j);
        		prev = result.get(j);
        		result.set(j, curNewVal);
        	}
        	result.add(1);
        }
        return result;
    }
    
    public static void main(String[] args) {
    	PascalTriangle2 t = new PascalTriangle2();
    	
    	System.out.println(t.getRow(3));
    	
    }
}
