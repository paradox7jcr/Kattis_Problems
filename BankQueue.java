import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BankQueue {
	
	public static class Person implements Comparable<Person>{
		int money;
		int time;
		
		Person(int m, int t){
			this.money = m;
			this.time = t;
		}
		
		@Override
		public int compareTo(Person a) {
			return this.money - a.money;
		}
	}
	
	public static class Solution{
		int sum;
		int availableSpots;
		int[] customers;
		
		Solution(int n){
			customers = new int[n];
			availableSpots = n;
		}
		
		public boolean add(int value, int position) {
			if(availableSpots == 0) {
				return false;
			}
			if(position < 0) {
				return true;
			}
			if(position > customers.length - 1) {
				position = customers.length - 1;
			}
			if(customers[position] == 0) {
				customers[position] = value;
				sum += value;
				availableSpots--;
				return true;
			}
			else {
				return add(value, position - 1);
			}
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int close = s.nextInt();
		int i;
		
		Solution sol = new Solution(close);
		PriorityQueue<Person> line = new PriorityQueue<Person>(Collections.reverseOrder());
		
		
		for(i = 0; i < n; i++) {
			int m = s.nextInt();
			int t = s.nextInt();
			line.add(new Person(m, t));
		}
		
		boolean addition = true;
		int position;
		Person p;
		while(addition) {
			if(!line.isEmpty())
				p = line.poll();
			else
				break;
			position = p.time;
			addition = sol.add(p.money, position);
		}
		System.out.println(sol.sum);
	}

}

/*
9 3
1000 1
2000 3
500 2
1500 1
1200 0
1400 4
5000 6
1500 7
20 5

5 2
100 8
27 20
29 9
19 1
17 3
*/
