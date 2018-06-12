import java.util.Scanner;

public class BatchetsGame {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		while(s.hasNextLine()) {
		
			int n = s.nextInt();
			int m = s.nextInt();
			
			int[] values = new int[m];
			boolean[] memo = new boolean[n];
			
			for(int i = 0; i < m; i++) {
				values[i] = s.nextInt();
				memo[values[i] -1] = true;
			}
			
			fillMemoBottomUp(n, values, memo);
			
			if(memo[n-1]) {
				System.out.println("Stan wins");
			}
			else {
				System.out.println("Ollie wins");
			}
			s.nextLine();
		}
		
	}

	public static void fillMemoBottomUp(int n, int[] values, boolean[] memo){
		for(int i = 0; i < n; i++) {
			calculateMemo(i, values, memo);
		}
	}
	
	public static void calculateMemo(int i, int[] values, boolean[]memo) {
		boolean temp = true;
		if(memo[i] == true)
			return;
		for(int j = 0; j < values.length; j++) {
			if(!(i - values[j] < 0))
				temp = temp && memo[i - values[j]];
		}
		memo[i] = !temp;
	}
}
