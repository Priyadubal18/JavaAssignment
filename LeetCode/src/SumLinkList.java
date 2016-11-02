import Class.ListNode;

public class SumLinkList {
	
	public static void main(String[] args) {
		ListNode l= new ListNode(2);
		ListNode l1 =l;
		l1.next =  new ListNode(4);
		l1= l1.next;
		l1.next = new ListNode(3);
		l1= l1.next;
		
		ListNode l2= new ListNode(5);
		l2.next =  new ListNode(6);
		l2= l2.next;
		l2.next = new ListNode(4);
		l2= l2.next;
		System.out.println("l"+l);
		//while(l1 != null){
		 // System.out.println("l1"+l1); }
	      System.out.println("l2"+l2);
				
	}
	
	
	 public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        ListNode result = new ListNode(0);
	        System.out.println("result"+result);
	        System.out.println("l1"+l1);
	        System.out.println("l2"+l2);
	        ListNode p1= l1;ListNode p2= l2;
	        int carry =0;
	        
	        while(p1 != null || p2 !=  null){
	            
	            if(p1 != null){
	                carry += p1.val;
	                p1= p1.next;
	                            }
	                            
	             if(p2 != null){
	                carry += p2.val;
	                p2 = p2.next;
	            }
	 
	            
	            result.next =new ListNode(carry%10);
	            result = result.next;
	            
	            carry = carry/10;
	        }//end while
	        
	        if(carry == 1){
	          result.next= new ListNode(1); 
	            
	        }
	        
	        return result.next;
	        
	    }
}
