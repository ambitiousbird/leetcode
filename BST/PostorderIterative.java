import java.util.ArrayDeque;
import java.util.Deque;

public class PostorderIterative {
    Node root;

    void postOrderIterative() {
        if (root == null) {
            return;
        }

        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        Node prev = null;

        while (!stack.isEmpty()) {
            Node current = stack.peek();
            // going down
            if (prev == null || current == prev.left || current == prev.right) {
                if (current.left != null) {
                    stack.push(current.left);
                } else if (current.right != null) {
                    stack.push(current.right);
                } else {
                    System.out.println(stack.pop().data);
                }
            }
            // going up from left tree
            else if (prev == current.left) {
                if (current.right != null) {
                    stack.push(current.right);
                } else {
                    System.out.println(stack.pop().data);
                }
            }
            // going up from right tree
            else {
                System.out.println(stack.pop().data);
            }
            prev = current;
        }

    }

    public static void main(String[] args) {
        PostorderIterative tree = new PostorderIterative();
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(2);
        tree.postOrderIterative();
    }
}