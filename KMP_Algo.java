import java.util.*;

class Test {
	public static void main (String[] args) {
		String s1="AAAAAABAAB";
		String pattern="AAB";
		int[] LPS = lpsHelper(pattern);
		int i = 0;
		int j = 0;
		boolean flag=false;
        while (i < s1.length()) {
            if (pattern.charAt(j) == s1.charAt(i)) {
                j++;
                i++;
            }
            if (j == pattern.length()) {
                System.out.println("Found pattern "+ "at index " + (i - j));
                
                j = LPS[j - 1];
                flag=true;
            }
            else if (i < s1.length() && pattern.charAt(j) != s1.charAt(i)) {
                if (j != 0)
                    j = LPS[j - 1];
                else
                    i = i + 1;
            }
        }
        if(!flag){
            System.out.println("Not Found");
        }
	}
	public static int[] lpsHelper(String pattern){
	    int[] lps=new int[pattern.length()];
	    int len = 0;
        int i = 1;
        lps[0] = 0;
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else{
                if (len != 0) {
                    len = lps[len - 1];
                }
                else
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
        return lps;
	}
}
