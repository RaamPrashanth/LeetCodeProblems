package Windows;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Solution {
	
	public static void main(String[] args) {
		Solution temp = new Solution();
		//temp.divide(-2147483648, -1);
				
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

		//int[] nums = {1, 1, 2};
		//temp.removeDuplicates(nums);
		
		//temp.divide(2147483647, -2);
		
		List<Employee> employees = new ArrayList<Employee>();
		/*Employee e1 = temp.new Employee(), e2 = temp.new Employee();
		e1.id = 1;
		e1.importance = 2;
		List<Integer> list = new ArrayList<Integer>();
		list.add(2);
		e1.subordinates = list;
		e2.id = 2;
		e2.importance = 3;
		e2.subordinates = new ArrayList<Integer>();
		employees.add(e1);
		employees.add(e2);
		temp.getImportance(employees, 	1);
		*/
		
		//[3,9,20,3,4,15,7]
	    TreeNode root = temp.new TreeNode(3);
		root.left = temp.new TreeNode(9);
		root.right = temp.new TreeNode(20);
		root.left.left = temp.new TreeNode(6);
		root.left.right = temp.new TreeNode(4);
		root.right.left = temp.new TreeNode(15);
		root.right.right = temp.new TreeNode(7);
		temp.levelOrder(root);
		
	}
	
    public int[] twoSum(int[] nums, int target) {
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
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
  			temp = carry + ((l1 != null)? l1.val : 0) + ((l2 != null)? l2.val : 0); 
  			if (temp > 9) {
  				carry = temp/10;
  				temp = temp%10;
  			} else {
  				carry = 0;
  			}
  			iterator.next = new ListNode(temp);
  			iterator = iterator.next;
  			if (l1 != null) 
  				l1 = l1.next;
  			if (l2 != null)
  				l2 = l2.next;
      	}
      	
      	if (carry > 0) {
      		iterator.next = new ListNode(carry);
      	}
      	
          return returnNode;    
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
    	 
    	 if (dividend == Integer.MAX_VALUE) {
    		 if (divisor == 1) {
    			 return Integer.MAX_VALUE;
    		 } else if (divisor == -1) {
    			 return Integer.MIN_VALUE;
    		 }
    	 }
    	 
         if (dividend == Integer.MIN_VALUE) {
        	 if (divisor == -1) {
    			 return Integer.MAX_VALUE;
    		 } else if (divisor == 1) {
    			 return Integer.MIN_VALUE;
    		 }
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
    		 if (dividend == Integer.MIN_VALUE) {
    			 dividend = dividend + divisor;
    			 quotient--;
    		 }
    		 
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
         return null;
     }
     
   /*  public String longestCommonPrefix(String[] strs) {
         String ret = "";
         //int j = 0;
         for (int i = 0; i<strs.length; i++) {
        	 
         }
         return ret;
     }*/
     
     public int[] countBits(int num) {
         int[] dp = new int[num+1];
         dp[0] = 0;
         dp[1] = 1;
         int bit = 0;
         for (int i = 2; i <= num; i++) {
        	 if ((i&(i-1)) == 0) {
        		 bit = 0;
        	 }
        	 dp[i] = 1 + dp[bit++]; 
         }
         
         return dp;
     }
     
    public int maxProfit(int[] prices) {
    	 int length = prices.length;
         int least = Integer.MAX_VALUE;
         int max = 0;
         for (int i = 0; i < length; i++) {
        	least = Math.min(prices[i], least);
        	max = Math.max(max, prices[i]-least);
        	
         }
         
         return max;
     } 
    
    public int numberOfArithmeticSlices(int[] A) {
    	int n = A.length;
    	if (n < 3) {
    		return 0;
    	}
        int count = 0;
        int[][] dp = new int[2][n];
        dp[1][1] = A[1] - A[0];
        for (int i = 2; i<n; i++) {
        	dp[1][i] = A[i]-A[i-1];
        	if (dp[1][i] == dp[1][i-1]) {
        		dp[0][i] = dp[0][i-1]+1;
        		count = count + dp[0][i];
        	}
        }
        
        return count;
    }
    
    public boolean isPalindrome(String s) {
    	int left = 0, right = s.length()-1;
    	s.toLowerCase();
        while (left < right) {
        	if (!Character.isLetterOrDigit(s.charAt(left))) {
        		left++;
        	} else if (!Character.isLetterOrDigit(s.charAt(right))) {
        		right--;
        	} else if(s.charAt(left) != s.charAt(right)) {
        		return false;
        	}
        }
    	return true;
    }
    
    public int lengthOfLIS(int[] nums) {
    	int n = nums.length;
    	if (n == 0)
    		return 0;
    	int max = 0;
    	int current = 0;
        for (int i = 1; i<n; i++) {
        	if (nums[i] > nums[i-1]) {
        		current++;
        	} else {
        		current = 0;
        	}
        	max = Math.max(current, max);
        }
        
        return max;
    }
    
    //Definition for a binary tree node.
    public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }
    
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null) 
        	return new ArrayList<Integer>();
        list.addAll(inorderTraversal(root.left));
        list.add(root.right.val);
        list.addAll(inorderTraversal(root.right));
        return list;
    }
    
    public boolean isSameTree(TreeNode p, TreeNode q) {
    	if (p != null && q != null) {
    		if (p.val != q.val) {
    			return false;
    		}
    		return (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    	} else if (p != q) {
    		return false;
    	}
        return true;
    }
    
    public boolean isSymmetric(TreeNode root) {
    	if(root == null) {
    		return true;
    	}
    	return isSymmetricHelper(root, root);
    }
    
    public boolean isSymmetricHelper(TreeNode p, TreeNode q) {
    	if (p != null && q != null) {
    		if (p.val != q.val) {
    			return false;
    		}
    		return (isSymmetricHelper(p.left, q.right) && isSymmetricHelper(p.right, q.left));
    	} else if (p != q) {
    		return false;
    	}
        return true;
    }
    
    public String serialize(TreeNode root) {
    	if (root == null) {
    		return "null";
    	}
    	System.out.println("" + root.val + "," + serialize(root.left) + "," + serialize(root.right));
        return "" + root.val + "," + serialize(root.left) + "," + serialize(root.right); 
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        TreeNode node = null;
        TreeNode iterator = node;
        for (int i = 0; i < nodes.length; i++) {
        		int rem = i%3;
        		if (rem == 0) {
        			iterator = nodes[i].equals("null")? new TreeNode(Integer.parseInt(nodes[i])):null;
        		} else if (rem == 1) {
        			iterator.left = nodes[i].equals("null")? new TreeNode(Integer.parseInt(nodes[i])):null;
        		} else {
        			iterator.right = nodes[i].equals("null")? new TreeNode(Integer.parseInt(nodes[i])):null;
        			iterator = iterator.left;
        		}		
        }
        return node;
    }
    
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        for (char s : S.toCharArray()) {
        	if(J.indexOf(s) != -1) {
        		count++;
        	}
        }
        return count;
    }

    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        if (n == 0) {
       	 return 0;
        }
        
        if (n==1) {
       	 return nums[0];
        } 
        if (n == 2) {
       	 return Math.max(nums[0], nums[1]);
        }
        
        dp[0] = nums[0];
        dp[1] = nums[1];
        
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + nums[i], (((i-3) < 0)? 0 : dp[i-3]) + nums[i])); 
            //System.out.println(" dp " + i + " = " + dp[i]);
        }
        
        
        return dp[n-1];
    }
    
    public int minSteps(int n) {
    	int min = 0;
    	if (n == 1) {
    		return 1;
    	}
    	return min;
    }
    
    public String reverseString(String s) {
        int i = 0;
        int j = s.length()-1;
        char[] charArray = s.toCharArray();
        char temp = ' ';
        while (i<j) {
        	temp = charArray[i];
        	charArray[i] = charArray[j];
        	charArray[j] = temp;
        	i++;
        	j--;
        }
        return new String(charArray);
    }
    
    public boolean canCross1(int[] stones) {
    	int n = stones.length;
    	int[] dp = new int[n];
    	if (stones[0] != 0 || stones[1] != 1) {
    		return false;
    	}
    	dp[0] = 0;
    	dp[1] = 1;
        int k = 1;
    	for (int i = 2; i < n; i++) {
    		if (dp[i-1] != 0) {
	    		 if (stones[i] == stones[i-1] + dp[i-1]) {
	    			dp[i] = dp[i-1];
	    		 }
	    		 if (stones[i] == stones[i-1] + dp[i-1]+1) {
		    			dp[i] = dp[i-1]+1;
		    	 }
	    		 if (stones[i] == stones[i-1] + dp[i-1]-1) {
		    			dp[i] = dp[i-1]-1;
		    	 }
    		}  
    		if (dp[i-2] != 0) {
    			if (stones[i] == stones[i-2] + dp[i-2]) {
	    			dp[i] = dp[i-2];
	    		 }
	    		 if (stones[i] == stones[i-2] + dp[i-2]+1) {
		    			dp[i] = dp[i-2]+1;
		    	 }
	    		 if (stones[i] == stones[i-2] + dp[i-2]-1) {
		    			dp[i] = dp[i-2]-1;
		    	 }
    		}
    		
    	}
        return dp[n-1] != 0;
    }
    
    public boolean canCross2(int[] stones) {
    	int n = stones.length;
    	int[] dp = new int[n];
    	if (stones[0] != 0 || stones[1] != 1) {
    		return false;
    	}
    	dp[0] = 0;
    	dp[1] = 1;
        return canCrossHelper1(stones, 3, 1);
    }
    
    public boolean canCrossHelper1(int[] stones, int start, int speed) {
    	if (start == stones.length && stones[start-1] == stones[start-2]+speed) {
    		return true;
    	}
    	
    	if (start > stones.length || speed < 1) {
    		return false;
    	}
    	
    	if (stones[start-1] == stones[start-2]+speed) {
    		return canCrossHelper1(stones, ++start, speed+1) || canCrossHelper1(stones, start, speed) || canCrossHelper1(stones, start, speed-1);
    	}
    		
    	return false;
    }
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	int m = obstacleGrid.length;
    	int n = obstacleGrid[0].length;
    	int[][] dp = new int[m][n];
        dp[0][0] = obstacleGrid[0][0]==0? 1 : 0;
    	for (int i = 1; i < m; i++) {
        	if (obstacleGrid[i][0] != 1)
        		dp[i][0] = dp[i-1][0];
        }
        for (int i = 1; i < n; i++) {
        	if (obstacleGrid[0][i] != 1)
        		dp[0][i] = dp[0][i-1];
        }
        
        for (int i = 1; i < m; i++) {
        	for (int j = 1; j < n; j++) {
        		if (obstacleGrid[i][j] != 1)
        		dp[i][j] = dp[i-1][j] + dp[i][j-1];
        	}
        }
        
    	return dp[m-1][n-1];
    }
    
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
        	dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
        	dp[0][i] = 1;
        }
        
        for (int i = 1; i < m; i++) {
        	for (int j = 1; j < n; j++) {
        		dp[i][j] = dp[i-1][j] + dp[i][j-1];
        	}
        }
        return dp[m-1][n-1];
    }
    
    public int maxDepth(TreeNode root) {
        return maxDepthHelper(root, 0);
        
    }
    
    private int maxDepthHelper(TreeNode node, int count) {
    	if (node == null) {
    		return count;
    	}
    	
    	count++;
    	return Math.max(maxDepthHelper(node.left, count), maxDepthHelper(node.right, count));
    }

    public int maxAreaOfIsland1(int[][] grid) {
    	int m = grid.length;
    	int n = grid[0].length;
        int max = 0;
        for (int i = 0; i < m; i++) {
        	for (int j=0; j < n; j++) {
        		max = Math.max(max, maxIslandRecursive(grid, i, j));
        	}
        }
        
        return max;
    }
    
    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    };
    
    public int getImportance(List<Employee> employees, int id) {
    	int importance = 0;
    	HashMap<Integer, HashMap<Integer, List<Integer>>>  map = new HashMap<Integer, HashMap<Integer, List<Integer>>>();
    	for (Employee emp : employees) {
    		HashMap<Integer, List<Integer>> impMap = new HashMap<Integer, List<Integer>>();
    		impMap.put(emp.importance, emp.subordinates);
    		map.put(emp.id, impMap);
    	}
    	
    	HashMap<Integer, List<Integer>> impMap = map.get(id);
    	importance = impMap.keySet().iterator().next();
    	List<Integer> list = impMap.get(importance);
    	while (!list.isEmpty()) {
    		importance += map.get(list.get(0)).keySet().iterator().next();
    		list.addAll(map.get(list.get(0)).get(map.get(list.get(0)).keySet().iterator().next()));
    		list.remove(0);
    	}
        return importance;
    }
    
    private int maxIslandRecursive(int[][] grid, int i, int j) {
		if (grid[i][j] == 0)
		return 0;
		
		grid[i][j] = 0;
		
		return 1 + (i==0? 0: maxIslandRecursive(grid, i-1, j))
				+ (j==0? 0: maxIslandRecursive(grid, i, j-1))
				+ (i == grid.length-1? 0: maxIslandRecursive(grid, i+1, j))
				+ (j == grid[0].length-1? 0: maxIslandRecursive(grid, i, j+1));
	}

	public int maxAreaOfIsland(int[][] grid) {
    	int m = grid.length;
    	int n = grid[0].length;
        boolean[][] isVisited = new boolean[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
        	for (int j=0; j < n; j++) {
        		max = Math.max(max, maxAreaOfIslandHelper(grid, isVisited, i, j));
        	}
        }
        
        return max;
    }
    
    private int maxAreaOfIslandHelper(int[][] grid, boolean[][] isVisited, int i,
			int j) {
		
    	if (i<0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || isVisited[i][j]) {
    		return 0;
    	}
    	isVisited[i][j] = true;
    	
		return 1 + maxAreaOfIslandHelper(grid, isVisited, i+1, j) + maxAreaOfIslandHelper(grid, isVisited, i-1, j) + maxAreaOfIslandHelper(grid, isVisited, i, j+1) + maxAreaOfIslandHelper(grid, isVisited, i, j-1);
	}

    public boolean isUgly(int num) {
    	if (num == 1) {
    		return true;
    	} 
    	if (num == 0) {
    		return false;
    	}
    	
        while (num%2 == 0) {
        	num = num/2;
        }
        
        while (num%3 == 0) {
        	num = num/3;
        }
        
        while (num%5 == 0) {
        	num = num/5;
        }
        
        return num==1;
    }
    
    public int nthUglyNumber(int n) {
    	if (n > 1690) {
    		return 0;
    	}
    	ArrayList<Integer> dp = new ArrayList<Integer>();
    	int index;
    	dp.add(1);
    	dp.add(2);
    	dp.add(3);
    	dp.add(4);
    	dp.add(5);
        for (int i = 6; dp.size() <= n; i++) {
        	int num = i;
        	 while (num%2 == 0) {
             	num = num/2;
             	if (dp.contains(num)) {
             		num = 1;
             	}
             }
             
             while (num%3 == 0) {
             	num = num/3;
             	if (dp.contains(num)) {
             		num = 1;
             	}
             }
             
             while (num%5 == 0) {
             	num = num/5;
             	if (dp.contains(num)) {
             		num = 1;
             	}
             }
             if (num == 1) {
            	 dp.add(i);
             }
        }
        return dp.get(n-1);
    }
    
    class MyQueue {

    	Stack<Integer> stack, swap;
    	
        /** Initialize your data structure here. */
        public MyQueue() {
        	stack = new Stack<Integer>();
        	swap = new Stack<Integer>();
        }
        
        /** Push element x to the back of queue. */
        public void push(int x) {
            while(!stack.isEmpty()) {
            	swap.push(stack.pop());
            }
            stack.push(x);
            while(!swap.isEmpty()) {
            	stack.push(swap.pop());
            }
        }
        
        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
        	return stack.pop();
        }
        
        /** Get the front element. */
        public int peek() {
            return stack.peek();
        }
        
        /** Returns whether the queue is empty. */
        public boolean empty() {
        	return stack.isEmpty();
            
        }
    }

    /**
     * Your MyQueue object will be instantiated and called as such:
     * MyQueue obj = new MyQueue();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.peek();
     * boolean param_4 = obj.empty();
     */
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    	floodFillHelper(image, sr, sc, newColor, image[sr][sc]);
    	return image;
    }

	private void floodFillHelper(int[][] image, int sr, int sc, int newColor,
			int oldColor) {
		if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != oldColor || image[sr][sc] == newColor) {
			return;
		}
		image[sr][sc] = newColor;
		floodFillHelper(image, sr-1, sc, newColor, oldColor);
    	floodFillHelper(image, sr+1, sc, newColor, oldColor);
    	floodFillHelper(image, sr, sc-1, newColor, oldColor);
    	floodFillHelper(image, sr, sc+1, newColor, oldColor);
	}
	
    public List<String> binaryTreePaths(TreeNode root) {
    	List<String> ret = new ArrayList<String>();
        if (root == null) 
            return ret;
    	String str = "";
    	binaryTreePathsHelper(root, str, ret);
    	return ret;
    }

	private void binaryTreePathsHelper(TreeNode root, String str, List<String> ret) {
        if (root == null) {
            return;
        }
		if (root.left == null && root.right == null ) {
			ret.add(str + root.val);
			return;
		}
		if (root.left != null) binaryTreePathsHelper(root.left, str + root.val + "->", ret);
		if (root.right != null)binaryTreePathsHelper(root.right, str + root.val + "->", ret);
	}
    
    public boolean hasPathSum(TreeNode root, int sum) {
        if ( root == null) {
        	return false;
        }
		return hasPathSumHelper(root, sum, 0);
    }

	private boolean hasPathSumHelper(TreeNode root, int sum, int current) {
		if (root.left == null && root.right == null) {
			if (current + root.val == sum) {
				return true;
			}
			return false;
		}
		return ((root.left != null? hasPathSumHelper(root.left, sum, current + root.val) : false) || (root.right != null? hasPathSumHelper(root.right, sum, current + root.val) : false));
	}
	
    public int minDepth(TreeNode root) {
        if (root == null) {
        	return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if ( left == 0 || right == 0) {
        	return 1 + left + right;
        }
        return 1 + Math.min(left, right);
    }
    
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
        	return true;
        }
        
        int diff = calculateDepth(root.left) - calculateDepth(root.right);
        if ( -1 > diff && diff > 1) {
        	return false;
        }
        
        return (isBalanced(root.left) && isBalanced(root.right));
    }
    
    public int calculateDepth(TreeNode root) {
    	if (root == null) {
    		return 0;
    	}
    	
    	return 1+Math.max(calculateDepth(root.left), calculateDepth(root.right));
    }
    
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    	HashSet<Integer> visited = new HashSet<Integer>();
    	HashSet<Integer> keys = new HashSet<Integer>();
    	keys.add(0);
		canVisitAllRoomsHelper(rooms, visited, 0);
        return (visited.size() == rooms.size());
    }

	private void canVisitAllRoomsHelper(List<List<Integer>> rooms,
			HashSet<Integer> visited, //HashSet<Integer> keys,
			int toVisit) {
		if (!visited.add(toVisit)) {
			return;
		}
		List<Integer> keys = rooms.get(toVisit);
		for (int key : keys) {
			canVisitAllRoomsHelper(rooms, visited, key);
		}
	}
    
	int maxDepth = -1;
	int leftMost = 0;
    public int findBottomLeftValue(TreeNode root) {
        findBottomLeftValueHelper(root, 0);
        return leftMost;
    }

	private void findBottomLeftValueHelper(TreeNode root,int depth) {
		if (root == null) {
			return;
		}
		if (maxDepth < depth) {
			maxDepth = depth;
			leftMost = root.val;
		}
			
		++depth;
		findBottomLeftValueHelper(root.left, depth);
		findBottomLeftValueHelper(root.right, depth);
	}
    
    public List<Integer> largestValues(TreeNode root) {
    	List<Integer> list = new ArrayList<Integer>();
    	largestValuesHelper(root, list, 0);
    	return list;
    }

	private void largestValuesHelper(TreeNode root, List<Integer> list,
			int depth) {
		if (root == null) {
			return;
		}
		if (list.size() > depth) {
			if (list.get(depth) < root.val) {
				list.set(depth, root.val);
			}
		} else {
			list.add(root.val);
		}
		++depth;
		largestValuesHelper(root.left, list, depth);
		largestValuesHelper(root.right, list, depth);
	} 
    
    public int findTargetSumWays(int[] nums, int S) {
        return findTargetSumWaysHelper(nums, 0, 0, S);
    }
    
    private int findTargetSumWaysHelper(int[] nums, int position, int current, int target) {
        int n = nums.length;
        if (position >= n) {
        	return 0;
        }
        if (position == n-1) {
        	if (current == target) {
        		return 1;
        	} else {
        		return 0;
        	}
        }
        position++;
        return findTargetSumWaysHelper(nums, position, current+nums[position-1], target) + findTargetSumWaysHelper(nums, position, current-nums[position-1], target);
    }
    
    public List<Integer> rightSideView(TreeNode root) {
    	List<Integer> list = new ArrayList<Integer>();
        if (root == null) {
        	return list;
        }
        rightSideViewHelper(root, list, 0);
        return list;
    }

	private void rightSideViewHelper(TreeNode root, List<Integer> list, int depth) {
		if (root == null) {
			return;
		}
		if (list.size() >= depth) {
			list.set(depth, root.val);
		}
		depth++;
		rightSideViewHelper(root.right, list, depth);
		rightSideViewHelper(root.left, list, depth);
	}
	
	public int sumNumbers(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return sumNumbersHelper(root, 0);
	}

	private int sumNumbersHelper(TreeNode root, int sum) {
		sum = sum*10 + root.val;
		if (root.left == null && root.right == null) {
			return sum;
		}
		int left = root.left != null? sumNumbersHelper(root.left, sum):0;
		int right = root.right != null? sumNumbersHelper(root.right, sum):0;
		return left+right;
	}
	   
    public TreeNode sortedArrayToBST(int[] nums) {
    	TreeNode ret = null;
    	int n = nums.length;
    	if (n == 0) {
    		return ret;
    	}
    	ret = new TreeNode(nums[0]);
    	for (int i = 1; i<n; i++) {
    		sortedArrayToBSTHelper(ret, nums[i]);
    	}
    	return ret;
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
    	if (root == null) {
    		return null;
    	}
    	List<TreeNode> bfs = new ArrayList<TreeNode>();
    	List<List<Integer>> list = new ArrayList<List<Integer>>();
    	bfs.add(root);
    	while(!bfs.isEmpty()) {
    		List<Integer> levelList = new ArrayList<Integer>();
    		int currentSize = bfs.size();
    		for (int i = 0; i<currentSize; i++) {
    			if (bfs.get(0).left != null) {
    				bfs.add(bfs.get(0).left);
    			}
    			if (bfs.get(0).right != null) {
    				bfs.add(bfs.get(0).right);
    			}
    			levelList.add(bfs.get(0).val);
    			bfs.remove(0);
    		}
    		list.add(levelList);	
    	}
    	return list;
    }
    
    private void sortedArrayToBSTHelper(TreeNode tree, int num) {
    	
    	if (num < tree.val) {
    		if (tree.left == null) {
    			tree.left = new TreeNode(num);
    		} else {
    			sortedArrayToBSTHelper(tree.left, num);
    		}
    	} else {
    		if (tree.right == null) {
    			tree.right = new TreeNode(num);
    		} else {
    			sortedArrayToBSTHelper(tree.right, num);
    		}
    	}
    }
    
    public int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i<m; i++) {
        	for (int j = 0; j<n; j++) {
        		if (grid[i][j] == '1') {
        			count++;
        			numIslandsDFS(grid, i, j);
        		}
        	}
        }
        return count;
    }

	private void numIslandsDFS(char[][] grid, int i, int j) {
		if (i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] != '1') {
			return;
		}
		grid[i][j] = '0';
		numIslandsDFS(grid, i-1, j);
		numIslandsDFS(grid, i, j-1);
		numIslandsDFS(grid, i+1, j);
		numIslandsDFS(grid, i, j+1);
	}
	
    public boolean judgeCircle(String moves) {
    	int x = 0;
    	int y = 0;
    	for (char ch : moves.toCharArray()) {
    		switch (ch) {
    		case 'U' :
    			y--;
    			break;
    		case 'D' :
    			y++;
    			break;
    		case 'L' :
    			x--;
    			break;
    		case 'R' :
    			x++;
    			break;
    		default : 
    			return false;
    		}
    	}
    	return x == 0 && y == 0;
    }
    
    public int firstUniqChar(String s) {
     int[] freq = new int[26];
     for (char c : s.toCharArray()) {
    	 freq[c-'a']++;
     }
     for (int i = 0; i < s.length(); i++) {
    	 if (freq[s.charAt(i)-'a'] == 1) {
    		 return i;
    	 }
     }
     return -1;
    }
    
   /** public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<Character>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        int n = s.length();
        for (int i = 0; i<n; i++) {
        	char c = s.charAt(i);
        	if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
        		stack.push(c);
        		list.add(i);
        	}
        	sb.append(c);
        }
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
        	sb.setCharAt(it.next(), stack.pop());
        }
        
        return sb.toString();
    }**/
    
    public String reverseVowels(String s) {
    	int start = 0;
    	int end = s.length()-1;
    	String vowels = "aeiouAEIOU";
    	char[] c = s.toCharArray();
    	while(start < end) {
    		while (start < end && (vowels.indexOf(c[start]) == -1)) {
    			start++;
    		}
    		while (start < end && (vowels.indexOf(c[end]) == -1)) {
    			end--;
    		}
    		char temp = c[start];
    		c[start] = c[end];
    		c[end] = temp;
    		start++;
    		end--;
    	}
    	
    	return new String(c); 
    }
    
   public List<String> letterCombinations(String digits) {
	   List<String> list = new ArrayList<String>();
	   String[] s = new String[8];
	   s[0] = "abc";
	   s[1] = "def";
	   s[2] = "ghi";
	   s[3] = "jkl";
	   s[4] = "mno";
	   s[5] = "pqrs";
	   s[6] = "tuv";
	   s[7] = "wxyz";
	   list.add("");
	   for (int i = 0; i<digits.length(); i++) {
		   List<String> tempList = new ArrayList<String>(); 
		   for (char c : s[digits.charAt(i)-'2'].toCharArray()) {
			   Iterator<String> it = list.iterator();
			   while (it.hasNext()) {
				   tempList.add(it.next() + c);
			   }
		   }
		   list = tempList;
	   }
	   return list;
    }
    
   public String longestPalindrome(String s) {
	   int n = s.length();
	   char[] c = s.toCharArray();
	   Boolean[][] dp = new Boolean[n][n];
	   int start, end;
	   start = end = 0;
	   for (int i= n-1; i>= 0; i--) {
		   for (int j = i; j<n; j++) {
               if (j-i < 3) {
                 dp[i][j] = (c[i] == c[j]); 
               } else {
                  dp[i][j] = (c[i] == c[j] && dp[i+1][j-1]);
               }
			   
			   if (dp[i][j] && (end-start <= j-i)) {
				   start = i;
				   end = j;
			   }
		   }
	   }
	   return s.substring(start, end+1);
   }
   public int minCost(int[][] costs) {
	   int n = costs.length;
       int[][] dp = new int[n][3];
       for (int i = 0; i<n; i++) {
    	   dp[0][i] = costs[0][i];
       }
       for (int i = 1; i<n; i++) {
    		   dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + costs[i][0];
    		   dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + costs[i][0];
    		   dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + costs[i][0];
       }
       return Math.min(Math.min(dp[n-1][0], dp[n-1][1]), dp[n-1][2]);
   }
   
   public int numSquares(int n) {
	  int k =(int) Math.ceil(Math.sqrt(n));
	  int[] sq = new int[k];
	  int min = Integer.MAX_VALUE;
	  for (int i = k; i<=k; i++) {
		  int sqr = i*i;
		  int sum = 0;
		  while(sum < n) {
			  sum+=sqr;
		  }
		  
		  
	  }
	  return 0;
   }
   
   class PeekingIterator implements Iterator<Integer> {
	   
	   Iterator<Integer> iterator = null;
	   Integer peek = null;

		public PeekingIterator(Iterator<Integer> iterator) {
		    // initialize any member here.
			this.iterator = iterator;
		}

	    // Returns the next element in the iteration without advancing the iterator.
		public Integer peek() {
	        if (peek == null) {
	        	peek = iterator.next();
	        }
	        
	        return peek;
		}

		// hasNext() and next() should behave the same as in the Iterator interface.
		// Override them if needed.
		//@Override
		public Integer next() {
			Integer temp = null;
		    if (peek != null) {
		    	temp = peek;
		    	peek = null;
		    } else {
		    	temp = iterator.next();
		    }
		    
		    return temp;
		}

		//@Override
		public boolean hasNext() {
		    return iterator.hasNext();
		}
	}
   
   public class BSTIterator {

	    List<Integer> list = new ArrayList<Integer>();
	    
	    public BSTIterator(TreeNode root) {
	    	addToList(root);
	    }

	    private void addToList(TreeNode root) {
	    	if (root == null) {
	    		return;
	    	}
	    	addToList(root.left);
	    	list.add(root.val);
	    	addToList(root.right);
	    }
	    /** @return whether we have a next smallest number */
	    public boolean hasNext() {
	        return !list.isEmpty();
	    }

	    /** @return the next smallest number */
	    public int next() {
	    	int ret = list.get(0); 
	    	list.remove(0);
	    	return ret;
	    }
	}
   
   public class ZigzagIterator1 {
	   
	   	List<Integer> list = new ArrayList<Integer>();
	   	Iterator<Integer> it;
	   	
	    public ZigzagIterator1(List<Integer> v1, List<Integer> v2) {
	        Iterator<Integer> it1 = v1.iterator();
	        Iterator<Integer> it2 = v2.iterator();
	        
	        while (it1.hasNext() && it2.hasNext()) {
	        	list.add(it1.next());
	        	list.add(it2.next());
	        }
	        
	        while (it1.hasNext()) {
	        	list.add(it1.next());
	        }
	        
	        while (it2.hasNext()) {
	        	list.add(it2.next());
	        }
	        
	        it = list.iterator();
	    }

	    public int next() {
	        return it.next();
	    }

	    public boolean hasNext() {
	        return it.hasNext();
	    }
	}
   
   public class ZigzagIterator {
	   	int index;
	   	int k;
	   	List<List<Integer>> list = new ArrayList<List<Integer>>();
	   	
	    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
	    	list.add(v1);
	    	list.add(v2);
	    	list.add(new ArrayList<Integer>(Arrays.asList(1,1,1,1)));
	    	list.add(new ArrayList<Integer>(Arrays.asList(2,2,2,2,2)));
	    	list.add(new ArrayList<Integer>(Arrays.asList(3,3,3,3,3,3)));
	    	list.add(new ArrayList<Integer>(Arrays.asList(4,4,4,4,4,4,4)));
	    	k = list.size();
	    	index = 0;
	    }
	   
	    public int next() {
	    	int ret;
	    	hasNext();
	    	ret = list.get(index%k).get(0);
	    	list.get(index%k).remove(0);
	    	index++;
    		return ret;
	    }

	    public boolean hasNext() {
	    	int temp = index%k; 
	    	while(list.get(index%k).isEmpty()) {
	    		index++;
	    		if (temp == index%k) {
	    			return false;
	    		}	
	    	}
	        return true; 
	    }        
   }
   
   public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	  List<TreeNode> pPath = new ArrayList<TreeNode>();
	  List<TreeNode> qPath = new ArrayList<TreeNode>();
      findPath(root, p.val, pPath);
      int i;
      for (i = 0; i <pPath.size() && i < qPath.size(); i++) {
    	  if (pPath.get(i).val != qPath.get(i).val) {
    		  break;
    	  }
      }
      return pPath.get(i-1);
   }

	private boolean findPath(TreeNode root, int val, List<TreeNode> list) {
		
		if (root == null) {
			return false;
		}
		
		if (root.val == val) {
			return true;
		}
		
		list.add(root);
		
		if (findPath(root.left, val, list)) {
			return true;
		}
		
		if (findPath(root.left, val, list)) {
			return true;
		}
		
		list.remove(list.size()-1);
		return false;
	}
	
	  public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
		    while ((root.val - p.val) * (root.val - q.val) > 0)
		        root = p.val < root.val ? root.left : root.right;
		    return root;
	}
	  
	  public List<Integer> postorderTraversal(TreeNode root) {
		    List<Integer> list = new ArrayList<Integer>();
		    postorderTraversalHelper(root, list);
		    return list;
	    }

	private void postorderTraversalHelper(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		postorderTraversalHelper(root.left, list);
		postorderTraversalHelper(root.right, list);
		list.add(root.val);
	}
	
	 public List<Integer> preorderTraversal(TreeNode root) {
		 List<Integer> list = new ArrayList<Integer>();
		 preorderTraversalHelper(root, list);
		 return list;
	 }

	private void preorderTraversalHelper(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		list.add(root.val);
		preorderTraversalHelper(root.left, list);
		preorderTraversalHelper(root.right, list);
	}
	
	private void multi(Integer... params) {
		if (params[0] == 1) {
			
		}
	}
	
    public int[] productExceptSelf(int[] nums) {
    	int mul = 1;
        for (int num : nums) {
        	mul*=num;
        }
        
        for (int i = 0; i<nums.length; i++) {
        	nums[i] = mul/nums[i];
        }
        
        return nums;
    }
    
    class Node {
        public int val;
        public Node left;
        public Node right;
		public List<Node> children;

        public Node() {}

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
    
    public Node treeToDoublyList(Node root) {
    	if (root == null) {
    		return null;
    	}
    	Node head = new Node(0, null, null);
    	Node iterator = head;
    	treeToDoublyListHelper(root, iterator);
    	return head.right;
    }

	private void treeToDoublyListHelper(Node root, Node iterator) {
		if (root == null) {
			return;
		}
		treeToDoublyListHelper(root.left, iterator); 
		iterator.right = new Node(root.val, iterator, null);
		iterator = iterator.right;
		treeToDoublyListHelper(root.right, iterator); 
	}
    
	public class Codec {
	    int count = 1;
	    static final String URL = "http://tinyurl.com/";
	    HashMap<Integer, String> map = new HashMap<Integer, String>();

	    // Encodes a URL to a shortened URL.
	    public String encode(String longUrl) {
	        map.put(count, longUrl);
	        return URL + count++;
	    }

	    // Decodes a shortened URL to its original URL.
	    public String decode(String shortUrl) {
	       return map.get(Integer.parseInt(shortUrl.charAt(shortUrl.length()-1) + ""));
	    }
	}
	
	 public int maximumProduct(int[] nums) {
	        int[] max = new int[3];
	        Arrays.fill(max, Integer.MIN_VALUE);
	        int[] min = new int[2];
	        int n = nums.length;
	        for (int i = 0; i<n; i++) {
	        	if (nums[i] >= max[2]) {
	        				max[0] = max[1];
	        				max[1] = max[2];
	        				max[2] = nums[i];
	        	} else if (nums[i] >= max[1]) {
	        		max[0] = max[1];
        			max[1] = nums[i];
	        	} else if (nums[i] >= max[0]) {
	        		max[0] = nums[i];
	        	}	
	        	
	        	if (nums[i] <= min[1]) {
	        		min[0] = min[1];
	        		min[1] = nums[i];
	        	} else if (nums[i] <= min[0]) {
	        		min[0] = nums[i];
	        	}

	        }
	        return Math.max(max[0] * max[1] * max[2], min[0] * min[1] * max[2]);
	 }
	 
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
     
     public boolean hasCycle1(ListNode head) {
         if (head == null) 
             return false;
	     ListNode slow = head;
	 	ListNode fast = head.next;
	 	
	 	while (fast != null && fast.next != null) {
	 		if (slow == fast) {
	 			return true;
	 		}
	 		slow = slow.next;
	 		fast = fast.next.next;
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
     
     public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    	 if ((t1 == null) && (t2 == null)) {
    		 return null;
    	 }
         if (t1 == null) {
             return t2;
         } else if (t2 == null) {
             return t1;
         }
         TreeNode ret = new TreeNode(t1.val + t2.val);
    	 ret.left = mergeTrees(t1.left, t2.left);
    	 ret.right = mergeTrees(t1.right, t2.right);
    	 
    	 return ret;
    	 
     }
     
     public int peakIndexInMountainArray(int[] A) {
       int max = Integer.MIN_VALUE;
       int maxIndex = 0;
       for (int i =0; i < A.length; i++) {
    	   if (A[i] > max) {
    		   max = A[i];
    		   maxIndex = i;
    	   }
       }
       return maxIndex;
     }
     
     public ListNode middleNode(ListNode head) {
         ListNode slow = head;
         ListNode fast = head;
         while (fast != null && fast.next != null) {
             slow = slow.next;
             fast = fast.next.next;
         }
         return slow;
     }
     
     public String[] uncommonFromSentences(String A, String B) {
    	 LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
    	 String[] split = A.split(" ");
    	 for (String s : split) {
    		 if (map.containsKey(s)) {
    			 map.put(s, map.get(s) + 1);
    		 } else {
    			 map.put(s, 1); 
    		 }
    	 }
    	 
    	 split = B.split(" ");
    	 for (String s : split) {
    		 if (map.containsKey(s)) {
    			 map.put(s, map.get(s) + 1);
    		 } else {
    			 map.put(s, 1); 
    		 }
    	 }
    	 List<String> arr = new ArrayList<String>();
    	 Iterator<String> it = map.keySet().iterator();
    	 while (it.hasNext()) {
    		 String s = it.next();
    		 if (map.get(s) == 1) {
    			 arr.add(s);
    		 }
    	 }
    	 String[] s = new String[0];
    	 return arr.toArray(s);
     }
     

    	
     public int maxDepth(Node root) {
         /**class Node {
     	    public int val;
     	    public List<Node> children;

     	    public Node() {}

     	    public Node(int _val,List<Node> _children) {
     	        val = _val;
     	        children = _children;
     	    }
     	};**/
     	
     	if (root == null) {
     		return 0;
     	}
     	int dep = 0;
     	for (Node c : root.children) {
     		dep = Math.max(dep, maxDepth(c));
     	}
     	
     	return dep + 1;
     }
     
     public int maxDepth1(Node root) {
    	 if (root == null) {
    		 return 0;
    	 }
    	 return maxDepthHelper(root, 1);
     }

	private int maxDepthHelper(Node root, int depth) {
		if (root == null) {
			return depth;
		}
		int ret = depth;
		for (Node c : root.children) {
     		ret = Math.max(maxDepthHelper(c, depth+1), ret);
     	}
		return ret;
	}
     
    
	public boolean isPalindrome(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		ListNode previous = slow;
		slow = slow.next;
		
		while (slow != null) {
			ListNode current = slow;
			slow = slow.next;
			current.next = previous;
			previous = current;
		}
		while (slow != null && head != null) {
			if (head.val != slow.val) {
				return false;
			}
            head = head.next;
            slow = slow.next;
		}
		return true;
    }
	
	  public List<Integer> postorder(Node root) {
		  List<Integer> list = new ArrayList<Integer>();
		  postorderHelper(root, list);
		  return list;
	  }

	private void postorderHelper(Node root, List<Integer> list) {
		if (root == null) {
			return;
		}
		for (Node c : root.children) {
			postorderHelper(c, list);
		}
		list.add(root.val);
	}
	
	 public TreeNode trimBST(TreeNode root, int L, int R) {
		 if (root == null) {
			 return root;
		 }
		 if (root.val < L) {
			 root = trimBST(root.right, L, R);
		 } else if (root.val > R) {
			 root = trimBST(root.left, L, R);
		 } else  {
			 root.left = trimBST(root.left, L, R);
			 root.right = trimBST(root.right, L, R);
		 }
		 return root;
	 }
	 
	    public int[] twoSum1(int[] numbers, int target) {
	        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	    	for (int i = 0; i < numbers.length; i++) {
	    		int diff = target-numbers[i];
	    		if (map.containsKey(diff)) {
	    			return new int[] {map.get(diff), i};
	    		}
	    		map.put(numbers[i], i);
	    	}
	        return new int[] {};
	    }
	    
	   public int[] twoSum2(int[] numbers, int target) {
		   int i = 0;
		   int j = numbers.length-1;
		   while (i < j) {
			   int sum = numbers[i]+numbers[j];
			   if (sum == target) {
				   return new int[] {i+1, j+1};
			   } else if (sum < target) {
				   i++;
			   } else {
				   j--;
			   }
		   }
		   return new int[] {};
	   }
	   
	    Set<Integer> set = new HashSet<Integer>();
	    public boolean findTarget(TreeNode root, int k) {
	    	if (root == null) {
	    		return false;
	    	}
	    	if (set.contains(k-root.val)) {
	    		return true;
	    	}
	    	set.add(root.val);
	    	return findTarget(root.left, k) || findTarget(root.right, k);    	
	    }
	    
	    class MinStack {

	    	Stack<Integer> stack;
	    	ArrayList<Integer> min;
	    	
	    	
	        /** initialize your data structure here. */
	        public MinStack() {
	            stack = new Stack<Integer>();
	            min = new ArrayList<Integer>();
	            
	        }
	        
	        public void push(int x) {
	            stack.push(x);
	            for (int i =0; i <min.size(); i++) {
	            	if (x < min.get(i)) {
	            		min.add(i, x);
	            		return;
	            	}
	            }
	            min.add(x);
	        }
	        
	        public void pop() {
	        	min.remove(stack.peek());
	            stack.pop();
	            
	        }
	        
	        public int top() {
	            return stack.peek();
	        }
	        
	        public int getMin() {
	            return min.get(0);
	        }
	    }
	    
	    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	    	List<ListNode> list = new ArrayList<ListNode>();
	    	while (headA != null) {
	    		list.add(headA);
	    		headA = headA.next;
	    	}
	    	while (headB != null) {
	    		if (list.contains(headB)) {
	    			return headB;
	    		}
	    		headB = headB.next;
	    	}
	    	
	    	return null;
	    }
	    
	    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
	    	ListNode a = headA;
	    	ListNode b = headB; 
	    	
	    	while (a != b) {
	    		if (a == null) {
	    			a = headB;
	    		} else {
	    			a = a.next;
	    		}
	    		if (b == null) {
	    			b = headA;
	    		} else {
	    			b = b.next;
	    		}
	    	}
	    	
	    	return a;
	    }
	    int ans = 0;
	    public int diameterOfBinaryTree(TreeNode root) {
	    	if (root == null) {
	    		return 0;
	    	}
	    	return diameterOfBinaryTreeHelper(root);
	    }

		private int diameterOfBinaryTreeHelper(TreeNode root) {
			if (root == null) {
				return 0;
			}
			int l = diameterOfBinaryTreeHelper(root.left);
			int r = diameterOfBinaryTreeHelper(root.right);
			ans = Math.max(l+r, ans);
			return l + r + 1;
			
		}
		
	    public String addStrings(String num1, String num2) {
	      String ret = "";
	      char[] a = num1.toCharArray();
	      char[] b = num2.toCharArray();
	      int carry = 0;
	      for (int i = num1.length()-1, j = num2.length()-1; i >= 0 || j >= 0; i--,j--) {
	    	  int temp = carry;
	    	  if (i >= 0)
	    	  temp += a[i] - '0';
	    	  if (j >= 0)
	    	  temp += b[j] - '0';

	    	  carry = temp/10;
	    	  temp = temp % 10;
	    	  ret = temp + ret;
	      }
	      if (carry > 0) {
	    	  ret = carry + ret;
	      }
	      
	      return ret;
	    }
	    
	    class TwoSum {

	    	//Set<Integer> sum;
	    	Map<Integer, Integer> val;
	        /** Initialize your data structure here. */
	        public TwoSum() {
	        	//sum = new HashSet<Integer>();
		    	val = new HashMap<Integer, Integer>();
	        }
	        
	        /** Add the number to an internal data structure.. */
	        public void add(int number) {
	        	if (val.containsKey(number)) {
	        		val.put(number, val.get(number)+1);
	        	} else {
	        		val.put(number, 1);
	        	}
	        }
	        
	        /** Find if there exists any pair of numbers which sum is equal to the value. */
	        public boolean find(int value) {
	        	Iterator<Integer> it = val.keySet().iterator();
	            while (it.hasNext()) {
	            	int i = it.next();
	            	int diff = value-i;
	            	if (val.containsKey(diff)) {
	            		if (i != diff || val.get(i) > 1) {
	            			return true;
	            		}
	            	}
	            }
	            return false;
	        }
	    }
	    
	    public int majorityElement(int[] nums) {
		      Map<Integer, Integer> map = new HashMap<Integer, Integer>();	   
		      for (int i : nums) {
		    	if (map.containsKey(i)) {
		    		map.put(i, map.get(i)+1);
		    	} else {
	                map.put(i,1);
		    	}
	            if (map.get(i) > nums.length/2) {
		    			return i;
		    	}
		      }
		      return 0;
		    }
	    
	    public TreeNode invertTree(TreeNode root) {
	        if (root == null) {
	        	return null;
	        }
	        TreeNode temp = root.left;
	        root.left = invertTree(root.right);
	        root.right = invertTree(temp);
	        
	        return root;
	    }
	    
	    public String countAndSay(int n) {
	    	String[] dp = new String[n+1];
	    	dp[1] = "1";
	    	for (int i =2; i<=n; i++) {
	    		int count = 1;
	    		char[] arr = dp[i-1].toCharArray();
	    		char digit = arr[0];
	    		for (int j = 1; j < arr.length; j++) {
	    			if (digit == arr[j]) {
	    				count++;
	    			} else {
	    				dp[i] = dp[i] + count + digit;
	    				digit = arr[j];
	    				count = 1;
	    			}
	    		}
	    		if (count > 0) {
	    			dp[i] = dp[i] = dp[i] + count + digit;
	    		}
	    	}
	    	return dp[n];
	    }
	    
	    public int singleNumber(int[] nums) {
	    	int ret = 0;
	    	for (int i : nums) {
	    		ret ^= i;
	    	}
	    	return ret;
	    }
	    
	    public char findTheDifference(String s, String t) {
	    	int bit = 0;
	    	for (char c : s.toCharArray()) {
	    		bit = bit ^ c;
	    	}
	    	for (char c : t.toCharArray()) {
	    		bit = bit ^ c;
	    	}
	    	return (char) bit;
	    }
	    
	    public ListNode detectCycle(ListNode head) {
	    	if (head == null) {
	    		return null;
	    	}
	    	ListNode fast = head;
	    	ListNode slow = head;
	    	ListNode ptr1 = head;
	    	ListNode ptr2 = null;
	    	
	    	while (fast != null && fast.next != null) {
	    		fast = fast.next.next;
	    		slow = slow.next;
	    		
	    		if (fast == slow) {
	    			ptr2 = fast;
	    			break;
	    		}
	    				
	    	}
	    	
	    	if (ptr2 != null) {
	    		while (ptr1 != ptr2) {
	    			ptr1 = ptr1.next;
	    			ptr2 = ptr2.next;
	    		}
	    		return ptr2;
	    	}
	    	
	    	return null;
	    }
	    
	    class LRUCache {
	    	
	    	List<Integer> keySet;
	    	Map<Integer, Integer> map; 
	    	int n;
	    	
	        public LRUCache(int capacity) {
	            map = new HashMap<Integer, Integer>();
	            keySet = new ArrayList<Integer>();
	            n = capacity;
	        }
	        
	        public int get(int key) {
	        	if (!keySet.contains(key)) {
	        		return -1;
	        	}
	        	keySet.remove((Integer)key);
	        	keySet.add(key);
	            return map.get(key);
	        }
	        
	        public void put(int key, int value) {
	        	if (keySet.contains(key)) {
	        		keySet.remove((Integer) key);
	        	}
	            if (map.size() >= n) {
	            	map.remove(keySet.get(0));
	            	keySet.remove(0);
	            	
	            }
	            
	            map.put(key, value);
            	keySet.add(key);
	        }
	    }
	    
	    static int getSpecialSubstring(String s, int k, String charValue) {
	        
	        char[] val = charValue.toCharArray();
	        char[] str = s.toCharArray();
	        int max = 0;
	        // O(n ^ 2)
	        /* 
	        for (int i = 0; i < str.length; i++) {
	            int temp = 0;
	            if (val[str[i]-'a'] == '0') {
	                temp++;
	            } 
	            for (int j = i+1; j < str.length; j++) {
	                if (val[str[j]-'a'] == '0') {
	                    temp++;
	                }
	                if (temp > k) {
	                    break;
	                }
	                if (j-i > max) {
	                max = j-i;
	                }
	            }
	        }
	        return max+1;*/
		    int temp = 0;
	        for (int i =0, j = 0; j < str.length; j++) {
	            if (val[str[j]-'a'] == '1') {
	                
	            } else {
	                if (temp < k) {
	                    temp++;
	                } else {
	                    while ((i <= j) && temp == k) {
	                        if (val[str[i]-'a'] == '0') {
	                            temp--;
	                        }
	                        i++;
	                    }
	                    temp++;
	                }
	            }
	           // System.out.println(" c " + str[j] + " i " + i + " j " + j + " val[c-a] " + val[str[j]-'a'] + " temp " + temp);
	            if (j-i > max) {
	                max = j-i;
	            }    
	        }
	        return max+1;
	        
	        
	    }
	    
	    
	      //Definition for an interval.
	      public class Interval {
	          int start;
	          int end;
	          Interval() { start = 0; end = 0; }
	          Interval(int s, int e) { start = s; end = e; }
	     }
	    
	    public boolean canAttendMeetings(Interval[] intervals) {
	    	Arrays.sort(intervals, (a,b)-> a.start-b.start);
	    	for (int i = 1; i<intervals.length; i++) {
	    		if (intervals[i-1].end > intervals[i-1].start) {
	    			return false;
	    		}
	    	}
	        return true;
	    }

	    /*public List<Interval> merge(List<Interval> intervals) {
	    	intervals.sort((a, b)-> a.start-b.start);
	    	for (int i = 0; i < itne)
	    }*/
	    
	    public String addBinary(String a, String b) {
	    	int m = a.length(), n = b.length();
	    	String ret = "";
	    	int carry = 0;
	    	int  i, j;
	        for (i = m-1, j = n-1; i >= 0 && j>=0; i--,j--) {
	        	int temp = carry + a.charAt(i) + b.charAt(j) - '0' - '0';
                if (temp < 2) {
                	carry = 0;
                } else {
                    temp--;
                    carry = 1;
                }
                ret = temp + "";
	        }
	        
	        while (i >= 0) {
	        	ret = a.charAt(i) + "";
	        	i--;
	        }
	        while (j >= 0) {
	        	ret = b.charAt(j) + "";
	        	j--;
	        }
	        return ret;
	    }
	    
	    public boolean canCross(int[] stones) {
	    	
	        if (stones.length < 2) {
	        	return false;
	        }
	        boolean[] dp = new boolean[stones.length];
	        if ((stones[0] != 0) || (stones[1] != 1)) {
	        	 return false;
	        }
	        dp[0] = true;
	        dp[1] = true;
	        dp[stones.length-1] = canCrossHelper(stones, 0, 0, dp);
	        return dp[stones.length-1];
	    }

		private boolean canCrossHelper(int[] stones, int position, int k, boolean[] dp) {
			/*if (stones[position] == stones[p])
			canCrossHelper(stones, position++, )*/
			return false;
		}
		
	    public List<List<String>> groupAnagrams(String[] strs) {
	      Map<String, List<String>> map = new HashMap<String, List<String>>();
    	  int[] count = new int[26];
	      for (String st : strs) {
	    	  Arrays.fill(count, 0);
	    	  for (char ch : st.toCharArray()) {
	    		  count[ch-'a']++;
	    	  }
	    	  String key = "";
	    	  for (int i : count) {
	    		  key = key + "#" + i; 
	    	  }
	    	  if (!map.containsKey(key)) {
	    		  map.put(key, new ArrayList<String>());
	    	  }
	    	  map.get(key).add(st);
	      }
	      return new ArrayList<List<String>>(map.values());
	    }
}

//[0,1,3,6,10,13,15,18]
