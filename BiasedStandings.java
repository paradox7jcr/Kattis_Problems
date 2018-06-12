import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BiasedStandings {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int T = s.nextInt();
		
		for(int i = 0; i < T; i++) {
			int n = s.nextInt();
			int badness = 0;
			PriorityQueue<Integer> prefs = new PriorityQueue<Integer>();
			for(int j = 0; j < n; j++) {
				s.next();
				prefs.add(s.nextInt());
			}
			for(int j=1; j <= n; j++) {
				int currPref = prefs.poll();
				badness+=(Math.abs(j-currPref));
				//System.out.println(j + "-" + currPref);
			}
			System.out.println(badness);
		}
	}

}
