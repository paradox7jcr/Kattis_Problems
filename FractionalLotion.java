import java.util.Scanner;

public class FractionalLotion {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(s.hasNextLine()) {
			String line = s.nextLine();
			int n = Integer.parseInt(line.substring(line.indexOf('/') + 1, line.length()));
			int counter = 0;
			
			for(int i = n+1; i <= n*2; i++) {
				double y = i*n/(i-n);
				if((i*y)/(i+y) == n) {
					counter ++;
				}
			}
			System.out.println(counter);
		}
	}

}
