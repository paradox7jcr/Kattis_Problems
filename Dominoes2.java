import java.util.HashSet;
import java.util.Scanner;
import java.util.Vector;

public class Dominoes2 {
	static class Node
	{
		int x;
		boolean knockedOver;
		HashSet<Integer> adjList;
		
		Node(int x){
			this.x = x;
			knockedOver = false;
			adjList = new HashSet<Integer>();
		}
		
		Node(Node n){
			this.x = n.x;
			this.knockedOver = n.knockedOver;
			this.adjList = (HashSet<Integer>) n.adjList.clone();
		}
	}
		
	static class Graph
	{
	    int V;
	    Vector<Node> nodes;
	    int knockedOver;
	     
	    Graph()
	    {
	    	V = 0;
	        nodes = new Vector<Node>();
	    }
	    
	    Graph(int V)
	    {
	        this.V = V;
	        nodes = new Vector<Node>();
	        for(int i = 0; i < V ; i++){
	            nodes.add(new Node(i));
	        }
	    }
	    
	    Graph(Graph g){
	    	this.V = g.V;
	    	this.nodes = new Vector<Node>();
	    	for(int i = 0; i < this.V; i++) {
	    		this.nodes.add(new Node(g.nodes.get(i)));
	    	}
	    }
	    
	    void addNode(int i){
	    	nodes.add(new Node(i));
	    	V++;
	    }
	}
	static void addEdge(Graph graph, int v1, int v2)
	{
	    graph.nodes.get(v1).adjList.add(v2);
	    //graph.nodes.get(v2).adjList.add(v1);
	}
	static void printGraph(Graph graph)
	{       
	    for(Node n : graph.nodes)
	    {
	        System.out.println("Adjacency list of vertex "+ n.x);
	        System.out.print("head");
	        for(int pCrawl: n.adjList){
	            System.out.print(" -> "+graph.nodes.get(pCrawl).x);
	        }
	        System.out.println("\n");
	    }
	}
	
	static int fallen = 0;

	public static void main(String[] args) throws CloneNotSupportedException {
		Scanner s = new Scanner(System.in);
		
		int i, j, t, n, m, l, z;
		t = s.nextInt();
		
		for(i = 0; i < t; i++) {
			n = s.nextInt();
			Graph g = new Graph(n);
			
			m = s.nextInt();
			l = s.nextInt();
			
			for(j = 0; j < m; j++) {
				addEdge(g, s.nextInt()-1, s.nextInt()-1);
			}
			//printGraph(g);
			
			for(j = 0; j < l; j++) {
				z = s.nextInt() - 1;
				howManyFall(g, g.nodes.get(z));
			}
			System.out.println(g.knockedOver);
		}
	}
	
	public static void howManyFall(Graph g, Node curr) {
		if(curr.knockedOver) {
			return;
		}
		else {
			curr.knockedOver = true;
			g.knockedOver++;
			for (int x : curr.adjList) {
				howManyFall(g, g.nodes.get(x));
			}
			return;
		}
	}

}

/*
1
3 2 2
1 2
2 3
2
1
1
8 4 2
1 2
2 3
5 1
2 4
2
5
*/
