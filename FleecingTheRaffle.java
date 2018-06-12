import java.math.BigInteger;
import java.util.Scanner;

public class FleecingTheRaffle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double n = sc.nextDouble();
		double p = sc.nextDouble();

		double lastVal = 0.0;
		n++;
		double trialNum = 1.0;
		double currentVal = probOnce(trialNum, n, p);
		while(lastVal <= currentVal) {
			lastVal = currentVal;
			trialNum++;
			n++;
			currentVal = probOnce(trialNum, n, p);
		}
		
		System.out.printf("%.6f", lastVal);
	}
	
	public static double probOnce(double numer, double denom, double trials) {
		double probHappens = numer/denom;
		numer = denom - numer;
		denom--;
		for(int i = 1; i < trials; i++) {
			probHappens *= (numer/denom);
			denom--;
			numer--;
		}
		return probHappens*trials;
	}
}

/*
3 2
1/4 * 1 = .25
2/5 * 3/4 = .3
3/6 * 3/5 = .3
4/7 * 3/6 = 2/9

*/