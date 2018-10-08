import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution1 {
 // Complete the minimalCost function below.
	static HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
	static int set = 0;
    static int minimalCost(int n, String[] pairs) {
    	int cost = 0;
    	int total = 0;
    	for (String pair : pairs) {
    		String[] nums = pair.split(" ");
    		insert(Integer.parseInt(nums[0]), Integer.parseInt(nums[1]));
    	}
    	Iterator<Integer> it = map.keySet().iterator();
    	while(it.hasNext()) {
    		int curr = it.next();
    		ArrayList<Integer> list = (ArrayList<Integer>) map.get(curr);
    		int size = list.size();
    		total += size;
    		cost = cost + (int) Math.ceil(Math.sqrt(size));
    	}
    	
    	if (total < n) {
    		cost = cost + (int) Math.ceil(Math.sqrt(n-total));
    	}
		return cost;
    }

    static void insert(int a, int b) {
    	Iterator<Integer> it = map.keySet().iterator();
    	while(it.hasNext()) {
    		int curr = (Integer) it.next();
    		ArrayList<Integer> list = (ArrayList<Integer>) map.get(curr);
    		if (list.contains(a) || list.contains(b)) {
    			if (!list.contains(a)) {
    				list.add(a);
    			} else {
    				list.add(b);
    			}
    			map.put(curr, list);
    			return;
    		}
    	}
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	list.add(a);
    	list.add(b);
    	map.put(++set, list);
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    	String hi = "how are you doing?";
    	String[] split = hi.split(" ");
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int pairsCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] pairs = new String[pairsCount];

        for (int i = 0; i < pairsCount; i++) {
            String pairsItem = scanner.nextLine();
            pairs[i] = pairsItem;
        }

        int res = minimalCost(n, pairs);

        System.out.println("res  " + res);
        /*bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();*/

        scanner.close();
    }
}