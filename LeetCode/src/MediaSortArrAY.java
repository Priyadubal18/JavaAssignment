
public class MediaSortArrAY {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1={2,4,8};
		int[] nums2 = {};
		double x = findMedianSortedArrays(nums1, nums2);
		System.out.println(x);
	}
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
	     int l1 = nums1.length;
	     int l2 = nums2.length;	      
	     
	     int p=0;	 
	     int j=0;
	     double median=0;
	     
	     if(l1 == 0){
	    	int l2mid = l2/2; 
	    	if(l2% 2 == 0 ) 
	    	 {median =( nums2[l2mid] + nums2[l2mid-1])/2;}
	    	else{
	    		median = nums2[l2mid] ;
	    	}
	    	}
	     if(l2 == 0){
		    	int l1mid = l1/2; 
		    	if(l1% 2 == 0 ) 
		    	 {median =( nums1[l1mid] + nums1[l1mid-1])/2;}
		    	else{
		    		median = nums1[l1mid] ;
		    	}
		     }
	     
	          
	     int[] merge = new int[l1+l2];     
	     int  i=0;
	   while(p < nums1.length && j < nums2.length )  {	    	    	 
	    	 if (nums1[p] < nums2[j]){
	    		 merge[i] = nums1[p];
	    		 p++;	    		 
	    	 }//end if
	    	 else{
	    		 merge[i] = nums2[j];
	    		 j++;
	    	 }
	    	 i++;
	     }// end while
	   
	   while(p < nums1.length){
		   merge[i] = nums1[p];
  		   p++;
  		   i++;
	   }
	   
	   while(j < nums2.length){
		   merge[i] = nums2[j];
  		   j++;
  		   i++;
	   }
	   
	   
	   
	     int mid =  merge.length/2;
	     if(merge.length%2 == 0){
	    	  double x = merge[mid];
	    	  double y = merge[mid-1];
	    	  median =  (x+y)/2;
	     }
	     else{
	    	  median= merge[mid];
	    	 }
	     return median;
	     }
      
}
