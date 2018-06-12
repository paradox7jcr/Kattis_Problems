import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Akcija {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		long n = s.nextLong();
		
		PriorityQueue<Integer> bookPrices = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		for(long i = 0; i < n; i++) {
			bookPrices.add(s.nextInt());
		}
		
		
		int cost = 0;
		int count = 0;
		while(!bookPrices.isEmpty()) {
			count ++;
			if(count < 3)
				cost += bookPrices.poll();
			else {
				bookPrices.remove();
				count = 0;
			}
		}
		
		System.out.println(cost);
	}

}
