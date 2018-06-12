import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class ClosingTheLoop {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		for(int i = 0; i < n; i++) {
			int S = s.nextInt();
			
			Vector<Integer> red = new Vector<Integer>();
			Vector<Integer> blue = new Vector<Integer>();
			
			String segment;
			for(int j = 0; j < S; j++) {
				segment = s.next();
				if(segment.substring(segment.length()-1).equals("R")) {
					red.add(Integer.parseInt(segment.substring(0, segment.length()-1)));
				}
				else {
					blue.add(Integer.parseInt(segment.substring(0, segment.length()-1)));
				}
			}
			Collections.sort(red, Collections.reverseOrder());
			Collections.sort(blue, Collections.reverseOrder());
			int answer;
			if(red.isEmpty() || blue.isEmpty()) {
				answer = 0;
			}
			else {
				int redIndex = 0;
				int blueIndex = 0;
				int redStart = 0;
				int blueStart = 0;
				boolean canAddRed = true;
				boolean canAddBlue = true;
				
				boolean even = false;
				
				while(canAddRed && canAddBlue) {
					int r = red.get(redIndex);
					int b = blue.get(blueIndex);
					redStart += (r + b);
					blueStart += (r + b);
					redIndex++;
					blueIndex++;
					canAddRed = redIndex < red.size();
					canAddBlue = blueIndex < blue.size();
				}
				answer = Math.max(redStart-(redIndex*2), blueStart-(blueIndex*2));
			}
			System.out.println("Case #" + (i+1) + ": " + answer);
		}

	}

}
