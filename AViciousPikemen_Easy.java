import java.util.PriorityQueue;
import java.util.Scanner;

public class AViciousPikemen_Easy {
	public static long A, B, C;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		PriorityQueue<Long> pq = new PriorityQueue<Long>();
		
		long n = sc.nextLong();
		long t = sc.nextLong();
		
		A = sc.nextLong();
		B = sc.nextLong();
		C = sc.nextLong();
		
		long t0 = sc.nextLong();
		
		for(long i = 0; i < n; i++) {
			pq.add(t0);
			t0 = nextTime(t0);
		}
		
		long time = 0;
		long penalty = 0;
		long count = 0;
		t0 = pq.poll();
		while(time + t0 <= t) {
			time += t0;
			penalty += time;
			count++;
			if(pq.isEmpty())
				break;
			t0 = pq.poll();
		}
		System.out.println(count + " " + penalty%1000000007);
	}
	
	public static long nextTime(long t) {
		return ((A*t + B)%C)+1;
	}

}

/*
10 11
1 2 3 4

*/
