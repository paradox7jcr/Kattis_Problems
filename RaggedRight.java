import java.util.Scanner;
import java.util.Vector;

public class RaggedRight {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Vector<Integer> lineLens = new Vector<Integer>();
		
		long raggedness = 0;
		int maxLen = 0;
		
		while(sc.hasNextLine()) {
			int temp = sc.nextLine().length();
			if(temp == 0)
				break;
			maxLen = Math.max(maxLen, temp);
			lineLens.add(temp);
		}
		for(int i = 0; i < lineLens.size(); i++) {
			raggedness += Math.pow((maxLen - lineLens.get(i)), 2);
		}
		System.out.println(raggedness);
	}

}
