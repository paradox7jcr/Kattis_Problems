import java.util.Scanner;
import java.util.Vector;

public class GoldbachsConjecture {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		int n;
		for(int tnum = 0; tnum < t; tnum++) {
			n = sc.nextInt();
			
			Vector<Integer> primes = primeFactors(n);
			Vector<String> representations = new Vector<String>();
			
			for(int i = 0; i < primes.size(); i++) {
				for(int j = i; j < primes.size(); j++) {
					if(primes.get(i) + primes.get(j) == n) {
						representations.add(primes.get(i) + "+" + primes.get(j));
					}
				}
			}
			System.out.println(n + " has " + representations.size() + " representation(s)");
			for(int i = 0; i < representations.size(); i++) {
				System.out.println(representations.get(i));
			}
			System.out.println();
		}
	}
	
	public static Vector<Integer> primeFactors(int n){
		Vector<Integer> primes = new Vector<Integer>();
		boolean prime[] = new boolean[n+1];
		for(int i = 0; i < n; i++) {
			prime[i] = true;
		}
		for(int p = 2; p*p <=n; p++) {
			if(prime[p]) {
				for(int i = p*2; i <= n; i+=p) {
					prime[i] = false;
				}
			}
		}
		for(int i = 2; i <= n; i++) {
			if(prime[i]) {
				primes.add(i);
			}
		}
		return primes;
	}
}
