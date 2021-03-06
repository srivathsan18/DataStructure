import java.util.*;

// This class represents a directed graph using adjacency list 
// representation 
class DFS {

    int nodes;
    boolean visited[];
    String connectednodes="";
    LinkedList<Integer>[] graphconnection;

    @SuppressWarnings({"unchecked"}) // added to remove array of linkedlist warning;
    public DFS(int nodes) {
        this.nodes = nodes;       
        graphconnection = new LinkedList[nodes];
        visited = new boolean[nodes];
        for (int i = 0; i < nodes; i++) {
            graphconnection[i] = new LinkedList<Integer>();
        }
    }

    // Adding the edges for the node
    public void addEdges(int startnode, int endnode) {
        graphconnection[startnode].add(endnode);
    }

    public void startNode(int startnode) {
        depthFirstSearchAlg(startnode);
        System.out.println(connectednodes);
    }

   
    private void depthFirstSearchAlg(int currentnode) {
        
        visited[currentnode]=true;
        connectednodes=connectednodes+"->"+currentnode;
        var node =graphconnection[currentnode];

        Iterator<Integer> i= node.iterator();
            
        while(i.hasNext()){
            int itrnode=(int)i.next();
            if(!visited[itrnode])
            depthFirstSearchAlg(itrnode);
        }        
        }

    public static void main(String args[]) {

        System.out.println("Enter the number of nodes");

        // static value for nodes
        DFS qr = new DFS(5);

        // static values for edges
        qr.addEdges(0, 1);
        //qr.addEdges();
        qr.addEdges(1, 1);
        qr.addEdges(1, 2);

        qr.startNode(0);
    }
}
