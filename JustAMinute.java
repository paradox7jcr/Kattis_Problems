import java.math.BigDecimal;
import java.util.Scanner;

public class JustAMinute {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		double minInSec = 0;
		double sec = 0;
		
		
		for(int i = 0; i < n; i++) {
			minInSec += s.nextDouble() * 60;
			sec += s.nextDouble();
		}
		double dif = sec/minInSec;
		if(dif <= 1) {
			System.out.println("measurement error");
		}
		else {
			System.out.printf("%.9f", dif);
			System.out.println();
		}	
	}
}
