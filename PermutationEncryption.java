import java.util.Scanner;

public class PermutationEncryption {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int bSize = sc.nextInt();
		
		while(bSize != 0) {
			int[] perm = new int[bSize];
			for(int i = 0; i < bSize; i++) {
				perm[i] = sc.nextInt();
			}
			sc.nextLine();
			
			String message = sc.nextLine();
			int messageLen = message.length();
			int incSize = 0;
			while((messageLen + incSize) % bSize != 0) {
				incSize++;
			}
			for(int i = 0; i < incSize; i++) {
				message += " ";
			}
			char[] paddedM = message.toCharArray();
			//System.out.println(paddedM);
			System.out.print("'");
			for(int i = 0; i < paddedM.length; i+=bSize) {
				char[] temp = new char[bSize];
				for(int j = 0; j < bSize; j++) {
					temp[j] = paddedM[i + perm[j]-1];
				}
				System.out.print(temp);
			}
			System.out.println("'");
			
			bSize = sc.nextInt();
		}
	}

}
