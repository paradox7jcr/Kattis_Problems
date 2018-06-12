import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ColoringSocks {
	
	public static class bin{
		long max;
		long capacity;
		long maxdiff;
		long num;
		
		bin(long cap, long maxd){
			capacity = cap;
			max = -1;
			num = 0;
			maxdiff = maxd;
		}
		
		public boolean add(long element) {
			if(num == capacity)
				return false;
			if(max == -1) {
				max = element;
				num++;
				return true;
			}
			else {
				if(max - element <= maxdiff) {
					num ++;
					return true;
				}
				else {
					return false;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		long socks = s.nextLong();
		long capacity = s.nextLong();
		long maxDiff = s.nextLong();
		
		PriorityQueue<Long> pq = new PriorityQueue<Long>(Collections.reverseOrder());
		
		
		for(long i = 0; i < socks; i++) {
			pq.add(s.nextLong());
		}
		
		bin b = new bin(capacity, maxDiff);
		long numBins = 1;
		while(!pq.isEmpty()) {
			boolean success = false;
			
			while(!success && !pq.isEmpty()) {
				long num = pq.poll();
				success = b.add(num);
				if(!success) {
					b = new bin(capacity, maxDiff);
					b.add(num);
					numBins++;
				}
			}
		}
		
		System.out.println(numBins);
	}

}
