import java.util.Scanner;
import java.util.Vector;

public class NPuzzle {
	
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
	
	static Point A = new Point(0, 0);
	static Point B = new Point(0, 1);
	static Point C = new Point(0, 2);
	static Point D = new Point(0, 3);
	static Point E = new Point(1, 0);
	static Point F = new Point(1, 1);
	static Point G = new Point(1, 2);
	static Point H = new Point(1, 3);
	static Point I = new Point(2, 0);
	static Point J = new Point(2, 1);
	static Point K = new Point(2, 2);
	static Point L = new Point(2, 3);
	static Point M = new Point(3, 0);
	static Point N = new Point(3, 1);
	static Point O = new Point(3, 2);

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int i;
		int scatter = 0;
		int row = 0;
		
		for(i = 0; i < 4; i++) {
			String line = s.nextLine();
			int col = 0;
			for(char c : line.toCharArray()) {
				scatter += distance(c, row, col);
				col++;
			}
			row++;
		}
		System.out.println(scatter);
	}
	
	public static double distance(char x, int row, int col) {
		Point p = new Point(row, col);
		switch(x) {
			case 'A':
				return A.distanceTo(p);
			case 'B':
				return B.distanceTo(p);
			case 'C':
				return C.distanceTo(p);
			case 'D':
				return D.distanceTo(p);
			case 'E':
				return E.distanceTo(p);
			case 'F':
				return F.distanceTo(p);
			case 'G':
				return G.distanceTo(p);
			case 'H':
				return H.distanceTo(p);
			case 'I':
				return I.distanceTo(p);
			case 'J':
				return J.distanceTo(p);
			case 'K':
				return K.distanceTo(p);
			case 'L':
				return L.distanceTo(p);
			case 'M':
				return M.distanceTo(p);
			case 'N':
				return N.distanceTo(p);
			case 'O':
				return O.distanceTo(p);
			default:
				return 0.0;
		}
	}

}
