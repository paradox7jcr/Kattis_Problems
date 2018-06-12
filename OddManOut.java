import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Scanner;

public class OddManOut {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		for(int i = 0; i < n; i++) {
			int g = s.nextInt();
			LinkedList<Long> mylist = new LinkedList<Long>();
			
			for(int j = 0; j < g; j++) {
				Long c = s.nextLong();
				if(mylist.contains(c)) {
					mylist.remove(c);
				}
				else {
					mylist.add(c);
				}
			}
			System.out.println("Case #" + (i+1) + ": " + mylist.removeFirst());
		}

	}

}
