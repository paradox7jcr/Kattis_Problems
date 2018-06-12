import java.math.BigDecimal;
import java.util.Scanner;

public class SierpinskiCircumference {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int caseNum = 1;
		int n;
		
		while(sc.hasNext()) {
			n = sc.nextInt();
			BigDecimal numSolution = sierpinski(n);
			System.out.println("Case " + caseNum + ": " + (numSolution.precision() - numSolution.scale()) + " " + numSolution);
			caseNum++;
		}
		

	}
	
	public static BigDecimal sierpinski(int n) {
		if(n == 0) {
			return BigDecimal.valueOf(3.0);
		}
		BigDecimal c = BigDecimal.valueOf(1.5);
		BigDecimal num = c.multiply(BigDecimal.ONE.subtract(c.pow(n)));
		return num.divide(BigDecimal.ONE.subtract(c)).add(BigDecimal.valueOf(3.0));
	}

}

// 3, 3 + (3/2^i)*3^i

/*
0
1
5
10
100
999
9999
10000
*/