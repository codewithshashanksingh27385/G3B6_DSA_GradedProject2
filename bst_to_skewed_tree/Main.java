package bst_to_skewed_tree;

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class Main {
    Node node;

    // Right rotation function
    private Node rightRotate(Node root) {
        Node newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;
        return newRoot;
    }

    // Convert BST to right skewed tree
    private Node convertToSkewedTree(Node root) {
        if (root == null) {
            return null;
        }

        // Perform right rotation until the left child is null
        while (root.left != null) {
            root = rightRotate(root);
        }

        // Recursively convert the right subtree
        root.right = convertToSkewedTree(root.right);

        return root;
    }

    // Print tree nodes in-order
    private void printInOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + " ");
        printInOrder(root.right);
    }

    public static void main(String[] args) {
        Main tree = new Main();
        tree.node = new Node(50);
        tree.node.left = new Node(30);
        tree.node.right = new Node(60);
        tree.node.left.left = new Node(10);
        tree.node.right.left = new Node(55);

        // Convert the BST to skewed tree
        tree.node = tree.convertToSkewedTree(tree.node);

        // Print the skewed tree nodes in-order
        tree.printInOrder(tree.node);
    }
}
