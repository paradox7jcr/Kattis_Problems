package problemSet2;

import java.util.Hashtable;
import java.util.Scanner;

public class AddingWords {
	
	public static int parseCalculation(Scanner s, Hashtable<String, Integer> k) {
		String var1 = s.next();
		String op = s.next();
		boolean impossible = false;
		
		
		int result = 0;
		if(k.containsKey(var1)) {
			result = k.get(var1);
			System.out.print(var1 + " " + op + " ");
		}
		else{
			String line = s.nextLine();
			System.out.print(var1 + " " + op + line + " ");
			impossible = true;
		}
			
		
		while(!op.equals("=") && !impossible) {
			String var2 = s.next();
			System.out.print(var2);
			int y = 0;
			if(k.containsKey(var2))
				y = k.get(var2);
			else
				impossible = true;
			switch(op) {
			case "+":
				result = result + y;
				break;
			case "-":
				result = result - y;
				break;
			default: 
				//System.out.println("Error");
				break;
			}
			op = s.next();
			System.out.print(" " + op + " ");
		}
		String answer = s.next();
		if(!k.contains(result)) {
			impossible = true;
		}
		if(impossible) {
			return 9999;
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Hashtable<String, Integer> key = new Hashtable<String, Integer>(2001);
		Hashtable<Integer, String> key2 = new Hashtable<Integer, String>(2001);
		
		while(scanner.hasNext()) {
			String command = scanner.next();
			switch(command) {
				case "def":
					String var = scanner.next();
					int val = scanner.nextInt();
					int currval;
					if(key.containsKey(var)) {
						key2.remove(key.remove(var));
					}
					/*
					String currval2;
					if(key2.containsKey(val)) {
						key.remove(key2.remove(val));
					}
					*/
					key.put(var, val);
					key2.put(val, var);
					//System.out.println(var + " " + val);
					break;
				case "calc":
					int result = parseCalculation(scanner, key);
					//System.out.println(result);
					if(key2.containsKey(result))
						System.out.println(key2.get(result));
					else
						System.out.println("unknown");
					break;
				case "clear":
					key.clear();
					key2.clear();
					break;
				default:
					break;
			}
		}
		
	}

}
