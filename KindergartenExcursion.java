package ProblemSet01;
import java.util.Scanner;

public class KindergartenExcursion {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String line = s.nextLine();
		char[] numbers = line.toCharArray();
		long totalSwap = 0;
		int Ones = 0;
		int Twos = 0;
		for(int i = 0; i < numbers.length; i++) {
			switch(numbers[i]) {
			case '2':
				Twos++;
				break;
			case '1':
				totalSwap += Twos;
				Ones++;
				break;
			case '0':
				totalSwap += (Twos + Ones);
				break;
			}
		}
		System.out.println(totalSwap);
	}
}
