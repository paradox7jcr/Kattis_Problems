import java.util.Scanner;

public class PrintedStatues {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int days = 0;
		
		while(multyplyingShorter(n, days)) {
			days++;
		}
		System.out.println(days+1);
	}
	
	public static boolean multyplyingShorter(int n, int days) {
		return Math.pow(2, days) < n;
	}
}
