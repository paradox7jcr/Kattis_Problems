import java.util.Scanner;

public class GettingGold {
	public static class Point{
		double x, y;
		
		Point(double _x, double _y){
			x = _x;
			y = _y;
		}
		
		public double distanceTo(Point p){
			return Math.abs((p.x - this.x)) + Math.abs((p.y - this.y));
		}
	}
	
	public static class Node{
		char type;
		boolean visited;
		
		Node(char t){
			type = t;
			visited = false;
		}
	}
	
	public static void PrintMap(Node[][] map) {
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j].type);
			}
			System.out.println();
		}
	}
	
	static Node[][] map;
	static int gold = 0;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int c = s.nextInt();
		int r = s.nextInt();
		map = new Node[r][c];
		s.nextLine();
		
		int x = 0;
		int y = 0;
		
		for(int i = 0; i < r; i++) {
			char[] line = s.nextLine().toCharArray();
			for(int j = 0; j < c; j++) {
				map[i][j] = new Node(line[j]);
				if(line[j] == 'P') {
					x = i;
					y = j;
				}
			}
		}
		BFS(x, y);
		
		System.out.println(gold);
	}
	
	public static void BFS(int r, int c) {
		if(map[r][c].visited || map[r][c].type == '#') {
			return;
		}
		else {
			map[r][c].visited = true;
			if(map[r][c].type == 'G') {
				gold ++;
			}
		}
		boolean noTraps = true;
		if(r-1 >= 0) {
			if(map[r-1][c].type == 'T')
				noTraps = false;
		}
		if(r+1 < map.length) {
			if(map[r+1][c].type == 'T')
				noTraps = false;
		}
		if(c-1 >= 0) {
			if(map[r][c-1].type == 'T')
				noTraps = false;
		}
		if(c+1 < map[0].length) {
			if(map[r][c+1].type == 'T')
				noTraps = false;
		}
		if(noTraps) {
			if(r-1 >= 0) {
				BFS(r-1, c);
			}
			if(r+1 < map.length) {
				BFS(r+1, c);
			}
			if(c-1 >= 0) {
				BFS(r, c-1);
			}
			if(c+1 < map[0].length) {
				BFS(r, c+1);
			}
		}
		else {
			return;
		}
	}

}
