import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Scanner;

public class SynchonizingLists {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = 1;
		
		while(n != 0) {
			n = s.nextInt();
			ArrayList<Integer> L1 = new ArrayList<Integer>();
			ArrayList<Integer> L2 = new ArrayList<Integer>();
			ArrayList<Integer> L1Sorted = new ArrayList<Integer>();
			ArrayList<Integer> L2Sorted = new ArrayList<Integer>();
			Hashtable<Integer, Integer> keys = new Hashtable<Integer, Integer>();
			
			for(int i = 0; i < n; i ++) {
				int x = s.nextInt();
				L1.add(x);
				L1Sorted.add(x);
			}
			for(int i = 0; i < n; i ++) {
				int x = s.nextInt();
				L2.add(x);
				L2Sorted.add(x);
			}
			Collections.sort(L1Sorted);
			Collections.sort(L2Sorted);
			for(int i = 0; i < n; i ++) {
				keys.put(L1Sorted.get(i), L2Sorted.get(i));
			}
			for(int i = 0; i < n; i++) {
				System.out.println(keys.get(L1.get(i)));
			}
			System.out.println();
		}
		
		
		
	}

}
