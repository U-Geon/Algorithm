import java.util.*;
import java.io.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static class Node {
        int weight;
        Node left = null;
        Node right = null;

        Node(int weight) {
            this.weight = weight;
        }

        void setLeft(Node left) {
            this.left = left;
        }

        void setRight(Node right) {
            this.right = right;
        }
    }

    static class BST {
        Node root;

        public void insert(int data) {
            root = insertSolution(root, data);
        }

        private Node insertSolution(Node node, int data) {
            if(node == null) return new Node(data);
            else if(node.weight < data) {
                Node right = insertSolution(node.right, data);
                node.setRight(right);
            } else if(node.weight > data) {
                Node left = insertSolution(node.left, data);
                node.setLeft(left);
            }
            return node;
        }

        public void postOrder(Node node) {
            if(node == null) return;
            postOrder(node.left);
            postOrder(node.right);
            sb.append(node.weight).append("\n");
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        BST bst = new BST();

        while(true) {
            try {
                bst.insert(Integer.parseInt(br.readLine()));
            } catch (NumberFormatException | IOException e) {
                break;
            }
        }

        bst.postOrder(bst.root);

        System.out.println(sb);
    }
}