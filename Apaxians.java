import java.util.Scanner;

public class Apaxians {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char[] name = sc.nextLine().toCharArray();
		String answer = "";
		answer += name[0];
		char last = name[0];
		for(int i = 1; i < name.length; i++) {
			char curr = name[i];
			if(curr == last) {
				
			}
			else {
				answer += curr;
			}
			last = curr;
		}
		System.out.println(answer);
	}

}
