package string;

public class IsStringPalindrome {
    public boolean isPalindrome(String s) {
        if(s == null) return false;
        
        // another approach can be while(h<t) h++, t-- 
        for (int h=0, t= s.length() -1; h<=t; h++, t--) {
        	char hc = s.charAt(h);
        	char tc = s.charAt(t);
            while (h<=t && !isValidChar(hc)) {
            	
            	h++;
            	if (h>t) {
            		return true;
            	}
            	hc = s.charAt(h);
            }
            while (h<=t && !isValidChar(tc) ) {
                t--;
                tc = s.charAt(t);
            }
            if (!equalIgnoreCase(hc, tc)) {
            	return false;
            }
        
        }
        return true;
        
    }
    
    public boolean isValidChar(char c) {
        return (c>='a' && c<='z') || (c>='A' && c<='Z') || (c>='0' && c<='9');
    }
    
    public boolean equalIgnoreCase(char a, char b) {
        return a==b || a==(b+32) || a==(b-32);
    }
	
    public static void main(String [] args) {
    	IsStringPalindrome t = new IsStringPalindrome();
    	System.out.println(t.isPalindrome(",M 9y\"yj\"j9 M,"));
    }
}
