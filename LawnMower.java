import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Vector;

public class LawnMower {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int wp = s.nextInt();
		int lp = s.nextInt();
		double w = s.nextDouble();
		
		while(lp != 0) {
			boolean widthCovered = true;
			boolean lengthCovered = true;
			PriorityQueue<Double> wStart = new PriorityQueue<Double>();
			PriorityQueue<Double> lStart = new PriorityQueue<Double>();
			for(int i = 0; i < wp; i++) {
					wStart.add(s.nextDouble());
			}
			for(int i = 0; i < lp; i++) {
				lStart.add(s.nextDouble());
			}
			double x = wStart.poll();
			if(x > w) {
				widthCovered = false;
			}
			while(!wStart.isEmpty() && widthCovered) {
				double y = wStart.poll();
				if(y - x > w) {
					widthCovered = false;
				}
				else {
					x = y;
				}
			}
			if(x + w/2 < 75.0) {
				widthCovered = false;
			}
			
			
			if(widthCovered) {
				double x1 = lStart.poll();
				if(x1 > w) {
					lengthCovered = false;
				}
				while(!lStart.isEmpty()) {
					double y = lStart.poll();
					if(y - x1 > w) {
						lengthCovered = false;
						break;
					}
					else {
						x1 = y;
					}
				}
				if(x1 + w/2 < 100.0) {
					lengthCovered = false;
				}
			}
			else {
				s.nextLine();
			}
			
			if(widthCovered && lengthCovered) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
			
			wp = s.nextInt();
			lp = s.nextInt();
			w = s.nextDouble();
		}

	}

}
