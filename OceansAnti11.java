import java.math.BigInteger;
import java.util.Scanner;

public class OceansAnti11 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		int n;
		for(int i = 0; i < t; i++) {
			n = sc.nextInt();
			System.out.println(fibonacci(n));
		}
	}
	
	public static BigInteger fibonacci(int n) {
		if(n == 1) {
			return BigInteger.valueOf(2);
		}
		if(n == 2) {
			return BigInteger.valueOf(3);
		}
		BigInteger last = BigInteger.valueOf(2);
		BigInteger curr = BigInteger.valueOf(3);
		for(int i = 2; i < n; i++) {
			BigInteger next = last.add(curr);
			last = curr;
			curr = next;
		}
		return curr.mod(BigInteger.valueOf(1000000007));
	}
}
