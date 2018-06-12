import java.util.Scanner;

public class PrimaryRegister {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] base = {1, 2, 6, 30, 210, 2310, 30030, 510510};
		
		int[] curr = {sc.nextInt(), sc.nextInt(),sc.nextInt(), sc.nextInt(),
						sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()};
		
		int total = 9699690;
		int sum = 0;
		for(int i = 0; i < 8; i++) {
			sum += (base[i] * curr[i]);
		}
		System.out.println(total - sum -1);

	}

}
// 1 0 4 6 10 12 16 18