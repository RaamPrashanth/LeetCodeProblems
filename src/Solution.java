

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Solution {
		
	public static void main(String[] args) {
		Solution temp = new Solution();
		///temp.divide(-2147483648, -1);
				
		/*ListNode l1 = temp.new ListNode(1);
		ListNode dummy = l1;
		dummy.next = temp.new ListNode(4);
		dummy = dummy.next;
		dummy.next = temp.new ListNode(5);
		
		ListNode l2 = temp.new ListNode(1);
		dummy = l2;
		dummy.next = temp.new ListNode(3);
		dummy = dummy.next;
		dummy.next = temp.new ListNode(4);

		ListNode l3 = temp.new ListNode(2);
		l3.next = temp.new ListNode(6);
		
		
		ListNode[] lists = {l1, l2, l3};
		temp.mergeKLists(lists);*/

		int[] nums = {1, 1, 2};
		temp.removeDuplicates(nums);
		String s = "Bob hit a ball, the hit BALL flew far after it was hit.";
		String[] st = new String[]{"hit"};
		temp.mostCommonWord(s, st);
		
	}
	
    public int[] twoSum(int[] nums, int target) {
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	map.keySet().iterator();
    	for (int i = 0; i < nums.length; i++) {
    		int diff = target-nums[i];
    		if (map.containsKey(diff)) {
    			return new int[] {i, map.get(diff)};
    		}
    		map.put(nums[i], i);
    	}
        return new int[] {};
    }
    
     public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
     }
     
     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      	ListNode returnNode = new ListNode(0);
        ListNode iterator = returnNode;
      	int carry = 0;
      	int temp = 0;
      	
      	while (l1 != null || l2 != null) {
  			temp = carry;
  			if (l1 != null) {
  				l1 = l1.next;
  			    temp += l1.val;
  			}
  			if (l2 != null) {
  				l2 = l2.next;
  				temp += l2.val;
  			}
  			if (temp > 9) {
  				carry = temp/10;
  				temp = temp%10;
  			} else {
  				carry = 0;
  			}
  			iterator.next = new ListNode(temp);
  			iterator = iterator.next;
  				
      	}
      	
      	if (carry > 0) {
      		iterator.next = new ListNode(carry);
      	}
      	
          return returnNode.next;    
      }
     
     public int lengthOfLongestSubstring(String s) {
    	int length = 0;
    	ArrayList<Character> list = new ArrayList<Character>();
    	for (int i = 0; i < s.length(); i++) {
    		if (list.contains(s.charAt(i))) {
    			while (list.get(0) != s.charAt(i)) {
    				list.remove(0);
    			}
    			list.remove(0);
    		}
    		list.add(s.charAt(i));
    		if (list.size() > length) {
    			length = list.size();
    		}
    	}
        return length; 
     }
     
     public double findMedianSortedArrays(int[] nums1, int[] nums2) {
         double median = 0.0;
         ArrayList<Integer> list = new ArrayList<Integer>();
         int i = 0, k = 0;
    	 while ((i < nums1.length) && (k < nums2.length)) {
    		 if (nums1[i] < nums2[k]) {
    			 list.add(nums1[i]);
    			 i++;
    		 } else {
    			 list.add(nums2[k]);
    			 k++;
    		 }
         }
    	 for (int j = i; j < nums1.length; j++) {
    		 list.add(nums1[j]);
         }
    	 for (int j = k; j < nums2.length; j++) {
    		 list.add(nums2[j]);
         }
         if (list.isEmpty()) {
             return 0.0;
         }
         System.out.println(list);
    	 if ((list.size() % 2) == 0) {
    		 median = (list.get(list.size()/2) + list.get((list.size()/2)-1))/2;
    	 } else {
             if (list.size() == 1) {
                 median = list.get(0);
             } else {
    		    median = list.get((list.size()/2) - 1);
             }
    	 }
    	 return median;
     }
     
     public String longestPalindrome(String s) {
    	 if (s.length() == 1) {
    		 return s;
    	 } else if (s.length() == 2) {
    		 if (s.charAt(0) == s.charAt(1)) {
    			 return s;
    		 } else { 
    			 return s.charAt(0) + "";
    		 }
    	 }
    	 String palindrome = "";
         return palindrome;
     }
     
     public int myAtoi(String str) {
    	 int num = 0;
    	 int prevNum = 0;
    	 int index = 0;
    	 int minus = 1;
    	 boolean max = false;
    	 //Remove all white spaces
    	 while (index < str.length() && str.charAt(index) == ' ') {
    		 index++;
    	 }
    	 
    	 //Check for signs
         if (index < str.length()) {
             if (str.charAt(index) == '-') {
                 minus = -1;
                 index++;
             } else if (str.charAt(index) == '+') {
                 index++;
             }
         }
    	 
    	 //Read Numbers
    	 while (index < str.length()) {
    		 prevNum = num;
    		 if (str.charAt(index) >= '0' && str.charAt(index) <= '9') {
    			 //Ascii value of '0' is 48, we get the digit when we subtract 48 from that digits ascii value
    			 num = (num*10) + (str.charAt(index)-'0'); 
	    		 //Check if the integer crossed max value
	        	 if (num/10 != prevNum) {
	        		 max = true;
	        	 }
    		 } else {
    			 break;
    		 }
    		 index++;
    	 }
         
         if (max && (minus == -1)) {
        	 return Integer.MIN_VALUE;
         } else if (max) {
        	 return Integer.MAX_VALUE;
         }
         
         num = num * minus;
    	 return num;
     }
     
     public int myAtoi1(String str) {
    	 int ret = 0;
    	 int prevRet = 0;
    	 boolean minus = false;
    	 boolean max = false;
    	 boolean isNum = false;
         for (int i = 0; i < str.length(); i++) {
        	 prevRet = ret;
        	 switch (str.charAt(i)) {
        	 	case '1' : ret = (ret*10) + 1; 
	 			   		   isNum = true;
        	 			   break;
        	 	case '2' : ret = (ret*10) + 2; 
	 			   		   isNum = true;
	 			   		   break;
        	 	case '3' : ret = (ret*10) + 3; 
	 			   		   isNum = true;
	 			   		   break;
        	 	case '4' : ret = (ret*10) + 4; 
        	 			   isNum = true; 
	 			   		   break;
        	 	case '5' : ret = (ret*10) + 5; 
	 			   		   isNum = true;
	 			   		   break;
        	 	case '6' : ret = (ret*10) + 6;
	 			   		   isNum = true;
	 			   		   break;
        	 	case '7' : ret = (ret*10) + 7; 
	 			   		   isNum = true;
	 			   		   break;
        	 	case '8' : ret = (ret*10) + 8; 
        	 			   isNum = true;
	 			   		   break;
        	 	case '9' : ret = (ret*10) + 9; 
        	 			   isNum = true;
        	 			   break;
        	 	case '0' : ret = (ret*10) + 0; 
        	 			   isNum = true;
	 			   		   break;
        	 	case '-' : if (!isNum) {
        	 				minus = true;
        	 			   } else {
        	 				  i = str.length();
        	 			   }
        	     		   isNum = true;
	 			   		   break;
        	 	case '+' : if (isNum) {
	 			   				i = str.length();
	 			   			}
	     		   			isNum = true;
	     		   			break;
        	 	case ' ' : if (isNum) {
        	 				i = str.length();
        	 			   }
        	 			   break;
	 			default:
	 				i = str.length();
	 				
        	 }
        	 
        	 if (ret != prevRet && ret/10 != prevRet) {
        		 max = true;
        	 }
         }
         
         if (minus) {
        	 ret = ret * (-1);
         }
         
         if (max && minus) {
        	 return Integer.MIN_VALUE;
         } else if (max) {
        	 return Integer.MAX_VALUE;
         }
         
         return ret;
     }
     
     public List<List<Integer>> threeSum(int[] nums) {
    	 List<List<Integer>> ret = new ArrayList<List<Integer>>();
    	 ArrayList<Integer> duplicates = new ArrayList<Integer>();
    	 for (int i = 0; i < nums.length; i++) {
    		 if(duplicates.contains(nums[i])) {
    			 continue;
    		 }
    		 duplicates.add(nums[i]);
             HashMap<Integer, Integer> accm = new HashMap<Integer, Integer>();
    		 for (int j=i+1; j<nums.length; j++) {
    			 if (accm.containsKey(0-nums[j])) {
    				 ArrayList<Integer> list = new ArrayList<Integer>();
    				 list.add(nums[i]);
    				 list.add(nums[accm.get(0-nums[j])]);
    				 list.add(nums[j]);
                     if (!ret.contains(list))
    				 ret.add(list);
    			 }
    			 accm.put(nums[i] + nums[j], j);
    		 }
    		 
    	 }
         return ret;
     }
     
     public boolean isPalindrome(int x) {
         if (x < 0) {
             return false;
         }
         
         if (x == 0) {
             return true;
         }
         int reverse = 0;
         int temp = x;
         while (temp != 0) {
             reverse = reverse * 10 + temp%10;
             temp = temp/10;
         }

         if (reverse == x) {
             return true;
         } else {
             return false;
         }
     }
     
     public String reverseWords(String s) {
         String reverse = "";
         String[] split = s.split(" ");
         for (int i = split.length-1; i >= 0; i--) {
        	 if (reverse.isEmpty()) {
        		 reverse = split[i];
        	 } else if (!split[i].isEmpty()){
        		 reverse = reverse + " " + split[i];
        	 }
         }
         reverse.trim();
         return reverse;
     }
     
     public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
         ListNode ret = new ListNode(0);
         ListNode iterator = ret;
         while (l1 != null && l2 != null) {
        	 if (l1.val < l2.val) {
        		 iterator.next = new ListNode(l1.val); 
        		 l1 = l1.next;
        	 } else {
        		 iterator.next = new ListNode(l2.val); 
        		 l2 = l2.next;
        	 }
        	 iterator = iterator.next;
         }
         
         if (l1 != null) {
        	 iterator.next = l1;
         }
         
         if (l2 != null) {
        	 iterator.next = l2;
         }
         
         return ret.next;
     }
     
     public boolean isValid(String s) {
    	 Stack<Character> stack = new Stack<Character>();
    	 
    	 for (int i=0; i<s.length(); i++) {
    		 switch(s.charAt(i)) {
    		 	case '(' :
    		 	case '{' :
    		 	case '[' :
    		 		stack.push(s.charAt(i));
    		 		break;
    		 	case ')' :
    		 		if (!stack.isEmpty() && stack.peek() == '(') {
    		 			stack.pop();
    		 		} else {
    		 			return false;
    		 		}
    		 		break;
    		 	case '}' :
    		 		if (!stack.isEmpty() && stack.peek() == '{') {
    		 			stack.pop();
    		 		} else {
    		 			return false;
    		 		}
    		 		break;
    		 	case ']' :
    		 		if (!stack.isEmpty() && stack.peek() == '[') {
    		 			stack.pop();
    		 		} else {
    		 			return false;
    		 		}
    		 		break;
    		 	default  :
    		 		return false;
    		 }
    	 }
    	 
         return stack.isEmpty();
     }
     
     public int divide(int dividend, int divisor) {
    	 if (dividend == 0 || divisor == 0) {
    		 return 0;
    	 }
    	 
    	 if (dividend == Integer.MAX_VALUE && divisor == 1) {
    		 return Integer.MAX_VALUE;
    	 }
    	 
     	 if (dividend == Integer.MIN_VALUE && divisor == -1) {
    		 return Integer.MAX_VALUE;
    	 }
    	 
         int quotient = 0;
    	 if (divisor > 0 && dividend > 0) {
           	while (dividend >= divisor) {
          		dividend = dividend - divisor;
          		++quotient;
          	}
    	 } else if (divisor < 0 && dividend < 0) {
    		 while (dividend <= divisor) {
           		dividend = dividend - divisor;
           		++quotient;
           		
           	}
    	 } else {
    		 while (Math.abs(dividend) >= Math.abs(divisor)) {
    			 dividend = dividend + divisor;
    			 quotient--;	 
    		 }
    	 }
         return quotient;
     }
     
     public ListNode mergeKLists(ListNode[] lists) {
    	 ListNode iterator = null;
    	 for (int i = 0; i < lists.length; i++) {
    		 iterator = mergeTwoLists(iterator, lists[i]);
    	 }
    	 return iterator;
     }
     
     public int removeDuplicates(int[] nums) {
    	 if (nums.length == 0) {
    		 return 0;
    	 }
    	 int j = 0;
    	 for (int i=1; i < nums.length; i++) {
    		 if (nums[i] != nums[j]) {
    			 nums[++j] = nums[i];
    		 }
    	 }
         return j+1;
     }
     
     public ListNode removeNthFromEnd(ListNode head, int n) {
    	 
    	 if (n == 0) {
    		 return head.next;
    	 }
    	 
         int index = 0;
         ListNode prev = null;
         ListNode iterator = head;
         while (iterator != null) {
        	 if (index == n) {
        		 prev.next = iterator.next;
        	 }
        	 prev = iterator;
        	 iterator = iterator.next;
         }
         
         return head;
     }
     
     /**public String longestCommonPrefix(String[] strs) {
         String ret = "";
         int j = 0;
         for (int i = 0; i<strs.length; i++) {
        	 
         }
         return ret;
     }**/
     
     public int missingNumber(int[] nums) {
    	 int sum = nums.length * (nums.length+1)/2;
         for (int n : nums) {
        	 sum -= n;
         }
         return sum;
     }
     
     public String numberToWords(int num) {
    	 StringBuilder sb = new StringBuilder();
         int pos = 0; // 0 - ones 1 - tens 2 - hundreds 3 - thousands 4 - 
         while (num > 0) {
        	 if (pos % 2 == 0) {
        		 sb.append(" " + getOnes(num/10));
        	 } else {
        		 //sb.append(c)
        	 }
        	 
         }
         
    	 if ((10 < num) && (num < 20)) {
    		 sb.append(" " +  getTeens(num));
    	 }
    	 
    	 return sb.toString().trim();
     }
     
     private String getOnes(int i) {
    	 switch(i) {
    	 	case 0 : return "";
    	 	case 1 : return "One";
    	 	case 2 : return "Two";
    	 	case 3 : return "Three";
    	 	case 4 : return "Four";
    	 	case 5 : return "Five";
    	 	case 6 : return "Six";
    	 	case 7 : return "Seven";
    	 	case 8 : return "Eight";
    	 	case 9 : return "Nine";
    	 	default : return "";
    	 }
     }
     
     private String getTens(int i) {
    	 switch(i) {
    	 	case 0 : return "";
    	 	case 1 : return "Ten";
    	 	case 2 : return "Twenty";
    	 	case 3 : return "Thirty";
    	 	case 4 : return "Fourty";
    	 	case 5 : return "Fivety";
    	 	case 6 : return "Sixty";
    	 	case 7 : return "Seventy";
    	 	case 8 : return "Eighty";
    	 	case 9 : return "Ninenty";
    	 	default : return "";
    	 }
     }
     
     private String getTeens(int i) {
    	 switch(i) {
    	 	case 10 : return "Ten";
    	 	case 11 : return "Eleven";
    	 	case 12 : return "Twelve";
    	 	case 13 : return "Thirteen";
    	 	case 14 : return "Fourteen";
    	 	case 15 : return "Fiveteen";
    	 	case 16 : return "Sixteen";
    	 	case 17 : return "Seventeen";
    	 	case 18 : return "Eighteen";
    	 	case 19 : return "Nineteen";
    	 	default : return "";
    	 }
     }
     
     public String longestCommonPrefix(String[] strs) {
         if (strs.length == 0)
             return "";
    	 String ret = strs[0];
    	 for (int i = 1; i < strs.length ; i++) {
    		 while (strs[i].indexOf(ret) != 0) {
    			 ret = ret.substring(0, ret.length()-1);
    			 if (ret == "") {
    				 return "";
    			 }
    		 }
    	 }
    	 
    	 return ret;
     }

     public ListNode reverseList(ListNode head) {
         ListNode preNode = null;
         ListNode curNode = null;
         
         while (head != null) {
        	 curNode = head;
        	 head = head.next;
        	 curNode.next = preNode;
        	 preNode = curNode;
         }
         
         return curNode;
     }
     
     public boolean hasCycle(ListNode head) {
    	 List<ListNode> validator = new ArrayList<ListNode>();
    	 while (head != null) {
    		 if (validator.contains(head)) {
    			 return true;
    		 } else {
    			 validator.add(head);
    			 head = head.next;
    		 }
    	 }
    	 
    	 return false;
    	 
     }
     
     public String mostCommonWord(String paragraph, String[] banned) {
         HashMap<String, Integer> map = new HashMap<String, Integer>();
         String[] para = paragraph.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
         
         for (String s : para) {
        	 if (map.containsKey(s)) {
        		 map.put(s, map.get(s)+1);
        	 } else {
        		 map.put(s,1);
        	 }
         }
         for (String s : banned) {
        	 map.remove(s);
         }
         Iterator<String> it = map.keySet().iterator();
         int max = 0;
         String maxString = "";
         while (it.hasNext()) {
        	String s = it.next();
        	if (map.get(s) > max) {
        		max = map.get(s);
        		maxString = s;
        	}
         }
         return maxString;
         
     }
     
     public void merge(int[] nums1, int m, int[] nums2, int n) {
    	int i, j, k;
    	i = m-1;
    	j = n -1;
    	k = m + n -1;
        while (i >=  0 && j >= 0) {
        	if (nums1[i] > nums2[j]) {
        		nums1[k] = nums1[i];
        		i--;
        	} else {
        		nums1[k] = nums2[j];
        		j--;
        	}
        	k--;
        }
        
        while (j >= 0) {
        	nums1[k] = nums2[j];
        	j--;
        	k--;
        }
        
     }
     
     public List<String> fizzBuzz(int n) {
    	 List<String> list = new ArrayList<String>();
         for (int i = 1; i < n; i++) {
        	 String c = "";
        	 if (i%3 == 0) {
        		 c = c + "Fizz";
        	 }
        	 if (i%5 == 0) {
        		 c = c + "Buzz";
        	 }
        	 if (c.isEmpty()) {
        		 list.add("" + i);
        	 } else {
        		 list.add(c);
        	 }
         }
         return list;
     }
     
     public void deleteNode(ListNode node) {
         node.val = node.next.val;
         node.next = node.next.next;
     }
     
     public void moveZeroes(int[] nums) {
       int i,j;
       for (i = 0, j =0; j < nums.length; j++) {
    	   if (nums[j] != 0) {
    		   nums[i] = nums[j];
    		   i++;
    	   }
       }
       while (i <= j) {
    	   nums[i] = 0;
       }
     }
     
     public class TreeNode {
    	 *     int val;
    	 *     TreeNode left;
    	 *     TreeNode right;
    	 *     TreeNode(int x) { val = x; }
    	 * }
     
     public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    	 TreeNode ret = null;
    	 return ret;
    	 
     }
}
