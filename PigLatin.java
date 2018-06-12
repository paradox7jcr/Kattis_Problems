import java.util.HashSet;
import java.util.Scanner;

import javax.xml.stream.events.Characters;

public class PigLatin {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		HashSet<Character> vowels = new HashSet<Character>();
		vowels.add('a');
		vowels.add('e');
		vowels.add('i');
		vowels.add('o');
		vowels.add('u');
		vowels.add('y');
		
		while(sc.hasNextLine()) {
			String[] words = sc.nextLine().split(" ");
			for(int i = 0; i < words.length; i++) {
				char[] curr = words[i].toCharArray();
				if(vowels.contains(curr[0])) {
					System.out.print(words[i] + "yay ");
				}
				else {
					int firstVowel = 1;
					for(int j = 1; j < words[i].length(); j++) {
						if(vowels.contains(curr[j]))
							break;
						firstVowel++;
					}
					System.out.print(words[i].substring(firstVowel) + words[i].substring(0, firstVowel) + "ay ");
				}
			}
			System.out.println();
		}
	}
}
