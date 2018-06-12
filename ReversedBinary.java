import java.util.Scanner;

public class ReversedBinary {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int number = s.nextInt();
		char[] binNum = Integer.toBinaryString(number).toCharArray();
		char[] revBinNum = new char[binNum.length];
		
		int j = binNum.length - 1;
		for(int i = 0; i < binNum.length; i++) {
			revBinNum[i] = binNum[j];
			j--;
		}
		
		String revBin = String.valueOf(revBinNum);
		
		int result = Integer.parseInt(revBin, 2);
		System.out.println(result);
	}
}
