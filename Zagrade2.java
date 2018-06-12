import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Zagrade2 {
	
	public static class Equation{
		
		Set<String> stringSet = new HashSet<String>();
		String str;
		int originalPairs;
		char[] charArray;
		int[] leftParens;
		int[] rightParens;
		
		Equation(String s){
			str = s;
			originalPairs = s.length() - s.replaceAll("\\(", "").length();
			charArray = str.toCharArray();
			leftParens = new int[originalPairs];
			rightParens = new int[originalPairs];
			
			Stack<Integer> leftP = new Stack<Integer>();
			int j = 0;
			for(int i = 0; i < charArray.length; i++) {
				if(charArray[i] == '(') {
					leftP.push(i);
				}
				else if(charArray[i] == ')') {
					int l = leftP.pop();
					int r = i;
					leftParens[j] = l;
					rightParens[j] = r;
					j++;
				}
			}
		}
	
		public void splitAndAdd(String str, int index) {
			if(index == originalPairs) {
				stringSet.add(str.replaceAll("\\#", ""));
				return;
			}
			char[] currentString = str.toCharArray();
			currentString[leftParens[index]] = '#';
			currentString[rightParens[index]] = '#';
			String tempMod = String.valueOf(currentString);
			splitAndAdd(tempMod, index + 1);
			splitAndAdd(str, index + 1);
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		PriorityQueue<String> possibilities = new PriorityQueue<String>();
		
		String equation = s.nextLine();
		
		Equation eq = new Equation(equation);
		eq.splitAndAdd(equation, 0);
		
		possibilities.addAll(eq.stringSet);
		possibilities.poll();
		int size = possibilities.size();
		for(int i = 0; i < size; i++) {
			System.out.println(possibilities.poll());
		}		
	}

}

/*
(2+(9+(3*4)))/(3*4)+(8*9+(4*9))
*/