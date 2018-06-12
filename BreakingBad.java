import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Vector;

public class BreakingBad {
	
static enum Color{
	BLACK,
	RED,
	NONE
}
	
static class Node
{
	int x;
	Color color;
	Vector<Integer> adjList;
	
	Node(int x){
		this.x = x;
		color = Color.NONE;
		adjList = new Vector<Integer>();
	}
}
	
static class Graph
{
    int V;
    Vector<Node> nodes;
     
    Graph(int V)
    {
        this.V = V;
        nodes = new Vector<Node>();
        for(int i = 0; i < V ; i++){
            nodes.add(new Node(i));
        }
    }
}
static void addEdge(Graph graph, int v1, int v2)
{
    graph.nodes.get(v1).adjList.add(v2);
    graph.nodes.get(v2).adjList.add(v1);
}
static void printGraph(Graph graph)
{       
    for(Node n : graph.nodes)
    {
        System.out.println("Adjacency list of vertex "+ n.x + " " + n.color);
        System.out.print("head");
        for(int pCrawl: n.adjList){
            System.out.print(" -> "+graph.nodes.get(pCrawl).x + " " + graph.nodes.get(pCrawl).color);
        }
        System.out.println("\n");
    }
}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int i;
		int n = s.nextInt();
		
		Graph graph = new Graph(n);
	
		HashMap<String, Integer> numMap = new HashMap<String, Integer>();
		HashMap<Integer, String> stringMap = new HashMap<Integer, String>();
		HashSet<String> walterList = new HashSet<String>();
		HashSet<String> jesseList = new HashSet<String>();
		
		for(i= 0; i < n; i++) {
			String ingredient = s.next();
			//System.out.println(i + ": " + ingredient);
			numMap.put(ingredient, i);
			stringMap.put(i, ingredient);
		}
		
		int m = s.nextInt();
		for(i = 0; i < m; i++) {
			String bad1 = s.next();
			String bad2 = s.next();
			addEdge(graph, numMap.get(bad1), numMap.get(bad2));
		}
		
		Flag(graph);
		boolean bipartite = isBipartite(graph);
		if(!bipartite) {
			System.out.println("impossible");
		}
		else {
			for(Node node : graph.nodes) {
				if(node.color == Color.BLACK || node.color == Color.NONE) {
					walterList.add(stringMap.get(node.x));
				}
				else {
					jesseList.add(stringMap.get(node.x));
				}
			}
		}
		for(String str : walterList) {
			System.out.print(str + " ");
		}
		System.out.println();
		for(String str: jesseList) {
			System.out.print(str + " ");
		}
		//printGraph(graph);
	}
	
	public static void Flag(Graph g) {
		for(Node n : g.nodes) {
			Color c = n.color == Color.NONE ? Color.BLACK : n.color;
			n.color = c;
			Color opposite = c == Color.BLACK ? Color.RED : Color.BLACK;
			mark(g, n, opposite);
		}
	}
	
	public static void mark(Graph g, Node n, Color c) {
		for(int x : n.adjList) {
			Node curr = g.nodes.get(x);
			if(curr.color == Color.NONE) {
				curr.color = c;
				Color opposite = c == Color.BLACK ? Color.RED : Color.BLACK;
				mark(g, curr, opposite);
			}
		}
	}
	
	public static boolean isBipartite(Graph g) {
		for(Node n : g.nodes) {
			Color c = n.color;
			if(c != Color.NONE) {
				for(int x : n.adjList) {
					Node curr = g.nodes.get(x);
					if(curr.color == c) {
						return false;
					}
				}
			}
		}
		return true;
	}
}

/*

6
1
2
3
4
5
6
6
1 3
2 4
2 3
1 6
1 5
3 6

*/