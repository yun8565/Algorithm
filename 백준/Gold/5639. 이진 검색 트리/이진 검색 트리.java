import java.util.*;

public class Main {

    static Node cur = null, root = null;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        while(s.hasNextLine()) {
            int n = Integer.parseInt(s.nextLine());
            Node newNode = new Node(n);
            cur = root;
            if(root == null)
                root = newNode;
            else
                addNode(newNode);
        }

        postOrder(root);
    }

    static void addNode(Node newNode) {
        while(true) {
            if(cur.val < newNode.val) {
                if(cur.right == null) {
                    cur.right = newNode;
                    return;
                }
                else cur = cur.right;
            }
            else {
                if(cur.left == null) {
                    cur.left = newNode;
                    return;
                }
                else cur = cur.left;
            }
        }
    }

    static void postOrder(Node cur) {
        if(cur != null) {
            postOrder(cur.left);
            postOrder(cur.right);
            System.out.println(cur.val);
        }
    }

    static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
}