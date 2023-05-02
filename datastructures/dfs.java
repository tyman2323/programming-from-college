import java.util.LinkedList;
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
   public void dFS(int f){
      boolean visited[] = new boolean[vert];//This will check to see if the node has been visited and make it in an array of booleans
      dFs(f,visited);
   }
   public void dFs(int f, boolean visited[]){
      visited[f] = true;
      System.out.print(f + " ");//this will print out the node after marking it as visited
      for(int x = 0; x<adjList[f].size();x++){
         int fin = adjList[f].get(x);//This will go through the DFS process, if it sees a path it will take the path else it will not 
         if(!visited[fin]){
            dFs(fin,visited);//This will conduct the dfs process recursviely
         }
      }
   }
}
public class dfs{
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
    g.dFS(30);
    }
    catch(Exception e){
      System.out.println("There is an error in the edges or dfs starer, please check them again and make sure they are correct");//Test case for a catch all on all invalid edges and all nodes that do not exist
    }
   } 
   
}
