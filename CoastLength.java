import java.util.Scanner;

public class CoastLength {
	
	public static class Node{
		boolean land;
		boolean outersea;
		
		Node(boolean landOrSea){
			land = landOrSea;
			outersea = false;
		}
	}
	
	public static void PrintMap(Node[][] map) {
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[0].length; j++) {
				if(map[i][j].land) {
					System.out.print("1");
				}
				else {
					System.out.print("0");
				}
			}
			System.out.println();
		}
	}
	
	public static void Fill(Node[][] map, int r, int c) {
		if(map[r][c].outersea || map[r][c].land) {
			return;
		}
		map[r][c].outersea = true;
		if(r-1 >= 0) {
			Fill(map, r-1, c);
		}
		if(r+1 < map.length) {
			Fill(map, r+1, c);
		}
		if(c-1 >= 0) {
			Fill(map, r, c-1);
		}
		if(c+1 < map[0].length) {
			Fill(map, r, c+1);
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int r = s.nextInt();
		int c = s.nextInt();
		
		int R = r+2;
		int C = c+2;
		
		Node[][] map = new Node[R][C];
		//System.out.println(map.length + " " + map[0].length);
		
		int i, j;
		
		for(i = 0; i < R; i++) {
			if(i == 0 || i == R-1) {
				for(j = 0; j < C; j++) {
					map[i][j] = new Node(false);
				}
			}
			else {
				String line = s.next();
				map[i][0] = new Node(false);
				map[i][C-1] = new Node(false);
				for(j = 1; j < C-1; j++) {
					boolean land = line.charAt(j-1) == '1' ? true : false;
					map[i][j] = new Node(land);
				}
			}
		}
		
		//PrintMap(map);
		
		
		Fill(map, 0, 0);
		
		int perimeter = 0;
		for(i = 1; i < R-1; i++) {
			for(j = 1; j < C-1; j++) {
				if(map[i][j].land) {
					if(map[i-1][j].outersea) {
						perimeter++;
					}
					if(map[i+1][j].outersea) {
						perimeter++;
					}
					if(map[i][j-1].outersea) {
						perimeter++;
					}
					if(map[i][j+1].outersea) {
						perimeter++;
					}
				}
			}
		}
		
		System.out.println(perimeter);
	}

}
