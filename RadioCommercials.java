import java.util.Scanner;
import java.util.Vector;
public class RadioCommercials {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int cost = s.nextInt();
		
		int[] profits = new int[n];
		for(int i = 0; i < n; i++) {
			profits[i] = (s.nextInt()-cost);
		}
		
		int maxVal = 0;
		int currVal = 0;
		
		for(int i = 0; i < n; i++) {
			if(profits[i] > currVal + profits[i]) {
				currVal = profits[i];
			}
			else {
				currVal += profits[i];
			}
			if(currVal > maxVal){
				maxVal = currVal;
			}
		}
		System.out.println(maxVal);
	}
}
