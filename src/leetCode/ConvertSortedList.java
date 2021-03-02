package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 헷갈렸던 부분
 * - 이분 탐색에서 탐색 인덱스(시작, 끝, 중간) 정해서 재귀로 탐색하는 방법을 생각하지 못했다.
 *
 */

public class ConvertSortedList {

    private List<Integer> values;

    public ConvertSortedList(){
        values = new ArrayList<>();
    }

    private void mapListToValue(ListNode head) {
        while(head != null) {
            values.add(head.val);
            head = head.next;
        }
    }

    private TreeNode makeBST(int startIndex, int endIndex) {

        System.out.println("startIndex = " + startIndex);
        System.out.println("endIndex = " + endIndex);

        if(startIndex > endIndex)
            return null;

        int midIndex = (startIndex + endIndex) / 2;
        TreeNode node = new TreeNode(values.get(midIndex));

        if(startIndex == endIndex)
            return node;

        node.left = makeBST(startIndex, midIndex - 1);
        node.right = makeBST(midIndex + 1, endIndex);

        return node;
    }

    public TreeNode sortedListToBST(ListNode head) {

        mapListToValue(head);

        TreeNode treeNode = makeBST(0, values.size() - 1);

        return treeNode;

    }

    public void printTree(TreeNode node) {
        if(node == null) {
            System.out.println("null");
            return;
        }
        System.out.println("value = " + node.val);

        printTree(node.left);
        printTree(node.right);

    }


    public static void main(String[] args) {

        ConvertSortedList convertSortedList = new ConvertSortedList();

        ListNode node5 = new ListNode(9, null);
        ListNode node4 = new ListNode(5, node5);
        ListNode node3 = new ListNode(0, node4);
        ListNode node2 = new ListNode(-3,node3);
        ListNode head = new ListNode(-10, node2);



//        convertSortedList.mapListToValue(head);

        TreeNode treeNode = convertSortedList.sortedListToBST(head);

        convertSortedList.printTree(treeNode);


    }
}



// Definition for singly-linked list.
    class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
