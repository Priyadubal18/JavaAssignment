import java.util.HashMap;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2, 7, 11, 15};
		int target=18;
		int[] index = new int[2];
		index = twoSum(nums,target);
		for (int i :index){
		System.out.println("The index are: "+i);
		}
		
	} // end main
	
	 public static  int[] twoSum(int[] numbers, int target) {	        
	        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
	        for(int i = 0; i < numbers.length; i++){
	            Integer diff = (Integer)(target - numbers[i]);
	            if(hash.containsKey(diff)){
	            	System.out.println(hash.get(diff));
	                int toReturn[] = {hash.get(diff), i};
	                return toReturn;
	            }

	            hash.put(numbers[i], i);

	        }
	        
	        return null;
	        
	    }

}
