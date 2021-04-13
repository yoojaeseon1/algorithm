package algorithmSkills;


import java.util.Stack;

/**
 * 전위 순회
 */
public class Order {

    public static void main(String[] args) {

        Node[] nodes = new Node[16];

        for(int nodesI = 1; nodesI < nodes.length; nodesI++) {
            nodes[nodesI] = new Node(nodesI);
        }

        for(int nodesI = 2; nodesI < nodes.length; nodesI++) {
            if(nodesI % 2 == 0)
                nodes[nodesI / 2].setLeft(nodes[nodesI]);
            else
                nodes[nodesI / 2].setRight(nodes[nodesI]);
        }

        Order order = new Order();

//        order.searchPreOrder(nodes[1]);
//        System.out.println();
//        order.searchInOrder(nodes[1]);
//        System.out.println();
//        order.searchPostOrder(nodes[1]);

        order.searchPreOrderNoRecursive(nodes[1]);
    }


    public void searchPreOrder(Node root){

        Node left = root.getLeft();
        Node right = root.getRight();

        System.out.print(root.getNodeNumber() + " ");

        if(left != null)
            searchPreOrder(left);

        if(right != null)
            searchPreOrder(right);

    }

    public void searchPreOrderNoRecursive(Node root){

        Stack<Node> stack = new Stack<>();

        stack.push(root);

        while(!stack.isEmpty()) {
            Node node = stack.pop();
            Node left = node.getLeft();
            Node right = node.getRight();
            System.out.print(node.getNodeNumber() + " ");


            if(right != null)
                stack.push(node.getRight());

            if(left != null) {
                stack.push(node.getLeft());
            }
        }


    }

    public void searchInOrderNoRecursive(Node root){

        Stack<Node> stack = new Stack<>();

        stack.push(root);

        while(!stack.isEmpty()) {
            Node node = stack.pop();
            Node left = node.getLeft();
            Node right = node.getRight();
            System.out.print(node.getNodeNumber() + " ");


            if(right != null)
                stack.push(node.getRight());

            if(left != null) {
                stack.push(node.getLeft());
            }
        }


    }

    public void searchInOrder(Node root){

        Node left = root.getLeft();
        Node right = root.getRight();

        if(left != null) {
            searchInOrder(left);
        }

        System.out.print(root.getNodeNumber() + " ");

        if(right != null)
            searchInOrder(right);

    }

    public void searchPostOrder(Node root){

        Node left = root.getLeft();
        Node right = root.getRight();

        if(left != null) {
            searchPostOrder(left);
        }

        if(right != null) {
            searchPostOrder(right);
        }

        System.out.print(root.getNodeNumber() + " ");

    }


}

class Node{
    private int nodeNumber;
    private Node left;
    private Node right;

    public Node(int nodeNumber) {
        this.nodeNumber = nodeNumber;
    }

    public int getNodeNumber() {
        return nodeNumber;
    }

    public void setNodeNumber(int nodeNumber) {
        this.nodeNumber = nodeNumber;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
