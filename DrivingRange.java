import java.util.Scanner;
import java.util.Vector;

public class DrivingRange {
	static class Node
	{
		int x;
		int dist;
		//Vector<Edge> adjList;
		
		Node(int x){
			this.x = x;
			dist = Integer.MAX_VALUE;
			//adjList = new Vector<Edge>();
		}
	}
	
	static class Edge {
		int weight;
		int node1;
		int node2;
		
		Edge(int a, int b, int w){
			node1 = a;
			node2 = b;
			weight = w;
		}
	}
		
	static class Graph
	{
	    int V;
	    Vector<Node> nodes;
	    Vector<Edge> edges;
	     
	    Graph()
	    {
	    	V = 0;
	        nodes = new Vector<Node>();
	    }
	    
	    Graph(int v){
	    	V = v;
	    	nodes = new Vector<Node>();
	    	edges = new Vector<Edge>();
	    	for(int i = 0; i < V; i++) {
	    		nodes.add(new Node(i));
	    	}
	    }
	    
	    void addNode(int i){
	    	nodes.add(new Node(i));
	    	V++;
	    }
	    void addEdge(int a, int b, int w)
		{
	    	Edge e = new Edge(a, b, w);
	    	edges.add(e);
		    //nodes.get(a).adjList.add(e);
		    if(nodes.get(a).dist > e.weight) {
		    	nodes.get(a).dist = e.weight;
		    }
		    //nodes.get(b).adjList.add(e);
		    if(nodes.get(b).dist > e.weight) {
		    	nodes.get(b).dist = e.weight;
		    }
		}
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int m = s.nextInt();
		
		Graph g = new Graph(n);
		
		for(int i = 0; i < m; i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			int w = s.nextInt();
			
			g.addEdge(a, b, w);
		}
		int maxDist = 0;
		for(Node node : g.nodes) {
			if(node.dist > maxDist) {
				maxDist = node.dist;
			}
		}
		if(maxDist > Math.pow(10.0, 9.1)) {
			System.out.println("IMPOSSIBLE");
		}
		else {
			System.out.println(maxDist);
		}
	}

}
