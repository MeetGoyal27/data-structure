class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1){
            return -1;
        }
        int wires = 0;
        DisJointSet dsu = new DisJointSet(n);
        for(int[] connection : connections){
            int u = connection[0];
            int v = connection[1];
            if(dsu.unionBySize(u,v)){
                wires++;
            }
        }
        return n-1-wires;

    }
}
public class DisJointSet {
    int[] parent;
    int[] size;
    
    DisJointSet(int nodes){
        this.parent = new int[nodes];
        this.size = new int[nodes];
        for(int i=0;i<nodes;i++){
            this.parent[i] = i;
            this.size[i] = 0;
            this.size[i] = 1;
        }
    }
    public int findParent(int node){
        if(node == parent[node]){
            return node;
        }
        parent[node] = findParent(parent[node]);
        return parent[node];
    }
    public boolean unionBySize(int node1,int node2){
        int p1 = findParent(node1);
        int p2 = findParent(node2);
        if(p1 == p2){
            return false;
        }
        if(size[p1] < size[p2]){
            parent[p1] = p2;
            size[p2] += size[p1];
        }
        else if(size[p1] > size[p2]){
            parent[p2] = p1;
            size[p1] += size[p2];

        }
        else{
            parent[p2] = p1;
            size[p1] += size[p2];
      }
      return true;
    }
}