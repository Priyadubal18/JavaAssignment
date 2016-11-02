import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String s ="abcdpwwkew";
			System.out.println("l"+lengthOfLongestSubstring1(s));
		
	}

	
	    public static int lengthOfLongestSubstring(String s) {
	    	if(s==null){
	            return 0;
	        }	     
	        int max = 0;	     
	        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	        int start=0;
	     
	        for(int i=0; i<s.length(); i++){
	            char c = s.charAt(i);
	            if(map.containsKey(c)){
	                max = Math.max(max, map.size()); 
	                System.out.println("m"+ max);
	                while(map.containsKey(c)){
	                    System.out.println( map.remove(s.charAt(start)));
	                    start++;
	                }
	     
	                map.put(c, i);
	            }else{
	                map.put(c, i);
	            }
	        }
	     
	        max = Math.max(max, map.size());  
	     
	        return max;
	}
	    
	    public static int lengthOfLongestSubstring1(String s) {
	        if(s==null)
	            return 0;
		char[] arr = s.toCharArray();
		int pre = 0;
	 
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	 
		for (int i = 0; i < arr.length; i++) {
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], i);
			} else {
				pre = Math.max(pre, map.size());
				i = map.get(arr[i]);
				map.clear();
			}
		}
	 
		return Math.max(pre, map.size());
	}

}