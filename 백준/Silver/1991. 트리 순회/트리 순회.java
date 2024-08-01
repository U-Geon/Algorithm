import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        String value;
        Node left;
        Node right;

        Node(String value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    static void insert(Node head, Node hn) {
        if(head == null) return ;
        if(head.value.equals(hn.value)) {
            head.left = hn.left;
            head.right = hn.right;
            return;
        }

        insert(head.left, hn);
        insert(head.right, hn);
    }

    static void preorder(Node root) {
        if(root == null) return ;

        System.out.print(root.value);
        preorder(root.left);
        preorder(root.right);
    }

    static void inorder(Node root) {
        if(root == null) return ;

        inorder(root.left);
        System.out.print(root.value);
        inorder(root.right);
    }

    static void postorder(Node root) {
        if(root == null) return ;

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.value);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        String root = st.nextToken();
        String left = st.nextToken();
        String right = st.nextToken();

        Node leftNode = left.equals(".") ? null : new Node(left, null, null);
        Node rightNode = right.equals(".") ? null : new Node(right, null, null);
        Node head = new Node(root, null, null);

        head.left = leftNode;
        head.right = rightNode;

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            root = st.nextToken();
            left = st.nextToken();
            right = st.nextToken();

            Node ln = left.equals(".") ? null : new Node(left, null, null);
            Node rn = right.equals(".") ? null : new Node(right, null, null);
            Node hn = new Node(root, ln, rn);

            insert(head, hn);
        }

        preorder(head);
        System.out.println();
        inorder(head);
        System.out.println();
        postorder(head);
    }
}