package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RemoteNode {

    public static void main(String[] args) {

        RemoteNode test = new RemoteNode();

        int n = 6;
        int [][] edge =  {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

        System.out.println(test.solution(n, edge));

    }

    public int solution(int n, int[][] edge) {

        TreeNode[] nodes = new TreeNode[n+1];

        for(int edgeI = 0; edgeI < edge.length; edgeI++) {
            int[] oneOfEdge = edge[edgeI];


            if(nodes[oneOfEdge[0]] == null) {
                nodes[oneOfEdge[0]] = new TreeNode(oneOfEdge[0]);
            }

            if(nodes[oneOfEdge[1]] == null) {
                nodes[oneOfEdge[1]] = new TreeNode(oneOfEdge[1]);
            }

            nodes[oneOfEdge[0]].getConnectedNodes().add(nodes[oneOfEdge[1]]);
            nodes[oneOfEdge[1]].getConnectedNodes().add(nodes[oneOfEdge[0]]);

        }

        boolean[] isVisited = new boolean[n+1];
        int[] distanceCounts = new int[50001];


        Queue<TreeNode> nodeQueue = new LinkedList<>();

        nodeQueue.add(nodes[1]);
        isVisited[1] = true;

        while(!nodeQueue.isEmpty()) {

            TreeNode parent = nodeQueue.poll();

            int parentDistance = parent.getDistance();
            int numChild = 0;

            for (TreeNode connectedNode : parent.connectedNodes) {
                int nodeNumber = connectedNode.getNodeNumber();
                if(!isVisited[nodeNumber]) {
                    connectedNode.setDistance(parentDistance + 1);
                    isVisited[nodeNumber] = true;
                    nodeQueue.add(connectedNode);
                    numChild++;
                }

            }

            distanceCounts[parent.getDistance()+1] += numChild;
            
        }


        for(int distanceI = distanceCounts.length-1; distanceI >= 0; distanceI--) {

            int distanceCount = distanceCounts[distanceI];

            if(distanceCount > 0)
                return distanceCount;
        }


        return 0;
    }

}

class TreeNode{

    private int nodeNumber;
    private int distance;
    List<TreeNode> connectedNodes;


    public TreeNode() {
        connectedNodes = new ArrayList<>();
    }

    public TreeNode(int nodeNumber) {
        connectedNodes = new ArrayList<>();
        this.nodeNumber = nodeNumber;
    }

    public int getNodeNumber() {
        return nodeNumber;
    }

    public List<TreeNode> getConnectedNodes() {
        return connectedNodes;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
