import java.util.Scanner;

public class PopularVote {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int T = s.nextInt();
		
		for(int i = 0; i < T; i++) {
			int candidates = s.nextInt();
			int mostVotes = 0;
			int candidateMostVotes = 0;
			int sumOfVotes = 0;
			boolean tie = false;
			for(int j = 0; j < candidates; j++) {
				int v = s.nextInt();
				sumOfVotes += v;
				if(v > mostVotes) {
					mostVotes = v;
					candidateMostVotes = j;
					tie = false;
				}
				else if(v == mostVotes) {
					tie = true;
				}
				//System.out.println(sumOfVotes + ", " + mostVotes);
			}
			if(tie) {
				System.out.println("no winner");
			}
			else {
				double dsum = (double)sumOfVotes;
				dsum = dsum/2;
				if(((double)mostVotes) <= dsum) {
					System.out.println("minority winner " + (candidateMostVotes + 1));
				}
				else {
					System.out.println("majority winner " + (candidateMostVotes + 1));
				}
			}
		}

	}

}
