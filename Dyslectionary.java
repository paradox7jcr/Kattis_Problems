import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class Dyslectionary {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		Vector<String> words = new Vector<String>();
		
		boolean stillgoing = true;
		while(sc.hasNext()) {
			int maxLen = 0;
			String word;
			words = new Vector<String>();
			
			while(true) {
				word = sc.nextLine();
				if(!sc.hasNext()) {
					stillgoing = false;
				}
				if(word.isEmpty())
					break;
				
				maxLen = Math.max(maxLen, word.length());
				words.add(reverse(word));
				
				if(!stillgoing)
					break;
			}
			Collections.sort(words);
			String format = "%" + maxLen + "s\n";
			for(String s : words) {
				System.out.printf(format, reverse(s));
			}
			
			if(stillgoing) {
				System.out.println();
			}
		}
	}
	
	public static String reverse(String original) {
		char[] wordArray = original.toCharArray();
		int len = wordArray.length;
		char[] newWordArray = new char[wordArray.length];
		for(int i = 0; i < len; i++) {
			newWordArray[i] = wordArray[len-i-1];
		}
		return String.valueOf(newWordArray);
	}
}

/*
apple
banana
grape
kiwi
pear

airplane
bicycle
boat
car

*/
