package programmers;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {

        private int nodeNumber;
        private int distance;
        List<programmers.TreeNode> connectedNodes;


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

        public List<programmers.TreeNode> getConnectedNodes() {
            return connectedNodes;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

}
