package problemSet2;

import java.util.Scanner;
import java.util.Queue;
import java.util.Stack;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;;

public class GuessTheDataStructure {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(s.hasNextInt()) {
			int n = s.nextInt();
			//System.out.println(n);
			
			
			boolean isqueue = true;
			boolean isstack = true;
			boolean ispqueue = true;
			
			Queue<Integer> q = new LinkedList<Integer>();
			Stack<Integer> stack = new Stack<Integer>();
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>(n, Collections.reverseOrder());
			
			for(int i = 0; i < n; i++) {
				String output;
				int instruction, number;
				instruction = s.nextInt();
				number = s.nextInt();
				if(instruction == 1) {
					//System.out.println("Adding " + number);
					q.add(number);
					stack.add(number);
					pq.add(number);
				}
				else {
						//System.out.println("Removing " + number);
						int x, y, z;
						if(isqueue) {
							if(q.size() > 0) {
								x = q.remove();
								//System.out.println(x);
								if(x != number)
									isqueue = false;
							}
							else {
								isqueue = false;
							}
						}
						if(isstack) {
							if(stack.size() > 0) {
								y = stack.pop();
								//System.out.println(y);
								if(y != number)
									isstack = false;
							}
							else {
								isstack = false;
							}
							
						}
						if(ispqueue) {
							if(pq.size() > 0) {
							z = pq.remove();
							//System.out.println(z);
							if(z != number)
								ispqueue = false;
							}
							else {
								ispqueue = false;
							}
						}
						//System.out.println(isqueue + " " + isstack + " "+ ispqueue);
					}
				}
			String output;
			if(isqueue || isstack || ispqueue) {
				if((isqueue && isstack) || (isqueue && ispqueue) || (isstack && ispqueue) || (isqueue && isstack && ispqueue)) {
					output = "not sure";
				}
				else {
					output = isqueue ? "queue" : (isstack ? "stack" : (ispqueue ? "priority queue" : "impossible"));
				}
			}
			else {
				output = "impossible";
			}
			System.out.println(output);
		}
		s.close();
	}
}
