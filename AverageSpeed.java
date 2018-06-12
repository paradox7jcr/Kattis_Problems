import java.util.Scanner;

public class AverageSpeed {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = 0;
		int m = 0;
		int s = 0;
		double seconds = 0;
		
		int speed = 0;
		double distance = 0.0;
		
		while(sc.hasNextLine()) {
			String[] end = sc.nextLine().split(" ");
			int h2 = Integer.parseInt(end[0].substring(0, 2));
			int m2 = Integer.parseInt(end[0].substring(3, 5));
			int s2 = Integer.parseInt(end[0].substring(6, 8));
			
			double seconds2 = h2*3600 + m2*60 + s2;
			double hoursPassed = (seconds2 - seconds)/3600;
			distance += hoursPassed*speed;
			
			h = h2;
			m = m2;
			s = s2;
			seconds = seconds2;
			
			
			if(end.length > 1) {
				speed = Integer.parseInt(end[1]);
			}
			else {
				System.out.print(end[0] + " ");
				System.out.printf("%.2f", distance);
				System.out.println(" km");
			}
		}
	}
	
}
