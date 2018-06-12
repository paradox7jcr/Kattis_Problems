import java.util.Scanner;

public class FallingMugs {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		long d = s.nextLong();
		
			for(long i = 0; i <= d; i++) {
				long n1 = i * i;
				long n2d = (long) Math.sqrt(d + n1);
				if(n2d % 1 == 0) {
					long n2 = n2d;
					long j = (long)Math.pow(n2, 2);
					if(j - n1 == d) {
						System.out.println((long)Math.sqrt(n1) + " " + n2);
						return;
					}
				}
			}
		System.out.println("impossible");
		}
}

/*
x^2 - y^2 = d

x^2 = d + y^2

i = x^2
j = y^2

*/

/*
Test Inputs
4 -> 0 2
9 -> 0 3
7 -> 2 4
190000 -> 60 440
222222 -> impossible
40000000000 -> 0 200000
*/