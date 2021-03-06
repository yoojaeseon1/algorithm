package leetCode;

import java.util.*;


/**
 *
 * 헷갈렸던 부분
 * - 트리 순회(탐색) = DFS(재귀)로 생각해서 재귀로 풀려고 했다.
 *      - 순회하는 순서에 따라 DFS / BFS 중 선택하는 것이다.
 *
 */

public class BinaryTreeZigzag {

    public static void main(String[] args) {


        BinaryTreeZigzag binaryTreeZigzag = new BinaryTreeZigzag();

        TreeNode treeNode1 = new TreeNode(15);
        TreeNode treeNode2 = new TreeNode(7);
        TreeNode treeNode3 = new TreeNode(20, treeNode1, treeNode2);
        TreeNode treeNode4 = new TreeNode(9);
        TreeNode root = new TreeNode(3, treeNode4, treeNode3);

        binaryTreeZigzag.zigzagLevelOrder(root);


    }

    public BinaryTreeZigzag() {

        sameLevelOrders = new ArrayList<>();

    }

    List<List<Integer>> sameLevelOrders;

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        boolean direction = false;

        Queue<TreeNode> nodeQueue = new LinkedList<>();

        if(root != null)
            nodeQueue.add(root);

        while(!nodeQueue.isEmpty()) {

            int queueSize = nodeQueue.size();
            List<Integer> currentLevelValues = new ArrayList<>();

            while(queueSize-- > 0) {
                TreeNode currentNode = nodeQueue.poll();

                if(currentNode.left != null)
                    nodeQueue.add(currentNode.left);
                if(currentNode.right != null)
                    nodeQueue.add(currentNode.right);

                currentLevelValues.add(currentNode.val);
            }

            if(direction)
                Collections.reverse(currentLevelValues);

            sameLevelOrders.add(currentLevelValues);
            direction = !direction;

        }

//        if(root != null) {
//            rootNode.add(root.val);
//            nodePairs.add(rootNode);
//        }


//        searchZigzagOrder(root, true);

//        for (List<Integer> nodePair : nodePairs) {
//            for (Integer integer : nodePair) {
//                System.out.print(integer + " ");
//            }
//            System.out.println();
//            System.out.println("============");
//        }

        return sameLevelOrders;
    }


//    public void searchZigzagOrder(TreeNode node, boolean direction) {
//
//        if(node == null || (node.right == null && node.left == null))
//            return;
//
////        System.out.println("node.val : " + node.val);
//
//        List<Integer> nodePair = new ArrayList<>();
//
//        if(direction) {
//
//
//            if(node.right != null) {
//                nodePair.add(node.right.val);
//            }
//
//            if(node.left != null) {
//                nodePair.add(node.left.val);
//            }
//
//
//        } else {
//
//            if(node.left != null)
//                nodePair.add(node.left.val);
//
//            if(node.right != null)
//                nodePair.add(node.right.val);
//
//        }
//
//        nodePairs.add(nodePair);
//
//        if(direction) {
//            searchZigzagOrder(node.left, !direction);
//            searchZigzagOrder(node.right, !direction);
//        } else {
//            searchZigzagOrder(node.right, !direction);
//            searchZigzagOrder(node.left, !direction);
//        }
//
//
//    }



}
