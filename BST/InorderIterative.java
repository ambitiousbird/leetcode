
// non-recursive java program for inorder traversal
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/* Class containing left and right child of
current node and key value*/
class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

/* Class to print the inorder traversal */
class InOrderIterative {
    Node root;

    void inorder() {
        Deque<Node> stack = new ArrayDeque<>();
        Node current = root;
        if (root == null)
            return;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            System.out.println(current.data);
            current = current.right;
        }
    }

    public static void main(String args[]) {

        /*
         * creating a binary tree and entering the nodes
         */
        InOrderIterative tree = new InOrderIterative();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.inorder();
    }
}