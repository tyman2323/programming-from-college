import java.util.LinkedList;
class Graph
{
int V; //Number of Vertices
LinkedList<Integer>[] adj; // adjacency lists
//Constructor
Graph(int V)
{
this.V = V;
adj = new LinkedList[V];
for (int i = 0; i < adj.length; i++)
adj[i] = new LinkedList<Integer>();
}
//To add an edge to graph

void addEdge(int v, int w)
{
adj[v].add(w); // Add w to the list of v.
}
}
public class Main{
   public static void main(String[] args){
      Graph g = new Graph(3);
      g.addEdge(0,1);
   }
   public void pist(int v, int u){
      
   }
}