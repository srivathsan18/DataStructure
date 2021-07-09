import java.util.*;

// This class represents a directed graph using adjacency list 
// representation 
class DFS {

    int nodes;
    boolean visited[];
    String connectedNodes="";
    LinkedList<Integer>[] graphconnection;

    public DFS(int nodes) {
        this.nodes = nodes;
        graphconnection = new LinkedList[nodes];
        visited = new boolean[nodes];
        for (int i = 0; i < nodes; i++) {
            graphconnection[i] = new LinkedList<Integer>();
        }
    }

    // Adding the edges for the node
    public void addEdges(int startNode, int endNode) {
        graphconnection[startNode].add(endNode);
    }

    public void startNode(int startNode) {
        depthFirstSearchAlg(startNode);
        System.out.println(connectedNodes);
    }

    private void depthFirstSearchAlg(int currentnode) {
        
        visited[currentnode]=true;
        connectedNodes=connectedNodes+"->"+currentnode;
        var node =graphconnection[currentnode];

        Iterator i= node.iterator();
            
        if(i.hasNext()){
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
        qr.addEdges(0, 2);
        //qr.addEdges();
        qr.addEdges(1, 2);

        qr.startNode(0);
    }
}
