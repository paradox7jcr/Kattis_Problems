import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PlantingTrees {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int n = s.nextInt();
		PriorityQueue<Integer> list = new PriorityQueue<Integer>(100000, Collections.reverseOrder());
		for(int i = 0; i < n; i ++) {
			int x = s.nextInt();
			list.add(x);
		}
		int max = 0;
		for(int i = 1; i <= n; i++) {
			int x = list.poll();
			if(x + i > max) {
				max = x+i;
			}
		}
		System.out.println(max + 1);
	}

}
