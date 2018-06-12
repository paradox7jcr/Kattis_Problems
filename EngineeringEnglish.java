import java.util.Scanner;
import java.util.TreeSet;

public class EngineeringEnglish {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		TreeSet<String> myList = new TreeSet<String>();
		
		while(s.hasNextLine()) {
			String word = s.nextLine();
			String words[] = word.split(" ");
			for(int i = 0; i < words.length; i++) {
				if(myList.contains(words[i].toLowerCase())) {
					System.out.print(". ");
				}
				else {
					myList.add(words[i].toLowerCase());
					System.out.print(words[i] + " ");
				}
			}
			System.out.println();
		}
	}

}
