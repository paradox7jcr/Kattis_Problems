import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;
public class ClosestSums {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] nums, queries;
		Vector<Integer> sums;
		int testCase = 1;
		
		while(s.hasNext()) {
			System.out.println("Case " + testCase + ":");
			testCase++;
			int n = s.nextInt();
			int i, j;
			nums = new int[n];
			sums = new Vector<Integer>();
			for(i = 0; i < n; i++) {
				nums[i] = s.nextInt();
			}
			
			int m = s.nextInt();
			queries = new int[m];
			for(i = 0; i < m; i++) {
				queries[i] = s.nextInt();
			}
			
			for(i = 0; i < n - 1; i++) {
				for(j = i + 1; j < n; j++) {
					sums.add(nums[i] + nums[j]);
				}
			}
			Collections.sort(sums);
			//System.out.println(sums);
			
			
			
			for(i = 0; i < m; i++) {
				int index = Collections.binarySearch(sums, queries[i]);
				int answer;
				if(index >= 0 && index < sums.size()) {
					answer = sums.get(index);
				}
				else if(index == -1) {
					answer = sums.get(0);
				}
				else {
					if(index < -1)
						index = -index;
					if(index > sums.size() - 1) {
						index = sums.size() - 1;
					}
					answer = sums.get(index);
				}
				if(answer == queries[i]) {
					System.out.println("Closest sum to " + queries[i] + " is " + answer + ".");
				}
				else if(index == sums.size() - 1 || index == -1) {
					System.out.println("Closest sum to " + queries[i] + " is " + answer + ".");
				}
				else {
					int lowIndex = index >= 2 ? index - 2 : 0;
					int highIndex = index >= 1? index - 1: 0;
					int lowerBound = sums.get(lowIndex);
					int upperBound = sums.get(highIndex);
					if(queries[i] - lowerBound <= upperBound - queries[i]) {
						answer = lowerBound;
					}
					else {
						answer = upperBound;
					}
					System.out.println("Closest sum to " + queries[i] + " is " + answer + ".");
				}
			}
			
		}

	}

}
