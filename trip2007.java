import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class trip2007 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		
		
		int n = s.nextInt();
		Vector<Integer> v = new Vector<Integer>(n);
		
		String answer = "";
		
		while(n != 0) {
			for(int i = 0; i < n; i++) {
				v.add(s.nextInt());
			}
			//Collections.sort(v, Collections.reverseOrder());
			int total = 0;
			while(!v.isEmpty()) {
				int bagmin = v.remove(0);
				total++;
				answer += (bagmin + " ");
				int i = 0;
				while(i < v.size() && !v.isEmpty()) {
					if(v.get(i) > bagmin) {
						int newbag = v.remove(i);
						bagmin = newbag;
						answer += (newbag + " ");
					}
					else {
						i++;
					}
				}
				answer+="\n";
			}
			
			answer = total + "\n" + answer;
			System.out.println(answer);
			
			System.out.println();
			n = s.nextInt();
		}
	}

}

/*
10
2 2 4 3 1 1 3 2 5 1
11
2 2 4 3 1 1 3 2 5 1 9
0
*/
