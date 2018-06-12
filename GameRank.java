import java.util.Scanner;

public class GameRank {
	
	public static class GameState{
		int rank = 25;
		int stars = 0;
		int streak = 0;
		
		GameState(){}
		
		public void gainStar() {
			streak++;
			
			if(streak >= 3 && rank >= 6) {
				streak = 1;
				gainStar();
			}
			
			if(rank < 1) {
				
			}
			else if(rank <= 10) {
				stars++;
				if(stars > 5) {
					stars = 1;
					rank --;
				}
			}
			else if(rank <= 15) {
				stars++;
				if(stars > 4) {
					stars = 1;
					rank --;
				}
			}
			else if(rank <= 20) {
				stars++;
				if(stars > 3) {
					stars = 1;
					rank --;
				}
			}
			else if(rank <= 25) {
				stars++;
				if(stars > 2) {
					stars = 1;
					rank --;
				}
			}
		}
		public void loseStar() {
			streak = 0;
			if(rank < 1) {
				
			}
			else if(rank <= 10) {
				stars--;
				if(stars < 0) {
					rank++;
					if(rank == 11) {
						stars = 3;
					}
					else {
						stars = 4;
					}
				}
			}
			else if(rank <= 15) {
				stars--;
				if(stars < 0) {
					rank++;
					if(rank == 16) {
						stars = 2;
					}
					else {
						stars = 3;
					}
				}
			}
			else if(rank <= 20) {
				stars--;
				if(stars < 0) {
					rank++;
					if(rank == 21) {
						stars = 0;
						rank = 20;
					}
					else {
						stars = 2;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		char[] record = s.nextLine().toCharArray();
		
		GameState game = new GameState();
		
		for(int i = 0; i < record.length; i++) {
			if(record[i] == 'W') {
				game.gainStar();
			}
			else if(record[i] == 'L') {
				game.loseStar();
			}
		}
		
		if(game.rank == 0)
			System.out.println("Legend");
		else
			System.out.println(game.rank);
		//System.out.println(game.stars);
	}

}
