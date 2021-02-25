package leetCode;


/**
 *
 * 헷갈렸던 부분
 * - 영어 문제라서 문제를 정확히 이해하지 않고 풀었다.(d에 해당하는 depth에 전부 v로 노드를 만들어야 되는 것)
 * - 테스트 케이스를 만드는 것에서 시간이 걸렸다. 바로 테스트 할 수 있도록 만들 수 있어야 한다.
 *
 * 보완할 점
 * - 문제가 길어지거나 쉽다고 생각하면 집중력이 흐트러진다. 문제를 풀 때까지 집중해서 풀자
 *
 *
 */

public class AddOneRow {


    public static void main(String[] args) {


//        TreeNode[] nodes = new TreeNode[6];
//
//        nodes[0] = new TreeNode(3);
//        nodes[1] = new TreeNode(1);
//        nodes[2] = new TreeNode(5);
//        nodes[3] = new TreeNode(2, nodes[0], nodes[1]);
//        nodes[4] = new TreeNode(6, nodes[2], null);
//        nodes[5] = new TreeNode(4, nodes[3], nodes[4]);

//        addOneRow(nodes[5], 1, 2);

        TreeNode[] nodes = new TreeNode[4];

        nodes[0] = new TreeNode(3);
        nodes[1] = new TreeNode(1);
        nodes[2] = new TreeNode(2, nodes[0], nodes[1]);
        nodes[3] = new TreeNode(4, nodes[2], null);

//        printNode(nodes[5]);

        addOneRow(nodes[3], 1, 3);

        printNode(nodes[3]);


    }

    public static TreeNode addOneRow(TreeNode root, int v, int d) {

        if(d == 1) {
            TreeNode newRoot = new TreeNode(v, root, null);
            return newRoot;
        }

        if(root.right != null)
            searchNode(root.right, root, 2, d, 'r', v);

        if(root.left != null)
            searchNode(root.left, root,2, d, 'l', v);

        if(d == 2) {
            if(root.right == null)
                root.right = new TreeNode(v);

            if(root.left == null)
                root.left = new TreeNode(v);
        }

        return root;
    }

    public static void printNode(TreeNode node) {

        System.out.println("current : " + node.val);

        if(node.right != null) {
            System.out.println("right : " + node.right.val);
            printNode(node.right);
        }

        if(node.left != null) {
            System.out.println("left : " + node.left.val);
            printNode(node.left);
        }



    }

    public static void searchNode(TreeNode currentNode,
                                  TreeNode parentNode,
                                  int currentDepth,
                                  int targetDepth,
                                  char beforeDirection,
                                  int addedNodeValue
                                  ) {

        if(currentDepth == targetDepth) {
            if(beforeDirection == 'r') {
                TreeNode node = new TreeNode(addedNodeValue, null, currentNode);
                parentNode.right = node;
            } else {
                TreeNode node = new TreeNode(addedNodeValue, currentNode, null);
                parentNode.left = node;
            }

            return;
        }


        if(currentNode.left != null) {
            searchNode(currentNode.left, currentNode, currentDepth+1, targetDepth, 'l', addedNodeValue);
        }

        if(currentNode.right != null) {
            searchNode(currentNode.right, currentNode, currentDepth+1, targetDepth, 'r', addedNodeValue);
        }

        if(currentDepth == targetDepth - 1) {
            if(currentNode.right == null)
                currentNode.right = new TreeNode(addedNodeValue);

            if(currentNode.left == null)
                currentNode.left = new TreeNode(addedNodeValue);
        }



    }



}


 // Definition for a binary tree node.
 class TreeNode {
   int val;
   TreeNode left;
   TreeNode right;
   TreeNode() {}
   TreeNode(int val) { this.val = val; }
   TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
