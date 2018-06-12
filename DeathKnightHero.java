import java.util.Scanner;
public class DeathKnightHero {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int wins = 0;
		
		for(int i = 0; i < n; i++) {
			String line = s.next();
			if(!line.contains("CD")) {
				wins++;
			}
		}
		System.out.println(wins);
	}

}
