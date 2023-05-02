import java.util.LinkedList;
import java.util.Iterator;
class Graph{
   int vert;
   LinkedList<Integer> adjList[];//This will allow us create an adjacency list using linked list
   public Graph(int vert){
      this.vert = vert;
      adjList = new LinkedList[vert];
      for(int x = 0; x< vert;x++){
         adjList[x] = new LinkedList<>();
      }
   }
   public void addEdge(int a, int z){//This will create an edge a being the departure and z being the arrival
      adjList[a].addFirst(z);
   }
   public void bfs(int a){
      boolean visit[] = new boolean[vert];//An array of booleans to check whether or not its been visited
      LinkedList<Integer> line = new LinkedList<Integer>();
      visit[a]=true;
      line.add(a);
      while(line.size()!=0){
         a = line.poll();
         System.out.println(a);//Print traversed node
          Iterator<Integer> b = adjList[a].listIterator();
          while(b.hasNext()){
            int c = b.next();
            if(!visit[c]){
               visit[c] = true;//This will go through the graph and if it sees a path it will push it to the queue and then visit it following the BFS algorithim
               line.add(c);
            }
          }
      }
   }
}
public class bfss{
   public static void main(String[] args){
   try{
    Graph g = new Graph(6);
    g.addEdge(0,1);
    g.addEdge(0,2);
    g.addEdge(2,3);
    g.addEdge(2,4);//Adding the edges to the graph and then calling on the dfs method
    g.addEdge(4,5);
    g.addEdge(1,3);
    g.addEdge(3,5);
    g.bfs(0);
    }
    catch(Exception e){
      System.out.println("There is an error in the edges or bfs starer, please check them again and make sure they are correct");//Test case for a catch all on all invalid edges and all nodes that do not exist
    }

}
}