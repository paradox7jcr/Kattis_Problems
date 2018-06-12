import java.util.Scanner;

public class TreasureHunt {
	
	public static Node[][] map;
	public static int travelTime = 0;
	public static int r;
	public static int c;
	static String answer;
	
	public static class Node{
		char type;
		boolean visited;
		
		Node(char c){
			type = c;
			visited = false;
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		r = s.nextInt();
		c = s.nextInt();
		s.nextLine();
		
		map = new Node[r][c];
		
		for(int i = 0; i < r; i++) {
			char[] line = s.nextLine().toCharArray();
			for(int j = 0; j < c; j++) {
				map[i][j] = new Node(line[j]);
			}
		}
		int x = 0;
		int y = 0;
		
		beginTravel(x, y);
		System.out.println(answer);
	}
	
	static void beginTravel(int x, int y){
		char direction = map[x][y].type;
		map[x][y].visited = true;
		switch(direction) {
			case 'N':
				x--;
				break;
			case 'S':
				x++;
				break;
			case 'W':
				y--;
				break;
			case 'E':
				y++;
				break;
			case 'T':
				answer = Integer.toString(travelTime);
				return;
			default:
				System.out.println("Error");
				break;
		}
		if(x >= r || x < 0) {
			answer = "Out";
			return;
		}
		else if(y >= c || y < 0) {
			answer = "Out";
			return;
		}
		if(map[x][y].visited) {
			answer = "Lost";
			return;
		}
		travelTime++;
		beginTravel(x, y);
	}

}
